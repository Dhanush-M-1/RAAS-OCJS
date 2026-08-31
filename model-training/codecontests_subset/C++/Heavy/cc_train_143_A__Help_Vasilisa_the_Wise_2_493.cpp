#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[10];
  for (int i = 0; i < 6; i++) scanf("%d", &a[i]);
  bool f = 0;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      if (j == i) continue;
      for (int k = 1; k <= 9; k++) {
        if (k == i || k == j) continue;
        for (int m = 1; m <= 9; m++) {
          if (m == i || m == j || m == k) continue;
          if ((i + j == a[0]) && (k + m == a[1]) && (i + k == a[2]) &&
              (j + m == a[3]) && (i + m == a[4]) && (j + k == a[5])) {
            f = 1;
            printf("%d %d\n%d %d\n", i, j, k, m);
            break;
          }
        }
      }
    }
  }
  if (!f) printf("-1\n");
}
