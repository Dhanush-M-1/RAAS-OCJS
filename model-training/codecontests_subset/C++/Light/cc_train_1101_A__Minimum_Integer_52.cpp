#include <bits/stdc++.h>
int q, l, r, d;
int main() {
  scanf("%d", &q);
  while (q--) {
    scanf("%d%d%d", &l, &r, &d);
    if (l > d)
      printf("%d\n", d);
    else
      printf("%d\n", r / d * d + d);
  }
}
