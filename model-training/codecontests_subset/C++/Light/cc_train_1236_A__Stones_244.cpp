#include <bits/stdc++.h>
int main() {
  long long int N, M, e, i, j, k, a, b, c, d, f, x, y, z, m, n, p, s, T;
  scanf("%lld", &N);
  for (i = 0; i < N; i++) {
    scanf("%lld %lld %lld", &a, &b, &c);
    s = 0;
    if ((b / 2) < a) {
      x = (b / 2) * 3;
    } else {
      x = a * 3;
    }
    if ((c / 2) < b) {
      y = (c / 2) * 3;
    } else {
      y = b * 3;
    }
    s = s + y;
    c = c - ((y / 3) * 2);
    b = b - (y / 3);
    if ((b / 2) < a) {
      d = (b / 2) * 3;
    } else {
      d = a * 3;
    }
    s += d;
    printf("%lld\n", s);
  }
  return 0;
}
