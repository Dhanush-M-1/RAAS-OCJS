#include <bits/stdc++.h>
using namespace std;
const long long N = 3e5 + 15, INF = 1e9;
long long n;
long long dp[N][10];
vector<vector<long long>> a[N];
long long solve(long long i, long long j) {
  if (i == n) return 0;
  if (dp[i][j] != -1) return dp[i][j];
  long long res = solve(i + 1, j);
  for (auto v : a[i]) {
    for (long long i = 1; i < ((long long)(v).size()); i++)
      assert(v[i] <= v[i - 1]);
    long long acum = j + ((long long)(v).size()), gain = 0;
    for (long long j : v) gain += j;
    assert(gain > 0);
    if (acum >= 10) {
      acum -= 10;
      gain += v[0];
    }
    assert(acum < 10);
    res = max(res, gain + solve(i + 1, acum));
  }
  return dp[i][j] = res;
}
int main() {
  ios::sync_with_stdio(false);
  memset(dp, -1, sizeof(dp));
  cin >> n;
  for (long long i = 0; i < n; i++) {
    vector<long long> g[3];
    for (long long j = 0; j < 3; j++)
      g[j].push_back(-INF), g[j].push_back(-INF), g[j].push_back(-INF);
    long long x;
    cin >> x;
    while (x--) {
      long long l, r;
      cin >> l >> r;
      g[l - 1].push_back(r);
    }
    for (long long j = 0; j < 3; j++) sort(g[j].rbegin(), g[j].rend());
    if (g[0][2] > 0) a[i].push_back({g[0][0], g[0][1], g[0][2]});
    a[i].push_back({max({g[0][0], g[1][0], g[2][0]})});
    long long l = g[0][0] + g[0][1], r = g[0][0] + g[1][0];
    if (l >= r && l > 0) {
      a[i].push_back({g[0][0], g[0][1]});
    } else if (r >= l && r > 0) {
      pair<long long, long long> tmp = {g[0][0], g[1][0]};
      if (tmp.second > tmp.first) swap(tmp.second, tmp.first);
      a[i].push_back({tmp.first, tmp.second});
    }
  }
  cout << solve(0, 0) << endl;
}
