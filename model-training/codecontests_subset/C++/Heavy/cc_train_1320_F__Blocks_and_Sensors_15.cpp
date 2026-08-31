#include <bits/stdc++.h>
using namespace std;
inline char nc() {
  return getchar();
  static char buf[100000], *l = buf, *r = buf;
  return l == r && (r = (l = buf) + fread(buf, 1, 100000, stdin), l == r)
             ? EOF
             : *l++;
}
template <class T>
void read(T &x) {
  x = 0;
  int f = 1, ch = nc();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = nc();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 - '0' + ch;
    ch = nc();
  }
  x *= f;
}
const int maxn = 2e5 + 50;
int n, m, k;
int a[maxn], b[maxn], c[maxn], d[maxn], e[maxn], f[maxn];
int col[maxn];
bool inq[maxn];
set<int> sx[maxn];
set<int> sy[maxn];
set<int> sz[maxn];
void upd(int x, int y, int z, int c) {
  int now = (((x)-1) * m * k + ((y)-1) * k + (z)-1);
  if (col[now] == -1)
    col[now] = c;
  else if (col[now] != c)
    col[now] = 0;
}
bool sol() {
  static int q[maxn];
  int hd = 0, tl = 0;
  for (int y = 1, id = 0; y <= m; ++y)
    for (int z = 1; z <= k; ++z, ++id)
      for (int x = 1; x <= n; ++x) sx[id].insert(x);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int z = 1; z <= k; ++z, ++id)
      for (int y = 1; y <= m; ++y) sy[id].insert(y);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int y = 1; y <= m; ++y, ++id)
      for (int z = 1; z <= k; ++z) sz[id].insert(z);
  memset(col, -1, sizeof(col));
  for (int y = 1, id = 0; y <= m; ++y)
    for (int z = 1; z <= k; ++z, ++id)
      read(a[id]), upd(*sx[id].begin(), y, z, a[id]);
  for (int y = 1, id = 0; y <= m; ++y)
    for (int z = 1; z <= k; ++z, ++id)
      read(b[id]), upd(*sx[id].rbegin(), y, z, b[id]);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int z = 1; z <= k; ++z, ++id)
      read(c[id]), upd(x, *sy[id].begin(), z, c[id]);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int z = 1; z <= k; ++z, ++id)
      read(d[id]), upd(x, *sy[id].rbegin(), z, d[id]);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int y = 1; y <= m; ++y, ++id)
      read(e[id]), upd(x, y, *sz[id].begin(), e[id]);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int y = 1; y <= m; ++y, ++id)
      read(f[id]), upd(x, y, *sz[id].rbegin(), f[id]);
  for (int x = 1, id = 0; x <= n; ++x)
    for (int y = 1; y <= m; ++y)
      for (int z = 1; z <= k; ++z, ++id)
        if (col[id] == 0) {
          inq[id] = 1;
          q[tl++] = id;
        }
  while (hd < tl) {
    int u = q[hd++];
    int x = u / (m * k);
    u -= x * m * k;
    ++x;
    int y = u / k;
    u -= y * k;
    ++y;
    int z = u;
    ++z;
    u = (((y)-1) * k + (z)-1);
    sx[u].erase(x);
    if (!sx[u].empty()) {
      int xx = *sx[u].begin(), now = (((xx)-1) * m * k + ((y)-1) * k + (z)-1);
      upd(xx, y, z, a[u]);
      if (col[now] == 0 && !inq[now]) inq[now] = 1, q[tl++] = now;
      xx = *sx[u].rbegin(), now = (((xx)-1) * m * k + ((y)-1) * k + (z)-1);
      upd(xx, y, z, b[u]);
      if (col[now] == 0 && !inq[now]) inq[now] = 1, q[tl++] = now;
    } else if (a[u] || b[u])
      return 0;
    u = (((x)-1) * k + (z)-1);
    sy[u].erase(y);
    if (!sy[u].empty()) {
      int yy = *sy[u].begin(), now = (((x)-1) * m * k + ((yy)-1) * k + (z)-1);
      upd(x, yy, z, c[u]);
      if (col[now] == 0 && !inq[now]) inq[now] = 1, q[tl++] = now;
      yy = *sy[u].rbegin(), now = (((x)-1) * m * k + ((yy)-1) * k + (z)-1);
      upd(x, yy, z, d[u]);
      if (col[now] == 0 && !inq[now]) inq[now] = 1, q[tl++] = now;
    } else if (c[u] || d[u])
      return 0;
    u = (((x)-1) * m + (y)-1);
    sz[u].erase(z);
    if (!sz[u].empty()) {
      int zz = *sz[u].begin(), now = (((x)-1) * m * k + ((y)-1) * k + (zz)-1);
      upd(x, y, zz, e[u]);
      if (col[now] == 0 && !inq[now]) inq[now] = 1, q[tl++] = now;
      zz = *sz[u].rbegin(), now = (((x)-1) * m * k + ((y)-1) * k + (zz)-1);
      upd(x, y, zz, f[u]);
      if (col[now] == 0 && !inq[now]) inq[now] = 1, q[tl++] = now;
    } else if (e[u] || f[u])
      return 0;
  }
  for (int x = 1, id = 0; x <= n; ++x)
    for (int y = 1; y <= m; ++y)
      for (int z = 1; z <= k; ++z, ++id) {
        if (col[id] == -1) col[id] = 0;
        printf("%d\n", col[id]);
      }
}
int main() {
  read(n), read(m), read(k);
  if (!sol()) puts("-1");
  return 0;
}
