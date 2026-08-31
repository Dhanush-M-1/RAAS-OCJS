#include <bits/stdc++.h>
bool aa[100000 << 1];
int a[100000], ab[100000], b[100000 << 1], c[100000 << 1], h[100000], n, m, i,
    x, y, na, ma;
int go(int k) {
  int ta = na, pa = ma, i, t;
  for (i = h[k]; ~i; i = b[i])
    if (!aa[i]) a[na++] = c[i], aa[i] = 1, aa[i >= m ? i - m : i + m] = 1;
  for (i = ta; i < na; i++) {
    t = go(a[i]);
    if (!~t)
      ab[ma++] = a[i];
    else
      printf("%d %d %d\n", k + 1, a[i] + 1, t + 1);
  }
  while (ma - pa >= 2) {
    i = ab[--ma];
    t = ab[--ma];
    printf("%d %d %d\n", i + 1, k + 1, t + 1);
  }
  na = ta;
  return ma > pa ? ab[--ma] : -1;
}
int main() {
  scanf("%d%d", &n, &m);
  if (m & 1) {
    puts("No solution");
    return 0;
  }
  for (i = 0; i < m * 2; i++) c[i] = -1;
  for (i = 0; i < n; i++) h[i] = -1;
  for (i = 0; i < m; ++i) {
    scanf("%d%d", &x, &y);
    --x, --y;
    b[i] = h[x];
    c[i] = y;
    h[x] = i;
    b[i + m] = h[y];
    c[i + m] = x;
    h[y] = i + m;
  }
  go(0);
  return 0;
}
