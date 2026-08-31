#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
const long long R = (long long)1e17 + 5;
int n;
long long a[N], b[N], f[N], g[N];
vector<pair<int, int> > adj[N];
long long Round(long long a, long long b) { return (a + b - 1) / b; }
void DFS(int u) {
  f[u] = max(0LL, a[u] - b[u]);
  g[u] = max(0LL, b[u] - a[u]);
  for (int k = 0; k < adj[u].size(); ++k) {
    int v = adj[u][k].first, w = adj[u][k].second;
    DFS(v);
  }
  for (int k = 0; k < adj[u].size(); ++k) {
    int v = adj[u][k].first, w = adj[u][k].second;
    if (f[v] >= Round(R - f[u], w))
      f[u] = R;
    else
      f[u] += f[v] * w;
    g[u] += g[v];
  }
  long long x = f[u], y = g[u];
  f[u] = max(0LL, x - y);
  g[u] = max(0LL, y - x);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%I64d", &b[i]);
  for (int i = 1; i <= n; ++i) scanf("%I64d", &a[i]);
  for (int i = 2; i <= n; ++i) {
    int p, k;
    scanf("%d%d", &p, &k);
    adj[p].push_back(pair<int, int>(i, k));
  }
  DFS(1);
  if (f[1] == 0)
    puts("YES");
  else
    puts("NO");
  return 0;
}
