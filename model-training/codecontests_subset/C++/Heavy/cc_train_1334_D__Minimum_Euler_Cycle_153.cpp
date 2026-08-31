#include <bits/stdc++.h>
using namespace std;
int cas, z, x, w, h, a[500000];
long long n, m;
int main() {
  scanf("%d", &cas);
  while (cas--) {
    scanf("%d%lld%lld", &z, &n, &m);
    x = 1;
    while (n > (z - x) * 2) {
      if (x == z) {
        m = 0;
        printf("1");
        break;
      }
      n -= (z - x) * 2;
      m -= (z - x) * 2;
      x++;
    }
    for (int i = 1; i <= z - x; i++) a[i * 2 - 1] = x, a[i * 2] = x + i;
    if (m <= (z - x) * 2) {
      for (int i = n; i <= m; i++) printf("%d ", a[i]);
    } else {
      for (int i = n; i <= (z - x) * 2; i++) printf("%d ", a[i]);
      m -= (z - x) * 2;
      x++;
      while (m && (z != x)) {
        for (int i = 1; i <= z - x; i++) a[i * 2 - 1] = x, a[i * 2] = x + i;
        if (m <= (z - x) * 2) {
          for (int i = 1; i <= m; i++) printf("%d ", a[i]);
          m = 0;
        } else {
          for (int i = 1; i <= (z - x) * 2; i++) printf("%d ", a[i]);
          m -= (z - x) * 2;
          x++;
        }
      }
      if (m) printf("1");
    }
    printf("\n");
  }
  return 0;
}
