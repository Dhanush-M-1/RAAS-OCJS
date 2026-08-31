#include <cstdio>
#include <cmath>
#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
int n;
ll a, b, c, d;

ll gcd(ll x, ll y) {
	if(x % y == 0) return y;
	else return gcd(y, x % y);
}

bool chk(ll A, ll B, ll C, ll D) {
	if(A < B || D < B) return 0;
	if(C + 1 >= B) return 1;
	ll tmp = gcd(B, D);
	A %= tmp;
	return B - tmp + A <= C;
}

int main() {
	cin >> n;
	while(n--) {
		cin >> a >> b >> c >> d;
		if(chk(a, b, c, d)) cout << "Yes" << endl;
		else cout << "No" << endl;
	}
}