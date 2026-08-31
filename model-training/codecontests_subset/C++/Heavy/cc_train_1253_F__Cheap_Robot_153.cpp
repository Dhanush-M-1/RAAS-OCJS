#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
const int Q = 3e5 + 7;
int d[N], ra[N];
vector<pair<int, int>> g[N];
unordered_set<int> tokens[N];
long long dist[N];
long long ans[Q];
vector<int> to_ans;
int find(int idx) {
  if (d[idx] == 0) return idx;
  return d[idx] = find(d[idx]);
}
bool join(int x, int y) {
  x = find(x);
  y = find(y);
  if (x == y) return false;
  if (ra[x] > ra[y]) swap(x, y);
  d[x] = y;
  for (auto &v : tokens[x]) {
    if (tokens[y].count(v)) {
      to_ans.push_back(v);
      tokens[y].erase(v);
    } else
      tokens[y].insert(v);
  }
  if (ra[x] == ra[y]) ++ra[y];
  return true;
}
struct Edge {
  int a, b;
  long long w;
  Edge() : a(0), b(0), w(0) {}
  Edge(int _a, int _b, long long _w) : a(_a), b(_b), w(_w) {}
};
Edge el[Q], nel[Q];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  clock_t ttt = clock();
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; ++i) {
    cin >> el[i].a >> el[i].b >> el[i].w;
    nel[i].a = el[i].a;
    nel[i].b = el[i].b;
    g[el[i].a].emplace_back(el[i].b, el[i].w);
    g[el[i].b].emplace_back(el[i].a, el[i].w);
  }
  for (int i = 1; i <= q; ++i) {
    int a, b;
    cin >> a >> b;
    tokens[a].insert(i);
    tokens[b].insert(i);
  }
  for (int i = k + 1; i <= n; ++i) dist[i] = 1LL << 60;
  priority_queue<pair<long long, int>, vector<pair<long long, int>>,
                 greater<pair<long long, int>>>
      dji;
  for (int i = 1; i <= k; ++i) dji.emplace(0LL, i);
  while (!dji.empty()) {
    auto v = dji.top();
    dji.pop();
    if (v.first > dist[v.second]) continue;
    for (auto &cc : g[v.second]) {
      if (dist[cc.first] > dist[v.second] + cc.second) {
        dist[cc.first] = dist[v.second] + cc.second;
        dji.emplace(dist[cc.first], (int)cc.first);
      }
    }
  }
  for (int i = 1; i <= m; ++i) {
    nel[i].w = dist[el[i].a] + dist[el[i].b] + el[i].w;
  }
  sort(nel + 1, nel + 1 + m,
       [](const Edge &lhs, const Edge &rhs) { return lhs.w < rhs.w; });
  for (int i = 1; i <= m; ++i) {
    auto &v = nel[i];
    if (!join(v.a, v.b)) continue;
    for (auto &letans : to_ans) {
      ans[letans] = v.w;
    }
    to_ans.clear();
  }
  for (int i = 1; i <= q; ++i) {
    cout << ans[i] << '\n';
  }
  cerr << "Time taken " << (double)(clock() - ttt) / CLOCKS_PER_SEC
       << " seconds\n";
  return 0;
}
