#include <bits/stdc++.h>
using namespace std;
int t, a, b, c, ans;
int main() {
  scanf("%d", &t);
  while (t--) {
    ans = 0;
    scanf("%d%d%d", &a, &b, &c);
    c /= 2;
    if (b >= c) {
      ans += c * 3;
      b -= c;
      b /= 2;
      if (a >= b)
        ans += b * 3;
      else
        ans += a * 3;
    } else
      ans += b * 3;
    printf("%d\n", ans);
  }
  return 0;
}
