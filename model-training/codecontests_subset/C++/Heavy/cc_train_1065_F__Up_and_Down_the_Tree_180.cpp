#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.14159265359;
const long long MOD = (long long)998244353ll;
const long long MAXN = (long long)1e6 + 10;
const long long INF = (long long)2242545357980376863;
const long double EPS = (long double)1e-8;
long long n, k;
long long val[MAXN], par[MAXN], dp[MAXN];
vector<long long> G[MAXN], H[MAXN], R[MAXN], vis, ord, topol;
vector<pair<long long, long long> > to_add, E;
bitset<1000010> lf, mk1, mk2;
void DFS(long long u) {
  long long dep = vis.size();
  vis.push_back(u);
  long long p = vis[max(dep - k, 0ll)];
  lf[u] = true;
  for (auto adj : G[u]) {
    DFS(adj);
    lf[u] = false;
  }
  if (lf[u]) to_add.push_back({u, p});
  vis.pop_back();
}
void DFS1(long long u) {
  mk1[u] = true;
  for (auto adj : G[u]) {
    if (!mk1[adj]) DFS1(adj);
  }
  ord.push_back(u);
}
void DFS2(long long u, long long p) {
  mk2[u] = true;
  par[u] = p;
  val[p] += (lf[u] ? 1 : 0);
  for (auto adj : H[u]) {
    if (!mk2[adj]) DFS2(adj, p);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  long long u, v;
  for (int i = 2; i <= n; i++) {
    cin >> u;
    G[u].push_back(i);
    H[i].push_back(u);
    E.push_back({i, u});
  }
  DFS(1);
  for (auto edge : to_add) {
    u = edge.first;
    v = edge.second;
    G[u].push_back(v);
    H[v].push_back(u);
    E.push_back({v, u});
  }
  DFS1(1);
  reverse(ord.begin(), ord.end());
  for (auto node : ord) {
    if (!mk2[node]) {
      DFS2(node, node);
      topol.push_back(node);
    }
  }
  for (auto edge : E) {
    u = edge.first;
    v = edge.second;
    u = par[u];
    v = par[v];
    if (u != v) R[u].push_back(v);
  }
  for (auto node : topol) {
    dp[node] = val[node];
    for (auto adj : R[node]) {
      dp[node] = max(dp[node], dp[adj] + val[node]);
    }
  }
  cout << *max_element(dp + 1, dp + n + 1);
  return 0;
}
