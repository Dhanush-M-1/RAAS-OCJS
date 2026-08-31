#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int base = 311;
const int N = 2e5 + 5;
int n;
long long dp[2][15];
vector<int> v[5];
void umax(long long &a, long long b) { a = max(a, b); }
void solved() {
  cin >> n;
  for (int i = 0; i <= 9; ++i) dp[0][i] = dp[1][i] = -1e15;
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    int num;
    cin >> num;
    for (int j = 1; j <= 3; ++j) v[j].clear();
    for (int j = 1; j <= num; ++j) {
      int cost, st;
      cin >> cost >> st;
      v[cost].push_back(st);
    }
    for (int j = 1; j <= 3; ++j)
      sort((v[j]).begin(), (v[j]).end(), greater<int>());
    for (int j = 0; j <= 9; ++j) {
      if (dp[0][j] < 0) continue;
      umax(dp[1][j], dp[0][j]);
      long long val = 0;
      for (int k = 1; k <= min(3, int((v[1]).size())); ++k) {
        int c = (k + j) % 10;
        val += v[1][k - 1];
        if (!c) val += v[1][0];
        umax(dp[1][c], dp[0][j] + val);
      }
      if (int((v[2]).size())) {
        long long val = v[2][0];
        if (j + 1 == 10) val *= 2;
        umax(dp[1][(j + 1) % 10], dp[0][j] + val);
      }
      if (int((v[1]).size()) && int((v[2]).size())) {
        long long val = v[2][0] + v[1][0];
        if (j + 2 >= 10) val += max(v[2][0], v[1][0]);
        umax(dp[1][(j + 2) % 10], dp[0][j] + val);
      }
      if (int((v[3]).size())) {
        long long val = v[3][0];
        if (j + 1 == 10) val *= 2;
        umax(dp[1][(j + 1) % 10], dp[0][j] + val);
      }
    }
    for (int j = 0; j <= 9; ++j) dp[0][j] = dp[1][j], dp[1][j] = -1e15;
  }
  long long ans = 0;
  for (int i = 0; i <= 9; ++i) ans = max(ans, dp[0][i]);
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  if (fopen("codeforces"
            ".inp",
            "r")) {
    freopen(
        "codeforces"
        ".inp",
        "r", stdin);
    freopen(
        "codeforces"
        ".out",
        "w", stdout);
  }
  solved();
}
