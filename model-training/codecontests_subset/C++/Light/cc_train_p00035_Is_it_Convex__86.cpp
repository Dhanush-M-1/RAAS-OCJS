#include <iostream>
#include <cstdio>
#include <cmath>
#include <complex>
using namespace std;

typedef complex<double> P;

#define x real()
#define y imag()

double isIntersect(P p1, P p2,P p3,P p4 ){
  return (((p1.x - p2.x)*(p3.y - p1.y)+(p1.y-p2.y)*(p1.x-p3.x))*((p1.x - p2.x)*(p4.y - p1.y)+(p1.y-p2.y)*(p1.x-p4.x)));
}

int main(){
  double xa,ya,xb,yb,xc,yc,xd,yd;
  char e;
  while( scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF ){

    P a(xa , ya);
    P b(xb , yb);
    P c(xc , yc);
    P d(xd , yd);

    if(isIntersect(a,c,b,d) > 0.0 || isIntersect(b,d,a,c) > 0.0){
      cout << "NO" <<endl;
    }else cout << "YES" << endl; 


}
  return 0;
}