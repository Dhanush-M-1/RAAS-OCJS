#include <bits/stdc++.h>
int main() {
  int a, b, c;
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d", &a, &b, &c);
    if (a > c)
      printf("%d\n", c);
    else {
      printf("%d\n", ((b / c) + 1) * c);
    }
  }
}
