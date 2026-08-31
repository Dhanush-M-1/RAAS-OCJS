#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int t;
ll a, b, c, d;

ll gcd(ll x, ll y) {
	return y ? gcd(y, x % y) : x;
}

int main() {
	scanf("%d", &t);
	while (t--) {
		scanf("%lld%lld%lld%lld", &a, &b, &c, &d);
		if (b > a) puts("No");
		else if (d < b) puts("No");
		else if (c >= b) puts("Yes");
		else {
			d %= b; a %= b;
			ll e = gcd(d, b), lim = (b - a - 1) / e;
			a += lim * e;
			if (a + e < b) a += e;
			puts(a > c ? "No" : "Yes");
		}
	}
}