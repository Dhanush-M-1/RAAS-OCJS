#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int n, m, h[N], q[N], d[N], s[N], vis[N], sg[N];
vector<int> G[N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
  for (int i = 1, x, y; i <= m; i++)
    scanf("%d%d", &x, &y), G[x].push_back(y), d[y]++;
  int qs = 1, qe = 1;
  for (int i = 1; i <= n; i++)
    if (!d[i]) q[qe++] = i;
  while (qs < qe) {
    int u = q[qs++];
    for (int i = 0; i < G[u].size(); i++)
      if (!--d[G[u][i]]) q[qe++] = G[u][i];
  }
  for (int i = n; i; i--) {
    int u = q[i];
    for (int j = 0; j < G[u].size(); j++) vis[sg[G[u][j]]] = i;
    while (vis[sg[u]] == i) sg[u]++;
    s[sg[u]] ^= h[u];
  }
  for (int i = n, u; ~i; i--)
    if (s[i]) {
      for (int j = 1; j <= n; j++)
        if (sg[j] == i && h[j] > (s[i] ^ h[j])) u = j;
      h[u] ^= s[i];
      for (int j = 0; j < G[u].size(); j++)
        h[G[u][j]] ^= s[sg[G[u][j]]], s[sg[G[u][j]]] = 0;
      puts("WIN");
      for (int j = 1; j <= n; j++) printf("%d ", h[j]);
      puts("");
      return 0;
    }
  puts("LOSE");
}
