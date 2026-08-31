#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5;
int n, m, h[maxn + 3], xo[maxn + 3], deg[maxn + 3], sg[maxn + 3], vis[maxn + 3],
    res[maxn + 3];
vector<int> G[maxn + 3], H[maxn + 3];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = (1); i <= int(n); i++) scanf("%d", &h[i]);
  for (int i = (1); i <= int(m); i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    G[u].push_back(v), H[v].push_back(u);
  }
  for (int i = (1); i <= int(n); i++) deg[i] = G[i].size();
  queue<int> Q;
  for (int i = (1); i <= int(n); i++)
    if (!deg[i]) Q.push(i);
  for (int k = (1); k <= int(n); k++) {
    int u = Q.front();
    Q.pop();
    for (int i = (0); i <= int(G[u].size() - 1); i++) {
      int v = G[u][i];
      vis[sg[v]] = k;
    }
    for (int i = (0); i <= int(n); i++)
      if (vis[i] != k) {
        sg[u] = i;
        break;
      }
    xo[sg[u]] ^= h[u];
    for (int i = (0); i <= int(H[u].size() - 1); i++) {
      int v = H[u][i];
      if (!--deg[v]) {
        Q.push(v);
      }
    }
  }
  bool flag = true;
  for (int i = (0); i <= int(n - 1); i++) flag &= xo[i] == 0;
  if (flag) {
    puts("LOSE");
  } else {
    puts("WIN");
    for (int i = (1); i <= int(n); i++) res[i] = h[i];
    int x = -1, y = -1;
    for (int i = (n - 1); i >= int(0); i--)
      if (xo[i]) {
        x = i;
        break;
      }
    for (int i = (1); i <= int(n); i++)
      if (sg[i] == x && (h[i] ^ xo[x]) < h[i]) {
        res[i] ^= xo[x], y = i;
        break;
      }
    for (int i = (0); i <= int(G[y].size() - 1); i++) {
      int v = G[y][i];
      if (sg[v] < x && xo[sg[v]]) {
        res[v] ^= xo[sg[v]], xo[sg[v]] = 0;
      }
    }
    for (int i = (1); i <= int(n); i++) printf("%d%c", res[i], " \n"[i == n]);
  }
  return 0;
}
