#include<iostream>
using namespace std;

typedef long long ll;

ll gcd(ll a, ll b) {
	if (b == 0) return a;
	else return gcd(b, a % b);
}

int main() {
	int T; cin >> T;
	for (int i = 0; i < T; i++) {
		ll A, B, C, D; cin >> A >> B >> C >> D;
		if (A < B) {
			cout << "No" << endl;
			continue;
		}
		else if (D < B) {
			cout << "No" << endl;
			continue;
		}
		else if (C > B) {
			cout << "Yes" << endl;
			continue;
		}

		ll G = gcd(B, D);
		if (A % G + B - G > C) cout << "No" << endl;
		else cout << "Yes" << endl;
	}

	return 0;
}