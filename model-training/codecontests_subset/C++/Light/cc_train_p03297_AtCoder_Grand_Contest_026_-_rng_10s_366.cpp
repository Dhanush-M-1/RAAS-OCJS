#include<cstdio>

long long gcd(long long a, long long b) {
	long long r;
	while((r = a % b) != 0) {
		a = b;
		b = r;
	}
	return b;
}

int main() {
	int t;
	scanf("%d", &t);
	for(int i=0;i<t;i++) {
		bool ans;
		long long a, b, c, d;
		scanf("%lld %lld %lld %lld", &a, &b, &c, &d);
		long long g = gcd(b, d);
		long long m = c - a + g * ((d - c + a - 1) / g);
		if(d >= b && a >= b && d - m - b + c >= 0) {
			ans = true;
		} else {
			ans = false;
		}
		printf("%s\n", ans ? "Yes" : "No");
	}
	return 0;
}
