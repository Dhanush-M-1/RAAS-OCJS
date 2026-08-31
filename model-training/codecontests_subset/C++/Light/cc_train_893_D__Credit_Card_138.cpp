#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, d;
  scanf("%d%d", &n, &d);
  int mn = 0, mx = 0;
  int ans = 0;
  for (int i = 1, x; i <= n; ++i) {
    scanf("%d", &x);
    if (x) {
      mn += x, mx += x;
      if (mn > d) return puts("-1"), 0;
      mx = min(mx, d);
    } else {
      if (mx >= 0)
        mn = max(mn, 0);
      else
        ++ans, mn = 0, mx = d;
    }
  }
  printf("%d\n", ans);
}
