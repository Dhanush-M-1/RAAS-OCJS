#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int input(void) {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  return 0;
}
int solve(void) {
  int x, ans = 0;
  for (register int y = 0; y <= b; y++) {
    for (register int z = 0; z <= c; z++) {
      x = (n - y - (z << 1)) << 1;
      if (0 <= x && x <= a) ans++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
int main(void) {
  input();
  solve();
  return 0;
}
