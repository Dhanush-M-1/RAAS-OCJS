#include <bits/stdc++.h>
using namespace std;
int pre[1010];
int a[1010], in[1010];
int dp[1010];
int n, m, my;
int dfs(int x) {
  int cnt = 1;
  int u = x, k = 0;
  if (u == m) k = 1;
  while (pre[u] != u) {
    ++cnt;
    u = pre[u];
    if (u == m) k = 1;
  }
  if (k) {
    int c = 1;
    u = x;
    while (u != m) {
      ++c;
      u = pre[u];
    }
    my = cnt - c + 1;
    return 0;
  } else
    return cnt;
}
int main() {
  int x;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) pre[i] = i, in[i] = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &x);
    if (x) pre[i] = x, ++in[x];
  }
  int cnt = 0;
  for (int i = 1; i <= n; ++i) {
    if (!in[i]) {
      x = dfs(i);
      if (x) a[cnt++] = x;
    }
  }
  memset(dp, 0, sizeof(dp));
  dp[0] = 1;
  for (int i = 0; i < cnt; ++i)
    for (int j = n; j - a[i] >= 0; --j)
      if (dp[j - a[i]]) dp[j] = 1;
  for (int i = 0; i <= n; ++i)
    if (dp[i] && i + my <= n) printf("%d\n", i + my);
}
