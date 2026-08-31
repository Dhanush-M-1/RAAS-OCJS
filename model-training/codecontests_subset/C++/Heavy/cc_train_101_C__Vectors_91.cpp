#include <bits/stdc++.h>
using namespace std;
struct Point {
  long long x, y;
  Point(long long _x = 0, long long _y = 0) : x(_x), y(_y) {}
  void input() { scanf("%lld%lld", &x, &y); }
  void output() { printf("(%lld %lld)\n", x, y); }
};
Point operator+(Point A, Point B) { return Point(A.x + B.x, A.y + B.y); }
Point operator-(Point A, Point B) { return Point(A.x - B.x, A.y - B.y); }
Point Rotate(Point A) { return Point(-A.y, A.x); }
long long gcd(long long a, long long b) { return !b ? a : gcd(b, a % b); }
int main() {
  int ok = 0;
  Point A, B, C1, C2, F;
  A.input();
  B.input();
  C1.input();
  C2 = Rotate(C1);
  for (int i = 0; i < 4; i++) {
    A = Rotate(A);
    F = B - A;
    ok = 0;
    long long a1 = C1.x, b1 = C2.x;
    long long a2 = C1.y, b2 = C2.y;
    long long c1 = F.x, c2 = F.y;
    if (a2 == 0 && b2 == 0) swap(a1, a2), swap(b1, b2), swap(c1, c2);
    if (a1 == 0 && b1 == 0) {
      if (c1) {
        ok = 0;
      } else if (a2 == 0 && b2 == 0) {
        if (c2)
          ok = 0;
        else
          ok = 1;
      } else if (c2 % gcd(a2, b2) == 0)
        ok = 1;
      else
        ok = 0;
    } else if (c1 % gcd(a1, b1) || c2 % gcd(a2, b2)) {
      ok = 0;
    } else if (a1 * b2 == a2 * b1) {
      if (a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) {
        ok = 1;
      }
      ok = 0;
    } else if ((b1 * c2 - b2 * c1) % (a1 * b2 - a2 * b1)) {
      ok = 0;
    } else if ((c1 * a2 - c2 * a1) % (b1 * a2 - a1 * b2)) {
      ok = 0;
    } else
      ok = 1;
    if (ok == 1) break;
  }
  printf(ok ? "YES\n" : "NO\n");
}
