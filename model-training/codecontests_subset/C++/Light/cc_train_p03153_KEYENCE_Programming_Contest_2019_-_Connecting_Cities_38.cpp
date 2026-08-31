// Code by Denverjin.
#include <bits/stdc++.h>
using namespace std;

using ld = double;
using ll = long long;
using ull = unsigned long long;
const int INF = 1 << 30;
const ll LINF = 1LL << 60;

const int SZ = 1 << 13;
char buff[SZ], *pos = buff + SZ - 1;
#define getchar() (++ pos == buff + SZ ? fread(pos = buff, 1, SZ, stdin), *pos : *pos)

inline ll read() {
	ll x = 0; int f = 1, c = getchar();
	for (;!isdigit(c); c = getchar()) if (c == '-') f = -f;
	for (; isdigit(c); c = getchar()) x = (x<<3) + (x<<1) + (c^48);
	return x * f;
}

const int N = 1 << 20;
int n, D;
ll dpL[N], dpR[N];
ll a[N];

int main() {
	n = read(), D = read();
	for (int i = 0; i < n; ++ i) a[i] = read();
	dpL[0] = a[0];
	for (int i = 1; i < n; ++ i) dpL[i] = min(a[i], dpL[i - 1] + D);
	dpR[n - 1] = a[n - 1];
	for (int i = n - 2; ~i; -- i) dpR[i] = min(a[i], dpR[i + 1] + D);
	ll res = 1LL * D * (n - 1);
	for (int i = 0; i < n; ++ i) res += a[i];
	for (int i = 1; i < n - 1; ++ i) res += min(dpL[i], dpR[i]);
	printf("%lld\n", res);
	return 0;
}
