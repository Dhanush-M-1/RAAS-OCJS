#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int T;
ll A, B, C, D;

ll gcd(ll a, ll b) { return b ? gcd(b, a%b) : a; }

int main() {
	scanf("%d", &T);

	for (int i = 0; i < T; ++i) {
		scanf("%lld%lld%lld%lld", &A, &B, &C, &D);

		if (A < B || D < B) {
			printf("No\n");
			continue;
		}

		if (C >= B) {
			printf("Yes\n");
			continue;
		}

		ll d = gcd(D, B);
		if (B - d + A % d > C) printf("No\n");
		else printf("Yes\n");
	}
}