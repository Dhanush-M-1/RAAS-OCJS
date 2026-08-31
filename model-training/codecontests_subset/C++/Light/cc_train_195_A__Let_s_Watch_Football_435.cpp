#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-7;
int main() {
  int a, b, c, i, j, k, l, t, data, rdata, v;
  scanf("%d%d%d", &a, &b, &c);
  t = a * c;
  k = 1;
  while (k) {
    data = b * k;
    v = 0;
    for (i = 1; i <= c; i++) {
      data += b;
      if (data < a) break;
      data -= a;
      v += a;
    }
    if (v >= t) break;
    k++;
  }
  printf("%d\n", k);
  return 0;
}
