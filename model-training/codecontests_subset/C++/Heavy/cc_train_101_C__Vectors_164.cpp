#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
long long ax, ay, bx, by, cx, cy;
int solve(long long x, long long y) {
  x = bx - x, y = by - y;
  if (cx == 0 && cy == 0) {
    if (x == 0 && y == 0) return 1;
    return 0;
  } else {
    if ((y * cx - x * cy) % (cy * cy + cx * cx) != 0) return 0;
    long long b = (y * cx - x * cy) / (cy * cy + cx * cx);
    if (cx) {
      if ((x + b * cy) % cx != 0) return 0;
      return 1;
    } else if (cy) {
      if (y % cy != 0) return 0;
      return 1;
    } else {
      if (y == 0) return 1;
      return 0;
    }
  }
}
int main() {
  while (
      ~scanf("%lld %lld %lld %lld %lld %lld", &ax, &ay, &bx, &by, &cx, &cy)) {
    int flag = 0;
    if (solve(ax, ay)) flag = 1;
    if (solve(-ax, -ay)) flag = 1;
    if (solve(ay, -ax)) flag = 1;
    if (solve(-ay, ax)) flag = 1;
    if (flag)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
