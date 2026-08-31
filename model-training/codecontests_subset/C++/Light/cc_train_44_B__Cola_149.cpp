#include <bits/stdc++.h>
int min(int x, int y) {
  if (x < y)
    return x;
  else
    return y;
}
int main() {
  int n, ans(0), a, b, c;
  scanf("%d%d%d%d", &n, &a, &b, &c);
  n *= 2;
  for (int z = 0; z <= c; ++z)
    for (int y = min((n - z * 4) / 2, b); y >= 0; --y) {
      int x = n - z * 4 - y * 2;
      if (x > a) break;
      if (x >= 0) ++ans;
    }
  printf("%d\n", ans);
  return 0;
}
