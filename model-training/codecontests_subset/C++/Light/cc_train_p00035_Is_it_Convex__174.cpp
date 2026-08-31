#include <iostream>
using namespace std;

class Point{
public:
  double x, y;
  Point(double x = 0, double y = 0) : x(x), y(y) {}
  Point operator +(Point p) { return Point(x+p.x, y+p.y); }
  Point operator -(Point p) { return Point(x-p.x, y-p.y); }
  Point operator *(double a) { return Point(x*a, y*a); }
};

typedef Point Vector;

double cross(Vector a, Vector b) {
  return a.x*b.y - a.y*b.x;
}

int main() {
  Point p[4];
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
	      &p[0].x, &p[0].y, &p[1].x, &p[1].y,
	      &p[2].x, &p[2].y, &p[3].x, &p[3].y) != EOF) {

    bool okFlag = true;
    for(int i = 0; i < 4; i++) {
      int idx1, idx2, idx3;
      idx1 = (i+1)%4;
      idx2 = (i+2)%4;
      idx3 = (i+3)%4;
      if(cross(p[idx1]-p[i], p[idx2]-p[i])
	 *cross(p[idx2]-p[i], p[idx3]-p[i]) < 0) {
	okFlag = false;
	break;
      }
    }

    if(okFlag) {
      cout << "YES" << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}