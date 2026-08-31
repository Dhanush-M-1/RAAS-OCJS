#include <bits/stdc++.h>
using namespace std;
const int maxn = 200005, maxm = 200005;
int n, m, e, stp;
int h[maxn], SG[maxn], start[maxn], to[maxm], then[maxm], xorsum[maxn],
    deg[maxn], vis[maxn];
vector<int> v[maxn], revg[maxn], g[maxn];
queue<int> q;
inline void add(int x, int y) {
  g[x].push_back(y), deg[x]++;
  revg[y].push_back(x);
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    add(x, y);
  }
  for (int i = 1; i <= n; i++)
    if (deg[i] == 0) q.push(i);
  while (!q.empty()) {
    int x = q.front();
    q.pop(), stp++;
    for (int i = 0; i < revg[x].size(); i++) {
      int y = revg[x][i];
      deg[y]--;
      if (deg[y] == 0) q.push(y);
    }
    for (int i = 0; i < g[x].size(); i++) vis[SG[g[x][i]]] = stp;
    while (vis[SG[x]] == stp) SG[x]++;
    xorsum[SG[x]] ^= h[x], v[SG[x]].push_back(x);
  }
  for (int i = n; i >= 0; i--) {
    if (xorsum[i] == 0) continue;
    puts("WIN");
    int x;
    for (int j = 0; j < v[i].size(); j++)
      if ((h[v[i][j]] ^ xorsum[i]) < h[v[i][j]]) {
        x = v[i][j];
        break;
      }
    h[x] ^= xorsum[SG[x]], xorsum[SG[x]] = 0;
    for (int j = 0; j < g[x].size(); j++) {
      int y = g[x][j];
      h[y] ^= xorsum[SG[y]], xorsum[SG[y]] = 0;
    }
    for (int j = 1; j <= n; j++) printf("%d%c", h[j], i == n ? '\n' : ' ');
    return 0;
  }
  puts("LOSE");
  return 0;
}
