#include <bits/stdc++.h>
using namespace std;
int t;
int main() {
  scanf("%d", &t);
  while (t--) {
    int a, b, c, ans = 0;
    scanf("%d%d%d", &a, &b, &c);
    for (int i = 0; i <= a; i++)
      if (b >= i * 2) {
        int cur = i * 3;
        int lb = b - i * 2;
        cur += min(lb, c / 2) * 3;
        ans = max(ans, cur);
      }
    printf("%d\n", ans);
  }
  return 0;
}
