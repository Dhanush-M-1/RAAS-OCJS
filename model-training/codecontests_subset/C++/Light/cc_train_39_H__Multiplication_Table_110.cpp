#include <bits/stdc++.h>
using namespace std;
int i, j, k, l, n, m, x, y, s, p;
int main() {
  cin >> n;
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      x = i * j;
      s = 0;
      p = 0;
      while (x > 0) {
        k = x % n;
        s += k * pow(10, p);
        x /= n;
        p++;
      }
      printf("%d", s);
      if (j != n - 1) printf(" ");
    }
    if (i != n - 1) printf("\n");
  }
  return 0;
}
