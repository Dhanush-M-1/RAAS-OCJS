#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b) {
	if(b == 0) return a;
	else return gcd(b, a%b);
}


int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; ++i) {
		long long a, b, c, d;
		cin >> a >> b >> c >> d;
		if(a < b) puts("No");
		else if(d < b) puts("No");
		else {
			long long v = c - b + 1;
			long long x = a;
			x %= gcd(b, d);
			x -= gcd(b, d);
			if(v <= x && x < 0) puts("No");
			else puts("Yes");

		}


	}
}
