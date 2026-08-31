#include <bits/stdc++.h>
using namespace std;
const int N = 105;
const int M = 10005;
int n, m, k, a[N], b[N];
int sa, sb, id[N];
int f[N][M], ans;
bool cmp(int i, int j) { return b[i] > b[j]; }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) id[i] = i;
  sa = sb = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    sa += a[i];
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &b[i]);
    sb += b[i];
  };
  m = sb - sa;
  sort(id + 1, id + n + 1, cmp);
  for (int i = 1; i <= n; i++) {
    sa -= b[id[i]];
    if (sa <= 0) {
      k = i;
      break;
    }
  }
  k = n - k;
  memset(f, -1, sizeof(f));
  f[0][0] = 0;
  for (int h = 1; h <= n; h++)
    for (int i = min(k, h); i >= 1; i--)
      for (int j = m - b[h]; j >= 0; j--)
        if (f[i - 1][j] != -1 &&
            (f[i][j + b[h]] == -1 || f[i - 1][j] + a[h] < f[i][j + b[h]]))
          f[i][j + b[h]] = f[i - 1][j] + a[h];
  ans = M;
  for (int i = 0; i <= m; i++)
    if (f[k][i] != -1) ans = min(ans, f[k][i]);
  printf("%d %d\n", n - k, ans);
  return 0;
}
