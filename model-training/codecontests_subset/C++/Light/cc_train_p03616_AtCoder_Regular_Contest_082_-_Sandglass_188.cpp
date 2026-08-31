#include<bits/stdc++.h>
typedef long long ll ;
#define rep(i, a, b) for (int i = a; i <= b; ++i)
using namespace std;
template <typename tn> void read (tn & a) {
	tn x = 0, f = 1; char c = getchar();
	while (c < '0' || c > '9') { if (c == '-') f = 0; c = getchar(); }
	while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
	a = f ? x : -x;
}
const int MAXN = 1e5 + 10;
int x, k, q;
int r[MAXN];
int sign, kx;
void calc (ll &k) {
	if(k < 0) k = 0;
	if(k > x) k = x;
}


int main () {
//	freopen("in.txt","r",stdin);
	read(x);
	read(k);
	rep(i, 1, k) read(r[i]);
	read(q);
	ll L = 0, R = x, kx = 1, m = 0;
	sign = -1;
	rep(i, 1, q) {
		int a, t;
		read(t);
		read(a);
		while (kx <= k && r[kx] <= t) {
			ll vx = (r[kx] - r[kx - 1]) * sign;
			R += vx;
			L += vx;
			m += vx;
			calc(R);
			calc(m);
			++kx;
			sign = -sign;
		}
		ll an = a + L;
		ll hh = (t - r[kx - 1]) * sign;
//		cerr<<" ]  "<<kx<<" "<<i<<" "<<t<<" "<<r[kx - 1]<<"\n";
		if (an < m) an = m;
		if (an > R) an = R;
		an += hh;
		calc(an);
//		cerr<<"! "<<kx<<" "<<L<<" "<<R<<" "<<m<<" "<<hh<<"\n";
		printf("%lld\n", an);
	}
	
	return 0;
}