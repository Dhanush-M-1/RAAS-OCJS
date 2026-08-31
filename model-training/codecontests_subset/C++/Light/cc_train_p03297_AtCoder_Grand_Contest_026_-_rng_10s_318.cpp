#include "bits/stdc++.h"
using namespace std;

long long GCD(long long X, long long Y) {
	if (Y == 0) return X;
	return GCD(Y, X % Y);
}

int main() {
	long long T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		long long A, B, C, D;
		cin >> A >> B >> C >> D;
		if (A < B) cout << "No" << endl;
		else if (D < B) cout << "No" << endl;
		else if (B <= C + 1) cout << "Yes" << endl;
		else {
			if (C - A % GCD(B, D) >= B - GCD(B, D)) cout << "Yes" << endl;
			else cout << "No" << endl;
		}
	}
}