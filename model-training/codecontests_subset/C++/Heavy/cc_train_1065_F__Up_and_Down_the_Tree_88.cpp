#include <bits/stdc++.h>
using namespace std;
int n, k, siz[1000005], dep[1000005], low[1000005], f[1000005];
bool is_leaf[1000005];
vector<int> G[1000005];
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    (x *= 10) += ch - '0';
    ch = getchar();
  }
  return x * f;
}
void dfs1(int u, int c_fa) {
  dep[u] = dep[c_fa] + 1;
  low[u] = 2e9;
  if (is_leaf[u]) low[u] = dep[u];
  for (int v : G[u]) dfs1(v, u), low[u] = min(low[u], low[v]);
}
void dfs2(int u) {
  if (is_leaf[u]) siz[u] = 1;
  for (int v : G[u]) {
    dfs2(v);
    if (low[v] - dep[u] <= k) siz[u] += siz[v], siz[v] = 0;
  }
}
void dfs3(int u) {
  f[u] = siz[u];
  int mx = 0;
  for (int v : G[u]) dfs3(v), mx = max(mx, f[v]);
  f[u] += mx;
}
int main() {
  n = read(), k = read();
  memset(is_leaf, true, sizeof(is_leaf));
  for (int i = 2, x; i <= n; i++)
    x = read(), is_leaf[x] = false, G[x].push_back(i);
  dfs1(1, 0);
  dfs2(1);
  dfs3(1);
  printf("%d\n", f[1]);
  return 0;
}
