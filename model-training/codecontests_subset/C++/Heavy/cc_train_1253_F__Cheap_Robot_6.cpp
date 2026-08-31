#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 5;
const long long inf = 1e18 + 9;
int n, m, k, q;
vector<pair<int, int> > g[maxn];
pair<long long, pair<int, int> > edges[maxn];
pair<int, int> query[maxn];
struct data {
  int id;
  long long val;
  bool operator<(const data& other) const { return val > other.val; }
};
long long d[maxn];
int lab[maxn];
int low[maxn], high[maxn];
vector<int> vec[maxn];
void read_input() {
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    edges[i] = make_pair(w, pair<int, int>(u, v));
    g[u].push_back(pair<int, int>(v, w));
    g[v].push_back(pair<int, int>(u, w));
  }
  for (int i = 1; i <= q; ++i) {
    int u, v;
    cin >> u >> v;
    query[i] = pair<int, int>(u, v);
  }
}
void dijkstra() {
  priority_queue<data> pq;
  fill(d + 1, d + n + 1, inf);
  for (int i = 1; i <= k; ++i) {
    d[i] = 0;
    pq.push({i, 0});
  }
  while (!pq.empty()) {
    data tp = pq.top();
    pq.pop();
    if (tp.val != d[tp.id]) continue;
    int u = tp.id;
    for (auto& to : g[u]) {
      int v = to.first, w = to.second;
      if (d[v] > d[u] + w) {
        d[v] = d[u] + w;
        pq.push({v, d[v]});
      }
    }
  }
}
int find_set(int u) { return lab[u] < 0 ? u : lab[u] = find_set(lab[u]); }
void union_sets(int u, int v) {
  if (lab[u] < lab[v]) swap(u, v);
  lab[v] += lab[u];
  lab[u] = v;
}
void solve() {
  dijkstra();
  for (int i = 1; i <= m; ++i) {
    int u = edges[i].second.first, v = edges[i].second.second;
    edges[i].first += d[u] + d[v];
  }
  sort(edges + 1, edges + m + 1);
  for (int i = 1; i <= q; ++i) {
    low[i] = 1;
    high[i] = m;
  }
  while (true) {
    bool stop = true;
    for (int i = 1; i <= q; ++i)
      if (low[i] <= high[i]) {
        stop = false;
        int mid = (low[i] + high[i]) / 2;
        vec[mid].push_back(i);
      }
    if (stop) break;
    fill(lab + 1, lab + n + 1, -1);
    for (int i = 1; i <= m; ++i) {
      int u = edges[i].second.first, v = edges[i].second.second;
      u = find_set(u);
      v = find_set(v);
      if (u != v) union_sets(u, v);
      while ((int)vec[i].size()) {
        int id = vec[i].back();
        vec[i].pop_back();
        if (find_set(query[id].first) == find_set(query[id].second))
          high[id] = i - 1;
        else
          low[id] = i + 1;
      }
    }
  }
  for (int i = 1; i <= q; ++i) cout << edges[low[i]].first << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  read_input();
  solve();
}
