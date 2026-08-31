#include <bits/stdc++.h>
int main() {
  int m, n, c = 0;
  scanf("%d %d", &m, &n);
  while (m != 0) {
    c++;
    m = m - 1;
    if (c % n == 0) m = m + 1;
  }
  printf("%d", c);
  return 0;
}
