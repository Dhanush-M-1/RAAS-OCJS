#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0;
  scanf("%d%d%d%d", &n, &a, &b, &c);
  for (int i = 0; i <= a && i / 2 < n; i += 2) {
    int nn = n - i / 2, miny, maxy;
    if ((nn & 1) && !b) continue;
    maxy = min(c, nn >> 1);
    if (nn & 1) {
      int bb = b - 1;
      --nn;
      miny = max(0, nn - bb >> 1);
      if (nn - bb > 0 && (nn - bb) & 1) ++miny;
      if (miny <= maxy) ans += (maxy - miny + 1);
    } else {
      miny = max(0, nn - b >> 1);
      if (nn - b > 0 && (nn - b) & 1) ++miny;
      if (miny <= maxy) ans += (maxy - miny + 1);
    }
  }
  if (a / 2 >= n) ++ans;
  printf("%d\n", ans);
  return 0;
}
