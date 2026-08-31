#include <bits/stdc++.h>
using namespace std;
int n, m, Q, fa[500020], g[500020], p[500020];
vector<int> t, T[500020 << 2];
int read() {
  int x = 0, k = 1;
  char c;
  c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') k = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x * k;
}
struct edge {
  int u, v, w;
} e[500020];
int find(int x) {
  if (fa[x] == x) return x;
  int t = fa[x];
  fa[x] = find(fa[x]);
  g[x] ^= g[t];
  return fa[x];
}
vector<int> Merge(vector<int> a, vector<int> b) {
  int cnt = 0;
  vector<int> c;
  for (int i = 0; i < a.size(); i++) {
    int x = a[i];
    fa[e[x].u] = e[x].u, fa[e[x].v] = e[x].v;
    g[e[x].u] = g[e[x].v] = 0;
  }
  for (int i = 0; i < b.size(); i++) {
    int x = b[i];
    fa[e[x].u] = e[x].u, fa[e[x].v] = e[x].v;
    g[e[x].u] = g[e[x].v] = 0;
  }
  for (int i = 0, j = 0; i < a.size() || j < b.size();) {
    if (i < a.size() && (j == b.size() || e[a[i]].w > e[b[j]].w))
      p[++cnt] = a[i], i++;
    else
      p[++cnt] = b[j], j++;
  }
  for (int i = 1; i <= cnt; i++) {
    int x = e[p[i]].u, y = e[p[i]].v;
    if (find(x) != find(y))
      g[fa[x]] = g[x] ^ g[y] ^ 1, fa[fa[x]] = fa[y], c.push_back(p[i]);
    else if (g[x] != g[y])
      continue;
    else {
      c.push_back(p[i]);
      break;
    }
  }
  return c;
}
void Build(int p, int l, int r) {
  if (l == r) {
    T[p].push_back(l);
    return;
  }
  int mid = (l + r) >> 1;
  Build(p << 1, l, mid), Build(p << 1 | 1, mid + 1, r);
  T[p] = Merge(T[p << 1], T[p << 1 | 1]);
}
vector<int> Query(int p, int l, int r, int L, int R) {
  if (L <= l && R >= r) return T[p];
  int mid = (l + r) >> 1;
  if (R <= mid)
    return Query(p << 1, l, mid, L, R);
  else if (L > mid)
    return Query(p << 1 | 1, mid + 1, r, L, R);
  return Merge(Query(p << 1, l, mid, L, R),
               Query(p << 1 | 1, mid + 1, r, L, R));
}
int main() {
  n = read(), m = read(), Q = read();
  for (int i = 1; i <= m; i++)
    e[i].u = read(), e[i].v = read(), e[i].w = read();
  Build(1, 1, m);
  for (int i = 1; i <= Q; i++) {
    int L = read(), R = read();
    t = Query(1, 1, m, L, R);
    for (int j = 0; j < t.size(); j++)
      fa[e[t[j]].u] = e[t[j]].u, fa[e[t[j]].v] = e[t[j]].v;
    int ans = -1;
    for (int j = 0; j < t.size(); j++) {
      int u = e[t[j]].u, v = e[t[j]].v;
      if (find(u) == find(v)) {
        ans = e[t[j]].w;
        break;
      }
      fa[fa[u]] = fa[v];
    }
    printf("%d\n", ans);
  }
  return 0;
}
