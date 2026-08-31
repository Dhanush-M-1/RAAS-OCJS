#include <bits/stdc++.h>
using namespace std;
int n;
unordered_set<int> g[200005];
bool gone[200005];
void dfs1(int u, int p) {
  printf("%d\n", u);
  gone[u] = true;
  for (auto v : g[u]) {
    if (v == p) continue;
    dfs1(v, u);
  }
}
void dfs(int u, int p) {
  if (gone[u]) return;
  for (auto itr = g[u].begin(); itr != g[u].end();) {
    int v = *itr;
    auto nitr = next(itr);
    if (v == p) {
      itr = nitr;
      continue;
    }
    dfs(v, u);
    itr = nitr;
  }
  if (g[u].size() && (g[u].size() & 1) == 0) {
    printf("%d\n", u);
    gone[u] = true;
    for (auto itr = g[u].begin(); itr != g[u].end();) {
      int v = *itr;
      auto nitr = next(itr);
      g[u].erase(v);
      g[v].erase(u);
      if (v != p) {
        dfs1(v, u);
      }
      itr = nitr;
    }
  }
}
int main() {
  memset(gone, 0, sizeof(gone));
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int u = i;
    int v;
    scanf("%d", &v);
    if (v == 0) continue;
    g[u].insert(v);
    g[v].insert(u);
  }
  if ((n & 1) == 0) {
    printf("NO\n");
    return (0);
  }
  printf("YES\n");
  dfs(1, 0);
  for (int i = 1; i <= n; i++) {
    if (gone[i] == false) printf("%d\n", i);
  }
  return (0);
}
