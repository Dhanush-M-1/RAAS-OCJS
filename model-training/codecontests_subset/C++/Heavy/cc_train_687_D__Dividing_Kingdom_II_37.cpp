#include <bits/stdc++.h>
using namespace std;
const int N = 1005;
const int M = N * (N - 1) / 2;
struct Edge {
  int u, v, w;
};
struct Node {
  vector<Edge> e;
  int ans = -1;
};
int p[N], vis[N], pass, change[N], sz[N];
int f(int u) { return u == p[u] ? u : f(p[u]); }
int get(int u) { return u == p[u] ? 0 : change[u] ^ get(p[u]); }
int n, m, q;
Node merge(const Node &a, const Node &b) {
  Node ans;
  ans.ans = max(a.ans, b.ans);
  pass++;
  auto init = [](int u) {
    vis[u] = pass;
    p[u] = u;
    sz[u] = 1;
    change[u] = 0;
  };
  bool over = false;
  auto add = [&](Edge e) {
    if (over) return;
    if (vis[e.u] != pass) init(e.u);
    if (vis[e.v] != pass) init(e.v);
    int valu = get(e.u), valv = get(e.v);
    int u = f(e.u), v = f(e.v);
    if (u == v and valu == valv) {
      over = true;
      ans.ans = max(ans.ans, e.w);
      return;
    }
    if (u != v) {
      ans.e.push_back(e);
      if (sz[u] < sz[v]) swap(u, v);
      p[v] = u;
      sz[u] += sz[v];
      if (valu == valv) change[v] ^= 1;
    }
  };
  size_t i = 0, j = 0;
  while (!over and i < a.e.size() and j < b.e.size()) {
    if (a.e[i].w > b.e[j].w) {
      add(a.e[i++]);
    } else {
      add(b.e[j++]);
    }
  }
  while (!over and i < a.e.size()) add(a.e[i++]);
  while (!over and j < b.e.size()) add(b.e[j++]);
  return ans;
}
Node st[2 * M];
Node query(int l, int r) {
  Node ans;
  for (l += m, r += m; l < r; l >>= 1, r >>= 1) {
    if (l & 1) ans = merge(ans, st[l++]);
    if (r & 1) ans = merge(ans, st[--r]);
  }
  return ans;
}
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    Edge e;
    scanf("%d %d %d", &e.u, &e.v, &e.w);
    st[i + m].e.push_back(e);
  }
  for (int i = m - 1; i > 0; i--) {
    st[i] = merge(st[2 * i], st[2 * i + 1]);
  }
  while (q--) {
    int l, r;
    scanf("%d %d", &l, &r);
    printf("%d\n", query(l - 1, r).ans);
  }
}
