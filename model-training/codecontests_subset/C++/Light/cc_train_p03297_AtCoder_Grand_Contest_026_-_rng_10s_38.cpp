#include<bits/stdc++.h>
using namespace std;
using ll = long long;

ll gcd(ll a, ll b) {
	return b ? gcd(b, a % b) : a;
}

bool solve() {
	ll A, B, C, D; cin >> A >> B >> C >> D;
	if (A < B) return false;
	if (B > D) return false;
	if (B <= C+1) return true;
	ll G = gcd(B, D);
	ll AM = A % G;
	ll ma = B - G + AM;
	return ma <= C;
}

int main() {
	int Q; cin >> Q;
	while (Q--) {
		if (solve()) cout << "Yes" << endl;
		else cout << "No" << endl;
	}
}
