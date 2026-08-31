#include <bits/stdc++.h>
using namespace std;
template <class T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  for (auto i = begin(v); i != end(v); i++)
    os << *i << (i == end(v) - 1 ? "" : " ");
  return os;
}
template <class T>
istream& operator>>(istream& is, vector<T>& v) {
  for (auto i = begin(v); i != end(v); i++) is >> *i;
  return is;
}
int n, m, k, q;
vector<pair<int, int>> edg[101000];
vector<long long> best_dists(101000, 10000000000000000LL);
set<int> markers[101000];
int dsu[101000];
int drank[101000];
vector<long long> ans(301000, 10000000000000000LL);
struct Edg {
  int u, v;
  long long w;
};
int dsu_find(int a) {
  if (dsu[a] == a) return a;
  return dsu[a] = dsu_find(dsu[a]);
}
void dsu_union(int a, int b, long long curr_ans) {
  a = dsu_find(a);
  b = dsu_find(b);
  if (a == b) return;
  if (drank[a] >= drank[b]) {
    dsu[b] = a;
    drank[a] += drank[b];
  } else {
    dsu[a] = b;
    swap(a, b);
    drank[a] += drank[b];
  }
  if (markers[a].size() < markers[b].size()) swap(markers[a], markers[b]);
  for (int x : markers[b]) {
    if (markers[a].find(x) != markers[a].end()) {
      ans[x] = curr_ans;
      markers[a].erase(x);
    } else {
      markers[a].insert(x);
    }
  }
}
int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin >> n >> m >> k >> q;
  vector<Edg> edges;
  for (int i = 0; i < m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    edg[u].push_back({v, w});
    edg[v].push_back({u, w});
    edges.push_back(Edg{u, v, w});
  }
  set<pair<long long, int>> ss;
  for (int i = 0; i < k; i++) {
    ss.insert({0, i});
    best_dists[i] = 0;
  }
  while (ss.size() > 0) {
    auto curr = *ss.begin();
    ss.erase(curr);
    for (auto x : edg[curr.second]) {
      long long new_dist = curr.first + x.second;
      if (new_dist < best_dists[x.first]) {
        ss.erase({best_dists[x.first], x.first});
        best_dists[x.first] = new_dist;
        ss.insert({best_dists[x.first], x.first});
      }
    }
  }
  for (int i = 0; i < m; i++) {
    edges[i].w += best_dists[edges[i].u] + best_dists[edges[i].v];
  }
  sort(edges.begin(), edges.end(), [&](Edg& x, Edg& y) { return x.w < y.w; });
  vector<pair<int, int>> qs(q);
  for (int i = 0; i < q; i++) {
    int a, b;
    cin >> a >> b;
    a--, b--;
    qs[i] = {a, b};
    markers[a].insert(i);
    markers[b].insert(i);
  }
  for (int i = 0; i < n; i++) {
    dsu[i] = i;
    drank[i] = 1;
  }
  for (int i = 0; i < m; i++) {
    dsu_union(edges[i].u, edges[i].v, edges[i].w);
  }
  for (int i = 0; i < q; i++) cout << ans[i] << "\n";
  return 0;
}
