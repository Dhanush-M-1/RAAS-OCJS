#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int inf = 0x3f3f3f3f;
struct Edge {
  int to, nxt;
} E[maxn << 1];
int n, k;
int head[maxn], cnt;
void addedge(int u, int v) {
  E[++cnt].to = v;
  E[cnt].nxt = head[u];
  head[u] = cnt;
}
int dp[maxn];
int step[maxn];
int siz[maxn];
void dfs(int u, int fa) {
  step[u] = inf;
  for (int i = head[u]; i; i = E[i].nxt) {
    int v = E[i].to;
    if (v == fa) continue;
    dfs(v, u);
    siz[u] += siz[v];
    step[u] = min(step[u], step[v] + 1);
    dp[u] = max(dp[u], dp[v] - siz[v]);
  }
  dp[u] += siz[u];
  if (step[u] == inf) dp[u] = siz[u] = 1, step[u] = 0;
  if (step[u] >= k) siz[u] = 0;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int p, i = 2; i <= n; i++) {
    scanf("%d", &p);
    addedge(p, i);
  }
  dfs(1, 0);
  printf("%d", dp[1]);
  return 0;
}
