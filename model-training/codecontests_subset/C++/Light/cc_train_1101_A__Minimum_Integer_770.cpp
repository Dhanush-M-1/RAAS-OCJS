#include <bits/stdc++.h>
int main(void) {
  int q;
  scanf("%d", &q);
  while (q--) {
    int l, r, d;
    scanf("%d %d %d", &l, &r, &d);
    if (d < l) {
      printf("%d\n", d);
      continue;
    }
    printf("%d\n", ((r / d) + 1) * d);
  }
}
