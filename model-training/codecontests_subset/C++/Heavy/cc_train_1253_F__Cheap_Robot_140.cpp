#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("O0")
#pragma GCC optimize("O1")
long long pw(int a, int b) {
  long long ret = 1;
  long long mul = a;
  while (b > 0) {
    if (b & 1) ret *= mul;
    mul *= mul;
    b /= 2;
  }
  return ret;
}
long long to_int(string s) {
  long long ret = 0;
  for (int(i) = (0); (i) < (s.size()); (i)++) {
    ret += pw(10, s.size() - i - 1) * (long long)(s[i] - '0');
  }
  return ret;
}
const int MAXN = 1e5 + 15;
int n, m, k, q, par[MAXN], rnk[MAXN], tin[MAXN], tout[MAXN], tme;
long long up[MAXN][20][2];
long long dis[MAXN];
vector<pair<int, int> > adj[MAXN];
vector<pair<long long, long long> > adj2[MAXN];
pair<pair<long long, long long>, long long> ed[3 * MAXN];
int get(int v) { return par[v] = (par[v] == v ? v : get(par[v])); }
void uni(int a, int b) {
  a = get(a), b = get(b);
  if (rnk[a] < rnk[b]) swap(a, b);
  par[b] = a;
  rnk[a] += (rnk[a] == rnk[b]);
}
void dij() {
  priority_queue<pair<long long, long long>,
                 vector<pair<long long, long long> >,
                 greater<pair<long long, long long> > >
      pq;
  for (int(i) = (0); (i) < (k); (i)++) dis[i] = 0, pq.push({0, i});
  for (int(i) = (k); (i) < (n); (i)++) dis[i] = 2e15;
  while (pq.size()) {
    int v = pq.top().second;
    long long dv = pq.top().first;
    pq.pop();
    if (dv != dis[v]) continue;
    for (int(i) = (0); (i) < (adj[v].size()); (i)++) {
      int u = adj[v][i].first, c = adj[v][i].second;
      if (dis[u] > dis[v] + c) dis[u] = dis[v] + c, pq.push({dis[u], u});
    }
  }
}
void dfs(int v, int p, long long w) {
  tin[v] = tme++;
  up[v][0][0] = p, up[v][0][1] = w;
  for (int(i) = (1); (i) < (20); (i)++)
    up[v][i][0] = up[up[v][i - 1][0]][i - 1][0],
    up[v][i][1] = max(up[v][i - 1][1], up[up[v][i - 1][0]][i - 1][1]);
  for (int(i) = (0); (i) < (adj2[v].size()); (i)++) {
    int u = adj2[v][i].first;
    long long ww = adj2[v][i].second;
    if (u != p) dfs(u, v, ww);
  }
  tout[v] = tme;
}
bool isAnc(int u, int v) { return (tin[u] <= tin[v] and tout[u] >= tout[v]); }
long long mx(int u, int v) {
  long long ret = 0;
  int lca = v;
  for (int(i) = (19); (i) >= (0); (i)--) {
    if (!isAnc(up[lca][i][0], u))
      ret = max(ret, up[lca][i][1]), lca = up[lca][i][0];
  }
  if (!isAnc(lca, u)) ret = max(ret, up[lca][0][1]);
  lca = u;
  for (int(i) = (19); (i) >= (0); (i)--) {
    if (!isAnc(up[lca][i][0], v))
      ret = max(ret, up[lca][i][1]), lca = up[lca][i][0];
  }
  if (!isAnc(lca, v)) ret = max(ret, up[lca][0][1]);
  return ret;
}
bool cmp(pair<pair<long long, long long>, long long> a,
         pair<pair<long long, long long>, long long> b) {
  return dis[a.first.first] + dis[a.first.second] + a.second <
         dis[b.first.first] + dis[b.first.second] + b.second;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  ;
  cin >> n >> m >> k >> q;
  for (int(i) = (0); (i) < (n); (i)++) par[i] = i;
  for (int(i) = (0); (i) < (m); (i)++) {
    int s, e, w;
    cin >> s >> e >> w;
    s--, e--;
    adj[s].push_back({e, w});
    adj[e].push_back({s, w});
    ed[i] = {{s, e}, w};
  }
  dij();
  sort(ed, ed + m, cmp);
  for (int(i) = (0); (i) < (m); (i)++) {
    int a = ed[i].first.first, b = ed[i].first.second;
    long long w =
        ed[i].second + dis[ed[i].first.first] + dis[ed[i].first.second];
    if (get(a) != get(b)) {
      uni(a, b);
      adj2[a].push_back({b, w});
      adj2[b].push_back({a, w});
    }
  }
  dfs(0, 0, 0);
  while (q--) {
    int a, b;
    cin >> a >> b;
    a--, b--;
    cout << mx(a, b) << "\n";
  }
}
