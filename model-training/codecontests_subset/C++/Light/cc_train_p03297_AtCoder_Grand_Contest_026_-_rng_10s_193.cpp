#include<cstdio>
#include<algorithm>
using namespace std;
int n, res;
long long gcd(long long a, long long b) {
	return b?gcd(b, a%b) :a;
}
int main() {
	long long a, b, c, d;
	int TC;
	scanf("%d", &TC);
	while (TC--) {
		scanf("%lld%lld%lld%lld", &a, &b, &c, &d);
		long long g = gcd(b, d);
		long long t = a % g;
		if (t <= c) t += (c - t) / g*g;
		while (t <= c)t += g;
		if (t >= b && a>=b && b<=d)puts("Yes");
		else puts("No");
	}
}