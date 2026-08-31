#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> from(m), to(m);
  vector<vector<pair<int, int> > > adj(n);
  for (int i = (int)(0); i < (int)(m); ++i) {
    cin >> from[i] >> to[i];
    from[i]--, to[i]--;
    adj[from[i]].emplace_back(to[i], i);
    adj[to[i]].emplace_back(from[i], i);
  }
  vector<int> alive(m, 1);
  vector<int> deg(n);
  set<pair<int, int> > g;
  for (int i = (int)(0); i < (int)(n); ++i) {
    deg[i] = adj[i].size();
    if (deg[i]) g.emplace(deg[i], i);
  }
  function<void()> update = [&]() {
    while (g.size() && g.begin()->first < k) {
      int u = g.begin()->second;
      g.erase(g.begin());
      for (auto &p : adj[u]) {
        if (alive[p.second]) {
          alive[p.second] = 0;
          int v = p.first;
          g.erase({deg[v], v});
          g.emplace(--deg[v], v);
        }
      }
    }
  };
  vector<int> ans(m);
  for (int i = (int)(m - 1); i >= (int)(0); --i) {
    update();
    ans[i] = g.size();
    if (alive[i]) {
      int u = from[i], v = to[i];
      g.erase({deg[u], u});
      g.emplace(--deg[u], u);
      g.erase({deg[v], v});
      g.emplace(--deg[v], v);
      alive[i] = 0;
    }
  }
  for (int i = (int)(0); i < (int)(m); ++i) {
    cout << ans[i] << "\n";
  }
  return 0;
}
