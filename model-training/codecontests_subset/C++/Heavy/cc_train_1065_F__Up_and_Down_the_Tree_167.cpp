#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000010;
int n, k;
int p[maxn];
vector<int> G[maxn];
int dep[maxn];
int min_dep[maxn];
bool is_leaf[maxn];
int dp[maxn];
void pre_dfs(int u) {
  int sz = G[u].size();
  is_leaf[u] = 1;
  for (int i = 0; i < sz; i++) {
    int v = G[u][i];
    dep[v] = dep[u] + 1;
    is_leaf[u] = 0;
    pre_dfs(v);
    min_dep[u] = min(min_dep[u], min_dep[v]);
  }
  if (is_leaf[u]) min_dep[u] = dep[u];
}
int last_dep = 0;
int tmp = 0;
int ans = 0;
int que[maxn];
int que_size = 0;
int dfs(int u) {
  int re = is_leaf[u];
  int sz = G[u].size();
  for (int i = 0; i < sz; i++) {
    int v = G[u][i];
    if (min_dep[v] - dep[v] >= k) {
      que[que_size++] = v;
      continue;
    } else {
      re += dfs(v);
    }
  }
  dp[u] = re;
  return re;
}
int dfs2(int u) {
  int re = is_leaf[u];
  int sz = G[u].size();
  int mx = 0;
  for (int i = 0; i < sz; i++) {
    int v = G[u][i];
    if (min_dep[v] - dep[v] >= k) {
      mx = max(mx, dfs2(v));
    } else {
      int tmp = dfs2(v);
      mx = max(mx, tmp - dp[v]);
      re += dp[v];
    }
  }
  re += mx;
  return re;
}
int main() {
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    scanf("%d", &p[i]);
    G[p[i]].push_back(i);
  }
  for (int i = 1; i <= n; i++) min_dep[i] = 1e9;
  pre_dfs(1);
  que[que_size++] = 1;
  for (int i = 0; i < que_size; i++) {
    dfs(que[i]);
  }
  cout << dfs2(1) << endl;
  return 0;
}
