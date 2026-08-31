#include <iostream>
using namespace std;
long long gcd(long long x, long long y) {
	if (y == 0) return x;
	return gcd(y, x % y);
}
int main() {
	int Q;
	cin >> Q;
	while (Q--) {
		long long A, B, C, D;
		cin >> A >> B >> C >> D; ++C;
		long long g = gcd(B, D);
		if (B > D || A - B < 0 || (A % g - C % g + g) % g + C - B < 0) {
			cout << "No" << endl;
		}
		else {
			cout << "Yes" << endl;
		}
	}
	return 0;
}