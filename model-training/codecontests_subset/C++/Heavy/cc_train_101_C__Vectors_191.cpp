#include <bits/stdc++.h>
using namespace std;
struct point {
  long long x, y;
} a, b, c;
point operator-(point a, point b) { return {a.x - b.x, a.y - b.y}; }
point operator+(point a, point b) { return {a.x + b.x, a.y + b.y}; }
point operator*(long long m, point a) { return {a.x * m, a.y * m}; }
bool operator==(point a, point b) {
  if (a.x == b.x && a.y == b.y) return 1;
  return 0;
}
point rot(point ret) { return {ret.y, -ret.x}; }
bool check(point d) {
  d = b - d;
  if (c.x == 0 && c.y == 0) {
    if (d.x == 0 && d.y == 0) return true;
    return false;
  }
  if (c.x == 0) {
    long long bb = d.x / c.y;
    long long aa = d.y / c.y;
    if (aa * c + bb * rot(c) == d)
      return true;
    else
      return false;
  } else if (c.y == 0) {
    long long aa = d.x / c.x;
    long long bb = -d.y / c.x;
    if (aa * c + bb * rot(c) == d)
      return true;
    else
      return false;
  } else {
    double bb2 = ((double)d.y - ((double)d.x * c.y) / (double)c.x) /
                 ((double)-c.x - ((double)c.y * c.y) / (double)c.x);
    double aa2 = ((double)d.x - (double)bb2 * c.y) / (double)c.x;
    bb2 = round(bb2);
    aa2 = round(aa2);
    long long aa = aa2;
    long long bb = bb2;
    if (aa * c + bb * rot(c) == d)
      return true;
    else
      return false;
  }
}
int main() {
  scanf("%lld %lld", &a.x, &a.y);
  scanf("%lld %lld", &b.x, &b.y);
  scanf("%lld %lld", &c.x, &c.y);
  for (int i = 0; i <= 3; i++) {
    if (check(a)) {
      printf("YES\n");
      return 0;
    }
    a = rot(a);
  }
  printf("NO\n");
  return 0;
}
