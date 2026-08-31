#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  scanf("%d", &q);
  while (q--) {
    int l, r, d;
    scanf("%d %d %d", &l, &r, &d);
    if (d < l)
      printf("%d\n", d);
    else if (d > r)
      printf("%d\n", d);
    else {
      int res = r - d;
      res = res % d;
      printf("%d\n", r + d - res);
    }
  }
}
