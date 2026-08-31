#include<iostream>
#include<algorithm>
using namespace std;

long long n, m, a, b, p, q, minx, d, s, B;
long long x[10000], y[10000], c[10000];
long long rem;

int main() {
	cin >> n >> m >> a >> b >> p >> q;
	x[0] = 1; y[0] = 1;
	s = min((long long)10000, n);

	if (a >= 1000000000 && b >= 1000000000) {
		if (p >= 1000000000 && q >= 1000000000) {
			cout << min(m, abs(m - p - q)) << endl;
		}
		else {
			cout << min(m, min(abs(m - p - q), min(abs(m - a * p - b * q), abs(m - a * p - b * q - p - q)))) << endl;
		}
		return 0;
	}

	for (int i = 1; i < s; i++) {
		x[i] = x[i - 1] * a;
		if (x[i] > m) { break; }
	}
	for (int i = 1; i < s; i++) {
		y[i] = y[i - 1] * b;
		if (x[i] > m) { break; }
	}

	if (a == 1 && b == 1) {
		if (n >= 1000001 && (p + q) >= 1000001) { goto F; }
		if (m <= n * (p + q)) {
		F:;
			B = m % (p + q);
			if (B > (p + q) / 2) {
				B = (p + q) - B;
			}
			cout << B << endl;
		}
		else {
			cout << m - (long long)(n * (p + q)) << endl;
		}
		return 0;
	}

	for (int i = 0; i < s; i++) {
		c[i] = p*x[i] + q*y[i];
		if (c[i] > m) {
			d = i;
			minx = c[i] - m;
			goto E;
		}
	}
	minx = m;
	d = s;
E:;
	rem = m - c[d - 1];
	minx = min(minx, abs(rem));
	for (int i = d - 2; i >= 0; i--) {
		minx = min(minx, (long long)abs(rem - c[i]));
		if (rem >= c[i]) {
			rem -= c[i];
		}
	}
	cout << minx << endl;
	return 0;
}