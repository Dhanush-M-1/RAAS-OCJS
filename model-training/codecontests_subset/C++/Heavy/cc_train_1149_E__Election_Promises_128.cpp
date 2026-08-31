#include <bits/stdc++.h>
using namespace std;
struct node {
  int to, nxt;
} edge[200100];
int val[200100], maxn, cnt, head[200100], n, m;
long long h[200100], X[710];
void addedge(int x, int y) {
  edge[++cnt].to = y;
  edge[cnt].nxt = head[x];
  head[x] = cnt;
}
void dfs(int x) {
  if (val[x] != -1) return;
  bool vis[710] = {0};
  for (int i = head[x]; i; i = edge[i].nxt) {
    int upup = edge[i].to;
    dfs(upup);
    vis[val[upup]] = 1;
  }
  for (int i = 0;; i++)
    if (!vis[i]) {
      val[x] = i;
      break;
    }
  maxn = max(maxn, val[x]);
  X[val[x]] ^= h[x];
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%lld", &h[i]);
  memset(val, -1, sizeof(val));
  for (int i = 1, x, y; i <= m; i++) {
    scanf("%d%d", &x, &y);
    addedge(x, y);
  }
  for (int i = 1; i <= n; i++) dfs(i);
  for (int i = maxn; i >= 0; i--)
    if (X[i]) {
      puts("WIN");
      for (int j = 1; j <= n; j++)
        if (val[j] == i && (h[j] ^ X[i]) < h[j]) {
          h[j] ^= X[i];
          X[i] = 0;
          for (int k = head[j]; k; k = edge[k].nxt) {
            int upup = edge[k].to;
            if (X[val[upup]]) {
              h[upup] = X[val[upup]] ^ h[upup];
              X[val[upup]] = 0;
            }
          }
          break;
        }
      for (int j = 1; j <= n; j++) printf("%lld ", h[j]);
      puts("");
      return 0;
    }
  puts("LOSE");
}
