#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m, i, j, k, l, p = 0, q, x, y, z;
  scanf("%lld %lld %lld %lld", &n, &m, &k, &l);
  x = l * 2;
  x = min(x, n);
  i = x / 2;
  for (; i >= 0; i--) {
    x = i * 2;
    x = n - x;
    x = min(x, k);
    for (j = x; j >= 0; j--) {
      y = (i * 2) + j;
      y = n - y;
      y *= 2;
      if (y <= m) p++;
    }
  }
  printf("%lld", p);
}
