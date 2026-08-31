#include <bits/stdc++.h>
using namespace std;
int n, d, x, ans;
int main() {
  scanf("%d%d", &n, &d);
  int vup = 0, vdn = 0;
  while (n--) {
    scanf("%d", &x);
    if (x) {
      vup += x;
      if (vup > d) vup = d;
      vdn += x;
    } else {
      vdn = max(vdn, 0);
      if (vdn > vup) ++ans, vup = d, vdn = 0;
    }
    if (vdn > vup) return puts("-1"), 0;
  }
  printf("%d", ans);
  return 0;
}
