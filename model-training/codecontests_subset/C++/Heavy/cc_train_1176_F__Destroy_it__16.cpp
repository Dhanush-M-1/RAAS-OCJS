#include <bits/stdc++.h>
using namespace std;
long long i, i1, j, k, k1, t, n, m, res, flag[10], a, b;
long long dp[200010][10], c, d;
vector<long long> adj[4];
void upd(long long l, array<long long, 3> f) {
  long long i, d1, j, s;
  vector<long long> v;
  for (i = 1; i <= 3; i++) {
    if (adj[i].size() < f[i - 1]) return;
  }
  for (i = 1; i <= 3; i++) {
    for (j = 0; j < f[i - 1]; j++) {
      v.push_back(adj[i][j]);
    }
  }
  sort(v.begin(), v.end());
  reverse(v.begin(), v.end());
  s = v.size();
  d1 = 0;
  for (auto u : v) d1 += u;
  for (j = 0; j <= 9; j++) {
    if (s == 0)
      dp[l][j] = max(dp[l][j], dp[l - 1][j]);
    else
      dp[l][j] =
          max(dp[l][j], dp[l - 1][(j - s + 10) % 10] + d1 + (j < s) * v[0]);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (i = 0; i < 200010; i++) {
    for (j = 0; j <= 9; j++) {
      dp[i][j] = -(long long)1e18;
    }
  }
  dp[0][0] = 0;
  for (i = 1; i <= n; i++) {
    cin >> k;
    for (j = 0; j <= 3; j++) adj[j].clear();
    for (j = 1; j <= k; j++) {
      cin >> c >> d;
      adj[c].push_back(d);
    }
    for (j = 0; j <= 3; j++) {
      sort(adj[j].begin(), adj[j].end());
      reverse(adj[j].begin(), adj[j].end());
    }
    upd(i, {0, 0, 0});
    upd(i, {1, 0, 0});
    upd(i, {2, 0, 0});
    upd(i, {3, 0, 0});
    upd(i, {0, 1, 0});
    upd(i, {1, 1, 0});
    upd(i, {0, 0, 1});
  }
  res = 0;
  for (j = 0; j <= 9; j++) res = max(res, dp[n][j]);
  cout << res << "\n";
  return 0;
}
