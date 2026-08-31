#include <bits/stdc++.h>
int main() {
  int a, b, c, d, e, X;
  scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
  X = a + b + c + d + e;
  if (X > 0 && X % 5 == 0) {
    printf("%d", X / 5);
  } else {
    printf("-1");
  }
}
