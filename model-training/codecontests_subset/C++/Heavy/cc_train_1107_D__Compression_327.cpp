#include <bits/stdc++.h>
using namespace std;
string s[5200];
int dp[5200][5200];
string expand_string(string& s) {
  int digit;
  string tmp2 = "";
  for (char c : s) {
    if (c >= 'A' && c <= 'Z')
      digit = c - 'A' + 10;
    else
      digit = c - '0';
    string tmp = "";
    for (int cn = 0; cn < 4; ++cn) {
      tmp += (digit & 1 ? '1' : '0');
      digit >>= 1;
    }
    reverse(tmp.begin(), tmp.end());
    tmp2 += tmp;
  }
  return tmp2;
}
int main(int argc, char const* argv[]) {
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> s[i];
  }
  for (int i = 0; i < n; ++i) {
    string a = expand_string(s[i]);
    for (int j = 0; j < n; ++j) {
      dp[i][j] = a[j] == '1' ? 1 : 0;
      if (i > 0) dp[i][j] += dp[i - 1][j];
      if (j > 0) dp[i][j] += dp[i][j - 1];
      if (i > 0 && j > 0) dp[i][j] -= dp[i - 1][j - 1];
    }
  }
  int ans = 1;
  for (int d = 2; d < n + 1; ++d) {
    if (n % d != 0) continue;
    int flag = 1;
    for (int i = 0; i < n; i += d)
      for (int j = 0; j < n; j += d) {
        int ones = dp[i + d - 1][j + d - 1];
        if (i > 0) ones -= dp[i - 1][j + d - 1];
        if (j > 0) ones -= dp[i + d - 1][j - 1];
        if (i > 0 && j > 0) ones += dp[i - 1][j - 1];
        int zeros = d * d - ones;
        if (ones == d * d || zeros == d * d)
          ;
        else
          flag &= 0;
      }
    ans = flag ? d : ans;
  }
  cout << ans << endl;
  return 0;
}
