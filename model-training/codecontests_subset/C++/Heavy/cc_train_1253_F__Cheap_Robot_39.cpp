#include <bits/stdc++.h>
using namespace std;
const double pai = acos(-1);
const double eps = 1e-8;
const long long mod = 1e9 + 7;
const int MXN = 2e5;
const int MXLOG = 20;
vector<pair<long long, int> > g[MXN], G[MXN];
long long d[MXN];
int dfg[MXN], sour[MXN];
int fa[MXN];
int found(int x) {
  if (x == fa[x]) return x;
  return fa[x] = found(fa[x]);
}
int bei[MXN][MXLOG], de[MXN];
long long val[MXN][MXLOG];
void dfs(int u, int p) {
  for (auto i : G[u]) {
    if (i.second != p) {
      de[i.second] = de[u] + 1;
      bei[i.second][0] = u;
      val[i.second][0] = i.first;
      dfs(i.second, u);
    }
  }
}
void initLCA(int nn) {
  bei[1][0] = -1;
  de[1] = 0;
  dfs(1, -1);
  for (int k = 0; k < MXLOG - 1; k++) {
    for (int v = 1; v <= nn; v++) {
      if (bei[v][k] < 0)
        bei[v][k + 1] = -1;
      else
        bei[v][k + 1] = bei[bei[v][k]][k],
                   val[v][k + 1] = max(val[v][k], val[bei[v][k]][k]);
    }
  }
}
long long query(int u, int v) {
  if (de[u] > de[v]) swap(u, v);
  long long re = -1;
  for (int k = 0; k < MXLOG; k++) {
    if ((de[v] - de[u]) >> k & 1) re = max(re, val[v][k]), v = bei[v][k];
  }
  if (u == v) return re;
  for (int k = MXLOG - 1; k >= 0; k--) {
    if (bei[u][k] != bei[v][k]) {
      re = max(re, val[v][k]), re = max(re, val[u][k]);
      u = bei[u][k], v = bei[v][k];
    }
  }
  re = max(re, val[u][0]);
  re = max(re, val[v][0]);
  return re;
}
int main() {
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++) {
    int su, sv, sw;
    scanf("%d%d%d", &su, &sv, &sw);
    g[su].push_back(make_pair(sw, sv));
    g[sv].push_back(make_pair(sw, su));
  }
  priority_queue<pair<long long, int> > pq;
  for (int i = 1; i <= n; i++) d[i] = LLONG_MAX / 2;
  for (int i = 1; i <= k; i++) pq.push(make_pair(0, i)), d[i] = 0, sour[i] = i;
  while (!pq.empty()) {
    auto now = pq.top();
    pq.pop();
    int u = now.second;
    if (dfg[u]) continue;
    dfg[u] = 1;
    for (auto ed : g[u]) {
      long long dis = ed.first + d[u];
      if (dis > d[ed.second]) continue;
      d[ed.second] = dis;
      sour[ed.second] = sour[u];
      pq.push(make_pair(-dis, ed.second));
    }
  }
  vector<tuple<long long, int, int> > krs;
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= n; i++) {
    for (auto ed : g[i]) {
      if (sour[i] != sour[ed.second])
        krs.push_back(make_tuple(ed.first + d[i] + d[ed.second], sour[i],
                                 sour[ed.second]));
    }
  }
  sort(krs.begin(), krs.end());
  for (auto i : krs) {
    int xx = found(get<1>(i));
    int yy = found(get<2>(i));
    if (xx == yy) continue;
    fa[xx] = fa[yy];
    G[get<1>(i)].push_back(make_pair(get<0>(i), get<2>(i)));
    G[get<2>(i)].push_back(make_pair(get<0>(i), get<1>(i)));
  }
  initLCA(n);
  while (q--) {
    int sa, sb;
    scanf("%d%d", &sa, &sb);
    cout << query(sa, sb) << '\n';
  }
  return 0;
}
