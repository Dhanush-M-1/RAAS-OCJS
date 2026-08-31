#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007LL;
const int N = 100007;
const int LOG = 20;
long long in[N], out[N], sIn[N], sOut[N], dep[N];
int n, timer, size[N], tin[N], tout[N], par[N], up[LOG][N];
vector<pair<int, int> > G[N];
long long calc(long long w, long long in, long long sum, int cnt) {
  return (in + cnt * w % MOD * w + 2 * sum % MOD * w) % MOD;
}
void dfs(int u, int p = 1, long long d = 0) {
  tin[u] = timer++;
  size[u] = 1;
  dep[u] = d;
  par[u] = p;
  up[0][u] = p;
  for (int i = 0; i < LOG - 1; ++i) {
    up[i + 1][u] = up[i][up[i][u]];
  }
  for (auto pp : G[u]) {
    int to = pp.first;
    long long w = pp.second;
    if (to != p) {
      dfs(to, u, (d + w) % MOD);
      size[u] += size[to];
      sIn[u] = (sIn[u] + sIn[to] + w * size[to]) % MOD;
      in[u] += calc(w, in[to], sIn[to], size[to] - 1) + w * w;
      in[u] %= MOD;
    }
  }
  tout[u] = timer++;
}
void dfsOut(int u, long long pw) {
  int p = par[u];
  if (u != 1) {
    long long sibIn = in[p] - calc(pw, in[u], sIn[u], size[u] - 1) - pw * pw;
    long long sibSum = sIn[p] - sIn[u] - pw * size[u];
    int sibCnt = size[p] - 1 - size[u];
    out[u] = calc(pw, out[p], sOut[p], n - size[p]);
    out[u] += calc(pw, sibIn, sibSum, sibCnt);
    out[u] += pw * pw;
    out[u] %= MOD;
    sOut[u] = (sOut[p] + sibSum + sibCnt * pw + (n - size[p] + 1) * pw) % MOD;
    if (sOut[u] < 0) sOut[u] += MOD;
  }
  for (auto pp : G[u]) {
    int to = pp.first;
    long long w = pp.second;
    if (to != p) dfsOut(to, w);
  }
}
inline bool parent(int parent, int child) {
  return (tin[parent] <= tin[child] && tout[child] <= tout[parent]);
}
int lca(int u, int v) {
  if (parent(u, v)) return u;
  if (parent(v, u)) return v;
  for (int k = 19; k >= 0; --k) {
    int w = up[k][u];
    if (!parent(w, v)) u = w;
  }
  return par[u];
}
long long getDist(int u, int v) {
  int w = lca(u, v);
  return (dep[u] + dep[v] - 2 * dep[w] + 2 * MOD) % MOD;
}
void solve() {
  scanf("%d", &n);
  for (int i = 0; i < (n - 1); ++i) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    G[u].push_back(make_pair(v, w));
    G[v].push_back(make_pair(u, w));
  }
  dfs(1);
  dfsOut(1, 0);
  int q;
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    long long ans;
    long long d = getDist(u, v);
    if (!parent(v, u)) {
      cerr << "1 ";
      ans =
          -in[u] - out[u] + 2 * calc(d, in[v], sIn[v], size[v] - 1) + 2 * d * d;
    } else {
      cerr << "2 ";
      ans = in[u] + out[u] - 2 * calc(d, out[v], sOut[v], n - size[v]);
    }
    ans %= MOD;
    if (ans < 0) ans += MOD;
    printf("%lld\n", ans);
  }
}
int main() {
  solve();
  return 0;
}
