#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
bool solve(long long x, long long y) {
  x = bx - x;
  y = by - y;
  if (cx == 0 && cy == 0) {
    if (x == 0 && y == 0)
      return 1;
    else
      return 0;
  } else if (cx == 0) {
    long long m = x / cy, n = y / cy;
    if (m * cy == x && n * cy == y)
      return 1;
    else
      return 0;
  } else if (cy == 0) {
    long long m = x / cx, n = y / cx;
    if (m * cx == x && n * cx == y)
      return 1;
    else
      return 0;
  } else {
    long long tx = x * cy, ty = y * cx;
    long long b = (tx - ty) / (cy * cy + cx * cx);
    if (b * (cx * cx + cy * cy) != (tx - ty))
      return 0;
    else {
      long long a = (x - b * cy) / cx;
      if (a * cx + b * cy == x) return 1;
      return 0;
    }
  }
}
int main() {
  scanf("%lld%lld%lld%lld%lld%lld", &ax, &ay, &bx, &by, &cx, &cy);
  bool flag = 0;
  if (solve(ax, ay)) flag = 1;
  if (solve(-ax, -ay)) flag = 1;
  if (solve(ay, -ax)) flag = 1;
  if (solve(-ay, ax)) flag = 1;
  if (flag)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
