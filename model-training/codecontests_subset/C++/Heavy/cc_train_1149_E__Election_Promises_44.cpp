#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> E[N];
int n, m, h[N], deg[N], vis[N], sg[N], sum[N], sq[N], tt = 0;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> h[i];
  for (int i = 1, u, v; i <= m; i++) cin >> u >> v, ++deg[v], E[u].push_back(v);
  queue<int> q;
  for (int i = 1; i <= n; i++)
    if (!deg[i]) q.push(i);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    sq[++tt] = u;
    for (auto v : E[u])
      if (!--deg[v]) q.push(v);
  }
  for (int i = tt, u; i; i--) {
    u = sq[i];
    for (auto v : E[u]) vis[sg[v]] = u;
    for (int j = 0;; j++)
      if (vis[j] ^ u) {
        sum[sg[u] = j] ^= h[u];
        break;
      }
  }
  for (int i = n - 1; ~i; i--)
    if (sum[i]) {
      puts("WIN");
      for (int u = 1; u <= n; u++)
        if (sg[u] == i && (h[u] ^ sum[i]) < h[u]) {
          h[u] ^= sum[i];
          for (auto v : E[u]) h[v] ^= sum[sg[v]], sum[sg[v]] = 0;
          for (int v = 1; v <= n; v++) cout << h[v] << ' ';
          return 0;
        }
    }
  puts("LOSE");
  return 0;
}
