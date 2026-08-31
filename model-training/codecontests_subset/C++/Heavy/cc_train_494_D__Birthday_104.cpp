#include <bits/stdc++.h>
using namespace std;
const long long N = 100100;
vector<pair<long long, long long> > G[N];
long long n, ht[N], dist[N], sum[N], sum2[N], all2[N], size[N], all[N];
long long parent[N], p[N][20];
static bool vis[N][2], vis_[N];
void dfs(long long v) {
  vis_[v] = true;
  long long i, sz = G[v].size();
  size[v] = 1;
  for (i = 0; i < sz; i++)
    if (!vis_[G[v][i].first]) {
      dfs(G[v][i].first);
      size[v] += size[G[v][i].first];
      sum[v] = (sum[v] + (size[G[v][i].first] * G[v][i].second) % 1000000007 +
                sum[G[v][i].first] % 1000000007) %
               1000000007;
      sum2[v] = (sum2[v] + sum2[G[v][i].first] +
                 (2LL * sum[G[v][i].first] * G[v][i].second) % 1000000007 +
                 (size[G[v][i].first] *
                  ((G[v][i].second * G[v][i].second) % 1000000007)) %
                     1000000007) %
                1000000007;
    }
}
void bfs(long long v) {
  long long i, sz, h;
  vis[v][0] = vis[v][1] = true;
  parent[v] = dist[v] = ht[v] = 0;
  queue<long long> q;
  q.push(v);
  while (!q.empty()) {
    h = q.front();
    sz = G[h].size();
    for (i = 0; i < sz; i++)
      if (!vis[G[h][i].first][0]) {
        dist[G[h][i].first] = (dist[h] + G[h][i].second) % 1000000007;
        ht[G[h][i].first] = ht[h] + 1;
        parent[G[h][i].first] = h;
        vis[G[h][i].first][0] = true;
        q.push(G[h][i].first);
      }
    q.pop();
  }
  for (long long i = 1; i <= n; i++)
    all[v] = (all[v] + dist[i]) % 1000000007,
    all2[v] = (all2[v] + (dist[i] * dist[i]) % 1000000007) % 1000000007;
  q.push(v);
  while (!q.empty()) {
    h = q.front();
    sz = G[h].size();
    for (i = 0; i < sz; i++)
      if (!vis[G[h][i].first][1]) {
        all[G[h][i].first] =
            ((all[h] + (n - 2LL * size[G[h][i].first]) * G[h][i].second) %
                 1000000007 +
             1000000007) %
            1000000007;
        all2[G[h][i].first] =
            ((all2[h] -
              (n * ((G[h][i].second * G[h][i].second) % 1000000007) %
               1000000007) +
              2LL * (all[G[h][i].first] - 2LL * sum[G[h][i].first]) *
                  G[h][i].second) %
                 1000000007 +
             1000000007) %
            1000000007;
        vis[G[h][i].first][1] = true;
        q.push(G[h][i].first);
      }
    q.pop();
  }
}
void init() {
  long long i, j;
  for (i = 1; i < n + 1; i++) p[i][0] = parent[i];
  for (j = 1; (1 << j) < n; j++)
    for (i = 1; i < n + 1; i++) p[i][j] = p[p[i][j - 1]][j - 1];
}
long long lca(long long u, long long v) {
  if (ht[u] < ht[v]) swap(u, v);
  long long log, i;
  for (log = 1; (1 << log) <= ht[u]; log++)
    ;
  log--;
  for (i = log; i >= 0; i--)
    if (ht[u] - (1 << i) >= ht[v]) u = p[u][i];
  if (u == v) return u;
  for (i = log; i >= 0; i--)
    if (p[u][i] and (p[u][i] != p[v][i])) u = p[u][i], v = p[v][i];
  return p[u][0];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  long long a, b, c, i, q;
  for (i = 1; i < n; i++) {
    cin >> a >> b >> c;
    G[a].push_back(make_pair(b, c));
    G[b].push_back(make_pair(a, c));
  }
  dfs(1);
  bfs(1);
  init();
  cin >> q;
  while (q--) {
    cin >> a >> b;
    long long k = lca(a, b), ans;
    if (k != b) {
      long long d =
          ((dist[a] + dist[b] - 2LL * dist[k]) % 1000000007 + 1000000007) %
          1000000007;
      long long c = size[b], s = sum[b], s2 = sum2[b], A = all2[a];
      ans = (((2LL * c * ((d * d) % 1000000007)) % 1000000007 +
              (4LL * d * s) % 1000000007 + 2LL * s2 - A) %
                 1000000007 +
             1000000007) %
            1000000007;
    } else {
      long long d = (dist[a] - dist[b] + 1000000007) % 1000000007;
      long long c = size[b], s = sum[b], s2 = sum2[b];
      long long A2a = all2[a], A2b = all2[b], Ab = all[b];
      ans =
          ((A2a -
            (2LL * ((d * d) % 1000000007) * (n - c + 1000000007)) % 1000000007 -
            4LL * (d * (Ab - s + 1000000007)) % 1000000007 -
            2LL * (A2b - s2 + 1000000007) % 1000000007) %
               1000000007 +
           1000000007) %
          1000000007;
    }
    cout << ans << '\n';
  }
  return 0;
}
