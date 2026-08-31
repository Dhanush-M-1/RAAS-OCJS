#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10, M = 1e6 + 10;
bool vis[N], visa[N];
long long n, i, m, las[N], nex[M], t, tot, tov[M], x, y, a, b, pre[N], suma,
    sumb, ans;
void ins(long long x, long long y) {
  tov[++tot] = y, nex[tot] = las[x], las[x] = tot;
}
void dfs(long long x, long long c) {
  long long i, y;
  vis[x] = true;
  for (i = las[x]; i; i = nex[i]) {
    y = tov[i];
    if (vis[y] || y == c) continue;
    dfs(y, c);
  }
}
int main() {
  for (scanf("%d", &t); t; t--) {
    scanf("%lld%lld%lld%lld", &n, &m, &a, &b), tot = suma = sumb = 0;
    memset(las, 0, sizeof(las));
    for (i = 1; i <= m; i++) {
      scanf("%lld%lld", &x, &y), ins(x, y), ins(y, x);
    }
    memset(vis, false, sizeof(vis));
    dfs(a, b);
    memcpy(visa, vis, sizeof(visa));
    memset(vis, false, sizeof(vis));
    dfs(b, a);
    for (i = 1; i <= n; i++) {
      if (visa[i] && !vis[i] && i != a) suma++;
      if (!visa[i] && vis[i] && i != b) sumb++;
    }
    ans = suma * sumb;
    printf("%lld\n", ans);
  }
}
