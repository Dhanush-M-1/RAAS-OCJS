#include <bits/stdc++.h>
using namespace std;
long long tests;
int parent[1000005], siz[1000005], ans[1000005], d[1000005];
vector<long long> g[1000005];
void dfs(int v, int printf = 0) {
  if (printf) parent[v] = printf;
  siz[v] = 1;
  int mx = 0, mx2 = 0;
  for (auto u : g[v])
    if (!parent[u]) {
      dfs(u, v);
      siz[v] += siz[u];
      d[v] = max(d[v], d[u] + 1);
      if (d[u] + 1 > mx) {
        mx2 = mx;
        mx = d[u] + 1;
      } else if (d[u] + 1 > mx2)
        mx2 = d[u] + 1;
      ans[v] = max(mx + mx2, max(ans[v], ans[u]));
    }
}
int find_set(int v) {
  if (v == parent[v]) return v;
  return parent[v] = find_set(parent[v]);
}
void union_sets(int a, int b) {
  a = find_set(a);
  b = find_set(b);
  if (a == b) return;
  if (siz[a] < siz[b]) swap(a, b);
  siz[a] += siz[b];
  parent[b] = a;
  ans[a] = max(ans[a], max(ans[b], ((ans[a] + 1) / 2 + (ans[b] + 1) / 2 + 1)));
}
long long n, m, q, x, y, cnt;
int main() {
  scanf("%I64d%I64d%I64d", &n, &m, &q);
  while (m--) {
    scanf("%I64d%I64d", &x, &y);
    g[x].push_back(y);
    g[y].push_back(x);
  }
  for (int i = 1; i <= n; i++)
    if (!parent[i]) {
      parent[i] = i;
      dfs(i);
    }
  while (q--) {
    scanf("%I64d", &tests);
    if (tests == 1) {
      scanf("%I64d", &x);
      x = find_set(x);
      printf("%d\n", ans[x]);
    } else {
      scanf("%I64d%I64d", &x, &y);
      union_sets(x, y);
    }
  }
}
