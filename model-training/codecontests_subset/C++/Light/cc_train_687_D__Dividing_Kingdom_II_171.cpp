#include <bits/stdc++.h>
using namespace std;
struct DisjointSets {
  int N;
  vector<int> representatives;
  DisjointSets(const int N) : N(N), representatives(N) {
    iota(begin(representatives), end(representatives), 0);
  }
  int find(const int n) {
    if (representatives[n] != n) representatives[n] = find(representatives[n]);
    return representatives[n];
  }
  void merge(const int n, const int m) { representatives[find(n)] = find(m); }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  struct Edge {
    int index, v, w, weight;
  };
  int n, m, q;
  cin >> n >> m >> q;
  auto edges = vector<Edge>(m);
  for (auto i = 0; i < m; i++) {
    int v, w, weight;
    cin >> v >> w >> weight;
    v--;
    w--;
    edges[i] = {i, v, w, weight};
  }
  sort(begin(edges), end(edges),
       [](const Edge a, const Edge b) { return a.weight > b.weight; });
  const auto solve = [&](const int l, const int r) {
    auto components = DisjointSets(2 * n);
    for (const auto e : edges)
      if (l <= e.index && e.index <= r) {
        if (components.find(2 * e.v) == components.find(2 * e.w))
          return e.weight;
        components.merge(2 * e.v, 2 * e.w + 1);
        components.merge(2 * e.v + 1, 2 * e.w);
      }
    return -1;
  };
  for (auto i = 0; i < q; i++) {
    int l, r;
    cin >> l >> r;
    l--;
    r--;
    cout << solve(l, r) << "\n";
  }
}
