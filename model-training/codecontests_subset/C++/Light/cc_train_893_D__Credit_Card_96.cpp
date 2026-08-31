#include <bits/stdc++.h>
using namespace std;
int n, d;
int x;
int mi = 0, mx = 0;
int ans;
int main() {
  scanf("%d%d", &n, &d);
  for (int i(1); i <= (n); ++i) {
    scanf("%d", &x);
    if (x) {
      mi += x, mx += x;
      if (mi > d) return 0 * puts("-1");
      mx = min(mx, d);
    } else {
      if (mx >= 0)
        mi = max(mi, 0);
      else
        ++ans, mx = d, mi = 0;
    }
  }
  printf("%d\n", ans);
  return 0;
}
