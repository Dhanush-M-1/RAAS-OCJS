// 0012 を使い回す
#include <fstream>
#include <iostream>
#include <cmath>
#include <vector>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

bool same_side(double x1, double y1, double x2, double y2, double x, double y, double x0, double y0) {
  return ((y1 - y2) * (x - x2) - (x1 - x2) * (y - y2)) * ((y1 - y2) * (x0 - x2) - (x1 - x2) * (y0 - y2)) >= 0;
}


bool in_triangle(double x1, double y1, double x2, double y2, double x3, double y3, double xp, double yp) {
  return same_side(x1,y1,x2,y2,xp,yp,x3,y3) && same_side(x2,y2,x3,y3,xp,yp,x1,y1) && same_side(x3,y3,x1,y1,xp,yp,x2,y2);
}


int main() {
  double x[4];
  double y[4];
  char c,d;
  while (cin >> x[0] >> c >> y[0]) {
    for (int i = 1; i < 4; i++)
      cin >> c >> x[i] >> d >> y[i];

    bool res = true;
    int k[4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++)
        k[j] = (j + i) % 4;
      if (in_triangle(x[k[0]], y[k[0]], x[k[1]], y[k[1]], x[k[2]], y[k[2]], x[k[3]], y[k[3]]))
        res = false;
    }

    if (res) {
      cout << "YES" << endl;
    } else {
      cout << "NO" << endl;
    }
  }
}