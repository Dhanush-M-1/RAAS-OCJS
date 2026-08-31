#include <bits/stdc++.h>
long long mpow(long long a, long long n, long long mod) {
  long long ret = 1;
  long long b = a;
  while (n) {
    if (n & 1) ret = (ret * b) % mod;
    b = (b * b) % mod;
    n >>= 1;
  }
  return (long long)ret;
}
using namespace std;
int dp[100005][3];
vector<pair<int, int> > v;
int main() {
  int n, i, j;
  cin >> n;
  for (j = 0; j < n; j++) {
    int x, h;
    cin >> x >> h;
    v.push_back(make_pair(x, h));
  }
  memset(dp, 0, sizeof(dp));
  dp[0][0] = 1;
  dp[0][1] = 1;
  dp[0][2] = 0;
  for (j = 1; j < n - 1; j++) {
    if (v[j].first - v[j].second > v[j - 1].first) {
      if (v[j - 1].first + v[j - 1].second < v[j].first - v[j].second) {
        dp[j][0] = max(dp[j - 1][0], dp[j - 1][1]);
        dp[j][0] = max(dp[j][0], dp[j - 1][2]) + 1;
      } else
        dp[j][0] = max(dp[j - 1][0], dp[j - 1][2]) + 1;
    }
    if (j + 1 < n && (v[j].first + v[j].second) < v[j + 1].first) {
      dp[j][1] = max(dp[j - 1][0], dp[j - 1][1]);
      dp[j][1] = max(dp[j][1], dp[j - 1][2]) + 1;
    }
    dp[j][2] = max(dp[j - 1][0], dp[j - 1][1]);
    dp[j][2] = max(dp[j - 1][2], dp[j][2]);
  }
  int k = max(dp[n - 2][0], dp[n - 2][1]);
  k = max(dp[n - 2][2], k);
  cout << k + 1;
  return 0;
}
