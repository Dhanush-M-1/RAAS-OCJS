#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 100;
vector<int> a[N];
int deep[N], leaf[N], dp[N], n, k;
void dfs(int u) {
  if (a[u].size() == 0) {
    leaf[u] = dp[u] = deep[u] = 1;
    return;
  }
  deep[u] = n + 12;
  int tmp = 0;
  for (int v : a[u]) {
    dfs(v);
    deep[u] = min(deep[v] + 1, deep[u]);
    tmp += leaf[v];
  }
  if (deep[u] <= k) leaf[u] = tmp;
  for (int v : a[u]) {
    dp[u] = max(dp[u], tmp - leaf[v] + dp[v]);
  }
}
int x;
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    scanf("%d", &x);
    a[x].push_back(i);
  }
  dfs(1);
  printf("%d", dp[1]);
  return 0;
}
