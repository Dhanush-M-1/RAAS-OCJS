#include <iostream>
#include <cstdio>
#include <complex>

using namespace std;

typedef complex<double> P;

#define X real()
#define Y imag()

//¼üp1p3Æüªp2p4Ìð·»è
//1ÂÌüªp1p3ÆA»êÉÜÜêÈ¢2_p2,p4ÉÂ¢ÄAp1p3Æp1p2Ap1p3Æp1p4A»ê¼êÉÂ¢ÄOÏðßÄ»ÌÏðæé
//OÏÌ³ÍxNgÌÈ·pÌsinÉËéÌÅAp2,p4Ì»ê¼êªp1p3Ì¶É é©EÉ é©ªí©é
//³Èçð·µÄ¢È¢AÈçð·µÄ¢éA0Èç¼üã
double is_intersected(P p1,P p2,P p3,P p4) {

  return (((p3.X-p1.X)*(p2.Y-p1.Y)-(p3.Y-p1.Y)*(p2.X-p1.X))*((p3.X-p1.X)*(p4.Y-p1.Y)-(p3.Y-p1.Y)*(p4.X-p1.X)));

}

int main() {

  double xa,ya,xb,yb,xc,yc,xd,yd;

  //¼üACÆüªBDA é¢ÍüªACÆ¼üBDªð·µÄ¢êÎÊp`
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF) {

    P a(xa,ya),b(xb,yb),c(xc,yc),d(xd,yd);

    if(is_intersected(a,b,c,d)>0.0 || is_intersected(b,a,d,c)>0.0) cout << "NO" << endl;

    else cout << "YES" << endl;

  }

  return 0;

}