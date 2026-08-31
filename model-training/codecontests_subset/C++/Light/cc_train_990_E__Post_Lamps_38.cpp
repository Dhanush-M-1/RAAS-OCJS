#include <bits/stdc++.h>
using namespace std;
int dp[1000005], c[1000005], adj[1000005];
int n, m, k, s;
long long solve(int i) {
  int cur = 0, pv = 0;
  long long val = 0;
  while (cur < n) {
    pv = cur;
    cur += i;
    val += c[i];
    if (cur >= n) break;
    if (dp[cur]) cur = adj[cur];
    if (pv >= cur) return 1e18;
  }
  return val;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i <= n; i++) adj[i] = i;
  for (int i = 1; i <= m; i++) {
    scanf("%d", &s);
    dp[s] = 1;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d", &c[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (dp[i] == 1) adj[i] = adj[i - 1];
  }
  if (dp[0] == 1) {
    printf("-1\n");
    return 0;
  }
  long long ans = 1e18;
  for (int i = 1; i <= k; i++) {
    long long res = solve(i);
    if (res != 1e18) ans = min(ans, res);
  }
  if (ans == 1e18) ans = -1;
  printf("%lld\n", ans);
}
