#include <iostream>
#include <cstdio>

using namespace std;

double isConvex(double xa, double ya, double xb, double yb, double x, double y)
{
	double ret;
	ret = (xa-xb)*(y-ya) + (ya-yb)*(xa-x);
	return ret;
}

int main()
{
	double xa, ya, xb, yb, xc, yc, xd, yd;
	while( scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF ){
		// 直線BDと線分ACが交わるか
		double bd_ac = isConvex(xb, yb, xd, yd, xa, ya)*isConvex(xb, yb, xd, yd, xc, yc);
		// 直線ACと線分BDが交わるか
		double ac_bd = isConvex(xa, ya, xc, yc, xb, yb)*isConvex(xa, ya, xc, yc, xd, yd);
		
		// bd_acが負またはac_bdが負ならば、交差している
		if( bd_ac < 0.0 && ac_bd < 0.0 ){
			cout<<"YES"<<endl;
		}else{
			cout<<"NO"<<endl;
		}
		
	}
	return 0;
}