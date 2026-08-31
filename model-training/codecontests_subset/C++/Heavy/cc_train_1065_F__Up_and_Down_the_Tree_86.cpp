#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const long long MXN = 1e6 + 10;
long long n, k, x;
long long Comp[MXN], Cnt[MXN], dp[MXN];
vector<long long> adj[MXN], adt[MXN], G[MXN], V[MXN], Jad, Top;
bool mark[MXN], vis[MXN];
void dfs1(long long u, long long d) {
  if (G[u].empty()) {
    adj[u].push_back(Jad[max(d - k, 0ll)]),
        adt[Jad[max(d - k, 0ll)]].push_back(u);
  }
  Jad.push_back(u);
  for (auto v : G[u]) dfs1(v, d + 1);
  Jad.pop_back();
}
void dfs(long long u) {
  mark[u] = 1;
  for (auto v : adj[u]) {
    if (!mark[v]) dfs(v);
  }
  Top.push_back(u);
}
void sfd(long long u) {
  vis[u] = 1, Comp[u] = x, Cnt[x] += (G[u].empty()), V[x].push_back(u);
  for (auto v : adt[u]) {
    if (!vis[v]) sfd(v);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++)
    cin >> x, adj[x].push_back(i), adt[i].push_back(x), G[x].push_back(i);
  dfs1(1, 0), x = 1;
  for (int i = 1; i <= n; i++) {
    if (!mark[i]) dfs(i);
  }
  reverse(Top.begin(), Top.end());
  for (auto u : Top) {
    if (!vis[u]) sfd(u), x++, dp[x - 1] = Cnt[x - 1];
  }
  for (int c = x - 1; c; c--) {
    for (auto u : V[c]) {
      for (auto v : adj[u]) {
        if (Comp[v] != c) dp[c] = max(dp[c], Cnt[c] + dp[Comp[v]]);
      }
    }
  }
  cout << dp[Comp[1]] << '\n';
  return 0;
}
