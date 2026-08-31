#include <bits/stdc++.h>
using namespace std;
int n, m, k, q;
struct Edge {
  int v;
  long long d;
  Edge() {
    v = 0;
    d = 0;
  }
  Edge(int rv, int rd) {
    v = rv;
    d = rd;
  }
};
struct SortEdge {
  int u;
  int v;
  long long d;
};
bool operator<(const SortEdge& a, const SortEdge& b) {
  if (a.d != b.d) return a.d < b.d;
  if (a.u != b.u) return a.u < b.u;
  return a.v < b.v;
}
vector<Edge> e[100005];
long long du[100005];
int pre[100005];
int fa[100005 * 4][21];
long long ans[100005 * 4];
int dsuFa[100005 * 4];
int topK;
int level[100005 * 4];
int tl[100005 * 4];
int tr[100005 * 4];
vector<SortEdge> se;
void dijstra() {
  priority_queue<pair<long long, int>> pq;
  int i;
  for (i = 1; i <= n; i++) {
    if (i <= k) {
      du[i] = 0;
      pq.push({0, i});
    } else {
      du[i] = -1;
    }
    pre[i] = i;
  }
  while (!pq.empty()) {
    auto cur = pq.top();
    pq.pop();
    int u = cur.second;
    long long cd = -cur.first;
    for (auto& it : e[u]) {
      long long nd = cd + it.d;
      if (du[it.v] == -1 || du[it.v] > nd) {
        du[it.v] = nd;
        pq.push({-nd, it.v});
        pre[it.v] = pre[u];
      }
    }
  }
}
int dsuFind(int x) {
  if (dsuFa[x] != x) {
    dsuFa[x] = dsuFind(dsuFa[x]);
  }
  return dsuFa[x];
}
void dsuUnion(int x, int y, long long val) {
  int xx = dsuFind(x);
  int yy = dsuFind(y);
  topK++;
  fa[xx][0] = topK;
  fa[yy][0] = topK;
  dsuFa[xx] = topK;
  dsuFa[yy] = topK;
  dsuFa[topK] = topK;
  ans[topK] = val;
  tl[topK] = xx;
  tr[topK] = yy;
}
void dfs(int u) {
  for (int j = 1; j < 21; j++) {
    fa[u][j] = fa[fa[u][j - 1]][j - 1];
  }
  if (tl[u]) {
    level[tl[u]] = level[u] + 1;
    dfs(tl[u]);
  }
  if (tr[u]) {
    level[tr[u]] = level[u] + 1;
    dfs(tr[u]);
  }
}
int lca(int a, int b) {
  if (level[a] < level[b]) {
    int c = a;
    a = b;
    b = c;
  }
  int ha = level[a];
  int hb = level[b];
  int begina = a;
  int beginb = b;
  int beginlevela = level[a];
  int beginlevelb = level[b];
  int deltaH = ha - hb;
  for (int i = 0; i < 21; i++) {
    if (deltaH & (1 << i)) {
      a = fa[a][i];
    }
  }
  for (int i = 20; i >= 0; i--) {
    if (fa[a][i] != fa[b][i]) {
      a = fa[a][i];
      b = fa[b][i];
    }
  }
  return fa[a][0];
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> n >> m >> k >> q;
  int i;
  for (i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    e[a].push_back({b, c});
    e[b].push_back({a, c});
  }
  dijstra();
  for (i = 1; i <= n; i++) {
    for (int j = 0; j < e[i].size(); j++) {
      if (i > e[i][j].v) {
        if (pre[i] != pre[e[i][j].v]) {
          if (pre[i] <= k && pre[e[i][j].v] <= k) {
            se.push_back(
                {pre[i], pre[e[i][j].v], du[i] + du[e[i][j].v] + e[i][j].d});
          }
        }
      }
    }
  }
  sort(se.begin(), se.end());
  topK = k;
  for (i = 1; i <= k; i++) {
    dsuFa[i] = i;
    tl[i] = 0;
    tr[i] = 0;
    level[i] = 0;
  }
  for (i = 0; i < se.size(); i++) {
    if (dsuFind(se[i].u) != dsuFind(se[i].v)) {
      dsuUnion(se[i].u, se[i].v, se[i].d);
    }
  }
  level[topK] = 1;
  dfs(topK);
  while (q--) {
    int a, b;
    cin >> a >> b;
    int c = lca(a, b);
    if (c > 0) {
      cout << ans[c] << endl;
    } else {
      cout << a << " " << b << endl;
    }
  }
  return 0;
}
