#include <bits/stdc++.h>
int d, l, q, r;
int main() {
  scanf("%d", &q);
  while (q--) {
    scanf("%d%d%d", &l, &r, &d);
    printf("%d\n", l > d ? d : (r / d + 1) * d);
  }
}
