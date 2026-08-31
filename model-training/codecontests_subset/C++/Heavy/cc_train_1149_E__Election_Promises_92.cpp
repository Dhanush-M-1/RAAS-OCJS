#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
struct edge {
  int to, nxt;
} e[N];
vector<int> G[N];
int deg[N], n, head[N], cnt, m, h[N], mex[N], X[N];
bool vis[N];
queue<int> q;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) scanf("%d", h + i);
  while (m--) {
    int u, v;
    scanf("%d%d", &u, &v);
    e[++cnt] = (edge){v, head[u]}, head[u] = cnt, ++deg[u];
    G[v].push_back(u);
  }
  for (int i = 1; i <= n; ++i)
    if (deg[i] == 0) q.push(i);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int i = head[u]; i; i = e[i].nxt) vis[mex[e[i].to]] = 1;
    while (vis[mex[u]]) ++mex[u];
    for (int i = head[u]; i; i = e[i].nxt) vis[mex[e[i].to]] = 0;
    for (int to : G[u])
      if (!--deg[to]) q.push(to);
  }
  for (int i = 1; i <= n; ++i) X[mex[i]] ^= h[i];
  for (int i = n; ~i; --i)
    if (X[i]) {
      puts("WIN");
      for (int j = 1; j <= n; ++j)
        if (mex[j] == i && (h[j] ^ X[i]) < h[j]) {
          h[j] ^= X[i], X[i] = 0;
          for (int k = head[j]; k; k = e[k].nxt) {
            int to = e[k].to;
            h[to] ^= X[mex[to]], X[mex[to]] = 0;
          }
        }
      for (int i = 1; i <= n; ++i) printf("%d ", h[i]);
      return 0;
    }
  puts("LOSE");
  return 0;
}
