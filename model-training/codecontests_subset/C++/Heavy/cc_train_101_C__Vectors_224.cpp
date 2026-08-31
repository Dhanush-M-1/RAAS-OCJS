#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
int solve(long long x, long long y) {
  x = bx - x;
  y = by - y;
  if (cx == 0 && cy == 0) {
    if (x == 0 && y == 0) return 1;
    return 0;
  } else if (cx == 0) {
    long long g = x / cy, h = y / cy;
    if (g * cy == x && h * cy == y) return 1;
    return 0;
  } else if (cy == 0) {
    long long g = x / cx, h = y / cx;
    if (g * cx == x && h * cx == y) return 1;
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
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  int f = 0;
  if (solve(ax, ay)) f = 1;
  if (solve(-ax, -ay)) f = 1;
  if (solve(ay, -ax)) f = 1;
  if (solve(-ay, ax)) f = 1;
  if (f)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
