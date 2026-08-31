#include <bits/stdc++.h>
using namespace std;
const int maxn = 200050;
struct Edge {
  int v, nxt;
} e[maxn * 2];
int h[maxn], tot;
void addEdge(int x, int y) {
  e[++tot] = (Edge){y, h[x]};
  h[x] = tot;
}
int n, deg[maxn];
bool vis[maxn];
int ans[maxn], c;
void del(int x, int x_fa) {
  if (vis[x]) return;
  vis[x] = true;
  ans[c++] = x;
  for (int i = h[x]; i; i = e[i].nxt) {
    deg[e[i].v]--;
  }
  for (int i = h[x]; i; i = e[i].nxt) {
    if (e[i].v != x_fa && !vis[e[i].v]) {
      del(e[i].v, x);
    }
  }
}
void dfs(int x, int x_fa) {
  for (int i = h[x]; i; i = e[i].nxt) {
    if (e[i].v == x_fa) continue;
    dfs(e[i].v, x);
  }
  if (deg[x] % 2 == 0) del(x, x_fa);
}
int main(int argc, char const *argv[]) {
  scanf("%d", &n);
  int root = 0;
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    if (x) {
      addEdge(x, i);
      addEdge(i, x);
      deg[x]++;
      deg[i]++;
    } else
      root = i;
  }
  dfs(root, 0);
  if (c < n) {
    printf("NO\n");
    return 0;
  }
  printf("YES\n");
  for (int i = 0; i < n; ++i) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
