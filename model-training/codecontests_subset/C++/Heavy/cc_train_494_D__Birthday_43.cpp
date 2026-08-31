#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  while (a && b) {
    if (a >= b)
      a %= b;
    else
      b %= a;
  }
  return a + b;
}
long long power(long long a, long long n) {
  long long p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
    }
    n >>= 1;
    a *= a;
  }
  return p;
}
long long power(long long a, long long n, long long mod) {
  long long p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
      p %= mod;
    }
    n >>= 1;
    a *= a;
    a %= mod;
  }
  return p % mod;
}
int getint() {
  char c;
  int ret = c - '0', sgn = 0;
  while ((c = getchar()) && !(c >= '0' && c <= '9') && c != '-')
    ;
  if (c == '-') sgn = 1, ret = 0;
  while ((c = getchar()) && c >= '0' && c <= '9') ret = ret * 10 + c - '0';
  if (sgn) ret = -ret;
  return ret;
}
const int maxn = 1e5 + 10;
const int maxm = maxn * 2;
const long long inf = 1e18;
const long long mod = 1e9 + 7;
int sz[maxn];
long long cost[maxn];
long long f[maxn], ft[maxn], f2[maxn], f1[maxn];
vector<pair<int, int> > g[maxn];
long long get(long long x, long long y) {
  x %= mod, y %= mod;
  x = ((x - y) % mod + mod) % mod;
  return x;
}
void add(long long& x, long long y) {
  x %= mod, y %= mod;
  x = (x + y) % mod;
}
void dfs1(int u, int pa) {
  int len = g[u].size();
  sz[u] = 1;
  for (int i = 0; i < len; i++) {
    int v = g[u][i].first;
    long long w = g[u][i].second;
    if (v == pa) continue;
    cost[v] = w;
    dfs1(v, u);
    sz[u] += sz[v];
    ft[u] += (ft[v] + w * sz[v] % mod) % mod;
    ft[u] %= mod;
    if (ft[u] < 0) ft[u] += mod;
    f[u] +=
        ((f[v] + w * w % mod * sz[v] % mod) % mod + w * 2 % mod * ft[v] % mod) %
        mod;
    f[u] %= mod;
  }
}
int n;
void dfs2(int u, int pa) {
  int len = g[u].size();
  for (int i = 0; i < len; i++) {
    int v = g[u][i].first;
    long long w = g[u][i].second;
    if (v == pa) continue;
    long long temp = get(ft[u], sz[v] * w % mod) + (n - sz[v]) * w % mod;
    temp %= mod;
    long long temp2 = get(temp, ft[v]);
    temp2 = get(temp2, (n - sz[v]) * w % mod);
    f1[v] = temp2;
    long long temp3 = f[v];
    f[v] = ((f[u] - 1LL * sz[v] * w % mod * w % mod) % mod -
            1LL * 2 * w % mod * ft[v] % mod) %
           mod;
    f[v] = (f[v] + mod) % mod;
    f2[v] = get(f[v], temp3);
    f[v] = (f[v] + 1LL * (n - sz[v]) * w % mod * w % mod +
            2LL * w % mod * temp2 % mod) %
           mod;
    ft[v] = temp;
    dfs2(v, u);
  }
}
int deep[maxn], fa[25][maxn];
long long ds[maxn], sumdis[maxn], sumq[maxn];
void dfs(int u, int pa, int d) {
  deep[u] = d;
  fa[0][u] = pa;
  int i;
  int len = g[u].size();
  sumdis[u] = ds[u], sumq[u] = ds[u] * ds[u] % mod;
  for (int i = 0; i < len; i++) {
    int v = g[u][i].first, w = g[u][i].second;
    if (v == pa) continue;
    ds[v] = ds[u] + w;
    ds[v] %= mod;
    dfs(v, u, d + 1);
    add(sumdis[u], sumdis[v]);
    add(sumq[u], sumq[v]);
  }
}
void lca_init() {
  for (int k = 0; k < 20; k++) {
    for (int i = 1; i <= n; i++) {
      if (fa[k][i] == -1)
        fa[k + 1][i] = -1;
      else
        fa[k + 1][i] = fa[k][fa[k][i]];
    }
  }
}
int lca(int u, int v) {
  if (deep[u] > deep[v]) swap(u, v);
  for (int k = 0; k < 22; k++) {
    if ((deep[v] - deep[u]) >> k & 1) {
      v = fa[k][v];
    }
  }
  if (u == v) return u;
  for (int k = 21; k >= 0; k--) {
    if (fa[k][u] != fa[k][v]) {
      u = fa[k][u], v = fa[k][v];
    }
  }
  return fa[0][v];
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) g[i].clear();
  for (int i = 1; i < n; i++) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    g[u].push_back(make_pair(v, w));
    g[v].push_back(make_pair(u, w));
  }
  memset(f, 0, sizeof(f));
  f1[1] = f2[1] = 0;
  dfs1(1, -1);
  dfs2(1, -1);
  ds[1] = sumdis[1] = sumq[1] = 0;
  dfs(1, -1, 1);
  lca_init();
  int q;
  cin >> q;
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int la = lca(u, v);
    long long ans = 0;
    if (la != v) {
      long long cnt = sz[v] - 1;
      long long x = get(ds[u] + ds[v], 2 * ds[la]), y = x;
      x = get(x, ds[v]);
      long long temp =
          (cnt * x % mod * x % mod + get(sumq[v], ds[v] * ds[v] % mod)) % mod +
          2 * x % mod * get(sumdis[v], ds[v]) % mod;
      temp %= mod;
      add(temp, y * y % mod);
      ans = temp;
    } else {
      long long cnt = n - sz[v];
      long long x = get(ds[u], ds[v]);
      long long ww = (x + cost[v]) % mod;
      long long temp = (f2[v] + cnt * ww % mod * ww % mod) % mod +
                       ww * 2 % mod * f1[v] % mod;
      temp = temp % mod;
      ans = get(f[u], temp);
    }
    ans = get(ans, get(f[u], ans));
    cout << ans << "\n";
  }
  return 0;
}
