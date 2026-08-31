#include <bits/stdc++.h>

using namespace std;

long gcd(long a, long b) {
	for (; b; swap(a, b))
		a %= b;
	return a;
}
int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		long a, b, c, d;
		cin >> a >> b >> c >> d;
		if (a < b || d < b) {
			cout << "No\n";
			continue;
		}
		if (b <= c) {
			cout << "Yes\n";
			continue;
		}
		long g = gcd(b, d);
		long cc = (a - c + g - 1) / g, bb = (a - b) / g;
		cout << (cc - bb > 1 ? "No" : "Yes") << '\n';
	}
	cout << flush;
	return 0;
}
