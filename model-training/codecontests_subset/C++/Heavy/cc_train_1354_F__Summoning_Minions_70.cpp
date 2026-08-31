#include <bits/stdc++.h>
using namespace std;
const int Maxn = 88, inf = 0x3f3f3f3f;
struct node {
  int a, b, id;
} g[Maxn];
int f[Maxn][Maxn], s[Maxn];
bool flag[Maxn][Maxn], vis[Maxn];
int a[Maxn], b[Maxn], id[Maxn];
int n, m, cnt;
inline bool cmp(node x, node y) { return x.b < y.b; }
void init() {
  for (int i = 0; i <= n; ++i)
    for (int j = 0; j <= m; ++j) flag[i][j] = 0;
  for (int i = 1; i <= n; ++i) s[i] = vis[i] = 0;
  cnt = 0;
}
inline int read() {
  int s = 0, w = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9')
    s = (s << 3) + (s << 1) + (ch ^ 48), ch = getchar();
  return s * w;
}
int main() {
  int T = read();
  while (T--) {
    n = read(), m = read();
    for (int i = 1; i <= n; ++i) g[i].a = read(), g[i].b = read(), g[i].id = i;
    sort(g + 1, g + 1 + n, cmp);
    for (int i = 1; i <= n; ++i) a[i] = g[i].a, b[i] = g[i].b, id[i] = g[i].id;
    for (int i = 0; i <= n; ++i)
      for (int j = 0; j <= m; ++j) f[i][j] = -inf;
    f[0][0] = 0;
    for (int i = 1; i <= n; ++i)
      for (int j = 0; j <= min(i, m); ++j) {
        f[i][j] = f[i - 1][j] + b[i] * (m - 1), flag[i][j] = 0;
        if (j && f[i - 1][j - 1] + a[i] + b[i] * (j - 1) > f[i][j])
          f[i][j] = f[i - 1][j - 1] + a[i] + b[i] * (j - 1), flag[i][j] = 1;
      }
    int i = n, j = m;
    while (i) {
      if (flag[i][j]) s[++cnt] = i, vis[i] = 1, --j;
      --i;
    }
    printf("%d\n", (n << 1) - m);
    for (int i = cnt; i > 1; --i) printf("%d ", id[s[i]]);
    for (int i = 1; i <= n; ++i)
      if (!vis[i]) printf("%d %d ", id[i], -id[i]);
    printf("%d\n", id[s[1]]);
    init();
  }
  return 0;
}
