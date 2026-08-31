#include <bits/stdc++.h>
using namespace std;
const int N = 55, M = N * N - 1, mod = 1e9 + 7;
int rd() {
  int x = 0, w = 1;
  char ch = 0;
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + (ch ^ 48);
    ch = getchar();
  }
  return x * w;
}
void ad(int &x, int y) { x += y, x -= x >= mod ? mod : 0; }
int n, m, a[M][N], e[M][2], ta[M], mp[N][N], d[N << 1], td, s1[N << 1], t1,
    s2[N << 1], t2, f[N << 1][N][2];
int to[M << 1], nt[M << 1], hd[N], tot;
void adde(int x, int y) { ++tot, to[tot] = y, nt[tot] = hd[x], hd[x] = tot; }
struct node {
  int y, l;
};
vector<node> pa[N], pz[N], ps[N];
int main() {
  n = rd(), m = rd();
  int mk = n + n + n;
  for (int i = 1; i <= m; ++i) {
    e[i][0] = rd(), e[i][1] = rd();
    adde(e[i][0], e[i][1]), mp[e[i][0]][e[i][1]] = i;
    ta[i] = rd(), mk = min(mk, ta[i]);
    for (int j = 1; j <= ta[i]; ++j) a[i][j] = rd();
  }
  bool ok = 0;
  for (int i = 1; i <= m; ++i) {
    int x = e[i][0], y = e[i][1];
    int zl = 1, zr = ta[i];
    while (zl <= ta[i] && a[i][zl] != x) ++zl;
    while (zr >= 1 && a[i][zr] != y) --zr;
    if (zl + 1 == zr) {
      t1 = t2 = 0;
      td = 0;
      for (int j = zl; j; --j) d[++td] = a[i][j];
      s1[++t1] = x;
      while (t1 < td && t1 + t2 <= n + n + 1) {
        ++t1, s1[t1] = d[t1];
        if (!mp[s1[t1]][s1[t1 - 1]]) {
          t1 = -1;
          break;
        }
        int k = mp[s1[t1]][s1[t1 - 1]];
        for (int l = ta[k]; l; --l) d[++td] = a[k][l];
      }
      if (t1 < 0) continue;
      td = 0;
      for (int j = zr; j <= ta[i]; ++j) d[++td] = a[i][j];
      s2[++t2] = y;
      while (t2 < td && t1 + t2 <= n + n + 1) {
        ++t2, s2[t2] = d[t2];
        if (!mp[s2[t2 - 1]][s2[t2]]) {
          t2 = -1;
          break;
        }
        int k = mp[s2[t2 - 1]][s2[t2]];
        for (int l = 1; l <= ta[k]; ++l) d[++td] = a[k][l];
      }
      if (t2 < 0 || t1 + t2 > n + n + 1) continue;
      x = s1[t1], y = s2[t2];
      pa[x].push_back((node){y, t1 + t2});
    }
  }
  for (int x = 1; x <= n; ++x)
    for (int i = hd[x]; i; i = nt[i]) {
      int y = to[i];
      if (a[i][ta[i]] == x) {
        t1 = td = 0;
        for (int j = ta[i]; j; --j) d[++td] = a[i][j];
        s1[++t1] = x;
        while (t1 < td && t1 + 1 <= n + n + 1) {
          ++t1, s1[t1] = d[t1];
          if (!mp[s1[t1]][s1[t1 - 1]]) {
            t1 = -1;
            break;
          }
          int k = mp[s1[t1]][s1[t1 - 1]];
          for (int l = ta[k]; l; --l) d[++td] = a[k][l];
        }
        if (t1 < 0 || t1 + 1 >= n + n + 1) continue;
        pz[s1[t1]].push_back((node){y, t1 + 1});
      }
    }
  for (int x = 1; x <= n; ++x)
    for (int i = hd[x]; i; i = nt[i]) {
      int y = to[i];
      if (a[i][1] == y) {
        t1 = td = 0;
        for (int j = 1; j <= ta[i]; ++j) d[++td] = a[i][j];
        s1[++t1] = y;
        while (t1 < td && t1 + 1 <= n + n + 1) {
          ++t1, s1[t1] = d[t1];
          if (!mp[s1[t1 - 1]][s1[t1]]) {
            t1 = -1;
            break;
          }
          int k = mp[s1[t1 - 1]][s1[t1]];
          for (int l = 1; l <= ta[k]; ++l) d[++td] = a[k][l];
        }
        if (t1 < 0 || t1 + 1 >= n + n + 1) continue;
        ps[x].push_back((node){s1[t1], t1 + 1});
      }
    }
  for (int i = 1; i <= n; ++i) f[1][i][0] = 1;
  for (int i = 1; i <= n + n; ++i)
    for (int x = 1; x <= n; ++x) {
      int nn = pa[x].size();
      for (int j = 0; j < nn; ++j) {
        int y = pa[x][j].y, l = pa[x][j].l;
        if (i + l - 1 <= n + n + 1) ad(f[i + l - 1][y][1], f[i][x][0]);
      }
      int mm = pz[x].size();
      for (int j = 0; j < mm; ++j) {
        int y = pz[x][j].y, l = pz[x][j].l;
        if (i + l - 1 <= n + n + 1) ad(f[i + l - 1][y][0], f[i][x][0]);
      }
      int oo = ps[x].size();
      for (int j = 0; j < oo; ++j) {
        int y = ps[x][j].y, l = ps[x][j].l;
        if (i + l - 1 <= n + n + 1) ad(f[i + l - 1][y][1], f[i][x][1]);
      }
      for (int j = hd[x]; j; j = nt[j]) {
        int y = to[j];
        if (!ta[j]) ad(f[i + 1][y][0], f[i][x][1]);
      }
    }
  for (int i = 2; i <= n + n + 1; ++i) {
    int an = 0;
    for (int x = 1; x <= n; ++x) ad(an, f[i][x][1]);
    printf("%d\n", an);
  }
  return 0;
}
