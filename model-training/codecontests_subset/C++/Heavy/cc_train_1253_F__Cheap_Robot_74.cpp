#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 5;
const long long INF = 1e18;
struct Edge {
  int u, v, nxt;
  long long w;
} edge[maxn << 1], n_edge[maxn << 1];
int fa[maxn][30];
long long mcost[maxn][30];
int depth[maxn];
struct EdgeInfo {
  int u, v;
  long long w;
  bool operator<(const EdgeInfo &rhs) const { return w < rhs.w; }
} ee[maxn], new_e[maxn];
int n, m, k, q;
int head[maxn], nhead[maxn], cnt = -1, ncnt = -1, new_e_info_cnt;
bool vis[maxn];
long long dis[maxn];
int belong[maxn], lg[maxn];
inline void init() {
  for (int i = 0; i <= n; ++i) {
    head[i] = nhead[i] = -1;
    vis[i] = false;
    belong[i] = -1;
  }
  for (int i = 1; i < maxn; ++i) lg[i] = lg[i - 1] + (1 << lg[i - 1] == i);
}
inline void addedge(int u, int v, long long w) {
  edge[++cnt] = {u, v, head[u], w};
  head[u] = cnt;
}
inline void addn_edge(int u, int v, long long w) {
  n_edge[++ncnt] = {u, v, nhead[u], w};
  nhead[u] = ncnt;
}
struct DSU {
  int pre[maxn];
  DSU() {
    for (int i = 0; i < maxn; ++i) pre[i] = i;
  }
  int Findpre(int x) { return x == pre[x] ? x : pre[x] = Findpre(pre[x]); }
  bool Union(int x, int y) {
    int fx = Findpre(x);
    int fy = Findpre(y);
    if (fx != fy) {
      pre[fy] = fx;
      return true;
    }
    return false;
  }
};
inline void Dijiastra() {
  struct Node {
    int u;
    long long dis;
    int from_p;
    bool operator<(const Node &rhs) const { return dis > rhs.dis; }
  };
  priority_queue<Node> pq;
  for (int i = 0; i <= n; ++i) {
    dis[i] = INF;
    vis[i] = false;
    belong[i] = i;
    if (i <= k && i >= 1) {
      dis[i] = 0;
      pq.push(Node{i, dis[i], i});
    }
  }
  while (!pq.empty()) {
    Node u = pq.top();
    pq.pop();
    if (vis[u.u]) continue;
    vis[u.u] = true;
    for (int i = head[u.u]; ~i; i = edge[i].nxt) {
      Edge &e = edge[i];
      if (dis[e.v] > dis[u.u] + e.w) {
        dis[e.v] = dis[u.u] + e.w;
        belong[e.v] = u.from_p;
        pq.push(Node{e.v, dis[e.v], u.from_p});
      }
    }
  }
}
void dfs(int u, int f) {
  fa[u][0] = f;
  depth[u] = depth[f] + 1;
  for (int i = 1; (1 << i) <= depth[u]; ++i) {
    fa[u][i] = fa[fa[u][i - 1]][i - 1];
    mcost[u][i] = max(mcost[u][i - 1], mcost[fa[u][i - 1]][i - 1]);
  }
  for (int i = nhead[u]; ~i; i = n_edge[i].nxt) {
    Edge &e = n_edge[i];
    if (e.v != f) {
      mcost[e.v][0] = e.w;
      dfs(e.v, u);
    }
  }
}
long long LCA(int x, int y) {
  long long ans = 0;
  if (depth[x] < depth[y]) swap(x, y);
  while (depth[x] > depth[y]) {
    ans = max(ans, mcost[x][lg[depth[x] - depth[y]] - 1]);
    x = fa[x][lg[depth[x] - depth[y]] - 1];
  }
  if (x == y) return ans;
  for (int i = lg[depth[x]] - 1; i >= 0; --i) {
    if (fa[x][i] != fa[y][i]) {
      ans = max(ans, max(mcost[x][i], mcost[y][i]));
      x = fa[x][i];
      y = fa[y][i];
    }
  }
  return ans = max(ans, max(mcost[x][0], mcost[y][0]));
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  init();
  for (int i = 0; i < m; ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    ee[i] = {u, v, w};
    addedge(u, v, w);
    addedge(v, u, w);
  }
  Dijiastra();
  for (int i = 0; i < m; ++i) {
    EdgeInfo &e = ee[i];
    if (belong[e.u] != belong[e.v]) {
      new_e[new_e_info_cnt++] = {belong[e.u], belong[e.v],
                                 dis[e.u] + dis[e.v] + e.w};
    }
  }
  sort(new_e, new_e + new_e_info_cnt);
  DSU dsu;
  int pp = 0;
  for (int i = 0; i < new_e_info_cnt; ++i) {
    EdgeInfo &e = new_e[i];
    int fu = dsu.Findpre(e.u);
    int fv = dsu.Findpre(e.v);
    if (fu != fv) {
      addn_edge(e.u, e.v, e.w);
      addn_edge(e.v, e.u, e.w);
      dsu.Union(e.u, e.v);
      ++pp;
    }
    if (pp == k - 1) break;
  }
  dfs(1, 0);
  for (int i = 0; i < q; ++i) {
    int a, b;
    cin >> a >> b;
    cout << LCA(a, b) << endl;
  }
  return 0;
}
