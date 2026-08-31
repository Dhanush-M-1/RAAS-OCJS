#include <bits/stdc++.h>
using namespace std;
const int __ = 1e5 + 5;
int a[__];
int main() {
  int q;
  for (scanf("%d", &q); q; --q) {
    int l, r, d;
    scanf("%d%d%d", &l, &r, &d);
    if (d < l || d > r) {
      printf("%d\n", d);
      continue;
    }
    printf("%d\n", (r / d + 1) * d);
  }
  return 0;
}
