#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3f;
template <typename T, typename T2>
inline void _max(T &a, T2 b) {
  a = max((T)a, (T)b);
}
template <typename T, typename T2>
inline void _min(T &a, T2 b) {
  a = min((T)a, (T)b);
}
const int MAX = 2e5 + 10;
int n, m, k;
set<int> g[MAX];
set<pair<int, int> > mm;
set<int> vs;
vector<pair<int, int> > es;
void removeEdge(int a, int b) {
  mm.erase(mm.find({g[a].size(), a}));
  g[a].erase(b);
  mm.insert({g[a].size(), a});
}
void remove(int v) {
  vs.erase(v);
  set<int> nxt = g[v];
  for (auto &to : nxt) {
    removeEdge(to, v);
    removeEdge(v, to);
  }
}
void clear() {
  for (int i = 0; i < MAX; i++) g[i].clear();
  mm.clear();
  vs.clear();
  es.clear();
}
void read() {
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--, b--;
    g[a].insert(b);
    g[b].insert(a);
    es.push_back({a, b});
  }
}
void solve() {
  for (int i = 0; i < n; i++) vs.insert(i);
  for (int i = 0; i < n; i++) mm.insert({g[i].size(), i});
  while (!mm.empty() && mm.begin()->first < k) {
    auto p = *mm.begin();
    remove(p.second);
    mm.erase(mm.begin());
  }
  vector<int> res;
  for (int i = m - 1; i >= 0; i--) {
    res.push_back(vs.size());
    auto e = es[i];
    int u = e.first, v = e.second;
    if (vs.count(u) == 0 || vs.count(v) == 0) continue;
    removeEdge(u, v);
    removeEdge(v, u);
    while (!mm.empty() && mm.begin()->first < k) {
      auto p = *mm.begin();
      remove(p.second);
      mm.erase(mm.begin());
    }
  }
  reverse(begin(res), end(res));
  for (auto &x : res) printf("%d\n", x);
}
int main() {
  while (scanf("%d%d%d", &n, &m, &k) == 3) {
    clear();
    read();
    solve();
    return 0;
  }
  return 0;
}
