#include <iostream>
#include <complex>
#include <cmath>
using namespace std;
typedef complex<double> P;

// real -> X
// imag -> Y
bool isIntersect(P p1, P p2, P p3, P p4){
	return 	(
			((p1.real() - p2.real()) * (p3.imag() - p1.imag()) + (p1.imag() - p2.imag()) * (p1.real() - p3.real())) *
			((p1.real() - p2.real()) * (p4.imag() - p1.imag()) + (p1.imag() - p2.imag()) * (p1.real() - p4.real()))
			) > 0.0;
}

int main(){
	cin.tie(0);
	ios::sync_with_stdio(false);

	double xa, ya, xb, yb, xc, yc, xd, yd;
	// 0 0 1 0 1 1 0 1
	char c0;
	while(cin >> xa >> c0 >> ya >> c0){
		cin >> xb >> c0 >> yb >> c0;
		cin >> xc >> c0 >> yc >> c0;
		cin >> xd >> c0 >> yd;

		P a(xa, ya);
		P b(xb, yb);
		P c(xc, yc);
		P d(xd, yd);

		cout << ((isIntersect(a, c, b, d) || isIntersect(b, d, a, c)) ? "NO" : "YES") << endl;
	}

	return 0;
}