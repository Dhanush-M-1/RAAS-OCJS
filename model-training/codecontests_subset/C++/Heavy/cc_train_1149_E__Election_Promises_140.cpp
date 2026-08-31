#include <bits/stdc++.h>
using namespace std;
const int NN = 200011;
vector<int> adj[NN];
int n, m;
int h[NN];
int xo[NN];
int g[NN];
int ans[NN];
int vst[NN];
int runs = 1;
int calc(int u) {
  if (~g[u]) return g[u];
  for (int v : adj[u]) calc(v);
  runs++;
  for (int v : adj[u]) vst[g[v]] = runs;
  for (int i = 0;; i++)
    if (vst[i] ^ runs) return g[u] = i;
}
int solve() {
  memset(g, -1, sizeof g);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) scanf("%d", h + i), ans[i] = h[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    adj[u].push_back(v);
  }
  for (int i = 1; i <= n; i++) xo[calc(i)] ^= h[i];
  int id = -1;
  for (int i = 0; i <= n; i++)
    if (xo[i]) id = i;
  if (id == -1) return puts("LOSE");
  puts("WIN");
  int now = -1;
  for (int i = 1; i <= n; i++)
    if (g[i] == id) {
      int u = xo[id] ^ h[i];
      if (u < h[i]) {
        ans[i] = u;
        now = i;
        break;
      }
    }
  assert(now != -1);
  for (int u : adj[now]) ans[u] = xo[g[u]] ^ h[u], xo[g[u]] = 0;
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
}
int main() {
  solve();
  return 0;
}
