#include <bits/stdc++.h>
const int N = 105;
using namespace std;
int a[N], b[N], c[N], f[N][N * N];
int main() {
  int n, i, j, k, m, t, v = 0, s = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    s += a[i];
  }
  for (i = 0; i < n; i++) {
    scanf("%d", &b[i]);
    c[i] = b[i];
    v += b[i];
  }
  sort(c, c + n);
  m = 0;
  t = 0;
  for (i = n - 1; i >= 0; i--) {
    t += c[i];
    m++;
    if (t >= s) break;
  }
  memset(f, -1, sizeof(f));
  f[0][0] = 0;
  for (i = 0; i < n; i++)
    for (j = m - 1; j >= 0; j--)
      for (k = v; k >= 0; k--)
        if (f[j][k] != -1)
          f[j + 1][k + b[i]] = max(f[j + 1][k + b[i]], f[j][k] + a[i]);
  int maxm = -1;
  for (i = s; i <= v; i++) maxm = max(maxm, f[m][i]);
  printf("%d %d\n", m, s - maxm);
  return 0;
}
