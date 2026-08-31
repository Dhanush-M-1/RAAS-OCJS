#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100100;
const int LOGMAXN = 18;
const int MOD = 1e+9 + 7;
struct node {
  int xsum, xsqr, xcnt;
  node() : xsum(0), xsqr(0), xcnt(0) {}
};
int N;
vector<pair<int, int> > V[MAXN];
int dad[MAXN][LOGMAXN];
int dep[MAXN];
int sum[MAXN];
node data[MAXN];
node str[MAXN][LOGMAXN];
inline int sqr(int x) { return ((long long)x * x) % MOD; }
inline int add(int a, int b) {
  int ret = a + b;
  if (ret >= MOD) ret -= MOD;
  return ret;
}
inline int sub(int a, int b) {
  int ret = a - b + MOD;
  if (ret >= MOD) ret -= MOD;
  return ret;
}
inline int mul(int a, int b) { return ((long long)a * b) % MOD; }
inline int f(int curr, int k) {
  return add(mul(data[curr].xcnt, sqr(k)),
             add(mul(2, mul(k, data[curr].xsum)), data[curr].xsqr));
}
namespace tr {
int depth = 0;
int curr_sum = 0;
node build(int curr, int prev = 0) {
  dep[curr] = depth;
  sum[curr] = curr_sum;
  dad[curr][0] = prev;
  for (int i = 1; i < LOGMAXN - 1; ++i)
    dad[curr][i] = dad[dad[curr][i - 1]][i - 1];
  node ret;
  ret.xcnt = 1;
  for (pair<int, int> nxt : V[curr]) {
    if (nxt.first == prev) continue;
    depth += 1;
    curr_sum = add(curr_sum, nxt.second);
    node get = build(nxt.first, curr);
    ret.xcnt = add(ret.xcnt, get.xcnt);
    ret.xsum = add(ret.xsum, mul(get.xcnt, nxt.second));
    ret.xsum = add(ret.xsum, get.xsum);
    ret.xsqr = add(ret.xsqr, mul(get.xcnt, sqr(nxt.second)));
    ret.xsqr = add(ret.xsqr, get.xsqr);
    ret.xsqr = add(ret.xsqr, mul(2, mul(nxt.second, get.xsum)));
    curr_sum = sub(curr_sum, nxt.second);
    depth -= 1;
  }
  return data[curr] = ret;
}
void dfs(int curr, int prev = 0) {
  long long tmp = 0;
  str[curr][0].xsum = sub(data[dad[curr][0]].xsum, data[curr].xsum);
  str[curr][0].xsum =
      sub(str[curr][0].xsum,
          mul(data[curr].xcnt, sub(sum[curr], sum[dad[curr][0]])));
  str[curr][0].xcnt = sub(data[dad[curr][0]].xcnt, data[curr].xcnt);
  str[curr][0].xsqr =
      sub(data[dad[curr][0]].xsqr, f(curr, sub(sum[curr], sum[dad[curr][0]])));
  for (int i = 1; i < LOGMAXN - 1; ++i) {
    str[curr][i].xcnt =
        str[curr][i - 1].xcnt + str[dad[curr][i - 1]][i - 1].xcnt;
    int par1 = dad[curr][i - 1];
    int par2 = dad[curr][i];
    int edge_val = sub(sum[dad[curr][0]], sum[dad[par1][0]]);
    tmp = str[curr][i - 1].xsum + (long long)str[par1][i - 1].xsum +
          (long long)edge_val * str[par1][i - 1].xcnt;
    str[curr][i].xsum = (tmp % MOD + MOD) % MOD;
    int dist = sub(sum[dad[curr][0]], sum[dad[par1][0]]);
    str[curr][i].xsqr = add(str[curr][i - 1].xsqr, str[par1][i - 1].xsqr);
    str[curr][i].xsqr =
        add(str[curr][i].xsqr, mul(2, mul(str[par1][i - 1].xsum, dist)));
    str[curr][i].xsqr =
        add(str[curr][i].xsqr, mul(str[par1][i - 1].xcnt, sqr(dist)));
  }
  for (pair<int, int> nxt : V[curr]) {
    if (nxt.first == prev) continue;
    dfs(nxt.first, curr);
  }
}
}  // namespace tr
int lca(int u, int v) {
  if (dep[u] > dep[v]) swap(u, v);
  for (int i = 16; i >= 0; --i) {
    if (dep[v] - (1 << i) < dep[u]) continue;
    v = dad[v][i];
  }
  for (int i = 16; i >= 0; --i) {
    int nu = dad[u][i];
    int nv = dad[v][i];
    if (nu == nv) continue;
    u = nu;
    v = nv;
  }
  if (u != v) u = dad[u][0];
  return u;
}
int query(int u, int v) {
  int LCA = lca(u, v);
  int dist = sum[u] + sum[v] - 2 * sum[LCA];
  if (LCA != v || u == v) return f(v, dist);
  int ret = data[u].xsqr;
  int curr = u;
  for (int i = 16; i >= 0; --i) {
    if (dep[curr] - (1 << i) < dep[v]) continue;
    const node get = str[curr][i];
    int dist = sub(sum[u], sum[dad[curr][0]]);
    curr = dad[curr][i];
    int tmp = add(get.xsqr, mul(sqr(dist), get.xcnt));
    tmp = add(tmp, mul(2, mul(get.xsum, dist)));
    ret = add(ret, tmp);
    ret = (ret + MOD) % MOD;
  }
  return (ret % MOD + MOD) % MOD;
}
int main(void) {
  scanf("%d", &N);
  for (int i = 1; i < N; ++i) {
    int u, v, x;
    scanf("%d%d%d", &u, &v, &x);
    V[u].push_back({v, x});
    V[v].push_back({u, x});
  }
  tr::build(1);
  tr::dfs(1);
  int Q;
  scanf("%d", &Q);
  while (Q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int LCA = lca(u, v);
    int dist = sum[u] + sum[v] - 2 * sum[LCA];
    printf("%d\n", (sub(mul(2, query(u, v)), query(u, 1)) % MOD + MOD) % MOD);
  }
  return 0;
}
