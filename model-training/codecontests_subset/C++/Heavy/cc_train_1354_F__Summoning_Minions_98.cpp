#include <bits/stdc++.h>
using namespace std;
const int maxn = 80;
int n, m;
int a[maxn], b[maxn], id[maxn];
int f[maxn][maxn], g[maxn][maxn];
bool used[maxn];
inline int read() {
  char c = getchar();
  int res = 0, f = 1;
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') res = res * 10 + c - '0', c = getchar();
  return res * f;
}
inline bool cmp(int x, int y) { return b[x] < b[y]; }
void dfs(int n, int m) {
  if (!n) return;
  if (g[n][m]) used[n] = 1, m--;
  dfs(n - 1, m);
}
inline void solve() {
  n = read(), m = read();
  for (int i = 1; i <= n; i++) a[i] = read(), b[i] = read(), id[i] = i;
  sort(id + 1, id + n + 1, cmp);
  memset(f, 0xcf, sizeof(f));
  memset(g, 0, sizeof(g));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 0; j <= min(i, m); j++) {
      f[i][j] = f[i - 1][j] + b[id[i]] * (m - 1), g[i][j] = 0;
      if (j && f[i - 1][j - 1] + a[id[i]] + b[id[i]] * (j - 1) > f[i][j])
        f[i][j] = f[i - 1][j - 1] + a[id[i]] + b[id[i]] * (j - 1), g[i][j] = 1;
    }
  memset(used, 0, sizeof(used));
  dfs(n, m);
  printf("%d\n", m - 1 + (n - m) * 2 + 1);
  int last = 0;
  for (int i = 1; i <= n; i++) {
    if (!used[i]) continue;
    last++;
    if (last == m) {
      last = id[i];
      break;
    }
    printf("%d ", id[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (used[i]) continue;
    printf("%d %d ", id[i], -id[i]);
  }
  printf("%d\n", last);
}
int main() {
  int T = read();
  while (T--) solve();
  return 0;
}
