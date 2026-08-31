#include <bits/stdc++.h>
int main() {
  int l, r, d, t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d %d %d", &l, &r, &d);
    if (l != d && l / d >= 1)
      printf("%d\n", d);
    else
      printf("%d\n", ((r / d) + 1) * d);
  }
}
