#include <bits/stdc++.h>
using namespace std;
void dijk();
void build();
void dfs(int u);
long long getv(int u, int v);
bool add(int u, int v, long long w);
int n, m, k, dpth[100002], r[100002];
pair<int, long long> pr[17][100002];
long long d[100002];
vector<pair<int, long long> > ad[100002];
pair<long long, pair<int, int> > edge[100002 * 6];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int i, q;
  cin >> n >> m >> k >> q;
  for (i = 1; i <= m; ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    ad[u].push_back({v, w});
    ad[v].push_back({u, w});
  }
  dijk();
  build();
  dfs(1);
  for (i = 1; i <= q; ++i) {
    int u, v;
    cin >> u >> v;
    cout << getv(u, v) << '\n';
  }
  return 0;
}
long long getv(int u, int v) {
  if (dpth[u] < dpth[v]) swap(u, v);
  int cv = dpth[u] - dpth[v], i;
  long long rev = 0;
  for (i = 0; i < 17; ++i)
    if ((cv >> i) & 1) {
      rev = max(rev, pr[i][u].second);
      u = pr[i][u].first;
    }
  for (i = 16; i >= 0; --i)
    if (pr[i][u].first != pr[i][v].first) {
      rev = max(rev, max(pr[i][u].second, pr[i][v].second));
      u = pr[i][u].first;
      v = pr[i][v].first;
    }
  if (u == v) return rev;
  return max(rev, max(pr[0][u].second, pr[0][v].second));
}
void dfs(int u) {
  int i;
  for (auto v : ad[u]) {
    if (v.first == pr[0][u].first) continue;
    pr[0][v.first] = {u, v.second};
    dpth[v.first] = dpth[u] + 1;
    for (i = 1; i < 17; ++i) {
      pr[i][v.first].first = pr[i - 1][pr[i - 1][v.first].first].first;
      pr[i][v.first].second = max(pr[i - 1][v.first].second,
                                  pr[i - 1][pr[i - 1][v.first].first].second);
    }
    dfs(v.first);
  }
}
int getr(int x) { return r[x] ? r[x] = getr(r[x]) : x; }
bool add(int u, int v, long long w) {
  int ru = getr(u), rv = getr(v);
  if (ru == rv) return 0;
  r[ru] = rv;
  ad[u].push_back({v, w});
  ad[v].push_back({u, w});
  return 1;
}
void build() {
  int i;
  m = 0;
  for (i = 1; i <= n; ++i) {
    for (auto j : ad[i])
      edge[++m] = {d[i] + d[j.first] + j.second, {i, j.first}};
    ad[i].clear();
  }
  sort(edge + 1, edge + m + 1);
  for (i = 1; i <= m; ++i)
    add(edge[i].second.first, edge[i].second.second, edge[i].first);
}
void dijk() {
  int i, u;
  long long cv;
  priority_queue<pair<long long, int> > pq;
  for (i = 1; i <= k; ++i) {
    pq.push({0, i});
    d[i] = 0;
  }
  for (; i <= n; ++i) d[i] = 1e18;
  while (pq.size()) {
    u = pq.top().second;
    cv = -pq.top().first;
    pq.pop();
    if (cv > d[u]) continue;
    for (auto v : ad[u])
      if (d[v.first] > cv + v.second) {
        d[v.first] = cv + v.second;
        pq.push({-d[v.first], v.first});
      }
  }
}
