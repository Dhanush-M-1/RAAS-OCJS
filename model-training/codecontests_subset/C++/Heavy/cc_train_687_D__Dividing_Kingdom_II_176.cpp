#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int t = 1, sum = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') t = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') sum = sum * 10 + ch - '0', ch = getchar();
  return t * sum;
}
const int _N = 1e3 + 10, _M = 5e5 + 10;
int fa[_N], col[_N], n, m, ans, Ans;
struct edge {
  int u, v, w;
  void init() {
    fa[u] = u;
    fa[v] = v;
    col[u] = col[v] = 0;
  }
} _e[_M];
vector<edge> E[_M << 2], ans1, ans2;
int find_fa(int x) {
  if (fa[x] == x) return x;
  int F = find_fa(fa[x]);
  col[x] ^= col[fa[x]];
  return fa[x] = F;
}
int make_tg(int u, int v) {
  int x = find_fa(u), y = find_fa(v);
  if (x == y)
    if (col[u] == col[v])
      return 2;
    else
      return 0;
  col[x] ^= col[u] ^ 1 ^ col[v];
  fa[x] = y;
  return 1;
}
void merge(vector<edge> &a, vector<edge> &b, vector<edge> &c) {
  edge now;
  c.clear();
  int i, j, k;
  for (i = 0; i < a.size(); i++) a[i].init();
  for (i = 0; i < b.size(); i++) b[i].init();
  i = j = 0;
  while (i < a.size() || j < b.size()) {
    if (i < a.size() && (j == b.size() || a[i].w > b[j].w))
      now = a[i++];
    else
      now = b[j++];
    k = make_tg(now.u, now.v);
    if (k) {
      c.push_back(now);
      if (k == 2) {
        ans = now.w;
        break;
      }
    }
  }
}
void build(int o, int l, int r) {
  if (l == r) {
    E[o].push_back(_e[l]);
    return;
  }
  int mid = l + r >> 1;
  build(o << 1, l, mid);
  build(o << 1 | 1, mid + 1, r);
  merge(E[o << 1], E[o << 1 | 1], E[o]);
}
void query(int o, int l, int r, int L, int R) {
  if (L <= l && r <= R) {
    if (r == R) ans = -1;
    merge(ans1, E[o], ans2), swap(ans1, ans2);
    if (r == R) Ans = ans;
    return;
  }
  int mid = l + r >> 1;
  if (L <= mid) query(o << 1, l, mid, L, R);
  if (R > mid) query(o << 1 | 1, mid + 1, r, L, R);
}
int main() {
  int i, x, y, Q;
  n = read();
  m = read();
  Q = read();
  for (i = 1; i <= m; i++) _e[i].u = read(), _e[i].v = read(), _e[i].w = read();
  build(1, 1, m);
  while (Q--) {
    x = read();
    y = read();
    ans1.clear();
    ans2.clear();
    query(1, 1, m, x, y);
    printf("%d\n", Ans);
  }
  return 0;
}
