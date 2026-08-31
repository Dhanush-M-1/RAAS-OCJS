#include <bits/stdc++.h>
const int N = 110;
int main() {
  int n;
  while (~scanf("%d", &n)) {
    int ans = 0, x;
    while (n--) {
      scanf("%d", &x);
      if (x <= 500000 && x - 1 > ans)
        ans = x - 1;
      else if (x > 500000 && 1000000 - x > ans)
        ans = 1000000 - x;
    }
    printf("%d\n", ans);
  }
}
