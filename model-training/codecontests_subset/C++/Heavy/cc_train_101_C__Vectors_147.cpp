#include <bits/stdc++.h>
using namespace std;
long long det(long long a11, long long a12, long long a21, long long a22) {
  return a11 * a22 - a12 * a21;
}
bool can(long long ax, long long ay, long long bx, long long by, long long cx,
         long long cy) {
  long long dt = det(cy, -cx, cx, cy);
  bx -= ax;
  by -= ay;
  if (dt == 0) {
    if (!bx && !by) {
      return true;
    } else {
      return false;
    }
  } else {
    long long k = det(by, -cx, bx, cy);
    long long l = det(cy, by, cx, bx);
    if (k % dt == 0 && l % dt == 0) {
      return true;
    } else {
      return false;
    }
  }
}
int main() {
  long long ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  if (can(ax, ay, bx, by, cx, cy) || can(ay, -ax, bx, by, cx, cy) ||
      can(-ax, -ay, bx, by, cx, cy) || can(-ay, ax, bx, by, cx, cy)) {
    puts("YES");
  } else {
    puts("NO");
  }
  return 0;
}
