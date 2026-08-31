#include <iostream>
#include <cstdio>
#include <cmath>
#define PI 3.1415926535898
#define EPS 1e-9
using namespace std;

double calc(double a1,double a2,double b1,double b2){
	return acos((a1 * b1 + a2 * b2) / sqrt(a1 * a1 + a2 * a2) / sqrt(b1 * b1 + b2 * b2)) * 180.0 / PI;
}

int main(){
	double x1,y1,x2,y2,x3,y3,x4,y4;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x1,&y1,&x2,&y2,&x3,&y3,&x4,&y4) != EOF){
		double c1,c2,c3,c4;
		c2 = calc(x1 - x2,y1 - y2,x3 - x2,y3 - y2);
		c3 = calc(x2 - x3,y2 - y3,x4 - x3,y4 - y3);
		c4 = calc(x3 - x4,y3 - y4,x1 - x4,y1 - y4);
		c1 = calc(x4 - x1,y4 - y1,x2 - x1,y2 - y1);
		if(abs(360.0 - (c1 + c2 + c3 + c4)) <= EPS) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
	return 0;
}