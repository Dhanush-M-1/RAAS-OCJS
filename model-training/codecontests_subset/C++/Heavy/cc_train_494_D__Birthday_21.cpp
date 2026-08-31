#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:128000000")
using namespace std;
void solve();
int main() {
  cin.tie(0);
  cout.sync_with_stdio(0);
  cout.precision(10);
  cout << fixed;
  cin.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
int TIMER = 1;
vector<pair<long long, long long> > g[101010];
int tin[101010];
int tout[101010];
long long depth[101010];
long long cntDown[101010];
long long sumDistDown[101010];
long long sumSqrDistDown[101010];
long long sumDist[101010];
long long sumSqrDist[101010];
long long sumDistUp[101010];
long long sumSqrDistUp[101010];
const int MOD = 1000000007;
int n;
int l = 17;
vector<int> up[101010];
void dfs(int v, int p) {
  tin[v] = ++TIMER;
  cntDown[v] = 1;
  up[v][0] = p;
  for (int i = 1; i <= l; ++i) up[v][i] = up[up[v][i - 1]][i - 1];
  for (pair<int, int> to : g[v]) {
    if (to.first == p) continue;
    depth[to.first] = depth[v] + to.second;
    depth[to.first] %= MOD;
    dfs(to.first, v);
    cntDown[v] += cntDown[to.first];
    sumDistDown[v] += sumDistDown[to.first] + cntDown[to.first] * to.second;
    sumDistDown[v] %= MOD;
    sumSqrDistDown[v] += sumSqrDistDown[to.first] +
                         to.second * 2 * sumDistDown[to.first] % MOD +
                         cntDown[to.first] * to.second % MOD * to.second;
    sumSqrDistDown[v] %= MOD;
  }
  tout[v] = ++TIMER;
}
void dfs2(int v, int p) {
  for (pair<int, int> to : g[v]) {
    if (to.first == p) continue;
    sumDist[to.first] = sumDist[v] - to.second * cntDown[to.first] +
                        to.second * (n - cntDown[to.first]);
    sumDist[to.first] %= MOD;
    sumDistUp[to.first] = (sumDist[to.first] - sumDistDown[to.first]) % MOD;
    sumSqrDist[to.first] =
        sumSqrDist[v] -
        2 * to.second *
            (sumDistDown[to.first] + to.second * cntDown[to.first] % MOD) +
        cntDown[to.first] * to.second % MOD * to.second;
    sumSqrDist[to.first] +=
        2 * to.second *
            (sumDistUp[to.first] - to.second * (n - cntDown[to.first]) % MOD) +
        (n - cntDown[to.first]) * to.second % MOD * to.second;
    sumSqrDist[to.first] %= MOD;
    sumSqrDistUp[to.first] =
        (sumSqrDist[to.first] - sumSqrDistDown[to.first]) % MOD;
    dfs2(to.first, v);
  }
  tout[v] = ++TIMER;
}
bool upper(int v, int u) { return (tin[v] <= tin[u] && tout[v] >= tout[u]); }
int lca(int a, int b) {
  if (upper(a, b)) return a;
  if (upper(b, a)) return b;
  for (int i = l; i >= 0; --i)
    if (!upper(up[a][i], b)) a = up[a][i];
  return up[a][0];
}
long long dist(long long u, long long v) {
  long long x = lca(u, v);
  return (depth[u] + depth[v] - 2 * depth[x]) % MOD;
}
void solve() {
  cin >> n;
  for (int i = 0; i < n - 1; ++i) {
    int a, b, c;
    cin >> a >> b >> c;
    --a, --b;
    g[a].push_back(make_pair(b, c));
    g[b].push_back(make_pair(a, c));
  }
  for (int i = 0; i < n; ++i) up[i].resize(l + 1);
  dfs(0, 0);
  sumDist[0] = sumDistDown[0];
  sumSqrDist[0] = sumSqrDistDown[0];
  dfs2(0, -1);
  int m;
  cin >> m;
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    --u, --v;
    long long ans = 0;
    long long d = dist(u, v);
    if (upper(v, u)) {
      ans = sumSqrDist[u] - (sumSqrDistUp[v] + 2 * d * sumDistUp[v] +
                             d * d % MOD * (n - cntDown[v]));
    } else {
      ans =
          sumSqrDistDown[v] + 2 * d * sumDistDown[v] + cntDown[v] * d % MOD * d;
    }
    ans %= MOD;
    ans = 2 * ans - sumSqrDist[u];
    ans %= MOD;
    ans += MOD;
    ans %= MOD;
    cout << ans << "\n";
  }
}
