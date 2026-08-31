#include <bits/stdc++.h>
using namespace std;
const long double eps = 1e-13;
const long double PI = acos(-1);
const int INF = (int)1e9;
const long long INFF = (long long)1e18;
const int mod = (int)1e9 + 7;
const int MXN = (int)1e6 + 7;
int n, k;
vector<int> edge[MXN];
vector<int> re_edge[MXN];
int prt[MXN];
int dp[21][MXN];
void init() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i < n + 1; i++) {
    scanf("%d", prt + i);
    edge[prt[i]].push_back(i);
    re_edge[i].push_back(prt[i]);
    dp[0][i] = prt[i];
  }
  return;
}
bool leaf[MXN];
struct Scc {
  int re[MXN], cntp;
  int in[MXN];
  int siz[MXN], gp[MXN];
  int num[MXN];
  int val[MXN];
  int fd(int u) { return gp[u] == u ? u : gp[u] = fd(gp[u]); }
  void uni(int u, int v) {
    u = fd(u), v = fd(v);
    if (u == v) return;
    if (siz[u] > siz[v]) swap(u, v);
    gp[u] = v;
    siz[u] += siz[v];
    return;
  }
  void dfs(int u) {
    in[u] = 1;
    for (int v : edge[u]) {
      if (!in[v]) dfs(v);
    }
    re[++cntp] = u;
    return;
  }
  void dfs2(int u, int la) {
    in[u] = 1;
    uni(u, la);
    for (int v : re_edge[u]) {
      if (!in[v]) dfs2(v, la);
    }
  }
  void pre() {
    for (int i = 1; i < n + 1; i++) siz[i] = 1, gp[i] = i;
    for (int i = 1; i < n + 1; i++)
      if (!in[i]) dfs(i);
    memset(in, 0, sizeof(in));
    ;
    for (int i = n; i >= 1; i--)
      if (!in[re[i]]) dfs2(re[i], re[i]);
    for (int i = 1; i < n + 1; i++)
      if (leaf[i]) {
        num[fd(i)]++;
        val[fd(i)]++;
      }
    return;
  }
  int solve() {
    pre();
    int ans = 0;
    for (int i = 1; i < n + 1; i++) {
      ans = max(ans, val[fd(i)]);
      for (int v : edge[re[i]]) {
        int p1 = fd(v);
        int p2 = fd(re[i]);
        if (p1 == p2) continue;
        val[p2] = max(val[p2], num[p2] + val[p1]);
        ans = max(ans, val[p2]);
      }
    }
    return ans;
  }
} scc;
int dep[MXN];
void dfs(int u, int dpt) {
  dep[u] = dpt;
  for (int v : edge[u]) dfs(v, dpt + 1);
  return;
}
int up(int u, int d) {
  for (int i = 0; i < 21; i++) {
    if (d & (1 << i)) {
      u = dp[i][u];
    }
  }
  return u;
}
void sol() {
  dfs(1, 1);
  for (int i = 1; i < 21; i++)
    for (int j = 1; j < n + 1; j++) {
      dp[i][j] = dp[i - 1][dp[i - 1][j]];
    }
  for (int i = 1; i < n + 1; i++)
    if (edge[i].empty()) {
      leaf[i] = 1;
      int p = 0;
      if (dep[i] <= k)
        p = 1;
      else
        p = up(i, k);
      edge[i].push_back(p);
      re_edge[p].push_back(i);
    }
  int ans = scc.solve();
  printf("%d\n", ans);
  return;
}
int main(void) {
  init();
  sol();
  return 0;
}
