#include <bits/stdc++.h>
using namespace std;
const long long INF = 0x3f3f3f3f;
const int N = 1e5 + 10;
const int M = 1e3 + 10;
const long long mod = 1e9 + 7;
const double PI = acos(-1);
inline long long ab(long long x) { return x < 0 ? -x : x; }
inline long long mm(long long x) {
  return x >= mod ? x - mod : x < 0 ? x + mod : x;
}
vector<pair<int, long long> > son[N];
struct Node {
  long long sum1 = 0, sum2 = 0, cnt = 0, deep = 0, len = 0;
  long long psum1 = 0, psum2 = 0, pcnt = 0;
  int fa[20];
} node[N];
void dfs(int o, int fa) {
  node[o].deep = node[fa].deep + 1, node[o].cnt = 1;
  node[o].fa[0] = fa;
  for (int i = 1; i < 20; ++i)
    node[o].fa[i] = node[node[o].fa[i - 1]].fa[i - 1];
  for (auto it : son[o]) {
    if (it.first != fa) {
      node[it.first].len = node[o].len + it.second;
      dfs(it.first, o);
      node[o].sum1 = (node[it.first].sum1 + node[o].sum1 +
                      node[it.first].cnt * it.second) %
                     mod;
      node[o].cnt += node[it.first].cnt;
      node[o].sum2 =
          (node[o].sum2 + node[it.first].cnt * it.second % mod * it.second +
           node[it.first].sum2 + 2 * node[it.first].sum1 * it.second) %
          mod;
    }
  }
}
void bfs(int o, int fa) {
  long long sum1, cnt, sum2;
  for (auto it : son[o]) {
    if (it.first != fa) {
      sum1 = mm((node[o].sum1 - node[it.first].sum1 -
                 node[it.first].cnt * it.second + node[o].psum1) %
                    mod +
                mod);
      cnt = node[o].cnt - node[it.first].cnt + node[o].pcnt;
      sum2 = mm((node[o].psum2 + node[o].sum2 -
                 node[it.first].cnt * it.second % mod * it.second -
                 node[it.first].sum2 - 2 * node[it.first].sum1 * it.second) %
                    mod +
                mod);
      node[it.first].psum1 = (sum1 + cnt * it.second) % mod;
      node[it.first].pcnt = cnt;
      node[it.first].psum2 = (cnt * it.second % mod * it.second % mod + sum2 +
                              2 * sum1 * it.second % mod) %
                             mod;
      bfs(it.first, o);
    }
  }
}
int get_lca(int u, int v) {
  if (node[u].deep < node[v].deep) swap(u, v);
  int dd = node[u].deep - node[v].deep;
  for (int i = 19; i >= 0; --i)
    if ((dd >> i) & 1) u = node[u].fa[i];
  if (u == v) return u;
  for (int i = 19; i >= 0; --i)
    if (node[u].fa[i] != node[v].fa[i]) u = node[u].fa[i], v = node[v].fa[i];
  return node[u].fa[0];
}
void solve(int u, int v) {
  int w = get_lca(u, v);
  if (w != v) {
    long long dd = (node[u].len + node[v].len - 2 * node[w].len) % mod;
    long long res = (node[v].cnt * dd % mod * dd % mod + node[v].sum2 +
                     2 * node[v].sum1 * dd % mod) %
                    mod;
    long long all = mm(node[u].psum2 + node[u].sum2);
    printf("%I64d\n", mm((res * 2 - all) % mod + mod));
  } else {
    long long dd = (node[u].len - node[v].len) % mod;
    long long res =
        mm((node[u].sum2 + node[u].psum2 - node[v].pcnt * 1ll * dd % mod * dd -
            node[v].psum2 - 2 * node[v].psum1 * dd) %
               mod +
           mod);
    long long all = mm(node[u].psum2 + node[u].sum2);
    printf("%I64d\n", mm((res * 2 - all) % mod + mod));
  }
}
int main() {
  int n, u, v, w, q;
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    scanf("%d%d%I64d", &u, &v, &w);
    son[u].push_back({v, w});
    son[v].push_back({u, w});
  }
  dfs(1, 0);
  bfs(1, 0);
  scanf("%d", &q);
  for (int i = 1; i <= q; ++i) {
    scanf("%d%d", &u, &v);
    solve(u, v);
  }
  return 0;
}
