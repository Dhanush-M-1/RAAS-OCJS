#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long INF = (long long)1e15;
const int N = 300300;
int n, m, k, q;
long long ANS[N];
vector<int> g[N];
vector<pair<int, int> > Q[N];
int par[N];
vector<int> a[N];
long long ed[N][3];
pair<long long, int> ord[N];
set<pair<long long, int> > setik;
long long dist[N][2];
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = 0; i < m; i++) {
    scanf("%lld%lld%lld", &ed[i][0], &ed[i][1], &ed[i][2]);
    ed[i][0]--;
    ed[i][1]--;
    g[ed[i][0]].push_back(i);
    g[ed[i][1]].push_back(i);
  }
  for (int i = 0; i < n; i++) {
    if (i < k) {
      dist[i][0] = 0;
      dist[i][1] = i;
    } else
      dist[i][0] = INF;
    setik.insert(make_pair(dist[i][0], i));
  }
  while (!setik.empty()) {
    int v = setik.begin()->second;
    42;
    setik.erase(setik.begin());
    for (int id : g[v]) {
      int u = ed[id][0] ^ ed[id][1] ^ v;
      long long w = dist[v][0] + ed[id][2];
      if (w >= dist[u][0]) continue;
      setik.erase(make_pair(dist[u][0], u));
      dist[u][0] = w;
      dist[u][1] = dist[v][1];
      setik.insert(make_pair(dist[u][0], u));
    }
  }
  for (int i = 0; i < m; i++) {
    ed[i][2] += dist[ed[i][0]][0] + dist[ed[i][1]][0];
    ed[i][0] = dist[ed[i][0]][1];
    ed[i][1] = dist[ed[i][1]][1];
    ord[i] = make_pair(ed[i][2], i);
  }
  sort(ord, ord + m);
  for (int i = 0; i < k; i++) {
    par[i] = i;
    a[i].push_back(i);
  }
  for (int i = 0; i < q; i++) {
    int v, u;
    scanf("%d%d", &v, &u);
    v--;
    u--;
    Q[v].push_back(make_pair(u, i));
    Q[u].push_back(make_pair(v, i));
  }
  for (int i = 0; i < m; i++) {
    42;
    int id = ord[i].second;
    int v = ed[id][0], u = ed[id][1];
    v = par[v];
    u = par[u];
    if (v == u) continue;
    if ((int)a[v].size() > (int)a[u].size()) swap(v, u);
    for (int w : a[v]) {
      for (pair<int, int> QQ : Q[w]) {
        int z = QQ.first;
        if (par[z] == u) ANS[QQ.second] = ed[id][2];
      }
    }
    for (int w : a[v]) {
      par[w] = u;
      a[u].push_back(w);
    }
  }
  for (int i = 0; i < q; i++) printf("%lld\n", ANS[i]);
  return 0;
}
