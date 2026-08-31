#include <bits/stdc++.h>

#define For(i, j, k) for (int i = j; i <= k; i++)

typedef long long LL;

LL A, B, C, D;

LL gcd(LL x, LL y) {
	return !y ? x : gcd(y, x % y);
}

int main() {

	scanf("%*d");
	while (scanf("%lld%lld%lld%lld", &A, &B, &C, &D) == 4) {
		if (A < B || B > D) { puts("No"); continue; }
		if (C >= B) { puts("Yes"); continue; }
		LL d = gcd(B, D);
		A %= d;
		LL x = C / d * d + A;
		if (x <= C) x += d;
		puts(x < B ? "No" : "Yes");
	}

	return 0;
}