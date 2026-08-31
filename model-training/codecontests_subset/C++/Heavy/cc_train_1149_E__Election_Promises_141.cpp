#include <bits/stdc++.h>
using namespace std;
int n, m, SG[200005], Mx, h[200005], sum[200005];
bool vis[200005];
int fir[200005], nxt[200005], to[200005], tot;
inline void line(int x, int y) {
  nxt[++tot] = fir[x];
  fir[x] = tot;
  to[tot] = y;
}
void dfs(int u) {
  for (int i = fir[u]; i; i = nxt[i])
    if (!SG[to[i]]) dfs(to[i]);
  for (int i = fir[u]; i; i = nxt[i]) vis[SG[to[i]]] = 1;
  int x = 1;
  while (vis[x] == 1) x++;
  Mx = max(Mx, SG[u] = x), sum[x] ^= h[u];
  for (int i = fir[u]; i; i = nxt[i]) vis[SG[to[i]]] = 0;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
  for (int i = 1, x, y; i <= m; i++) scanf("%d%d", &x, &y), line(x, y);
  for (int i = 1; i <= n; i++)
    if (!SG[i]) dfs(i);
  for (int k = Mx, id = 0; k >= 1; k--)
    if (sum[k]) {
      for (int i = 1; i <= n; i++)
        if (SG[i] == k && (h[i] ^ sum[k]) < h[i]) id = i;
      h[id] ^= sum[k];
      for (int i = fir[id]; i; i = nxt[i])
        if (!vis[SG[to[i]]]) h[to[i]] ^= sum[SG[to[i]]], vis[SG[to[i]]] = 1;
      puts("WIN");
      for (int i = 1; i <= n; i++) printf("%d%c", h[i], i == n ? 10 : 32);
      return 0;
    }
  puts("LOSE");
}
