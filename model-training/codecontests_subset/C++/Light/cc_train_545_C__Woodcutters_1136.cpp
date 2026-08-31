#include <bits/stdc++.h>
struct P {
  int x, h;
} a[100010];
bool vis[100010];
int main() {
  int n, ans = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", &a[i].x, &a[i].h);
  a[0].x = -1000000007;
  a[0].h = 0;
  a[n + 1].x = 1000000007 * 2;
  a[n + 1].h = 0;
  memset(vis, true, sizeof(vis));
  for (int i = 0; i <= n; i++) {
    int j = i + 1;
    if (i != 0 && vis[i] && ((a[i].x + a[i].h) < a[j].x)) {
      ans++;
      a[i].x += a[i].h;
      vis[i] = false;
    }
    if (j != n + 1 && vis[j] && ((a[j].x - a[j].h) > a[i].x)) {
      ans++;
      vis[j] = false;
    }
  }
  printf("%d", ans);
  return 0;
}
