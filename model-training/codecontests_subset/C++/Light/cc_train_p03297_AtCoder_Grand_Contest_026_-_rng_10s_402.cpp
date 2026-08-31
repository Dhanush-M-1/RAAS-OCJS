#include<iostream>
using namespace std;
long long gcd(long long a, long long b) {
	long long c;
	if (a < b)a += b, b = a - b, a -= b;
	while (b != 0) c = a % b, a = b, b = c;
	return a;
}
int main() {
	long long t, a, b, c, d;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> a >> b >> c >> d;
		int x = 0;
		long long z = (a - c) % gcd(b, d);
		if (z == 0) z = gcd(b, d);
		if (b - c <= z) x = 1;
		if (a < b || d < b) x = 0;
		if (x == 0) cout << "No" << endl;
		else cout << "Yes" << endl;
	}
}