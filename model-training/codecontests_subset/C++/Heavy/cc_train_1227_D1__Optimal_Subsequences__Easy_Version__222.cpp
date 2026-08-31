#include <bits/stdc++.h>
using namespace std;
constexpr int maxn = 105, inf = 0x3f3f3f3f;
int n;
int a[maxn], vis[maxn], b[maxn];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  int m;
  cin >> m;
  for (int i = 1; i <= m; i++) {
    int k, pos;
    cin >> k >> pos;
    int cnt = 0;
    memset(vis, 0, sizeof vis);
    for (int j = 1; j <= k; j++) {
      int res = 0;
      for (int d = 1; d <= n; d++) {
        if (vis[d]) continue;
        res = max(res, a[d]);
      }
      for (int d = 1; d <= n; d++) {
        if (res == a[d] && !vis[d]) {
          vis[d] = 1;
          b[++cnt] = d;
          break;
        }
      }
    }
    sort(b + 1, b + 1 + cnt);
    printf("%d\n", a[b[pos]]);
  }
}
