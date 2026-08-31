#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b) {
	return b == 0 ? a : gcd(b, a % b);
}

int main() {
	int ttt;
	cin >> ttt;
	while (ttt--) {
		long long a, b, c, d;
		cin >> a >> b >> c >> d;
		if (a < b || d < b) {
			cout << "No" << endl;
			continue;
		}
		long long g = gcd(b, d);
		g = g - a % g;
		if (b - g > c) {
			cout << "No" << endl;
		} else {
			cout << "Yes" << endl;
		}
	}
	return 0;
}