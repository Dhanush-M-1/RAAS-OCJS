#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 6e5 + 5;
long long n, m, k, T, w, x, y, t, tot, head[MAXN], ver[MAXN], edge[MAXN],
    Next[MAXN];
long long f[MAXN][21], maxx[MAXN][21];
pair<long long, long long> dis[MAXN];
long long d[MAXN];
bool v[MAXN];
void addedge(long long x, long long y, long long z) {
  ver[++tot] = y, edge[tot] = z, Next[tot] = head[x], head[x] = tot;
}
struct node {
  long long x, y, z;
} a[MAXN], b[MAXN];
priority_queue<pair<long long, long long> > q;
vector<pair<long long, long long> > g[MAXN];
void dij() {
  memset(v, 0, sizeof(v));
  for (long long i = 1; i <= n; i++) {
    if (i <= k)
      dis[i].first = 0, dis[i].second = i, q.push(make_pair(0, i));
    else
      dis[i].first = 1ll << 62, dis[i].second = 0;
  }
  while (q.size()) {
    long long x = q.top().second;
    q.pop();
    if (v[x]) continue;
    v[x] = 1;
    for (long long i = head[x]; i; i = Next[i]) {
      long long y = ver[i], z = edge[i];
      if (dis[y].first > dis[x].first + z) {
        dis[y].first = dis[x].first + z;
        dis[y].second = dis[x].second;
        q.push(make_pair(-dis[y].first, y));
      }
    }
  }
}
bool cmp(node a, node b) { return a.z < b.z; }
long long pre[MAXN];
long long Find(long long x) { return x == pre[x] ? x : pre[x] = Find(pre[x]); }
long long lca(long long x, long long y) {
  if (d[x] > d[y]) swap(x, y);
  long long ans = 0;
  for (long long i = t; i >= 0; i--) {
    if (d[f[y][i]] >= d[x]) ans = max(ans, maxx[y][i]), y = f[y][i];
  }
  if (x == y) return ans;
  for (long long i = t; i >= 0; i--) {
    if (f[x][i] != f[y][i])
      ans = max(ans, max(maxx[x][i], maxx[y][i])), x = f[x][i], y = f[y][i];
  }
  ans = max(ans, maxx[x][0]);
  ans = max(ans, maxx[y][0]);
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  while (cin >> n >> m >> k >> T) {
    t = (long long)(log(n) / log(2)) + 1;
    for (long long i = 1; i <= k; i++) g[i].clear(), pre[i] = i;
    memset(head, 0, sizeof(head));
    tot = 0;
    long long pos = 0;
    for (long long i = 1; i <= m; i++) {
      cin >> x >> y >> w;
      addedge(x, y, w);
      addedge(y, x, w);
      a[++pos].x = x, a[pos].y = y, a[pos].z = w;
      a[++pos].x = y, a[pos].y = x, a[pos].z = w;
    }
    dij();
    pos = 0;
    for (long long i = 1; i <= 2 * m; i++) {
      if (dis[a[i].x].second != dis[a[i].y].second) {
        b[++pos].x = dis[a[i].x].second;
        b[pos].y = dis[a[i].y].second;
        b[pos].z = a[i].z + dis[a[i].x].first + dis[a[i].y].first;
      }
    }
    sort(b + 1, b + pos + 1, cmp);
    for (long long i = 1; i <= pos; i++) {
      long long xx = Find(b[i].x);
      long long yy = Find(b[i].y);
      if (xx == yy) continue;
      pre[xx] = yy;
      g[b[i].x].push_back(make_pair(b[i].y, b[i].z));
      g[b[i].y].push_back(make_pair(b[i].x, b[i].z));
    }
    queue<long long> Q;
    memset(d, 0, sizeof(d));
    Q.push(1);
    d[1] = 1;
    while (Q.size()) {
      long long x = Q.front();
      Q.pop();
      long long len = g[x].size();
      for (long long i = 0; i <= len - 1; i++) {
        long long y = g[x][i].first;
        if (d[y]) continue;
        d[y] = d[x] + 1;
        f[y][0] = x;
        maxx[y][0] = g[x][i].second;
        for (long long j = 1; j <= t; j++) {
          f[y][j] = f[f[y][j - 1]][j - 1];
          maxx[y][j] = max(maxx[y][j - 1], maxx[f[y][j - 1]][j - 1]);
        }
        Q.push(y);
      }
    }
    while (T--) {
      cin >> x >> y;
      cout << lca(x, y) << endl;
    }
  }
  return 0;
}
