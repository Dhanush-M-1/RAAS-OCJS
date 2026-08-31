#include <bits/stdc++.h>
using namespace std;
int w[505], b[1005];
bool vis[505];
int main() {
  int n, m, ans = 0;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 1; i <= m; i++) scanf("%d", &b[i]);
  for (int i = 2; i <= m; i++) {
    memset(vis, false, sizeof(vis));
    for (int j = i - 1; j > 0; j--) {
      if (b[j] == b[i]) break;
      if (!vis[b[j]]) {
        ans += w[b[j]];
        vis[b[j]] = true;
      }
    }
  }
  printf("%d\n", ans);
}
