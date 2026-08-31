#include <bits/stdc++.h>
using namespace std;
vector<vector<long long>> g;
long long n, m, a, b;
vector<bool> used;
long long cnt = 0;
pair<bool, bool> dfs(long long v) {
  used[v] = true;
  ++cnt;
  bool first = false;
  bool second = false;
  for (long long u : g[v]) {
    if (u == a)
      first = true;
    else if (u == b)
      second = true;
    else if (!used[u]) {
      auto p = dfs(u);
      first = first || p.first;
      second = second || p.second;
    }
  }
  return {first, second};
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    --a;
    --b;
    g.resize(n);
    g.assign(n, vector<long long>());
    for (long long i = 0; i < m; ++i) {
      long long v, u;
      cin >> v >> u;
      --v;
      --u;
      g[v].push_back(u);
      g[u].push_back(v);
    }
    used.resize(n);
    used.assign(n, false);
    long long cnt1 = 0;
    long long cnt2 = 0;
    for (long long i = 0; i < n; ++i) {
      if (i == a) continue;
      if (i == b) continue;
      if (!used[i]) {
        cnt = 0;
        auto p = dfs(i);
        if (p.first && p.second) continue;
        if (p.first) cnt1 += cnt;
        if (p.second) cnt2 += cnt;
      }
    }
    cout << cnt1 * cnt2 << '\n';
  }
}
