#include <bits/stdc++.h>
int main() {
  long long q, p, s = 1, i;
  scanf("%I64d", &q);
  p = q;
  if (!(q % 2))
    s *= 2, q /= 2;
  else if (!(q % 3))
    s *= 3, q /= 3;
  else
    for (i = 1; (6 * i - 1) * (6 * i - 1) <= q; ++i) {
      if (!(q % (6 * i - 1))) {
        s *= 6 * i - 1, q /= 6 * i - 1;
        break;
      }
      if ((6 * i + 1) * (6 * i + 1) > q) break;
      if (!(q % (6 * i + 1))) {
        s *= 6 * i + 1, q /= 6 * i + 1;
        break;
      }
    }
  if (p == q || q == 1)
    puts("1\n0");
  else {
    p = q;
    if (q == 2 || q == 3) {
      puts("2");
      return 0;
    } else if (!(q % 2))
      s *= 2, q /= 2;
    else if (!(q % 3))
      s *= 3, q /= 3;
    else
      for (i = 1; (6 * i - 1) * (6 * i - 1) <= q; ++i) {
        if (!(q % (6 * i - 1))) {
          s *= 6 * i - 1, q /= 6 * i - 1;
          break;
        }
        if ((6 * i + 1) * (6 * i + 1) > q) break;
        if (!(q % (6 * i + 1))) {
          s *= 6 * i + 1, q /= 6 * i + 1;
          break;
        }
      }
    if (p == q)
      puts("2");
    else
      printf("1\n%I64d\n", s);
  }
  return 0;
}
