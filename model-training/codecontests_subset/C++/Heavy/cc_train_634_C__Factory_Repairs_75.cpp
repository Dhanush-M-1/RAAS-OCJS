#include <bits/stdc++.h>
int val[200100];
int ac[200100], bc[200100];
int sum(int *f, int x) {
  int r = 0;
  while (x) {
    r += f[x];
    x -= x & -x;
  }
  return r;
}
void upd(int *f, int x, int v) {
  while (x < 200100) {
    f[x] += v;
    x += x & -x;
  }
}
int main() {
  int n, k, a, b, q;
  int t, d, x;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d%d", &t, &d);
    if (t == 1) {
      scanf("%d", &x);
      int av = (val[d] + x > a ? a : val[d] + x) - (val[d] > a ? a : val[d]);
      int bv = (val[d] + x > b ? b : val[d] + x) - (val[d] > b ? b : val[d]);
      val[d] += x;
      upd(ac, d, av);
      upd(bc, d, bv);
    } else {
      printf("%d\n", sum(ac, n) - sum(ac, d + k - 1) + sum(bc, d - 1));
    }
  }
  return 0;
}
