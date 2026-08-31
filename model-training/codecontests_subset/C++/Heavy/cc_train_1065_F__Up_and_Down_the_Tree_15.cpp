#include <bits/stdc++.h>
using namespace std;
inline int getint() {
  char c = getchar();
  int x = 0;
  bool p = 0;
  while ((c < '0' || c > '9') && c != '-') c = getchar();
  if (c == '-') p = 1, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  if (p) x = -x;
  return x;
}
int n, k, tot, la[1000010], dp[1000010][2], s[1000010], st[1000010];
struct edge {
  int v, ne;
} e[1000010];
inline void add(int u, int v) {
  e[tot].v = v, e[tot].ne = la[u], la[u] = tot++;
}
void init() {
  tot = 0;
  memset(la, -1, sizeof(la));
  n = getint(), k = getint();
  for (int i = 2; i <= n; ++i) add(getint(), i);
}
inline void dfs(int u, int d) {
  st[d] = u;
  for (int i = la[u]; ~i; i = e[i].ne) {
    int v = e[i].v;
    dfs(v, d + 1);
    s[u] += s[v];
    if (s[v]) dp[u][0] += dp[v][0];
  }
  for (int i = la[u]; ~i; i = e[i].ne) {
    int v = e[i].v;
    if (s[v])
      dp[u][1] = max(dp[u][1], dp[u][0] - dp[v][0] + dp[v][1]);
    else
      dp[u][1] = max(dp[u][1], dp[u][0] + dp[v][1]);
  }
  if (la[u] == -1) {
    dp[u][0] = dp[u][1] = 1;
    ++s[u], --s[st[max(1, d - k)]];
  }
}
void solve() {
  dfs(1, 1);
  printf("%d\n", dp[1][1]);
}
int main() {
  init();
  solve();
  return 0;
}
