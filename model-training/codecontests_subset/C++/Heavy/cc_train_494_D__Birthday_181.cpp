#include <bits/stdc++.h>
using namespace std;
int n;
vector<pair<int, int> > edge[100005];
long long sum[100005];
long long sum2[100005];
long long up[100005];
long long up2[100005];
int s[100005];
int lca[100005][20];
int dep[100005];
long long dist[100005];
void dfs(int v, int u) {
  s[v] = 1;
  lca[v][0] = u;
  for (int i = 0; i < edge[v].size(); i++) {
    if (edge[v][i].first == u) continue;
    int x = edge[v][i].first;
    dfs(x, v);
    sum[v] += sum[x] + 1LL * s[x] * edge[v][i].second;
    sum2[v] += sum2[x] +
               1LL * s[x] * edge[v][i].second % 1000000007 * edge[v][i].second +
               2LL * edge[v][i].second * sum[x];
    sum[v] %= 1000000007;
    sum2[v] %= 1000000007;
    s[v] += s[x];
  }
}
void dfs2(int v, int u, int c) {
  if (u != -1) {
    dep[v] = dep[u] + 1;
    dist[v] = dist[u] + c;
    long long x = sum2[v] + 2LL * c * sum[v] + 1LL * c * c % 1000000007 * s[v];
    x %= 1000000007;
    long long y = sum[v] + 1LL * c * s[v];
    y %= 1000000007;
    long long q = (sum2[u] + up2[u] - x + 1000000007) % 1000000007;
    long long r = (sum[u] + up[u] - y + 1000000007) % 1000000007;
    up[v] = (r + 1LL * (n - s[v]) * c) % 1000000007;
    up2[v] =
        (q + 2LL * r * c + 1LL * c * c % 1000000007 * (n - s[v])) % 1000000007;
  }
  for (int i = 0; i < edge[v].size(); i++)
    if (u != edge[v][i].first) dfs2(edge[v][i].first, v, edge[v][i].second);
}
int calc(int a, int b) {
  if (dep[a] > dep[b]) swap(a, b);
  for (int i = 0; i < 20; i++) {
    if ((((dep[b] - dep[a]) >> i) & 1)) {
      b = lca[b][i];
    }
  }
  if (a == b) return a;
  for (int i = 19; i >= 0; i--) {
    if (lca[a][i] != lca[b][i]) {
      a = lca[a][i];
      b = lca[b][i];
    }
  }
  return lca[a][0];
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; i++) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    edge[a].push_back(make_pair(b, c));
    edge[b].push_back(make_pair(a, c));
  }
  dfs(1, -1);
  dfs2(1, -1, -1);
  int q;
  scanf("%d", &q);
  for (int i = 0; i < 19; i++)
    for (int j = 1; j <= n; j++)
      if (lca[j][i] == -1)
        lca[j][i + 1] = -1;
      else
        lca[j][i + 1] = lca[lca[j][i]][i];
  for (int i = 0; i < q; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    int x = calc(u, v);
    long long d = dist[u] + dist[v] - dist[x] * 2;
    d %= 1000000007;
    if (x == v && u != v) {
      long long a =
          up2[v] + 2LL * d * up[v] + 1LL * d * d % 1000000007 * (n - s[v]);
      a %= 1000000007;
      printf("%lld\n",
             (sum2[u] + up2[u] - 2 * a + 1000000007 + 1000000007) % 1000000007);
    } else {
      long long a =
          sum2[v] + 2LL * d * sum[v] + 1LL * d * d % 1000000007 * (s[v]);
      a %= 1000000007;
      printf("%lld\n",
             (2 * a - sum2[u] - up2[u] + 1000000007 + 1000000007) % 1000000007);
    }
  }
}
