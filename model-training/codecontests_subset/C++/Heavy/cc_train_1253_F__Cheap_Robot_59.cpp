#include <bits/stdc++.h>
using namespace std;
long long const ms = 1e5 + 10, mlg = 30;
vector<pair<long long, long long>> g[ms];
vector<pair<long long, long long>> mst[ms];
long long d1[ms];
long long n, m, k, q;
struct edge {
  long long u, v, w;
  edge() {}
  edge(long long u, long long v, long long w) : u(u), v(v), w(w) {}
};
vector<edge> me;
void dij() {
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      hp;
  for (int i = 0; i < n; i++) {
    if (i < k) {
      d1[i] = 0;
      hp.push({0, i});
    } else
      d1[i] = 1e18;
  }
  while (hp.size()) {
    long long nv = hp.top().second, dv = hp.top().first;
    hp.pop();
    if (d1[nv] < dv) continue;
    for (auto e : g[nv]) {
      long long av = e.first, wv = e.second;
      if (d1[nv] + wv < d1[av]) {
        d1[av] = d1[nv] + wv;
        hp.push({d1[av], av});
      }
    }
  }
}
void cong(long long a, long long b, long long w) {
  g[a].push_back({b, w});
  g[b].push_back({a, w});
}
void conm(long long a, long long b, long long w) {
  mst[a].push_back({b, w});
  mst[b].push_back({a, w});
}
long long ds[ms], sz[ms];
void mks() {
  for (int i = 0; i < n; i++) ds[i] = i, sz[i] = 1;
}
long long find(long long i) {
  if (ds[i] == i)
    return i;
  else
    return ds[i] = find(ds[i]);
}
void onion(long long a, long long b) {
  a = find(a), b = find(b);
  if (sz[a] < sz[b]) swap(a, b);
  if (a != b) sz[a] += sz[b];
  ds[b] = a;
}
long long par[ms][mlg + 1], maxw[ms][mlg + 1], lvl[ms];
void dfs(long long v, long long p, long long l = 0, long long take = 0) {
  lvl[v] = l;
  par[v][0] = p;
  maxw[v][0] = take;
  for (long long kk = 1; kk <= mlg; kk++) {
    par[v][kk] = par[par[v][kk - 1]][kk - 1];
    maxw[v][kk] = max(maxw[v][kk - 1], maxw[par[v][kk - 1]][kk - 1]);
  }
  for (auto &u : mst[v]) {
    if (u.first != p) dfs(u.first, v, l + 1, u.second);
  }
}
long long lca(long long a, long long b) {
  if (lvl[b] > lvl[a]) swap(a, b);
  for (long long i = mlg; i >= 0; i--) {
    if (lvl[a] - (1 << i) >= lvl[b]) a = par[a][i];
  }
  if (a == b) return a;
  for (long long i = mlg; i >= 0; i--) {
    if (par[a][i] != par[b][i]) a = par[a][i], b = par[b][i];
  }
  return par[a][0];
}
long long lift(long long v, long long d) {
  long long ret = 0;
  for (long long i = mlg; i >= 0; i--) {
    if ((1 << i) <= d) ret = max(ret, maxw[v][i]), v = par[v][i], d -= (1 << i);
  }
  return ret;
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  cin >> n >> m >> k >> q;
  long long a, b, w;
  for (int i = 0; i < m; i++) {
    cin >> a >> b >> w;
    a--, b--;
    cong(a, b, w);
  }
  dij();
  for (int i = 0; i < n; i++) {
    for (auto e : g[i]) {
      me.push_back(edge(i, e.first, d1[i] + d1[e.first] + e.second));
    }
  }
  sort(me.begin(), me.end(),
       [](edge &a, edge &b) -> bool { return a.w < b.w; });
  mks();
  for (int i = 0; i < me.size(); i++) {
    if (find(me[i].u) != find(me[i].v)) {
      conm(me[i].u, me[i].v, me[i].w);
      onion(me[i].u, me[i].v);
    }
  }
  memset(maxw, 0, sizeof maxw);
  dfs(0, 0);
  long long q1, q2, lc;
  while (q--) {
    cin >> q1 >> q2;
    q1--, q2--;
    lc = lca(q1, q2);
    cout << max(lift(q1, lvl[q1] - lvl[lc]), lift(q2, lvl[q2] - lvl[lc]))
         << '\n';
  }
  return 0;
}
