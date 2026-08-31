#include <bits/stdc++.h>
using namespace std;
int n, m, h[200012], cnt = 0, a[200012], f[200012], b[200012], c[200012];
bool vis[200012];
struct Edge {
  int to, next;
} e[200012];
inline void AddEdge(int x, int y) {
  e[++cnt] = (Edge){y, h[x]};
  h[x] = cnt;
}
void dfs(int x) {
  if (vis[x]) return;
  vis[x] = 1;
  int i;
  for (i = h[x]; i; i = e[i].next) dfs(e[i].to);
  for (i = h[x]; i; i = e[i].next) b[f[e[i].to]] = x;
  for (f[x] = 0; b[f[x]] == x; ++f[x])
    ;
}
int main() {
  scanf("%d%d", &n, &m);
  int i, x, y, p, o = 0;
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (i = 1; i <= m; i++) {
    scanf("%d%d", &x, &y);
    AddEdge(x, y);
  }
  for (i = 1; i <= n; i++) dfs(i), c[f[i]] ^= a[i];
  for (i = n; i >= 0; i--)
    if (c[i]) break;
  p = i;
  if (p == (-1)) {
    printf("LOSE");
    return 0;
  }
  printf("WIN\n");
  for (x = 1; x <= n; x++)
    if ((f[x] == p) && ((a[x] ^ c[p]) < a[x])) a[x] ^= c[p], c[p] = 0, o = x;
  for (i = h[o]; i; i = e[i].next)
    if (f[y = e[i].to] < p) a[y] ^= c[f[y]], c[f[y]] = 0;
  for (x = 1; x <= n; x++) printf("%d ", a[x]);
  return 0;
}
