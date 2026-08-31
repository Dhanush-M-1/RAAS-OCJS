#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T sqr(T x) {
  return x * x;
}
const double PI = acos(-1.0);
using namespace std;
int C[3][3];
class Tree {
 public:
  int head[200005], nxt[200005], e[200005], w[200005];
  int dpson[200005][3], dpfa[200005][3];
  int dp[200005][3];
  int vis[200005];
  int cnt;
  vector<pair<int, int> > stamp[200005];
  void init(int n) {
    cnt = 0;
    for (int i = 0; i <= n; i++) head[i] = -1;
    this->n = n;
  }
  inline void addEdge(int u, int v, int w) {
    e[cnt] = v;
    this->w[cnt] = w;
    int tmp = head[u];
    head[u] = cnt;
    nxt[cnt++] = tmp;
  }
  int dis[200005];
  int p[200005][20];
  int dis1[200005];
  int L[200005];
  int n;
  int tot;
  void dfs(int u, int fa, int d, int d1) {
    dis[u] = d;
    dis1[u] = d1;
    p[u][0] = fa;
    L[u] = tot++;
    for (int i = 1; (1 << i) <= n; i++) {
      if (~p[u][i - 1])
        p[u][i] = p[p[u][i - 1]][i - 1];
      else
        p[u][i] = -1;
    }
    for (int i = head[u]; ~i; i = nxt[i]) {
      int v = e[i];
      if (v == fa) continue;
      dfs(v, u, d + 1, (d1 + w[i]) % 1000000007);
      stamp[u].push_back(make_pair(tot - 1, i));
    }
  }
  int LCA(int u, int v) {
    if (dis[u] > dis[v]) swap(u, v);
    if (dis[u] < dis[v]) {
      int offset = dis[v] - dis[u];
      for (int i = 0; (1 << i) <= n; i++)
        if (offset & (1 << i)) v = p[v][i];
    }
    if (u != v) {
      for (int i = log2(n); i >= 0; i--) {
        if (p[u][i] != p[v][i]) u = p[u][i], v = p[v][i];
      }
      u = p[u][0], v = p[v][0];
    }
    return u;
  }
  void update(int a[], int b[], int w) {
    for (int j = 0; j <= 2; j++) {
      int now = 1;
      for (int l = 0; l <= j; l++) {
        Add(a[j], 1ll * C[j][l] * b[j - l] % 1000000007 * now % 1000000007);
        now = 1ll * now * w % 1000000007;
      }
    }
  }
  void dfs(int u, int fa) {
    for (int i = 0; i <= 2; i++) dpson[u][i] = 0;
    dpson[u][0] = 1;
    for (int i = head[u]; ~i; i = nxt[i]) {
      int v = e[i];
      if (v == fa) continue;
      tofa[v] = w[i];
      dfs(v, u);
      update(dpson[u], dpson[v], w[i]);
    }
  }
  int stack[200005];
  int tmp[3];
  int tofa[200005];
  void dfs1(int u, int fa, int idx) {
    if (idx != -1)
      tofa[u] = w[idx];
    else
      tofa[u] = 0;
    if (fa != -1) {
      update(dpfa[u], dpfa[fa], tofa[fa]);
      for (int i = 0; i <= 2; i++) {
        dp[idx][i] = dpson[u][i];
        dp[idx ^ 1][i] = dpfa[u][i];
      }
    }
    for (int i = 0; i <= 2; i++) tmp[i] = 0;
    int tot = 0;
    for (int i = head[u]; ~i; i = nxt[i]) {
      int v = e[i];
      if (v == fa) continue;
      for (int j = 0; j <= 2; j++) Add(dpfa[v][j], tmp[j]);
      update(tmp, dpson[v], w[i]);
      stack[tot++] = i;
    }
    for (int i = 0; i <= 2; i++) tmp[i] = 0;
    for (int x = tot - 1; x >= 0; x--) {
      int i = stack[x];
      int v = e[i];
      if (v == fa) continue;
      for (int j = 0; j <= 2; j++) Add(dpfa[v][j], tmp[j]);
      update(tmp, dpson[v], w[i]);
    }
    for (int i = head[u]; ~i; i = nxt[i]) {
      int v = e[i];
      if (v == fa) continue;
      dfs1(v, u, i);
    }
  }
  int sum[200005][3];
  void Add(int &ans, int v) {
    ans += v;
    if (ans >= 1000000007) ans -= 1000000007;
  }
  void dpSum() {
    dfs(1, -1);
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= 2; j++) dpfa[i][j] = 0;
      if (i > 1) dpfa[i][0] = 1;
    }
    dfs1(1, -1, -1);
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= 2; j++) sum[i][j] = 0;
      for (int j = head[i]; ~j; j = nxt[j]) update(sum[i], dp[j], w[j]);
    }
  }
} lca;
int main(void) {
  C[0][0] = 1;
  for (int i = 1; i <= 2; i++) {
    C[i][0] = 1;
    for (int j = 1; j <= i; j++) C[i][j] = C[i - 1][j] + C[i - 1][j - 1];
  }
  int n;
  scanf("%d", &n);
  lca.init(n);
  for (int i = 0; i < n - 1; i++) {
    int u, v, w;
    scanf("%d %d %d", &u, &v, &w);
    lca.addEdge(u, v, w);
    lca.addEdge(v, u, w);
  }
  lca.dfs(1, -1, 0, 0);
  lca.dpSum();
  int q;
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d %d", &u, &v);
    int ans = -lca.sum[u][2];
    int f = lca.LCA(u, v);
    int d = (0ll + lca.dis1[u] + lca.dis1[v] - 2 * lca.dis1[f]) % 1000000007;
    int ret = 0;
    if (v == 1)
      ret = lca.sum[u][2];
    else if (f == v) {
      int fv = lca.p[v][0];
      int pos = lower_bound(lca.stamp[fv].begin(), lca.stamp[fv].end(),
                            make_pair(lca.L[v], -1)) -
                lca.stamp[fv].begin();
      int idx = lca.stamp[fv][pos].second ^ 1;
      int now = 1;
      ret = lca.sum[u][2];
      lca.Add(d, lca.w[idx]);
      for (int i = 0; i <= 2; i++) {
        lca.Add(ret, (1000000007 - 1ll * C[2][i] * lca.dp[idx][2 - i] %
                                       1000000007 * now % 1000000007) %
                         1000000007);
        now = 1ll * now * d % 1000000007;
      }
    } else {
      int fv = lca.p[v][0];
      int pos = lower_bound(lca.stamp[fv].begin(), lca.stamp[fv].end(),
                            make_pair(lca.L[v], -1)) -
                lca.stamp[fv].begin();
      int idx = lca.stamp[fv][pos].second;
      int now = 1;
      for (int i = 0; i <= 2; i++) {
        lca.Add(ret, 1ll * C[2][i] * lca.dp[idx][2 - i] % 1000000007 * now %
                         1000000007);
        now = 1ll * now * d % 1000000007;
      }
    }
    ans += 2 * ret % 1000000007;
    ans = (ans % 1000000007 + 1000000007) % 1000000007;
    printf("%d\n", ans);
  }
  return 0;
}
