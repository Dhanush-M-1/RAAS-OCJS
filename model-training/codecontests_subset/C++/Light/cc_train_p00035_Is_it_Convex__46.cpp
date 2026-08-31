#include <iostream>
#include <algorithm>
#include <cmath>
#define rep(i, n) for(int i = 0; i < n; i++)
using namespace std;

struct Point {
  double x, y;
  Point(double x=0, double y=0) : x(x), y(y) {}
  Point operator - (Point p) { return Point(x-p.x, y-p.y); }
};
typedef Point Vector;
double cross(Vector a, Vector b) { return a.x*b.y - a.y*b.x; }

Point p[4];

bool solve() {
  double c0 = cross(p[1] - p[0], p[2] - p[0]);
  for(int i = 1; i < 4; i++) {
    if(c0 * cross(p[(i+1)%4] - p[i], p[(i+2)%4] - p[i]) < 0.0) return false;
  }
  return true;
}

int main() {
  while( scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
	       &p[0].x, &p[0].y, &p[1].x, &p[1].y,
	       &p[2].x, &p[2].y, &p[3].x, &p[3].y) != EOF )
    { cout << (solve() ? "YES" : "NO") << endl; }
}