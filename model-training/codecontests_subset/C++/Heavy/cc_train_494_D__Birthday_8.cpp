#include <bits/stdc++.h>
using namespace std;
template <class T>
T inline sqr(T x) {
  return x * x;
}
const long double pi = 3.1415926535897932384626433832795;
const long double eps = 1e-8;
const int N = 100500;
const int MOD = 1e9 + 7;
const int logN = 18;
int par[logN][N];
int timer = 0;
int tin[N], tout[N];
vector<pair<int, int> > g[N];
long long sumLin[N], sumSqr[N];
long long sumLinDown[N], sumSqrDown[N];
int cntDown[N];
long long h[N];
int n;
inline long long M(long long x) {
  x %= MOD;
  if (x < 0) x += MOD;
  return x;
}
long long f(long long w, int n, long long sumLin) {
  return M(M(w * w) * n + 2 * sumLin * w);
}
void dfs_init(int v) {
  tin[v] = ++timer;
  int p = -1;
  for (int i = 0; i < (int)(g[v].size()); ++i) {
    int to = g[v][i].first, w = g[v][i].second;
    if (tin[to]) {
      p = i;
    } else {
      h[to] = h[v] + w;
      dfs_init(to);
    }
  }
  cntDown[v] = 1;
  if (p != -1) {
    par[0][v] = g[v][p].first;
    g[v].erase(g[v].begin() + p);
  } else
    par[0][v] = v;
  for (pair<int, int> ed : g[v]) {
    int to = ed.first;
    long long w = ed.second;
    cntDown[v] += cntDown[to];
    sumLinDown[v] += sumLinDown[to] + w * cntDown[to];
    sumSqrDown[v] += sumSqrDown[to] + f(w, cntDown[to], sumLinDown[to]);
  }
  sumLinDown[v] %= MOD;
  sumSqrDown[v] %= MOD;
  tout[v] = ++timer;
}
void dfs2(int v) {
  for (pair<int, int> ed : g[v]) {
    int to = ed.first;
    long long w = ed.second;
    int q = cntDown[to];
    sumLin[to] = M(sumLin[v] - q * w + (n - q) * w);
    long long sumToChild = M(sumLinDown[to] + w * q);
    sumSqr[to] = M(sumSqr[v] + f(-w, q, sumToChild)) +
                 f(w, n - q, M(sumLin[v] - sumToChild));
    dfs2(to);
  }
}
bool isIn(int u, int v) { return tin[u] <= tin[v] && tout[u] >= tout[v]; }
int lca(int u, int v) {
  if (isIn(u, v)) return u;
  for (int j = (int)(logN)-1; j >= 0; --j) {
    int nu = par[j][u];
    if (!isIn(nu, v)) u = nu;
  }
  return par[0][u];
}
int main() {
  cin >> n;
  for (int i = 0; i < (int)(n - 1); ++i) {
    int a, b, c;
    cin >> a >> b >> c;
    --a, --b;
    g[a].push_back(make_pair(b, c));
    g[b].push_back(make_pair(a, c));
  }
  dfs_init(0);
  cerr << "init\n";
  for (int i = 1; i <= (int)(logN - 1); ++i)
    for (int j = 0; j < (int)(N); ++j) par[i][j] = par[i - 1][par[i - 1][j]];
  sumSqr[0] = sumSqrDown[0];
  sumLin[0] = sumLinDown[0];
  dfs2(0);
  cerr << "dfs2\n";
  for (int i = 0; i < (int)(n); ++i) {
  }
  int q;
  cin >> q;
  for (int i = 0; i < (int)(q); ++i) {
    int u, v;
    cin >> u >> v;
    --u, --v;
    long long ans = 0;
    int l = lca(u, v);
    long long d = M(h[u] + h[v] - 2 * h[l]);
    if (isIn(v, u)) {
      ans = M(sumSqr[v] - sumSqrDown[v]);
      ans = M(ans + f(d, n - cntDown[v], sumLin[v] - sumLinDown[v]));
      ans = M(sumSqr[u] - 2 * ans);
    } else {
      ans = sumSqrDown[v] + f(d, cntDown[v], sumLinDown[v]);
      ans = M(2 * ans - sumSqr[u]);
    }
    cout << ans << "\n";
  }
  return 0;
}
