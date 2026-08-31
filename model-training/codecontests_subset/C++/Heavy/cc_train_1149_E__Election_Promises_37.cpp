#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int n, m;
int h[maxn], in[maxn], q[maxn], sg[maxn], sum[maxn], vis[maxn];
vector<int> G[maxn];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) scanf("%d", &h[i]);
  for (int i = 1; i <= m; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    G[u].push_back(v);
    ++in[v];
  }
  int l = 1, r = 0;
  for (int i = 1; i <= n; ++i)
    if (!in[i]) q[++r] = i;
  while (l <= r) {
    int u = q[l++];
    for (int i = 0; i < G[u].size(); ++i) {
      int v = G[u][i];
      if (!--in[v]) q[++r] = v;
    }
  }
  for (int i = n; i; --i) {
    int u = q[i];
    for (int j = 0; j < G[u].size(); ++j) {
      int v = G[u][j];
      vis[sg[v]] = 1;
    }
    for (; vis[sg[u]]; ++sg[u])
      ;
    for (int j = 0; j < G[u].size(); ++j) {
      int v = G[u][j];
      vis[sg[v]] = 0;
    }
  }
  for (int i = 1; i <= n; ++i) sum[sg[i]] ^= h[i];
  int p = -1;
  for (int i = n; ~i; --i)
    if (sum[i]) {
      p = i;
      break;
    }
  if (p == -1) {
    puts("LOSE");
    return 0;
  }
  puts("WIN");
  for (int i = 1; i <= n; ++i)
    if (sg[i] == p) {
      if ((sum[p] ^ h[i]) > h[i]) continue;
      h[i] ^= sum[p];
      for (int j = 0; j < G[i].size(); ++j) {
        int v = G[i][j];
        h[v] ^= sum[sg[v]];
        sum[sg[v]] = 0;
      }
      break;
    }
  for (int i = 1; i <= n; ++i) printf("%d ", h[i]);
  return 0;
}
