#include <bits/stdc++.h>
using namespace std;
struct edge {
  int other, cost;
};
vector<edge> adj[100000];
const int mod = 1e9 + 7;
struct distset {
  int many;
  int sum1;
  int sum2;
  distset operator+(const distset &other) const {
    return {(many + other.many) % mod, (sum1 + other.sum1) % mod,
            (sum2 + other.sum2) % mod};
  }
  distset operator-(const distset &other) const {
    return {(many - other.many + mod) % mod, (sum1 - other.sum1 + mod) % mod,
            (sum2 - other.sum2 + mod) % mod};
  }
  distset operator^(long long by) const {
    by %= mod;
    return {
        many, (int)((sum1 + (long long)by * many) % mod),
        (int)((sum2 + (long long)many * by % mod * by + 2LL * by % mod * sum1) %
              mod)};
  }
  distset operator*(long long by) const {
    by %= mod;
    return {(int)(by * many % mod), (int)(by * sum1 % mod),
            (int)(by * sum2 % mod)};
  }
} up[100000], down[100000], full[100000];
int parent[100000][16 + 1], logn;
int height[100000];
long long depth[100000];
int goup(int a, int dist) {
  for (int l = 0; (1 << l) <= dist; l++)
    if (dist & (1 << l)) a = parent[a][l];
  return a;
}
int lca(int a, int b) {
  if (height[a] < height[b]) swap(a, b);
  a = goup(a, height[a] - height[b]);
  if (a == b) return a;
  for (int l = logn; l >= 0; l--)
    if (parent[a][l] != parent[b][l]) a = parent[a][l], b = parent[b][l];
  return parent[a][0];
}
void dfs2(int v, int p, distset from_up) {
  up[v] = from_up;
  full[v] = up[v] + down[v];
  for (edge &ed : adj[v]) {
    if (ed.other == p) continue;
    int u = ed.other;
    dfs2(u, v, (from_up + down[v] - (down[u] ^ ed.cost)) ^ ed.cost);
  }
}
void dfs(int v, int p, int h, long long d) {
  for (int l = 1; l <= logn; l++)
    parent[v][l] = parent[parent[v][l - 1]][l - 1];
  height[v] = h, depth[v] = d;
  down[v] = {1, 0, 0};
  for (edge &ed : adj[v]) {
    if (ed.other == p) continue;
    int u = ed.other;
    parent[u][0] = v;
    dfs(u, v, h + 1, d + ed.cost);
    down[v] = down[v] + (down[u] ^ ed.cost);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  logn = 0;
  while ((1 << (logn + 1)) <= n) logn++;
  for (int i = 0; i < n - 1; i++) {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c), a--, b--;
    adj[a].push_back({b, c});
    adj[b].push_back({a, c});
  }
  parent[0][0] = 0;
  dfs(0, -1, 0, 0);
  dfs2(0, -1, {0, 0, 0});
  int nq;
  scanf("%d", &nq);
  for (int q = 0; q < nq; q++) {
    int u, v;
    scanf("%d %d", &u, &v), u--, v--;
    int l = lca(u, v);
    long long dist = depth[u] + depth[v] - 2 * depth[l];
    distset result;
    if (l == v)
      result = full[u] - (up[v] ^ dist) * 2;
    else
      result = (down[v] ^ dist) * 2 - full[u];
    printf("%d\n", result.sum2);
  }
  return 0;
}
