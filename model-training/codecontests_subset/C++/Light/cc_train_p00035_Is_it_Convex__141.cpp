#include <cstdio>
#include <complex>
using namespace std;

typedef complex<double> Point;

#define X real()
#define Y imag()

Point ps[4];

double dot(Point a, Point b) {
  return (conj(a)*b).X;
}

double cross(Point a, Point b) {
  return (conj(a)*b).Y;
}

bool ccw(Point a, Point b, Point c) {
  return cross(c-b, a-b) > 0.0;
}

int main() {
  while (1) {
    for (int i=0; i<4; i++) {
      double x, y;
      if (scanf("%lf,%lf", &x, &y) != 2) return 0;
      getchar();
      ps[i] = Point(x, y);
    }
  
    bool base = ccw(ps[0], ps[1], ps[2]);
    bool is_convex = true;
    for (int i=1; i<4; i++) {
      is_convex &= (base == ccw(ps[i], ps[(i+1)%4], ps[(i+2)%4]));
    }

    if (is_convex) puts("YES");
    else puts("NO");
  }
}