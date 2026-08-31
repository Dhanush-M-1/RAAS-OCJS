#include <bits/stdc++.h>
int a, b, s = 0;
int main() {
  scanf("%d %d", &a, &b);
  if (a - b < 0)
    printf("%d", a);
  else {
    while (a - b >= 0) {
      s = s + b;
      a = a - b + 1;
    }
    if (a == 1)
      printf("%d", s + 1);
    else
      printf("%d", s + a);
  }
}
