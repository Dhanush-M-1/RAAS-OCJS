#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  vector<set<int>> g(n);
  vector<int> deg(n);
  set<pair<int, int>> cur;
  vector<pair<int, int>> edges;
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    deg[a]++;
    deg[b]++;
    edges.emplace_back(a, b);
    g[a].insert(b);
    g[b].insert(a);
  }
  for (int i = 0; i < n; i++) cur.insert(make_pair(deg[i], i));
  auto solve = [&]() {
    while (true) {
      if (cur.empty()) break;
      auto u = cur.begin();
      vector<int> rev;
      if (u->first < k) {
        for (int i : g[u->second]) {
          rev.push_back(i);
        }
        cur.erase(u);
        for (int i : rev) {
          if (cur.find(make_pair(deg[i], i)) != cur.end()) {
            cur.erase(make_pair(deg[i], i));
            cur.insert(make_pair(deg[i] - 1, i));
          }
          deg[i]--;
        }
      } else
        break;
    }
  };
  solve();
  vector<int> ans;
  ans.push_back(cur.size());
  for (int i = m - 1; i > -1; i--) {
    int u = edges[i].first, v = edges[i].second;
    if (cur.find(make_pair(deg[u], u)) != cur.end() &&
        cur.find(make_pair(deg[v], v)) != cur.end()) {
      cur.erase(make_pair(deg[u], u));
      deg[u]--;
      cur.insert(make_pair(deg[u], u));
      cur.erase(make_pair(deg[v], v));
      deg[v]--;
      cur.insert(make_pair(deg[v], v));
    }
    g[u].erase(v);
    g[v].erase(u);
    solve();
    ans.push_back(cur.size());
  }
  ans.pop_back();
  reverse(ans.begin(), ans.end());
  for (int i : ans) cout << i << endl;
  return 0;
}
