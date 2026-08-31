#include <bits/stdc++.h>
using namespace std;
int t, x, y, z, ans;
int main() {
  scanf("%d", &t);
  while (t--) {
    ans = 0;
    scanf("%d%d%d", &x, &y, &z);
    if (y >= 1 && z >= 2) {
      ans += min(z / 2, y) * 3;
      y = max(y - z / 2, 0);
    }
    if (x >= 1 && y >= 2) {
      ans += min(y / 2, x) * 3;
    }
    printf("%d\n", ans);
  }
  return 0;
}
