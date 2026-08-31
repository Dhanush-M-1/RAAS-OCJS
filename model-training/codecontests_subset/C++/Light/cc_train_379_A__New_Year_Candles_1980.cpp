#include <bits/stdc++.h>
int main() {
  int a;
  int b;
  scanf("%d", &a);
  scanf("%d", &b);
  int x = a;
  int r;
  do {
    if ((a % b) == 0) {
      a = a / b;
      x = x + a;
    } else {
      r = a % b;
      a = a - r;
      a = a / b;
      x = x + a;
      a = a + r;
    }
    if (a < b) {
      a = 0;
    }
  } while (a != 0);
  printf("%d", x);
}
