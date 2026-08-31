#include <bits/stdc++.h>
int a, b, c, n;
int s;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  a >>= 1;
  c <<= 1;
  for (register int i = 0; i <= a; ++i)
    for (register int j = 0; j <= b; ++j) {
      int x = i + j;
      if (x > n) break;
      if (x + c >= n && !((n - x) & 1)) s++;
    }
  printf("%d", s);
}
