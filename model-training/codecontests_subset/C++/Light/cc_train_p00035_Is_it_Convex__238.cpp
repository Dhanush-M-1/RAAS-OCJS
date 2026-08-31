#include <cstdio>
using namespace std;
struct Point { double x, y; };

bool intersect(Point a, Point b, Point c, Point d) {
  return ((a.x - b.x) * (c.y - a.y) + (a.y - b.y) * (a.x - c.x)) * ((a.x - b.x) * (d.y - a.y) + (a.y - b.y) * (a.x - d.x)) < 0;
}

int main() {
  Point A, B, C, D;
  while (~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &A.x, &A.y, &B.x, &B.y, &C.x, &C.y, &D.x, &D.y)) {
    if (intersect(A, C, B, D) && intersect(B, D, A, C)) puts("YES");
    else puts("NO");
  }
}
