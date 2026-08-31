#include <bits/stdc++.h>
using namespace std;
int k = 29, x1, x2, x3, t;
int ans1, ans2;
int main() {
  bool ok = false;
  while (k >= 0) {
    if (!ok) {
      printf("? %d %d\n", 0 + ans1, 0 + ans2);
      fflush(stdout);
      scanf("%d", &x1);
      ok = 1;
    }
    printf("? %d %d\n", (1 << k) + ans1, (1 << k) + ans2);
    fflush(stdout);
    scanf("%d", &x2);
    if (x1 == x2) {
      if (x1 == 1) {
        printf("? %d %d\n", 0 + ans1, (1 << k) + ans2);
        fflush(stdout);
        scanf("%d", &x3);
      } else {
        printf("? %d %d\n", ans1 + (1 << k), ans2 + 0);
        fflush(stdout);
        scanf("%d", &x3);
      }
      if (x1 == 0) {
        if (x3 == 1)
          ;
        else
          ans1 |= (1 << k), ans2 |= (1 << k);
        t = x1;
      } else {
        if (x3 != x2)
          ;
        else
          ans1 |= (1 << k), ans2 |= (1 << k);
        t = x1;
      }
    } else {
      if (x1 == -1 && x2 == 1) {
        printf("? %d %d\n", 0 + ans1, (1 << k) + ans2);
        ans2 |= (1 << k);
        fflush(stdout);
        scanf("%d", &x3);
        t = x3;
      } else {
        printf("? %d %d\n", (1 << k) + ans1, 0 + ans2);
        ans1 |= (1 << k);
        fflush(stdout);
        scanf("%d", &x3);
        t = x3;
      }
    }
    k--;
    x1 = t;
  }
  printf("! %d %d\n", ans1, ans2);
  fflush(stdout);
  return 0;
}
