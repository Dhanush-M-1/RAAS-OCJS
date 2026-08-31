#include <bits/stdc++.h>
using namespace std;
int vis[120];
int main() {
  int tmp, n, m;
  int ans = 0;
  scanf("%d%d", &n, &m);
  memset(vis, 0, sizeof vis);
  for (int i = 0; i < n; i++) {
    int num;
    scanf("%d", &num);
    for (int j = 0; j < num; j++) {
      scanf("%d", &tmp);
      if (!vis[tmp]) {
        vis[tmp] = 1;
        ans++;
      }
    }
  }
  if (m - ans)
    puts("NO");
  else
    puts("YES");
  return 0;
}
