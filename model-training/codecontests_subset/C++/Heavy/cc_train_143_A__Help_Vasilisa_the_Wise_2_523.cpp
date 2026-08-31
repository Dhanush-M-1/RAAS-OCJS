#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d %d", &r1, &r2);
  scanf("%d %d", &c1, &c2);
  scanf("%d %d", &d1, &d2);
  int a1 = -1;
  int a2 = -1;
  int a3 = -1;
  int a4 = -1;
  for (int i = 1; i <= 9; i++) {
    for (int y = 1; y <= 9; y++) {
      for (int l = 1; l <= 9; l++) {
        for (int p = 1; p <= 9; p++) {
          if (i != y && i != l && i != p && y != l && y != p && l != p) {
            if (i + y == r1) {
              if (l + p == r2) {
                if (i + l == c1) {
                  if (y + p == c2) {
                    if (i + p == d1) {
                      if (y + l == d2) {
                        a1 = i;
                        a2 = y;
                        a3 = l;
                        a4 = p;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  if (a1 != -1) {
    printf("%d %d\n", a1, a2);
    printf("%d %d\n", a3, a4);
  } else {
    printf("-1\n");
  }
}
