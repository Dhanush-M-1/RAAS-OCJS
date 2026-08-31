#include <bits/stdc++.h>
int main() {
  int n, a, b, c;
  int v, r(0);
  std::scanf("%d%d%d%d", &n, &a, &b, &c);
  n *= 2;
  for (int i(0); i <= a; ++i) {
    v = n - i;
    for (int j(0); j <= b && 0 <= v; ++j) {
      r += (v % 4 == 0) & (v / 4 <= c);
      v -= 2;
    }
  }
  std::printf("%d\n", r);
  return 0;
}
