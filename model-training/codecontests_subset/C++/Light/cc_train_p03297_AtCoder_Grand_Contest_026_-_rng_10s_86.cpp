#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b) {
	while (b) {
		long long c = a % b;
		a = b;
		b = c;
	}
	return a;
}

int main() {
	int T;
	ignore = scanf("%d", &T);
	while (T--) {
		long long a, b, c, d;
		ignore = scanf("%lld %lld %lld %lld", &a, &b, &c, &d);
		
		bool ok = (a >= b) && (d >= b);
		
		long long g = gcd(b, d);
		
		a %= b;
		long long x = a + (b - 1 - a) / g * g;
		
		printf("%s\n", ok && x <= c ? "Yes" : "No");
	}
	
	return 0;
}
