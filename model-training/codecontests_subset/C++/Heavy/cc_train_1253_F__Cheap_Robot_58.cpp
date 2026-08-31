#include <bits/stdc++.h>
using namespace std;
const int N = 1000 * 100 + 10;
const int M = 3 * N;
long long dis[N];
int col[N];
vector<pair<int, int>> c[N];
vector<pair<long long, pair<int, int>>> edges;
vector<int> ch[M];
int par[N];
set<pair<long long, int>> curr;
long long qx[M], qy[M], ql[M], qr[M];
int dfind(int u) { return par[u] < 0 ? u : par[u] = dfind(par[u]); }
void dmerge(int u, int v) {
  u = dfind(u);
  v = dfind(v);
  if (u == v) return;
  if (par[u] > par[v]) swap(u, v);
  par[u] += par[v];
  par[v] = u;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--;
    v--;
    c[u].push_back({v, w});
    c[v].push_back({u, w});
  }
  memset(dis, 63, sizeof dis);
  for (int i = 0; i < k; i++) {
    dis[i] = 0;
    col[i] = i;
    curr.insert({dis[i], i});
  }
  while (curr.size()) {
    int s = curr.begin()->second;
    curr.erase(curr.begin());
    for (auto x : c[s])
      if (dis[x.first] > dis[s] + x.second) {
        curr.erase({dis[x.first], x.first});
        dis[x.first] = dis[s] + x.second;
        col[x.first] = col[s];
        curr.insert({dis[x.first], x.first});
      }
  }
  for (int x = 0; x < n; x++)
    for (auto y : c[x]) {
      if (x < y.first && col[x] != col[y.first])
        edges.push_back(
            {dis[x] + dis[y.first] + y.second, {col[x], col[y.first]}});
    }
  sort(edges.begin(), edges.end());
  for (int i = 0; i < q; i++) {
    cin >> qx[i] >> qy[i];
    qx[i]--;
    qy[i]--;
    ql[i] = -1, qr[i] = ((int)(edges).size()) - 1;
  }
  for (int t = 0; t < 20; t++) {
    for (int i = 0; i < q; i++)
      if (qr[i] - ql[i] > 1) {
        int mid = (ql[i] + qr[i]) / 2;
        ch[mid].push_back(i);
      }
    memset(par, -1, sizeof par);
    for (int i = 0; i < ((int)(edges).size()); i++) {
      dmerge(edges[i].second.first, edges[i].second.second);
      for (auto x : ch[i])
        if (dfind(qx[x]) == dfind(qy[x]))
          qr[x] = i;
        else
          ql[x] = i;
      ch[i].clear();
    }
  }
  for (int i = 0; i < q; i++) cout << edges[qr[i]].first << '\n';
  return 0;
}
