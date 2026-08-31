#include <bits/stdc++.h>
int main() {
  int l, r, d;
  int x;
  int q;
  scanf("%d", &q);
  while (q--) {
    scanf("%d %d %d", &l, &r, &d);
    if (d < l)
      printf("%d\n", d);
    else {
      printf("%d\n", ((r / d) * d + d));
    }
  }
}
