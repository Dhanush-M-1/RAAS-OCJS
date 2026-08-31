#include <bits/stdc++.h>
int main() {
  int t, l, r, d, m, n, i;
  scanf("%d", &t);
  for (i = 0; i < t; i++) {
    scanf("%d %d %d", &l, &r, &d);
    if (l > d || r < d) {
      printf("%d\n", d);
    } else {
      m = (r / d) + 1;
      n = d * m;
      printf("%d\n", n);
    }
  }
  return 0;
}
