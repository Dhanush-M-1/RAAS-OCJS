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
    else {
      int acima = r + (d - (r % d));
      printf("%d\n", acima);
    }
  }
  return 0;
}
