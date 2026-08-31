#include <bits/stdc++.h>
using namespace std;
const int MM = 1005;
const long long MOD = 1000000007;
int n, m;
int w[MM], b[MM];
int vis[MM], sta[MM];
int main() {
  int cnt = 1;
  scanf("%d%d", &n, &m);
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 1; i <= m; i++) scanf("%d", &b[i]);
  for (int i = 1; i <= m; i++) {
    if (vis[b[i]]) continue;
    vis[b[i]] = 1;
    sta[cnt++] = b[i];
  }
  for (int i = 1; i <= n; i++) {
    if (vis[i]) continue;
    sta[cnt++] = i;
  }
  int ans = 0;
  for (int i = 1; i <= m; i++) {
    int index = 1;
    for (int j = 1; j <= n; j++) {
      if (b[i] == sta[j]) {
        index = j;
        break;
      }
      ans += w[sta[j]];
    }
    for (int j = index - 1; j >= 1; j--) sta[j + 1] = sta[j];
    sta[1] = b[i];
  }
  printf("%d\n", ans);
  return 0;
}
