#include <bits/stdc++.h>
using namespace std;
vector<int> g[100111];
long long a[100111], b[100111];
long long dp[100111];
long long wt[100111];
int n;
void dfs(int v) {
  for (auto nv : g[v]) {
    dfs(nv);
    if (dp[nv] < 0) {
      if ((1ll << 61) / wt[nv] <= -dp[nv]) {
        dp[nv] = 0;
        dp[v] = -(1ll << 61);
      } else {
        dp[v] += dp[nv] * wt[nv];
        dp[nv] = 0;
        if (dp[v] < -(1ll << 61)) dp[v] = -(1ll << 61);
      }
    } else {
      dp[v] += dp[nv];
      dp[nv] = 0;
    }
  }
}
int main() {
  int i;
  scanf("%d", &n);
  for (i = 1; i <= n; ++i) {
    scanf("%I64d", &b[i]);
  }
  for (i = 1; i <= n; ++i) {
    scanf("%I64d", &a[i]);
  }
  for (i = 1; i <= n; ++i) {
    dp[i] = b[i] - a[i];
  }
  for (i = 2; i <= n; ++i) {
    int v;
    long long k;
    scanf("%d%I64d", &v, &k);
    g[v].push_back(i);
    wt[i] = k;
  }
  dfs(1);
  printf("%s\n", dp[1] >= 0 ? "YES" : "NO");
  return 0;
}
