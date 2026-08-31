#include <bits/stdc++.h>
using namespace std;
const int M = 1005;
int parent[2 * M];
vector<pair<pair<int, int>, pair<int, int> > > edges;
void init() {
  for (int i = 0; i < 2 * M; i++) parent[i] = i;
}
int find(int u) {
  if (u == parent[u]) return u;
  return parent[u] = find(parent[u]);
}
void un(int u, int v) {
  u = find(u);
  v = find(v);
  parent[u] = v;
}
int main() {
  int n, m, q;
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    edges.push_back(make_pair(make_pair(c, i), make_pair(a, b)));
  }
  sort(edges.begin(), edges.end(),
       greater<pair<pair<int, int>, pair<int, int> > >());
  while (q--) {
    int l, r;
    scanf("%d %d", &l, &r);
    int ans = -1;
    init();
    for (int i = 0; i < edges.size(); i++) {
      int c = edges[i].first.first;
      int id = edges[i].first.second;
      int u = edges[i].second.first;
      int v = edges[i].second.second;
      if (id < l || id > r) continue;
      if (find(u) == find(v)) {
        ans = c;
        break;
      }
      un(u, v + n);
      un(u + n, v);
    }
    printf("%d\n", ans);
  }
  return 0;
}
