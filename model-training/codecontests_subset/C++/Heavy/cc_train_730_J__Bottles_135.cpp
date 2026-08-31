#include <bits/stdc++.h>
using namespace std;
int n, z, p, i, j, k, ans, t, a[105], b[105], d[105], f[105][10005];
bool cmp(int x, int y) { return x > y; }
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d", &a[i]), z += a[i];
  for (i = 1; i <= n; i++) scanf("%d", &b[i]), d[i] = b[i];
  sort(d + 1, d + n + 1, cmp);
  memset(f, 0x80, sizeof(f));
  f[0][0] = 0;
  for (i = 1; i <= n; i++) {
    p += d[i];
    if (p >= z) {
      ans = i;
      break;
    }
  }
  for (i = 1; i <= n; i++)
    for (j = p; j >= b[i]; j--)
      for (k = 1; k <= ans; k++)
        f[k][j] = max(f[k][j], f[k - 1][j - b[i]] + a[i]);
  for (i = z; i <= p; i++) t = max(t, f[ans][i]);
  printf("%d %d", ans, z - t);
  return 0;
}
