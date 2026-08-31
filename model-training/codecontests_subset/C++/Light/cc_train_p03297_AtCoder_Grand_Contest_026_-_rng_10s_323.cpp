#include <iostream>
using namespace std;
long gcd(long a, long b) {
	if (b == 0) return a;
	return gcd(b, a%b);
}
int main() {
	long a, b, c, d, e, f;
	cin >> a;
	for (int i = 0; i < a; ++i) {
		cin >> b >> c >> d >> e;
		if (b < c || e < c) {
			cout << "No" << endl;
		}
		else if (d >= c) {
			cout << "Yes" << endl;
		}
		else {
			f = gcd(c, e);
			if (c - f + (b%f) > d) cout << "No" << endl;
			else cout << "Yes" << endl;
		}
	}
}