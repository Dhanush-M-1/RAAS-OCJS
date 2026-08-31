#include <bits/stdc++.h>
using namespace std;
const int MN = 1010;
int vis[MN];
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    memset(vis, 0, sizeof(vis));
    int n, m, fg = -1;
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) {
      int t;
      scanf("%d", &t);
      if (!vis[t]) vis[t]++;
    }
    for (int i = 0; i < m; ++i) {
      int t;
      scanf("%d", &t);
      if (vis[t] == 1) {
        fg = t;
        vis[t]++;
      }
    }
    if (fg == -1)
      printf("NO\n");
    else
      printf("YES\n1 %d\n", fg);
  }
  return 0;
}
