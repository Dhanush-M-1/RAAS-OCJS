#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, k;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  if ((c1 + d1 - r2) % 2 == 1)
    printf("-1\n");
  else {
    k = (c1 + d1 - r2) / 2;
    if (k == (r1 - k) || k == (c1 - k) || k == (d1 - k) || r1 == c1 ||
        r1 == d1 || c1 == d1)
      printf("-1\n");
    else if (k <= 0 || k > 9 || (r1 - k) <= 0 || (r1 - k) > 9 ||
             (c1 - k) <= 0 || (c1 - k) > 9 || (d1 - k) <= 0 || (d1 - k) > 9)
      printf("-1\n");
    else {
      printf("%d ", k);
      printf("%d\n", r1 - k);
      printf("%d ", c1 - k);
      printf("%d\n", d1 - k);
    }
  }
  return 0;
}
