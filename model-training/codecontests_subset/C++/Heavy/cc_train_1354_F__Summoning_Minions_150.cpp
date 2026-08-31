#include <bits/stdc++.h>
const int N = 77;
int e, n, k, a[N], b[N], id[N], s[N], p[N][N], f[N][N];
int cmp(int x, int y) { return b[x] < b[y]; }
int main() {
  for (scanf("%d", &e); e; e--) {
    memset(f, -1, sizeof f);
    memset(p, 0, sizeof p);
    memset(s, 0, sizeof s);
    scanf("%d%d", &n, &k);
    f[0][0] = 0;
    int c = 0;
    for (int i = 1; i <= n; i++) scanf("%d%d", a + i, b + i), id[i] = i;
    std::sort(id + 1, id + 1 + n, cmp);
    for (int i = 1; i <= n; i++)
      for (int j = 0; j <= k && j <= i; j++) {
        if (f[i - 1][j] != -1)
          f[i][j] = f[i - 1][j] + b[id[i]] * (k - 1), p[i][j] = 0;
        if (j > 0 && f[i - 1][j - 1] != -1) {
          int t = f[i - 1][j - 1] + a[id[i]] + b[id[i]] * (j - 1);
          if (t > f[i][j]) f[i][j] = t, p[i][j] = 1;
        }
      }
    for (int i = n, j = k; i > 0; i--)
      if (p[i][j]) s[id[i]] = 1, j--;
    printf("%d\n", k + (n - k) * 2);
    for (int i = 1; i <= n; i++)
      if (s[id[i]]) {
        c++;
        if (c == k) {
          c = id[i];
          break;
        }
        printf("%d ", id[i]);
      }
    for (int i = 1; i <= n; i++)
      if (!s[i]) printf("%d %d ", i, -i);
    printf("%d\n", c);
  }
  return 0;
}
