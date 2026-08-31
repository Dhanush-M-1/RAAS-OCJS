#include <bits/stdc++.h>
using namespace std;
using namespace std;
int deg[200100];
set<pair<int, int> > pset;
vector<pair<int, int> > query;
set<int> conn[200100];
bool is_going(int u) { return (pset.find(make_pair(deg[u], u)) != pset.end()); }
int n, m, k;
void delete_adjacent(int u) {
  for (auto v : conn[u]) {
    conn[v].erase(conn[v].find(u));
    if (is_going(v)) {
      pset.erase(pset.find(make_pair(deg[v], v)));
      deg[v]--;
      if (deg[v] < k) {
        delete_adjacent(v);
      } else
        pset.insert(make_pair(deg[v], v));
    }
  }
  conn[u].clear();
}
void print_set() {
  if (!pset.size()) cout << "Set is empty" << endl;
  for (auto p : pset) cout << p.second << "," << p.first << " ";
  cout << endl;
}
vector<int> ans(200100);
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    deg[u]++;
    deg[v]++;
    query.push_back({u, v});
    conn[u].insert(v);
    conn[v].insert(u);
  }
  for (int i = 1; i <= n; i++) {
    pset.insert(make_pair(deg[i], i));
  }
  for (int i = 1; i <= n; i++) {
    if (deg[i] < k && is_going(i)) {
      pset.erase(make_pair(deg[i], i));
      delete_adjacent(i);
    }
  }
  for (int i = m - 1; i >= 0; i--) {
    int u = query[i].first;
    int v = query[i].second;
    ans[i + 1] = pset.size();
    if (pset.find(make_pair(deg[u], u)) != pset.end() &&
        pset.find(make_pair(deg[v], v)) != pset.end()) {
      if (deg[u] - 1 >= k && deg[v] - 1 >= k) {
        pset.erase(pset.find(make_pair(deg[u], u)));
        pset.erase(pset.find(make_pair(deg[v], v)));
        conn[u].erase(conn[u].find(v));
        conn[v].erase(conn[v].find(u));
        deg[u]--;
        deg[v]--;
        pset.insert(make_pair(deg[u], u));
        pset.insert(make_pair(deg[v], v));
      } else if (deg[u] <= k) {
        pset.erase(pset.find(make_pair(deg[u], u)));
        deg[u]--;
        delete_adjacent(u);
      } else {
        pset.erase(pset.find(make_pair(deg[v], v)));
        deg[v]--;
        delete_adjacent(v);
      }
    }
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << endl;
  cout << endl;
  return 0;
}
