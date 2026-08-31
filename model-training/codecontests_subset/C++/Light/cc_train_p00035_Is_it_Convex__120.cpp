#include <cstdio>
#include <complex>
#include <iostream>
using namespace std;

double cross(complex<double> z1, complex<double> z2) {
	return z1.real() * z2.imag() - z1.imag() * z2.real();
}

int main() {
	double x1, y1, x2, y2, x3, y3, x4, y4;
	while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &x1, &y1, &x2, &y2, &x3, &y3, &x4, &y4) != EOF) {
		complex<double> a(x1, y1), b(x2, y2), c(x3, y3), d(x4, y4);

		double ab, bc, cd, da;
		ab = cross(b - a, c - b);
		bc = cross(c - b, d - c);
		cd = cross(d - c, a - d);
		da = cross(a - d, b - a);

		if ((ab > 0 && bc > 0 && cd > 0 && da > 0) || (ab < 0 && bc < 0 && cd < 0 && da < 0)) {
			cout << "YES";
		}else {
			cout << "NO";
		}
		cout << endl;
	}
	return 0;
}