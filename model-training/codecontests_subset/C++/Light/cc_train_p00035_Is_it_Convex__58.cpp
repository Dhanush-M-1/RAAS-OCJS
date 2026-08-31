#include <cstdio>
using namespace std;

int main() {
  double xa, ya, xb, yb, xc, yc, xd, yd;
  double vx1, vy1, vx2, vy2;
  while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) == 8) {
    vx1 = ya-yc;
    vy1 = xc-xa;
    vx2 = yb-yd;
    vy2 = xd-xb;
    if ((vx1*(xb-xa)+vy1*(yb-ya))*(vx1*(xd-xa)+vy1*(yd-ya)) > 0 || (vx2*(xa-xb)+vy2*(ya-yb))*(vx2*(xc-xb)+vy2*(yc-yb)) > 0) printf("NO\n");
    else printf("YES\n");
  }

  return 0;
}