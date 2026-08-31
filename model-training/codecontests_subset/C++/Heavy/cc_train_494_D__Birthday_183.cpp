#include <bits/stdc++.h>
using namespace std;
inline int in() {
  int x;
  scanf("%d", &x);
  return x;
}
const int N = 1e5 + 10;
const int L = 20;
const long long MOD = 1e9 + 7;
const long double eps = 1e-12;
long long n, s1[N], s2[N], u1[N], u2[N], sz[N], par[N][L], dep[N], sub1[N],
    sub2[N], dtr[N];
vector<pair<int, int> > e[N];
void dfs1(int v = 0, int pr = 0, long long w = 0) {
  sz[v] = 1;
  for (int i = 0; i < e[v].size(); i++) {
    long long nx = e[v][i].first, w = e[v][i].second;
    if (nx == pr) continue;
    dfs1(nx, v, w);
    s1[v] = (1LL * s1[v] + 1LL * w * sz[nx] + 1LL * s1[nx]) % MOD;
    sz[v] += sz[nx];
    s2[v] = (1LL * s2[v] + 1LL * w * 2 * s1[nx] + 1LL * s2[nx] +
             1LL * ((1LL * w * w) % MOD) * sz[nx]) %
            MOD;
  }
  sub1[v] = s1[v];
  sub2[v] = s2[v];
}
void dfs2(int v = 0, int p = 0, long long w = 0) {
  if (v != 0) {
    long long y = (1LL * s2[p] - (1LL * s2[v] + 1LL * s1[v] * w * 2 +
                                  1LL * sz[v] * ((1LL * w * w) % MOD))) %
                  MOD;
    if (y < 0) y += MOD;
    long long x = (1LL * s1[p] - (1LL * s1[v] + 1LL * w * sz[v])) % MOD;
    if (x < 0) x += MOD;
    long long s = n - sz[v];
    s2[v] = (1LL * s2[v] + 1LL * y + 1LL * 2 * w * x +
             1LL * s * 1LL * ((1LL * w * w) % MOD)) %
            MOD;
    s1[v] = (1LL * s1[v] + 1LL * x + 1LL * s * w) % MOD;
  }
  for (int i = 0; i < e[v].size(); i++)
    if (e[v][i].first != p) dfs2(e[v][i].first, v, e[v][i].second);
}
void dfs3(int v = 0, int p = 0, long long w = 0) {
  if (v) dep[v] = dep[p] + 1, dtr[v] = dtr[p] + w, dtr[v] %= MOD;
  par[v][0] = p;
  for (int i = 1; i < L; i++) par[v][i] = par[par[v][i - 1]][i - 1];
  for (int i = 0; i < e[v].size(); i++)
    if (e[v][i].first != p) dfs3(e[v][i].first, v, e[v][i].second);
}
int lca(int a, int b) {
  if (dep[a] > dep[b]) swap(a, b);
  int dif = dep[b] - dep[a];
  for (int i = 0; i < L; i++)
    if ((1 << i) & dif) b = par[b][i];
  if (b == a) return b;
  for (int i = L - 1; i >= 0; i--)
    if (par[a][i] != par[b][i]) a = par[a][i], b = par[b][i];
  return par[a][0];
}
int get(long long x) {
  while (x < 0) x += MOD;
  return (x % MOD);
}
int main() {
  n = in();
  for (int i = 1; i < n; i++) {
    int a = in(), b = in(), w = in();
    a--, b--;
    e[a].push_back({b, w});
    e[b].push_back({a, w});
  }
  dfs1();
  dfs2();
  dfs3();
  int q = in();
  for (int i = 0; i < q; i++) {
    int a = in(), b = in();
    a--, b--;
    int x = lca(a, b);
    long long dis = dtr[a] + dtr[b] - 2 * dtr[x];
    long long first = (1LL * sub2[b] + 1LL * sub1[b] * dis * 2 +
                       1LL * sz[b] * ((1LL * dis * dis) % MOD)) %
                      MOD;
    first *= 2;
    first %= MOD;
    long long ans = (first - s2[a] + MOD) % MOD;
    if (x != b) printf("%d\n", get(ans));
    if (x == b) {
      long long out2 = (s2[b] - sub2[b]) % MOD;
      long long out1 = (s1[b] - sub1[b]) % MOD;
      if (out2 < 0) out2 += MOD;
      if (out1 < 0) out1 += MOD;
      long long s = n - sz[b];
      long long fot = (1LL * out2 + 1LL * out1 * dis * 2 +
                       1LL * s * 1LL * ((1LL * dis * dis) % MOD)) %
                      MOD;
      fot *= 2;
      fot %= MOD;
      printf("%d\n", get((s2[a] - fot + MOD) % MOD));
    }
  }
  return 0;
}
