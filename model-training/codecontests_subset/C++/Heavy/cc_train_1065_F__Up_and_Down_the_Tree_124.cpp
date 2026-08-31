#include <bits/stdc++.h>
using namespace std;
const int maxd = 1e9 + 7;
struct node {
  int to, nxt;
} sq[2001000];
int n, k, head[1001000], all = 0, dp[1001000], dis[1001000], back[1001000];
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while ((ch < '0') || (ch > '9')) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while ((ch >= '0') && (ch <= '9')) {
    x = x * 10 + (ch - '0');
    ch = getchar();
  }
  return x * f;
}
void add(int u, int v) {
  all++;
  sq[all].to = v;
  sq[all].nxt = head[u];
  head[u] = all;
}
void dfs(int u, int fa) {
  dis[u] = maxd;
  int i;
  for (i = head[u]; i; i = sq[i].nxt) {
    int v = sq[i].to;
    if (v == fa) continue;
    dfs(v, u);
    dis[u] = min(dis[u], dis[v] + 1);
    back[u] += back[v];
    dp[u] = max(dp[u], dp[v] - back[v]);
  }
  dp[u] += back[u];
  if (dis[u] == maxd) {
    dis[u] = 0;
    dp[u] = back[u] = 1;
  }
  if (dis[u] >= k) back[u] = 0;
}
int main() {
  n = read();
  k = read();
  int i;
  for (i = 2; i <= n; i++) {
    int v = read();
    add(i, v);
    add(v, i);
  }
  memset(dp, 0, sizeof(dp));
  memset(dis, 0, sizeof(dis));
  memset(back, 0, sizeof(back));
  dfs(1, 0);
  printf("%d", dp[1]);
  return 0;
}
