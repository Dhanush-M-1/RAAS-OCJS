#include <bits/stdc++.h>
using namespace std;
const long long int maxn = (1e6) + 10, mod = 1e9 + 7;
long long int n, k, lf[maxn], h[maxn], dp[maxn], pd[maxn];
vector<long long int> G[maxn], v1, v2;
void pre_DFS(long long int v) {
  for (long long int u : G[v]) {
    h[u] = h[v] + 1;
    pre_DFS(u);
  }
}
void DFS(long long int v) {
  if (!G[v].size()) {
    lf[v] = h[v], dp[v] = pd[v] = 1;
    return;
  } else
    lf[v] = mod;
  for (long long int u : G[v]) {
    DFS(u);
    lf[v] = min(lf[v], lf[u]);
  }
  for (long long int u : G[v])
    if (lf[u] - k <= h[v]) dp[v] += dp[u];
  pd[v] = dp[v];
  for (long long int u : G[v]) {
    if (lf[u] - k <= h[v])
      pd[v] = max(pd[v], dp[v] + (pd[u] - dp[u]));
    else
      pd[v] = max(pd[v], dp[v] + pd[u]);
  }
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (long long int i = 2; i <= n; i++) {
    long long int x;
    cin >> x;
    G[x].push_back(i);
  }
  pre_DFS(1);
  DFS(1);
  cout << pd[1] << endl;
}
