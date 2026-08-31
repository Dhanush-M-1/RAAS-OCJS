#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
const int N = 1e6 + 10;
const int INF = INT_MAX;
const int MAXLOG = 20;
const int MOD = 1e9 + 7;
int n, k, par[N], cnt[N], dp[N], c = 1, cmp[N];
vector<int> in[N], out[N], in1[N], out1[N], path, fn, f;
bool mark[N], lf[N];
void Dfs(int v) {
  mark[v] = 1;
  if (v != 1) {
    int sz = path.size();
    par[v] = path[max((int)path.size() - k, 0)];
  }
  if (out[v].size() == 0) lf[v] = 1;
  path.push_back(v);
  for (auto u : out[v])
    if (!mark[u]) Dfs(u);
  path.pop_back();
}
void DFS(int v) {
  mark[v] = 1;
  for (int u : out[v])
    if (!mark[u]) DFS(u);
  fn.push_back(v);
}
void SDF(int v) {
  cmp[v] = c;
  for (int u : in[v])
    if (cmp[u] == 0) SDF(u);
}
void ftime(int v) {
  mark[v] = 1;
  for (int u : out1[v])
    if (!mark[u]) ftime(u);
  f.push_back(v);
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int x;
    cin >> x;
    in[i].push_back(x);
    out[x].push_back(i);
  }
  Dfs(1);
  for (int i = 1; i <= n; i++)
    if (lf[i]) in[par[i]].push_back(i), out[i].push_back(par[i]);
  memset(mark, 0, sizeof mark);
  for (int i = 1; i <= n; i++)
    if (!mark[i]) DFS(i);
  reverse(fn.begin(), fn.end());
  for (int i : fn)
    if (!cmp[i]) SDF(i), c++;
  for (int i = 1; i <= n; i++)
    for (int j : out[i])
      if (cmp[i] != cmp[j])
        in1[cmp[j]].push_back(cmp[i]), out1[cmp[i]].push_back(cmp[j]);
  for (int i = 1; i <= n; i++)
    if (lf[i]) cnt[cmp[i]]++;
  dp[1] = cnt[1];
  memset(mark, 0, sizeof mark);
  ftime(1);
  reverse(f.begin(), f.end());
  for (int u : f)
    for (int v : out1[u]) dp[v] = max(dp[u] + cnt[v], dp[v]);
  cout << *max_element(dp, dp + n + 1);
  return 0;
}
