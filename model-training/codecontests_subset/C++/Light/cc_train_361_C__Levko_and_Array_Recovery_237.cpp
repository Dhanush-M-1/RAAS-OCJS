#include <bits/stdc++.h>
using namespace std;
const int inf = 1000000000;
const int maxn = 10000;
struct point {
  int t, l, r, d;
};
int n, m, b[maxn], ok, mx;
point a[maxn];
pair<int, int> ans[maxn];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= m; i++) cin >> a[i].t >> a[i].l >> a[i].r >> a[i].d;
  for (int i = 1; i <= n; i++) ans[i].first = inf, ans[i].second = false;
  for (int i = m; i >= 1; i--) {
    if (a[i].t == 2)
      for (int j = a[i].l; j <= a[i].r; j++) {
        ans[j].first = min(ans[j].first, a[i].d);
        ans[j].second = true;
      }
    else
      for (int j = a[i].l; j <= a[i].r; j++) {
        ans[j].first -= a[i].d;
        if (ans[j].second == false) ans[j].first = min(ans[j].first, inf);
      }
  }
  for (int i = 1; i <= n; i++) b[i] = ans[i].first;
  ok = true;
  for (int i = 1; i <= m; i++) {
    if (a[i].t == 2) {
      mx = -inf;
      for (int j = a[i].l; j <= a[i].r; j++) mx = max(mx, b[j]);
      if (mx != a[i].d) ok = false;
    } else {
      for (int j = a[i].l; j <= a[i].r; j++) b[j] += a[i].d;
    }
  }
  if (ok) {
    puts("YES");
    for (int i = 1; i <= n; i++) cout << ans[i].first << ' ';
  } else {
    puts("NO");
  }
  return 0;
}
