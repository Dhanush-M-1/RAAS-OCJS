#include <iostream>
#include <cstdlib>
#include <stdio.h>
#include <cmath>
using namespace std;

double triangle(double x1,double y1,double x2,double y2,double x3,double y3) {
  double a[2],b[2],theta,al,bl;
  a[0] = x2 - x1;
  a[1] = y2 - y1;
  b[0] = x3 - x1;
  b[1] = y3 - y1;
  al = sqrt(a[0] * a[0] + a[1] * a[1]);
  bl = sqrt(b[0] * b[0] + b[1] * b[1]);
  theta = acos((a[0] * b[0] + a[1] * b[1]) / (al * bl));
  return al * bl * abs(sin(theta)) / 2;
}

int main() {
  double x0,y0,x1,y1,x2,y2,x3,y3;
  double abc,bcd,cda,dab,abd,cbd,acd;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x0,&y0,&x1,&y1,&x2,&y2,&x3,&y3) == 8) {
    abc = triangle(x0,y0,x1,y1,x2,y2);
    bcd = triangle(x1,y1,x2,y2,x3,y3);
    cda = triangle(x2,y2,x3,y3,x0,y0);
    dab = triangle(x3,y3,x0,y0,x1,y1);
    abd = triangle(x0,y0,x1,y1,x3,y3);
    cbd = triangle(x2,y2,x1,y1,x3,y3);
    acd = triangle(x0,y0,x2,y2,x3,y3);
    if(abc > abd + cbd)
      cout << "NO" << endl;
    else if(bcd > abc + acd)
      cout << "NO" << endl;
    else if(cda > abd + bcd)
      cout << "NO" << endl;
    else if(dab > abc + acd)
      cout << "NO" << endl;
    else
      cout << "YES" << endl;
  }
}