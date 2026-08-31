#include <bits/stdc++.h>
using namespace std;
const int M = (int)1e9 + 7;
const int N = (int)1e5 + 10;
const int L = 17;
int sum0[N], sum1[N], sum2[N], psum0[N], psum1[N], psum2[N], par[L][N], in[N],
    out[N], curt, u, v, w, h[N], delta0[N], delta1[N], delta2[N], n, q;
vector<pair<int, int> > adj[N];
int add(int a, int b) { return (a + b) % M; }
int mult(int a, int b) { return (a * (long long)b) % M; }
bool is_parent(int u, int v) { return (in[u] <= in[v]) && (out[v] <= out[u]); }
int sq_sum(int sum0, int sum1, int sum2, int w) {
  return add(add(sum2, mult(sum1, mult(2, w))), mult(sum0, mult(w, w)));
}
void dfs(int v, int p = -1) {
  in[v] = curt++, par[0][v] = ((p == -1) ? v : p), sum0[v] = 1, sum1[v] = 0,
  sum2[v] = 0;
  for (int i = 0; i < ((int)(adj[v]).size()); ++i) {
    int u = adj[v][i].first, w = adj[v][i].second;
    if (u == p) continue;
    h[u] = add(h[v], w);
    dfs(u, v);
    sum0[v] = add(sum0[v], delta0[u] = sum0[u]);
    sum1[v] = add(sum1[v], delta1[u] = add(sum1[u], mult(sum0[u], w)));
    sum2[v] = add(sum2[v], delta2[u] = sq_sum(sum0[u], sum1[u], sum2[u], w));
  }
  out[v] = curt++;
}
void ndfs(int v, int p = -1) {
  for (int i = 0; i < ((int)(adj[v]).size()); ++i) {
    int u = adj[v][i].first, w = adj[v][i].second;
    if (u == p) continue;
    psum0[u] = add(psum0[v], add(sum0[v], M - delta0[u]));
    psum1[u] = add(psum1[v], add(sum1[v], M - delta1[u]));
    psum2[u] = add(psum2[v], add(sum2[v], M - delta2[u]));
    psum2[u] = sq_sum(psum0[u], psum1[u], psum2[u], w);
    psum1[u] = add(psum1[u], mult(psum0[u], w));
    ndfs(u, v);
  }
}
int lca(int u, int v) {
  if (is_parent(u, v)) return u;
  for (int j = L - 1; j >= 0; --j)
    if (!is_parent(par[j][u], v)) u = par[j][u];
  return par[0][u];
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i + 1 < n; ++i) {
    scanf("%d%d%d", &u, &v, &w), --u, --v;
    adj[u].push_back(make_pair(v, w)), adj[v].push_back(make_pair(u, w));
  }
  dfs(0);
  for (int j = 1; j < L; ++j)
    for (int i = 0; i < n; ++i) par[j][i] = par[j - 1][par[j - 1][i]];
  ndfs(0);
  scanf("%d", &q);
  for (int i = 0; i < q; ++i) {
    scanf("%d%d", &u, &v), --u, --v;
    w = add(add(h[u], h[v]), M - mult(2, h[lca(u, v)]));
    if (!is_parent(v, u))
      printf("%d\n", add(mult(2, sq_sum(sum0[v], sum1[v], sum2[v], w)),
                         M - add(psum2[u], sum2[u])));
    else
      printf("%d\n", add(M - mult(2, sq_sum(psum0[v], psum1[v], psum2[v], w)),
                         add(psum2[u], sum2[u])));
  }
  return 0;
}
