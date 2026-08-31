#include <bits/stdc++.h>
long long Ax, Ay, Bx, By, dx, dy, d;
bool check(long long x, long long y) {
  return !d && !x && !y ||
         d && (dx * y - dy * x) % d == 0 && (dx * x + dy * y) % d == 0;
}
int main() {
  scanf("%I64d%I64d%I64d%I64d%I64d%I64d", &Ax, &Ay, &Bx, &By, &dx, &dy);
  long long bx[] = {Bx, -By, -Bx, By}, by[] = {By, Bx, -By, -Bx};
  d = dx * dx + dy * dy;
  for (int j = 0; j < 4; ++j)
    if (check(bx[j] - Ax, by[j] - Ay)) return puts("YES"), 0;
  puts("NO");
  return 0;
}
