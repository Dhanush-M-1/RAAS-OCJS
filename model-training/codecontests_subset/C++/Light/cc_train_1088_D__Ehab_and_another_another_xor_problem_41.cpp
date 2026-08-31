#include <bits/stdc++.h>
int main() {
  int n, n1, n2;
  int i = 1 << 29;
  printf("? 0 0\n");
  fflush(stdout);
  scanf("%d", &n);
  int a = 0, b = 0;
  while (i) {
    printf("? %d %d\n", a + i, b);
    fflush(stdout);
    scanf("%d", &n1);
    printf("? %d %d\n", a, b + i);
    fflush(stdout);
    scanf("%d", &n2);
    if (n1 == -1 && n2 == 1) {
      a += i;
      b += i;
    } else if (n1 == n2) {
      if (n == 1) {
        a += i;
      } else {
        b += i;
      }
      n = n1;
    }
    i >>= 1;
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
