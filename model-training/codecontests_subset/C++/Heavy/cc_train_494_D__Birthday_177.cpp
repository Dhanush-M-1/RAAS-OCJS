#include <bits/stdc++.h>
using namespace std;
const long long M = 1e9 + 7;
vector<pair<int, long long> > v[100004];
int parent[100004], level[100004];
long long dist[100004], size[100004], first[100004], f_[100004], g[100004],
    g_[100004];
int n;
int P[100004][30];
long long mu(long long x1, long long x2) { return (x1 * x2) % M; }
void preprocess(void) {
  int i, m;
  int j = n;
  for (i = 0; i <= j; i++)
    for (m = 0; (1 << m) <= j; m++) P[i][m] = -1;
  for (i = 1; i <= j; i++) P[i][0] = parent[i];
  for (m = 1; 1 << m <= j; m++)
    for (i = 1; i <= j; i++)
      if (P[i][m - 1] != -1) P[i][m] = P[P[i][m - 1]][m - 1];
}
int lca(int p, int q) {
  int tmp, log, i;
  if (level[p] < level[q]) tmp = p, p = q, q = tmp;
  for (log = 1; 1 << log <= level[p]; log++)
    ;
  log--;
  for (i = log; i >= 0; i--)
    if (level[p] - (1 << i) >= level[q]) p = P[p][i];
  if (p == q) return p;
  for (i = log; i >= 0; i--)
    if (P[p][i] != -1 && P[p][i] != P[q][i]) p = P[p][i], q = P[q][i];
  return parent[p];
}
void dfs(int node, int par) {
  size[node] = 1;
  for (int j = 0; j < v[node].size(); j++) {
    int ver = v[node][j].first;
    if (ver != par) {
      level[ver] = 1 + level[node];
      parent[ver] = node;
      dist[ver] = (dist[node] + v[node][j].second) % M;
      dfs(ver, node);
      size[node] += size[ver];
      first[node] =
          (first[node] + first[ver] + v[node][j].second * size[ver]) % M;
      g[node] = (g[node] + g[ver] + 2 * first[ver] * v[node][j].second +
                 mu(v[node][j].second, v[node][j].second) * size[ver]) %
                M;
    }
  }
}
void dfs1(int node, int par, long long d) {
  f_[node] =
      (f_[par] + first[par] - first[node] + d * (n - 2 * size[node])) % M;
  g_[node] = (g_[par] + g[par] - g[node] + mu(d, d) * (n - 4 * size[node]) +
              d * (2 * first[par] + 2 * f_[par] - 4 * first[node])) %
             M;
  for (int j = 0; j < v[node].size(); j++) {
    int ver = v[node][j].first;
    if (ver != par) dfs1(ver, node, v[node][j].second);
  }
}
long long ans(int u1, int v1) {
  int lc = lca(u1, v1);
  long long sum = 0;
  long long d = dist[u1] + dist[v1] - 2 * dist[lc];
  if (lc == v1) {
    sum = (g[u1] + g_[u1] - 2 * g_[v1] - 2 * mu(d, d) * (n - size[v1]) -
           4 * d * f_[v1]) %
          M;
  } else {
    sum = (2 * g[v1] - g_[u1] - g[u1] + 2 * mu(d, d) * size[v1] +
           4 * d * first[v1]) %
          M;
  }
  if (sum < 0) sum += M;
  return sum;
}
int main() {
  int a, b;
  long long c;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%lld", &c);
    v[a].push_back(make_pair(b, c));
    v[b].push_back(make_pair(a, c));
  }
  parent[1] = 1;
  dist[1] = 0;
  level[1] = 1;
  dfs(1, 1);
  dfs1(1, 1, 0);
  preprocess();
  int q;
  scanf("%d", &q);
  while (q--) {
    scanf("%d", &a);
    scanf("%d", &b);
    cout << ans(a, b) << endl;
  }
}
