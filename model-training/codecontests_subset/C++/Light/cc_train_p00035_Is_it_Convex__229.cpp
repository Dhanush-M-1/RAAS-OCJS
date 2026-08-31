#include <iostream>
#include <cstdio>
using namespace std;

double cross(double x1, double y1, double x2, double y2, double x3, double y3) {
	double xx1 = x2-x1, yy1 = y2-y1;
	double xx2 = x3-x1, yy2 = y3-y1;
	return (xx1*yy2 - xx2*yy1);
}

int main() {
	double xa,xb,xc,xd,ya,yb,yc,yd;
	while (scanf(
			"%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
			&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd) == 8) {
		double p = cross(xa, ya, xb, yb, xc, yc);
		bool convex = true;
		if (p*cross(xb, yb, xc, yc, xd, yd) < 0.0) convex = false;
		if (p*cross(xc, yc, xd, yd, xa, ya) < 0.0) convex = false;
		if (p*cross(xd, yd, xa, ya, xb, yb) < 0.0) convex = false;

		cout << (convex ? "YES" : "NO") << endl;
	}
	return 0;
}