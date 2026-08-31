#include <bits/stdc++.h>
using namespace std;
const int maxn = 200010;
struct edge {
  int to, nxt;
};
edge G[maxn];
int head[maxn], cnt;
int h[maxn], deg[maxn];
queue<int> Q;
int a[maxn];
bool vis[maxn];
int bel[maxn];
int nim[maxn];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", h + i);
  int u, v;
  while (m--) {
    scanf("%d %d", &u, &v);
    G[++cnt] = {v, head[u]}, head[u] = cnt;
    deg[v]++;
  }
  for (int i = 1; i <= n; i++)
    if (!deg[i]) Q.push(i);
  int c = 0;
  while (!Q.empty()) {
    u = Q.front(), Q.pop();
    a[c++] = u;
    for (int i = head[u]; i; i = G[i].nxt)
      if (!(--deg[G[i].to])) Q.push(G[i].to);
  }
  int val = 0;
  while (c--) {
    for (int i = head[a[c]]; i; i = G[i].nxt) vis[bel[G[i].to]] = true;
    while (vis[bel[a[c]]]) bel[a[c]]++;
    if (bel[a[c]] > val) val = bel[a[c]];
    for (int i = head[a[c]]; i; i = G[i].nxt) vis[bel[G[i].to]] = false;
  }
  for (int i = 1; i <= n; i++) nim[bel[i]] ^= h[i];
  int p = -1;
  for (int i = val; i >= 0; i--)
    if (nim[i]) {
      p = i;
      break;
    }
  if (p == -1) {
    printf("LOSE\n");
    return 0;
  }
  for (int i = 1; i <= n; i++)
    if (bel[i] == p && (nim[bel[i]] ^ h[i]) <= h[i]) {
      h[i] ^= nim[bel[i]], vis[bel[i]] = true;
      for (int j = head[i]; j; j = G[j].nxt)
        if (!vis[bel[G[j].to]])
          h[G[j].to] ^= nim[bel[G[j].to]], vis[bel[G[j].to]] = true;
      break;
    }
  printf("WIN\n");
  for (int i = 1; i <= n; i++) printf("%d ", h[i]);
  printf("\n");
  return 0;
}
