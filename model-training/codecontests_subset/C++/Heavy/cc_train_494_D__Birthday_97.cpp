#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long N = 1e5 + 100;
const long long LOG = 19;
const long long MOD = 1e9 + 7;
vector<pair<long long, long long>> g[N];
long long up[N][LOG], tin[N], tout[N], d0[N], d1[N], d2[N], sizes[N], ans[N],
    ans1[N], ans2[N];
long long timer = 0;
long long n;
long long add(long long a, long long b) {
  a += b;
  a %= MOD;
  if (a < 0) {
    a += MOD;
  }
  return a;
}
long long mul(long long a, long long b) { return 1ll * a * b % MOD; }
void dfs0(long long v, long long p) {
  tin[v] = timer++;
  sizes[v] = 1;
  for (long long i = 1; i < LOG; i++) {
    up[v][i] = up[up[v][i - 1]][i - 1];
  }
  for (long long i = 0; i < (long long)g[v].size(); i++) {
    if (g[v][i].first == p) {
      g[v].erase(g[v].begin() + i);
      break;
    }
  }
  for (auto i : g[v]) {
    assert(i.first != p);
    up[i.first][0] = v;
    d0[i.first] = add(d0[v], i.second);
    dfs0(i.first, v);
    sizes[v] += sizes[i.first];
  }
  tout[v] = timer;
}
long long anc(long long a, long long b) {
  return tin[a] <= tin[b] && tout[b] <= tout[a];
}
long long lca(long long v, long long u) {
  if (anc(v, u)) {
    return v;
  }
  if (anc(u, v)) {
    return u;
  }
  for (long long i = LOG - 1; i >= 0; i--) {
    if (!anc(up[v][i], u)) {
      v = up[v][i];
    }
  }
  return up[v][0];
}
long long getDist(long long v, long long u) {
  long long w = lca(v, u);
  long long ret = add(d0[v], d0[u]);
  ret = add(ret, mul(-2, d0[w]));
  return ret;
}
long long get_cost(long long d, long long d1, long long d2, long long n) {
  long long ret = mul(mul(d, d), n);
  ret = add(ret, mul(2 * d, d1));
  ret = add(ret, d2);
  return ret;
}
void dfs1(long long v) {
  for (auto i : g[v]) {
    long long u = i.first, c = i.second;
    dfs1(u);
    d2[v] = add(d2[v], get_cost(c, d1[u], d2[u], sizes[u]));
    d1[v] = add(d1[v], mul(c, sizes[u]));
    d1[v] = add(d1[v], d1[u]);
  }
}
void dfs2(long long v, long long a, long long b) {
  ans[v] = add(ans[v], d2[v]);
  ans[v] = add(ans[v], b);
  ans1[v] = a;
  ans2[v] = b;
  a = add(a, d1[v]);
  b = add(b, d2[v]);
  for (auto i : g[v]) {
    long long u = i.first, c = i.second;
    long long ta = a;
    ta = add(ta, -d1[u]);
    ta = add(ta, -mul(c, sizes[u]));
    long long tb = b;
    tb = add(tb, -get_cost(c, d1[u], d2[u], sizes[u]));
    tb = get_cost(c, ta, tb, n - sizes[u]);
    ta = add(ta, mul(c, n - sizes[u]));
    dfs2(u, ta, tb);
  }
}
long long stupid(long long v) {
  long long ret = 0;
  for (long long i = 0; i < n; i++) {
    long long D = getDist(v, i);
    ret = add(ret, mul(D, D));
  }
  return ret;
}
long long solve(long long v, long long u) {
  swap(v, u);
  long long ret = 0;
  long long D = getDist(v, u);
  if (anc(v, u)) {
    ret = ans[u];
    long long cur = get_cost(D, ans1[v], ans2[v], n - sizes[v]);
    ret = add(ret, -mul(2, cur));
  } else {
    ret = add(0, -ans[u]);
    long long cur = 0;
    cur = get_cost(D, d1[v], d2[v], sizes[v]);
    ret = add(ret, mul(2, cur));
  }
  return ret;
}
signed main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long v, u, c;
    cin >> v >> u >> c;
    v--;
    u--;
    g[v].emplace_back(u, c);
    g[u].emplace_back(v, c);
  }
  dfs0(0, -1);
  dfs1(0);
  dfs2(0, 0, 0);
  long long q;
  cin >> q;
  while (q--) {
    long long v, u;
    cin >> v >> u;
    v--;
    u--;
    cout << solve(v, u) << '\n';
  }
}
