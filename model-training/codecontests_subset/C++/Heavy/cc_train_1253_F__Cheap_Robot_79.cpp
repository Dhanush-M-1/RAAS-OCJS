#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
const int maxn = 1e6 + 10;
int n, m, k, qnum, st[maxn], to[maxn], nt[maxn], topt, fa[maxn];
int ffa[21][100010], lg[maxn], dep[maxn];
long long dis[maxn], w[maxn], ma[21][100010];
bool f[maxn];
struct da {
  int first, to;
  long long v;
} a[maxn];
priority_queue<pair<long long, int>, vector<pair<long long, int> >,
               greater<pair<long long, int> > >
    q;
inline void add(int x, int y, long long z) {
  to[++topt] = y;
  nt[topt] = st[x];
  st[x] = topt;
  w[topt] = z;
}
void dij() {
  for (int i = 1; i <= n; i++) dis[i] = inf;
  for (int i = 1; i <= k; i++) dis[i] = 0, q.push(make_pair(0, i));
  while (!q.empty()) {
    int x = q.top().second;
    q.pop();
    if (f[x])
      continue;
    else
      f[x] = 1;
    int p = st[x];
    while (p) {
      if (dis[to[p]] > dis[x] + w[p]) {
        dis[to[p]] = dis[x] + w[p];
        q.push(make_pair(dis[to[p]], to[p]));
      }
      p = nt[p];
    }
  }
}
inline bool cmp(da aa, da bb) { return aa.v < bb.v; }
int getf(int x) {
  if (fa[x] == x) return x;
  fa[x] = getf(fa[x]);
  return fa[x];
}
void dfs(int x, int d, long long vv) {
  f[x] = 1;
  dep[x] = d;
  ma[0][x] = vv;
  int p = st[x];
  while (p) {
    if (!f[to[p]]) dfs(to[p], d + 1, w[p]), ffa[0][to[p]] = x;
    p = nt[p];
  }
}
inline void init() {
  for (int i = 1; i <= n; i++)
    lg[i] = lg[i - 1] + ((1 << (lg[i - 1] + 1)) == i);
  for (int j = 1; (1 << j) <= n; j++)
    for (int i = 1; i <= n; i++) ffa[j][i] = ffa[j - 1][ffa[j - 1][i]];
  for (int j = 1; (1 << j) <= n; j++)
    for (int i = 1; i <= n; i++)
      ma[j][i] = max(ma[j - 1][i], ma[j - 1][ffa[j - 1][i]]);
}
long long solve(int x, int y) {
  long long ans = 0;
  if (dep[x] < dep[y]) swap(x, y);
  while (dep[x] > dep[y]) {
    ans = max(ans, ma[lg[dep[x] - dep[y]]][x]);
    x = ffa[lg[dep[x] - dep[y]]][x];
  }
  if (x == y) return ans;
  for (register int i = lg[dep[x]]; i >= 0; i--)
    if (ffa[i][x] != ffa[i][y]) {
      ans = max(ans, ma[i][x]);
      ans = max(ans, ma[i][y]);
      x = ffa[i][x];
      y = ffa[i][y];
    }
  ans = max(ans, ma[0][x]);
  ans = max(ans, ma[0][y]);
  return ans;
}
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &qnum);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%lld", &a[i].first, &a[i].to, &a[i].v);
    add(a[i].first, a[i].to, a[i].v);
    add(a[i].to, a[i].first, a[i].v);
  }
  dij();
  for (int i = 1; i <= m; i++) a[i].v = a[i].v + dis[a[i].first] + dis[a[i].to];
  sort(a + 1, a + m + 1, cmp);
  topt = 0;
  for (int i = 1; i <= n; i++) st[i] = 0, fa[i] = i;
  for (int i = 1; i <= m; i++) {
    if (getf(a[i].first) == getf(a[i].to)) continue;
    fa[getf(a[i].first)] = getf(a[i].to);
    add(a[i].first, a[i].to, a[i].v);
    add(a[i].to, a[i].first, a[i].v);
  }
  for (int i = 1; i <= n; i++) f[i] = 0;
  dfs(1, 1, 0);
  init();
  for (int i = 1; i <= qnum; i++) {
    int xx, yy;
    scanf("%d%d", &xx, &yy);
    printf("%lld\n", solve(xx, yy));
  }
  return 0;
}
