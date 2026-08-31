#include <bits/stdc++.h>
int main() {
  int q;
  scanf("%d", &q);
  while (q--) {
    int l, r, d;
    scanf("%d %d %d", &l, &r, &d);
    int rem2 = r % d;
    if (d < l) {
      printf("%d\n", d);
    } else {
      int r1 = r + (d - rem2);
      printf("%d\n", r1);
    }
  }
  return 0;
}
