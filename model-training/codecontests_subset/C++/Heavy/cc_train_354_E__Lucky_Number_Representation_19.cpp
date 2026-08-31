#include <bits/stdc++.h>
using namespace std;
const int N = 20, CNT = 30;
int par[N][10], a[CNT], cnt;
bool dp[N][10];
long long ans[6];
string b[CNT], inp;
void cons(int c, int d) {
  if (!c) return;
  cons(c - 1, (a[par[c][d]] + d - inp[c - 1]) / 10);
  for (int i = 0; i < 6; i++) ans[i] = ans[i] * 10 + b[par[c][d]][i] - '0';
}
bool pos() {
  fill(ans, ans + 6, 0);
  dp[0][0] = true;
  for (int i = 1; i <= inp.size(); i++) {
    inp[i - 1] -= '0';
    for (int d = 0; d < 5; d++) {
      dp[i][d] = false;
      for (int j = 0; j < cnt; j++)
        if ((d + a[j]) % 10 == inp[i - 1])
          if (dp[i][d] |= dp[i - 1][(a[j] + d - inp[i - 1]) / 10]) {
            par[i][d] = j;
            break;
          }
    }
  }
  if (!dp[inp.size()][0]) return false;
  cons(inp.size(), 0);
  return true;
}
int main() {
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++)
      for (int k = 0; i + j + k <= 6; k++)
        if (i + j + k == 6) {
          for (int x = 0; x < i; x++) b[cnt].push_back('0');
          for (int x = 0; x < j; x++) b[cnt].push_back('4');
          for (int x = 0; x < k; x++) b[cnt].push_back('7');
          a[cnt++] = j * 4 + k * 7;
        }
  ios_base::sync_with_stdio(false);
  int test;
  cin >> test;
  while (test--) {
    cin >> inp;
    if (pos())
      for (int i = 0; i < 6; i++) cout << ans[i] << ' ';
    else
      cout << -1;
    cout << '\n';
  }
  return 0;
}
