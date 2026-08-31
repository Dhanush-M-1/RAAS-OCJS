#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const long long inf = 1e18;
int n, m, k, lt[maxn], cost[maxn];
bool vis[maxn];
long long solve(int v) {
  int now = 0;
  long long cnt = 0;
  while (true) {
    cnt++;
    now += v;
    if (now >= n) return cnt;
    if (lt[now] == now - v) return -1;
    now = lt[now];
  }
}
int main() {
  int i, j, x;
  long long ans, val;
  while (scanf("%d%d%d", &n, &m, &k) != EOF) {
    memset(vis, false, sizeof(vis));
    for (i = 1; i <= m; i++) {
      scanf("%d", &x);
      vis[x] = true;
    }
    for (i = 1; i <= k; i++) scanf("%d", &cost[i]);
    if (vis[0]) {
      printf("-1\n");
      continue;
    }
    for (i = 0; i < n; i++) {
      if (vis[i])
        lt[i] = lt[i - 1];
      else
        lt[i] = i;
    }
    ans = inf;
    for (i = 1; i <= k; i++) {
      val = solve(i);
      if (val != -1) ans = min(ans, val * cost[i]);
    }
    if (ans == inf)
      printf("-1\n");
    else
      printf("%lld\n", ans);
  }
  return 0;
}
