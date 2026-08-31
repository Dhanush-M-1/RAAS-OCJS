#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
int n, k;
vector<int> kid[N];
int h[N];
int lst[N];
int cm[N];
void dfs(int v) {
  if (!kid[v].size()) {
    lst[v] = h[v];
    return;
  }
  lst[v] = 1e9;
  for (auto u : kid[v]) {
    h[u] = h[v] + 1;
    dfs(u);
    lst[v] = min(lst[v], lst[u]);
  }
}
void getcm(int v) {
  if (!kid[v].size()) {
    cm[v] = 1;
    return;
  }
  for (auto u : kid[v]) {
    getcm(u);
    if (lst[u] - h[v] <= k) cm[v] += cm[u];
  }
}
int dp[N];
void solve(int v) {
  if (!kid[v].size()) {
    dp[v] = 1;
    return;
  }
  for (auto u : kid[v]) solve(u);
  int s = 0;
  for (auto u : kid[v])
    if (lst[u] - h[v] <= k) s += cm[u];
  for (auto u : kid[v])
    if (lst[u] - h[v] <= k)
      dp[v] = max(dp[v], s - cm[u] + dp[u]);
    else
      dp[v] = max(dp[v], s + dp[u]);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int p;
    cin >> p;
    kid[p].push_back(i);
  }
  dfs(1);
  getcm(1);
  solve(1);
  cout << dp[1];
}
