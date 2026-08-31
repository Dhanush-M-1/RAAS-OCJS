#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int t;
ll A, B, C, D;

ll gcd(ll x, ll y) { return x? gcd(y % x, x): y; }

int main()
{
	scanf("%d", &t);
	while (t--) {
		cin >> A >> B >> C >> D;
		if (A < B) printf("No\n");
		else if (D < B) printf("No\n");
		else if (C >= B) printf("Yes\n");
		else {
			ll g = gcd(B, D);
			ll k = (A - C + B - 1) / g;
			if (A - C - k * g < -C) printf("No\n");
			else printf("Yes\n");
		}
	}
	return 0;
}