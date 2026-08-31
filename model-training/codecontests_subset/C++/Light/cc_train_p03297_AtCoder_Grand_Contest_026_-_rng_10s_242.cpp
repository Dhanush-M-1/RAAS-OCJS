#include <iostream>
using namespace std;

long long gcd(long long a, long long b) {
	if (b == 0) return a;
	return gcd(b, a%b);
}

long long N, A, B, C, D;

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> A >> B >> C >> D;
		if (A < B) cout << "No" << endl;
		else if (B > D) cout << "No" << endl;
		else if (B <= C) cout << "Yes" << endl;
		else {
			long long S = gcd(B, D);
			long long T = ((B / S) - 1) * S + A % S;
			if (T > C) cout << "No" << endl;
			else cout << "Yes" << endl;
		}
	}
	return 0;
}