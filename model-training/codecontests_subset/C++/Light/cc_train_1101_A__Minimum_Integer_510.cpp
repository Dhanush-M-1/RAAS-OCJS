#include <bits/stdc++.h>
using namespace std;
int l, r, d;
int n, q;
int main() {
  scanf("%d", &q);
  while (q--) {
    scanf("%d%d%d", &l, &r, &d);
    if (d < l)
      printf("%d\n", d);
    else {
      bool flag = false;
      for (int i = r + 1; i <= r + 10000; ++i) {
        if (i % d == 0) {
          printf("%d\n", i);
          flag = true;
          break;
        }
      }
      if (!flag) {
        for (int i = d;; i += d) {
          if (i > r && i % d == 0) {
            printf("%d\n", i);
            break;
          }
        }
      }
    }
  }
  return 0;
}
