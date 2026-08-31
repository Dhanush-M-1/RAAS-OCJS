#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const int mod = 1e9 + 7;
void add(int &a, int b) {
  a += b;
  if (a >= mod) a -= mod;
}
int sum(int a, int b) {
  add(a, b);
  return a;
}
int mult(int a, int b) { return (1ll * a * b) % mod; }
int n, up[20][N], timer, tin[N], tout[N], q, sz[N], len[N], cost[N];
vector<pair<int, int> > g[N];
pair<int, int> dp[N], d[N], shit[N];
bool P(int a, int b) { return tin[a] <= tin[b] && tout[a] >= tout[b]; }
void dfs(int v = 1, int p = 1) {
  tin[v] = ++timer;
  up[0][v] = p;
  for (int i = 1; i < 20; i++) up[i][v] = up[i - 1][up[i - 1][v]];
  sz[v] = 1;
  for (auto to : g[v]) {
    if (to.first != p) {
      len[to.first] = sum(len[v], to.second);
      cost[to.first] = to.second;
      dfs(to.first, v);
      sz[v] += sz[to.first];
      add(d[v].first, sum(d[to.first].first, mult(to.second, sz[to.first])));
      int now = sum(d[to.first].second,
                    mult(sz[to.first], mult(to.second, to.second)));
      add(now, mult(2, mult(to.second, d[to.first].first)));
      add(d[v].second, now);
    }
  }
  tout[v] = ++timer;
}
void go(int v = 1, int p = 1, pair<int, int> up = make_pair(0, 0)) {
  shit[v] = up;
  dp[v] = make_pair(sum(d[v].first, up.first), sum(d[v].second, up.second));
  for (auto to : g[v]) {
    if (to.first != p) {
      pair<int, int> now = dp[v];
      add(now.first,
          mod - sum(d[to.first].first, mult(sz[to.first], to.second)));
      int temp = sum(d[to.first].second,
                     mult(sz[to.first], mult(to.second, to.second)));
      add(temp, mult(2, mult(to.second, d[to.first].first)));
      add(now.second, mod - temp);
      temp = sum(mult(2, mult(to.second, now.first)),
                 mult(n - sz[to.first], mult(to.second, to.second)));
      add(now.second, temp);
      add(now.first, mult(to.second, n - sz[to.first]));
      go(to.first, v, now);
    }
  }
}
int lca(int a, int b) {
  if (P(a, b)) return a;
  if (P(b, a)) return b;
  for (int i = 19; i >= 0; i--) {
    int x = up[i][a];
    if (!P(x, b)) a = x;
  }
  return up[0][a];
}
int dist(int a, int b) {
  int c = lca(a, b);
  int ans = sum(len[a], len[b]);
  add(ans, mod - mult(2, len[c]));
  return ans;
}
int get(int a, int b) {
  for (int i = 19; i >= 0; i--) {
    int x = up[i][a];
    if (!P(x, b)) a = x;
  }
  return a;
}
int main() {
  ios_base::sync_with_stdio(0);
  clock_t start = clock();
  cin >> n;
  for (int i = 1, u, v, c; i < n; i++) {
    cin >> u >> v >> c;
    g[u].push_back(make_pair(v, c));
    g[v].push_back(make_pair(u, c));
  }
  dfs();
  go();
  cin >> q;
  while (q--) {
    int a, b;
    cin >> a >> b;
    int di = dist(a, b);
    int ans = 0;
    if (!P(b, a) || a == b) {
      ans = sum(d[b].second, mult(sz[b], mult(di, di)));
      add(ans, mult(2, mult(di, d[b].first)));
      ans = sum(ans, ans);
      add(ans, mod - dp[a].second);
    } else {
      ans = dp[a].second;
      int now = sum(shit[b].second, mult(n - sz[b], mult(di, di)));
      add(now, mult(2, mult(di, shit[b].first)));
      add(ans, mod - now);
      ans = sum(ans, ans);
      add(ans, mod - dp[a].second);
    }
    cout << ans << endl;
  }
  double duration = ((double)clock() - start) / (double)CLOCKS_PER_SEC;
  return 0;
}
