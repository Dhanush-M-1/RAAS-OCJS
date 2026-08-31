#include <bits/stdc++.h>
using namespace std;
const int M = 2 * 1e5 + 10;
const long long Q = 1e9 + 7;
const long double eps = 1e-2;
const long double pi = 3.141592653589793238;
long long dp0[M], dp1[M], f[M], d[M], fi[M];
int kol[M], lvl[M], tin[M], tout[M], T = 0;
int jump[M][22];
vector<pair<int, long long> > g[M];
long long inc(int t, long long su, long long suq, long long y) {
  su = ((su % Q) + Q) % Q;
  suq = ((suq % Q) + Q) % Q;
  y = ((y % Q) + Q) % Q;
  return (suq + (2 * su * y) % Q + (t * ((y * y) % Q)) % Q) % Q;
}
long long dec(long long x, long long y) { return (x + Q - y) % Q; }
void build(int i, int pr) {
  int j;
  tin[i] = T++;
  jump[i][0] = pr;
  if (pr != i) lvl[i] = lvl[pr] + 1;
  for (j = 0; j < (int)g[i].size(); j++)
    if (g[i][j].first != pr) {
      d[g[i][j].first] = (d[i] + g[i][j].second) % Q;
      build(g[i][j].first, i);
    }
  for (j = 0; j < (int)g[i].size(); j++) {
    if (g[i][j].first == pr) continue;
    dp0[i] = (dp0[i] + dp0[g[i][j].first] +
              g[i][j].second * (long long)kol[g[i][j].first]) %
             Q;
    kol[i] += kol[g[i][j].first];
    dp1[i] = (dp1[i] + inc(kol[g[i][j].first], dp0[g[i][j].first],
                           dp1[g[i][j].first], g[i][j].second)) %
             Q;
  }
  kol[i]++;
  tout[i] = T++;
}
void dfs(int i, int pr, int ch, long long su, long long suq) {
  f[i] = (dp1[i] + suq) % Q;
  fi[i] = (dp0[i] + su) % Q;
  for (int j = 0; j < (int)g[i].size(); j++) {
    if (g[i][j].first != pr) {
      int child = ch + kol[i] - kol[g[i][j].first];
      long long su0 = (dec(0, (g[i][j].second * kol[g[i][j].first]) % Q) +
                       (su + dec(dp0[i], dp0[g[i][j].first]) +
                        (child * g[i][j].second) % Q)) %
                      Q;
      long long su1 = inc(
          child, dec(su0, (g[i][j].second * child) % Q),
          ((suq + dec(dp1[i], dp1[g[i][j].first]) -
            (kol[g[i][j].first] * ((g[i][j].second * g[i][j].second) % Q)) % Q -
            (2 * g[i][j].second * dp0[g[i][j].first]) % Q) %
               Q +
           Q) %
              Q,
          g[i][j].second);
      dfs(g[i][j].first, i, child, su0, su1);
    }
  }
}
bool is_child(int u, int v) { return (tin[v] < tin[u] && tout[u] < tout[v]); }
int lca(int i, int j) {
  int a = i;
  int b = j;
  int k;
  if (lvl[a] < lvl[b]) swap(a, b);
  for (k = 20; k >= 0; k--)
    if (lvl[jump[a][k]] >= lvl[b]) a = jump[a][k];
  if (a == b) return a;
  for (k = 20; k >= 0; k--) {
    if (jump[a][k] != jump[b][k]) {
      a = jump[a][k];
      b = jump[b][k];
    }
  }
  return jump[a][0];
}
long long dist(int i, int j) {
  int lc = lca(i, j);
  return ((d[i] + d[j] - 2 * d[lc]) % Q + Q) % Q;
}
int main() {
  srand(time(NULL));
  int n, i, u, v, j, q;
  long long c;
  scanf("%d", &n);
  for (i = 0; i < n - 1; i++) {
    scanf(
        "%d%d"
        "%lld",
        &u, &v, &c);
    g[u].push_back(make_pair(v, c));
    g[v].push_back(make_pair(u, c));
  }
  build(1, 1);
  dfs(1, 1, 0, 0, 0);
  for (i = 1; i <= 20; i++)
    for (j = 1; j <= n; j++) jump[j][i] = jump[jump[j][i - 1]][i - 1];
  scanf("%d", &q);
  for (int tq = 0; tq < q; tq++) {
    scanf("%d%d", &u, &v);
    if (!is_child(u, v))
      printf(
          "%lld"
          "\n",
          ((2 * (inc(kol[v], dp0[v], dp1[v], dist(u, v))) - f[u]) % Q + Q) % Q);
    else {
      long long tmp = ((f[u] - inc(n - kol[v], (fi[v] - dp0[v]) % Q,
                                   (f[v] - dp1[v]) % Q, dist(u, v))) %
                           Q +
                       Q) %
                      Q;
      printf(
          "%lld"
          "\n",
          ((2 * tmp - f[u]) % Q + Q) % Q);
    }
  }
  return 0;
}
