#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 500;
const int LOG = 20;
int n, m, q, k;
int v1[N], v2[N], w[N];
vector<pair<long long, int> > v[N], T[N];
long long dis[N];
int tko[N], par[N];
int lca[N][LOG], dep[N];
long long dp_lca[N][LOG];
int pr(int x) {
  if (par[x] == x) return x;
  return par[x] = pr(par[x]);
}
void mrg(int x, int y) { par[pr(x)] = pr(y); }
void dfs(int x, int lst) {
  lca[x][0] = lst;
  dep[x] = dep[lst] + 1;
  for (pair<long long, int> nxt : T[x]) {
    if (nxt.second == lst) continue;
    dp_lca[nxt.second][0] = nxt.first;
    dfs(nxt.second, x);
  }
}
void precompute() {
  for (int j = 1; j < LOG; j++) {
    for (int i = 1; i <= n; i++) {
      lca[i][j] = lca[lca[i][j - 1]][j - 1];
      dp_lca[i][j] = max(dp_lca[i][j - 1], dp_lca[lca[i][j - 1]][j - 1]);
    }
  }
}
long long get_lca(int x, int y) {
  long long ans = 0;
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = LOG - 1; i >= 0; i--)
    if (dep[x] - (1 << i) >= dep[y]) {
      ans = max(ans, dp_lca[x][i]);
      x = lca[x][i];
    }
  if (x == y) return ans;
  for (int i = LOG - 1; i >= 0; i--)
    if (lca[x][i] != lca[y][i]) {
      ans = max(ans, max(dp_lca[x][i], dp_lca[y][i]));
      x = lca[x][i], y = lca[y][i];
    }
  return max(ans, max(dp_lca[x][0], dp_lca[y][0]));
}
void dijkstra() {
  memset(dis, -1, sizeof(dis));
  set<pair<long long, int> > S;
  for (int i = 1; i <= k; i++)
    S.insert({0LL, i}), dis[i] = 0, tko[i] = i, par[i] = i;
  for (; !S.empty();) {
    pair<long long, int> cur = *S.begin();
    S.erase(S.begin());
    for (pair<long long, int> nxt : v[cur.second]) {
      if (dis[nxt.second] == -1 ||
          dis[cur.second] + nxt.first < dis[nxt.second]) {
        if (dis[nxt.second] != -1) S.erase({dis[nxt.second], nxt.second});
        dis[nxt.second] = dis[cur.second] + nxt.first;
        tko[nxt.second] = tko[cur.second];
        S.insert({dis[nxt.second], nxt.second});
      }
    }
  }
}
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", v1 + i, v2 + i, w + i);
    v[v1[i]].push_back({w[i], v2[i]});
    v[v2[i]].push_back({w[i], v1[i]});
  }
  dijkstra();
  vector<pair<long long, pair<int, int> > > edg;
  for (int i = 0; i < m; i++) {
    if (tko[v1[i]] != tko[v2[i]]) {
      edg.push_back({dis[v1[i]] + dis[v2[i]] + w[i], {tko[v1[i]], tko[v2[i]]}});
    }
  }
  sort(edg.begin(), edg.end());
  for (pair<long long, pair<int, int> > E : edg) {
    if (pr(E.second.first) == pr(E.second.second)) continue;
    mrg(E.second.first, E.second.second);
    T[E.second.first].push_back({E.first, E.second.second});
    T[E.second.second].push_back({E.first, E.second.first});
  }
  dfs(1, 1);
  precompute();
  for (int i = 0; i < q; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    printf("%lld\n", get_lca(x, y));
  }
}
