#include <bits/stdc++.h>
using namespace std;

constexpr double EPS = 1e-9;

double cross(double x1, double y1, double x2, double y2) {
	return x1 * y2 - y1 * x2;
}

int ccw(double x1, double y1, double x2, double y2, double x3, double y3) {
	x2 -= x1;
	y2 -= y1;
	x3 -= x1;
	y3 -= y1;

	const double t = cross(x2, y2, x3, y3);
	if(t > EPS) return 1;
	if(t < -EPS) return -1;
	return 0;
}

int main() {
	double x[4];
	double y[4];

	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", x, y, x+1, y+1, x+2, y+2, x+3, y+3) == 8) {
		bool ok = true;
		const int t = ccw(x[0], y[0], x[2], y[2], x[1], y[1]);
		for(int i = 1; i < 4; ++i) {
			const int next = (i + 1) % 4;
			const int next2 = (i + 2) % 4;
			if(t != ccw(x[i], y[i], x[next2], y[next2], x[next], y[next])) {
				ok =false;
				break;
			}
		}

		puts((ok ? "YES" : "NO"));
	}


	return 0;
}