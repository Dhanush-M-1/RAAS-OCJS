#include <bits/stdc++.h>
using namespace std;
bool dp[21][6][7][7][7];
int main() {
  srand((unsigned int)time(NULL));
  int t;
  scanf("%d", &t);
  while (t--) {
    memset(dp, 0, sizeof(dp));
    string second;
    cin >> second;
    reverse(second.begin(), second.end());
    while (second.size() < 20) second.push_back('0');
    int v[21];
    for (int i = 1; i <= 20; i++) v[i] = second[i - 1] - '0';
    dp[0][0][6][0][0] = true;
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 6; j++) {
        for (int k = 0; k <= 6; k++) {
          for (int l = 0; l <= 6; l++) {
            for (int m = 0; m <= 6; m++) {
              if (!dp[i][j][k][l][m]) continue;
              if (k + l + m != 6) continue;
              int x = j;
              for (int a = 0; a <= 6; a++) {
                for (int b = 0; b <= 6 - a; b++) {
                  int c = 6 - a - b;
                  if (c < 0) continue;
                  int sum = b * 4 + c * 7 + x;
                  if (sum % 10 != v[i + 1]) continue;
                  if (i == 19 && sum / 10 > 0) continue;
                  dp[i + 1][sum / 10][a][b][c] = true;
                }
              }
            }
          }
        }
      }
    }
    int zero, four, seven, sum;
    {
      for (int j = 0; j < 6; j++) {
        for (int k = 0; k <= 6; k++) {
          for (int l = 0; l <= 6; l++) {
            for (int m = 0; m <= 6; m++) {
              if (dp[20][j][k][l][m]) {
                zero = k;
                four = l;
                seven = m;
                sum = j;
                goto next;
              }
            }
          }
        }
      }
    }
    puts("-1");
    continue;
  next:;
    int cur = 20;
    string ans[6];
    for (int i = 0; i < 6; i++) ans[i].clear();
    while (cur > 0) {
      int prev = 10 * sum + v[cur] - 4 * four - 7 * seven;
      for (int i = 0; i < zero; i++) ans[i].push_back('0');
      for (int i = zero; i < zero + four; i++) ans[i].push_back('4');
      for (int i = zero + four; i < zero + four + seven; i++)
        ans[i].push_back('7');
      for (int i = 0; i <= 6; i++) {
        for (int j = 0; j <= 6; j++) {
          for (int k = 0; k <= 6; k++) {
            if (dp[cur - 1][prev][i][j][k]) {
              sum = prev;
              zero = i;
              four = j;
              seven = k;
              goto nxt;
            }
          }
        }
      }
    nxt:;
      cur--;
    }
    for (int i = 0; i < 6; i++) reverse(ans[i].begin(), ans[i].end());
    for (int i = 0; i < 6; i++) {
      while (!ans[i].empty() && ans[i][ans[i].size() - 1] == '0')
        ans[i].resize(ans[i].size() - 1);
      if (ans[i].empty()) ans[i] = "0";
    }
    for (int i = 0; i < 6; i++) reverse(ans[i].begin(), ans[i].end());
    for (int i = 0; i < 6; i++) cout << ans[i] << " ";
    cout << endl;
  }
}
