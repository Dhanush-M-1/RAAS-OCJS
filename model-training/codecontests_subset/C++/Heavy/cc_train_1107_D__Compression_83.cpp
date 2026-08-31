#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
int main() {
  std::ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  map<char, string> has;
  has['0'] = "0000";
  has['1'] = "0001";
  has['2'] = "0010";
  has['3'] = "0011";
  has['4'] = "0100";
  has['5'] = "0101";
  has['6'] = "0110";
  has['7'] = "0111";
  has['8'] = "1000";
  has['9'] = "1001";
  has['A'] = "1010";
  has['B'] = "1011";
  has['C'] = "1100";
  has['D'] = "1101";
  has['E'] = "1110";
  has['F'] = "1111";
  int n;
  cin >> n;
  string inp[n], s[n];
  for (long long i = 0; i < n; i++) cin >> inp[i];
  for (long long i = 0; i < n; i++) {
    s[i] = "";
    for (char c : inp[i]) s[i] += has[c];
  }
  int dp[n][n];
  memset(dp, 0, sizeof dp);
  dp[0][0] = s[0][0] - '0';
  for (long long i = 1; i <= n - 1; i++) {
    dp[0][i] += (dp[0][i - 1] + s[0][i] - '0');
    dp[i][0] += (dp[i - 1][0] + s[i][0] - '0');
  }
  for (long long i = 1; i <= n - 1; i++)
    for (long long j = 1; j <= n - 1; j++)
      dp[i][j] =
          dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (s[i][j] - '0');
  vector<int> f;
  for (int i = 1; i * i <= n; i++) {
    if ((n % i) == 0) {
      f.push_back(i);
      if ((i * i) != n) f.push_back(n / i);
    }
  }
  sort(f.begin(), f.end());
  int ans = 0;
  for (int x : f) {
    int flg = 0;
    for (int i = x - 1; i < n; i += x) {
      for (int j = x - 1; j < n; j += x) {
        int sub1 = 0, sub2 = 0, add = 0;
        if (i >= x) sub1 = dp[i - x][j];
        if (j >= x) sub2 = dp[i][j - x];
        if (i >= x && j >= x) add = dp[i - x][j - x];
        int y = dp[i][j] - sub1 - sub2 + add;
        if ((y != 0) && (y != x * x)) flg = 1;
      }
      if (flg) break;
    }
    if (!flg) ans = x;
  }
  cout << ans << "\n";
  return 0;
}
