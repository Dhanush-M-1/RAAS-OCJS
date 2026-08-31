#include<iostream>
#include<cmath>
using namespace std;

typedef double dbl;
dbl x[4], y[4];
bool point(dbl x[], dbl y[], int n) {
	dbl nx[3], ny[3];
	for (int i = 0, j = 0; i < 4; i++) {
		if (i != n) {
			nx[j] = x[i];
			ny[j++] = y[i];
		}
	}
	dbl S, s[3];
	S = fabs((nx[1] - nx[0])*(ny[2] - ny[0]) - (ny[1] - ny[0])*(nx[2] - nx[0])) / 2.0;
	for (int i = 0; i < 3; i++) {
		nx[i] -= x[n]; 
		ny[i] -= y[n];
	}
	for (int i = 0; i < 3; i++) {
		s[i] = fabs(nx[i] * ny[(i + 1) % 3] - ny[i] * nx[(i + 1) % 3]) / 2.0;
	}
	if (fabs(S - s[0] - s[1] - s[2]) < 1e-10) return true;
	else return false;
}
int main() {
	char c;
	while (cin >> x[0] >> c >> y[0]) {
		int ok = 1;
		for (int i = 1; i < 4; i++) {
			cin >> c >> x[i] >> c >> y[i];
		}
		for (int i = 0; i < 4; i++) {
			if (point(x, y, i)) {
				cout << "NO\n";
				ok = 0;
				break;
			}
		}
		if(ok) cout << "YES\n";
	}
}
