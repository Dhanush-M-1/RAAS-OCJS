#include <bits/stdc++.h>
using namespace std;
int n, m, q, w[1000001], u[1000001], v[1000001], id[1000001];
bool comp(int x, int y) { return w[x] < w[y]; }
int rnk[1001], bipartite[1001];
pair<int, int> parent[1001];
void make_set(int v) {
  parent[v] = make_pair(v, 0);
  rnk[v] = 0;
  bipartite[v] = true;
}
pair<int, int> find_set(int v) {
  if (v != parent[v].first) {
    int parity = parent[v].second;
    parent[v] = find_set(parent[v].first);
    parent[v].second ^= parity;
  }
  return parent[v];
}
bool unite(int a, int b) {
  pair<int, int> pa = find_set(a);
  a = pa.first;
  int x = pa.second;
  pair<int, int> pb = find_set(b);
  b = pb.first;
  int y = pb.second;
  if (a == b) {
    if (x == y) return false;
  } else {
    if (rnk[a] < rnk[b]) swap(a, b);
    parent[b] = make_pair(a, x ^ y ^ 1);
    bipartite[a] &= bipartite[b];
    if (rnk[a] == rnk[b]) ++rnk[a];
  }
  return true;
}
bool is_bipartite(int v) { return bipartite[find_set(v).first]; }
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &u[i], &v[i], &w[i]);
    id[i] = i;
  }
  sort(id + 1, id + m + 1, comp);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= n; i++) {
      make_set(i);
    }
    int bip = 0;
    for (int i = m; i >= 1; i--) {
      int cur = id[i];
      if (cur <= r && cur >= l) {
        if (!unite(u[cur], v[cur])) {
          printf("%d\n", w[cur]);
          bip = 1;
          break;
        }
      }
    }
    if (!bip) {
      printf("-1\n");
    }
  }
  return 0;
}
