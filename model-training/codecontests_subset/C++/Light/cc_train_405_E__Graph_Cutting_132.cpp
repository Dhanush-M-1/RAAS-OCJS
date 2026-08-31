#include <bits/stdc++.h>
bool a[100000 << 1];
int b[100000 << 1], c[100000 << 1], h[100000], n, m, i, x, y;
int go(int k) {
  int i, t, x = -1;
  for (i = h[k]; ~i; i = b[i])
    if (!a[i]) {
      a[i] = 1, a[i >= m ? i - m : i + m] = 1;
      t = go(c[i]);
      if (~t)
        printf("%d %d %d\n", k + 1, c[i] + 1, t + 1);
      else if (~x)
        printf("%d %d %d\n", x + 1, k + 1, c[i] + 1), x = -1;
      else
        x = c[i];
    }
  return ~x ? x : -1;
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
