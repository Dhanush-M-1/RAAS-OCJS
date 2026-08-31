#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long double eps = 1e-7;
const int inf = 1000000010;
const long long INF = 10000000000000010LL;
const int mod = 1000000007;
const int MAXN = 1000010, LOG = 20;
int n, m, k, u, v, x, y, t, a, b, ans;
int par[MAXN][LOG];
int leaf[MAXN];
int comp[MAXN];
int sz[MAXN];
int dp[MAXN];
bitset<MAXN> mark;
vector<int> Gin[MAXN], Gout[MAXN];
vector<int> G[MAXN];
vector<int> vec;
int getpar(int v) {
  for (int i = 0; i < LOG; i++)
    if ((1 << i) & k) v = par[v][i];
  return v;
}
void dfsout(int node) {
  mark[node] = 1;
  for (int v : Gout[node])
    if (!mark[v]) dfsout(v);
  vec.push_back(node);
}
void dfsin(int node, int c) {
  comp[node] = c;
  for (int v : Gin[node])
    if (!comp[v]) dfsin(v, c);
}
int f(int node) {
  if (dp[node] != -1) return dp[node];
  dp[node] = 0;
  for (int v : G[node]) dp[node] = max(dp[node], f(v));
  return dp[node] += sz[node];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  memset(dp, -1, sizeof(dp));
  cin >> n >> k;
  fill(leaf + 2, leaf + n + 1, 1);
  for (int i = 2; i <= n; i++) {
    cin >> par[i][0];
    leaf[par[i][0]] = 0;
    Gout[par[i][0]].push_back(i);
    Gin[i].push_back(par[i][0]);
  }
  par[1][0] = 1;
  for (int j = 1; j < LOG; j++) {
    par[1][j] = 1;
    for (int i = 2; i <= n; i++) par[i][j] = par[par[i][j - 1]][j - 1];
  }
  for (int i = 2; i <= n; i++)
    if (leaf[i]) {
      int p = getpar(i);
      Gin[p].push_back(i);
      Gout[i].push_back(p);
    }
  dfsout(1);
  reverse(vec.begin(), vec.end());
  for (int i : vec)
    if (!comp[i]) dfsin(i, i);
  for (int i = 1; i <= n; i++) sz[comp[i]] += leaf[i];
  for (int i = 1; i <= n; i++) {
    for (int v : Gout[i])
      if (comp[i] != comp[v]) G[comp[i]].push_back(comp[v]);
  }
  cout << f(1) << '\n';
  return 0;
}
