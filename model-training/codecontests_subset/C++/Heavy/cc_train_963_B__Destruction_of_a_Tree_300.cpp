#include <bits/stdc++.h>
const int maxn = 1e6 + 7;
int n, size[maxn], vis[maxn];
std::vector<int> ch[maxn];
void dfs1(int u, int f) {
  size[u] = 1;
  for (int v : ch[u])
    if (v != f) {
      dfs1(v, u);
      size[u] += size[v];
    }
}
void dfs(int u, int f, int dx) {
  int d = dx;
  for (int v : ch[u])
    if (v != f) d++;
  for (int v : ch[u]) {
    if (v != f && size[v] % 2 == 0) {
      dfs(v, u, 1);
      d--;
    }
  }
  if (d % 2 == 0) {
    printf("%d\n", u);
    vis[u] = 1;
    for (int v : ch[u])
      if (v != f && !vis[v]) dfs(v, u, 0);
  } else {
    int t = 0;
    for (int v : ch[u]) {
      if (v == f || vis[v]) continue;
      if (size[v] % 2 == 0) t = v;
    }
    assert(t);
    dfs(t, u, 1);
    printf("%d\n", u);
    vis[u] = 1;
    for (int v : ch[u])
      if (v != f && v != t && (!vis[v])) dfs(v, u, 0);
  }
}
int main() {
  scanf("%d", &n);
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    if (!x) continue;
    ch[i].push_back(x);
    ch[x].push_back(i);
  }
  puts("YES");
  dfs1(1, 0);
  dfs(1, 0, 0);
  return 0;
}
