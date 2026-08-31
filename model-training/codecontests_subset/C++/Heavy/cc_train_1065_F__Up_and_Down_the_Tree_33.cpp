#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long double Pi = 3.14159265359;
const long long MOD = 1000 * 1000 * 1000 + 7;
const long long N = 1e6 + 10;
const long long INF = 1e18;
const long long LOG = 20;
long long n, COM[N], k, v, u;
vector<long long> gin[N], gout[N], fn;
bitset<N> mark;
vector<long long> path;
long long deg[N];
vector<long long> G[N];
long long dp[N];
void DFS(long long v, long long p = 0) {
  mark[v] = 1;
  path.push_back(v);
  for (auto u : gout[v]) {
    if (mark[u]) continue;
    DFS(u, v);
  }
  if (deg[v] == 1 && p != 0) {
    long long node;
    if (path.size() - 1 - k < 0)
      node = 1;
    else {
      node = path[path.size() - 1 - k];
    }
    gout[v].push_back(node);
    gin[node].push_back(v);
  }
  path.pop_back();
  fn.push_back(v);
}
void SDF(long long v, long long C) {
  mark[v] = 1;
  COM[v] = C;
  for (auto u : gin[v]) {
    if (!mark[u]) {
      SDF(u, C);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    cin >> v;
    gout[v].push_back(i), gin[i].push_back(v);
    deg[i]++, deg[v]++;
  }
  DFS(1);
  for (int i = 0; i < N; i++) mark[i] = 0;
  long long com = 1;
  reverse(fn.begin(), fn.end());
  for (auto u : fn) {
    if (!mark[u]) {
      SDF(u, com++);
    }
  }
  for (int i = 1; i <= n; i++) {
    for (auto u : gout[i]) {
      if (COM[u] == COM[i]) continue;
      G[COM[i]].push_back(COM[u]);
    }
    if (i != 1 && deg[i] == 1) {
      dp[COM[i]]++;
    }
  }
  for (int i = com - 1; i >= 1; i--) {
    long long ans = 0;
    for (auto u : G[i]) {
      ans = max(ans, dp[u]);
    }
    dp[i] += ans;
  }
  cout << dp[COM[1]];
  return 0;
}
