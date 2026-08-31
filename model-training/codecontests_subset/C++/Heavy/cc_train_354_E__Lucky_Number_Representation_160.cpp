#include <bits/stdc++.h>
using namespace std;
const int N = 20;
string way[25][50];
bool dp[25][50];
int add, a[] = {0, 4, 7};
string tmp;
vector<pair<string, int> > rec;
void dfs(int pos) {
  if (pos == 6) {
    rec.push_back(make_pair(tmp, add));
    return;
  }
  for (int i = 0; i < 3; i++) {
    add += a[i];
    tmp[pos] = (char)('0' + a[i]);
    dfs(pos + 1);
    add -= a[i];
  }
}
int main() {
  int cas;
  tmp = string(6, '0');
  add = 0;
  dfs(0);
  cin >> cas;
  while (cas--) {
    string str;
    cin >> str;
    str = '0' + str;
    reverse(str.begin(), str.end());
    int n = (int)str.size();
    memset(dp, false, sizeof(dp));
    dp[0][0] = true;
    int mx = 0;
    way[0][0] = string(200, '0');
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= mx; j++) {
        if (!dp[i][j]) continue;
        for (int k = 0; k < (int)rec.size(); k++) {
          pair<string, int> &tmp = rec[k];
          int mod = (j + tmp.second) % 10;
          if (mod != (int)(str[i] - '0')) continue;
          int newj = (j + tmp.second) / 10;
          mx = max(mx, newj);
          if (dp[i + 1][newj]) continue;
          dp[i + 1][newj] = true;
          string newStr = way[i][j];
          for (int a = 0; a < 6 && a * n + i < 200; a++) {
            newStr[a * n + i] = tmp.first[a];
          }
          way[i + 1][newj] = newStr;
        }
      }
    }
    if (!dp[n][0])
      puts("-1");
    else {
      string s = way[n][0];
      for (int i = 0; i < 6; i++) {
        string tmp = "";
        for (int j = 0; j < n; j++) {
          tmp += s[i * n + j];
        }
        reverse(tmp.begin(), tmp.end());
        int j = 0;
        while (j < (int)tmp.size() && tmp[j] == '0') j++;
        if (j == (int)tmp.size())
          putchar('0');
        else
          cout << tmp.substr(j, (int)tmp.size() - j);
        cout << (i == 5 ? '\n' : ' ');
      }
    }
  }
  return 0;
}
