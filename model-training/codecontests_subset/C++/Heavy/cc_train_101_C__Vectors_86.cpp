#include <bits/stdc++.h>
using namespace std;
long long bx, by, cx, cy;
long long det(long long a, long long b, long long c, long long d) {
  return a * d - b * c;
}
bool solve(long long ax, long long ay) {
  long long dx = bx - ax;
  long long dy = by - ay;
  long long d = det(cx, cy, cy, -cx);
  if (d == 0) {
    return ((cx != 0 || cy != 0) && cy * dx == cx * dy &&
            cy * dy == -cx * dx) ||
           (cx == 0 && cy == 0 && dx == 0 && dy == 0);
  } else {
    return ((det(dx, cy, dy, -cx) % d == 0) && (det(cx, dx, cy, dy) % d == 0));
  }
}
int main() {
  long long ax, ay;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  bool res = false;
  res |= solve(ax, ay);
  res |= solve(ay, -ax);
  res |= solve(-ax, -ay);
  res |= solve(-ay, ax);
  if (res)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
