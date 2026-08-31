#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 11, mod = 998244353;
int ans, n, k, blo, bel[N], f[N], g[N], a[N], L[N], R[N], las[N], bef[N],
    lim[N], sum[411][N], Sum[411];
inline void inc(int &x, int y) {
  x += y;
  if (x >= mod) x -= mod;
}
inline void deal(int l, int r, int x) {
  int o = bel[l];
  for (register int i = l; i <= r; ++i) {
    if (f[i] <= lim[o]) inc(Sum[o], mod - g[i - 1]);
    inc(sum[o][f[i]], mod - g[i - 1]);
    f[i] += x;
    inc(sum[o][f[i]], g[i - 1]);
    if (f[i] <= lim[o]) inc(Sum[o], g[i - 1]);
  }
}
inline void modify(int l, int r, int x) {
  int o;
  if (bel[l] == bel[r]) {
    deal(l, r, x);
    return;
  }
  o = bel[l];
  deal(l, R[o], x);
  o = bel[r];
  deal(L[o], r, x);
  for (register int i = bel[l] + 1; i <= bel[r] - 1; ++i) {
    if (x == 1) inc(Sum[i], mod - sum[i][lim[i]]);
    lim[i] -= x;
    if (x == -1) inc(Sum[i], sum[i][lim[i]]);
  }
}
int main() {
  scanf("%d%d", &n, &k);
  blo = sqrt(n);
  for (register int i = 1; i <= n; ++i) {
    scanf("%d", a + i), bel[i] = (i - 1) / blo + 1;
    las[i] = bef[a[i]];
    bef[a[i]] = i;
  }
  for (register int i = 1; i <= n; ++i) {
    if (!L[bel[i]]) L[bel[i]] = i;
    R[bel[i]] = i;
  }
  for (register int i = 1; i <= bel[n]; ++i) lim[i] = k;
  g[0] = 1;
  for (register int i = 1; i <= n; ++i) {
    inc(sum[bel[i]][0], g[i - 1]), inc(Sum[bel[i]], g[i - 1]);
    modify(las[i] + 1, i, 1);
    if (las[i]) modify(las[las[i]] + 1, las[i], -1);
    ans = 0;
    for (register int j = 1; j <= bel[i]; ++j) inc(ans, Sum[j]);
    g[i] = ans;
  }
  printf("%d\n", g[n]);
  return 0;
}
