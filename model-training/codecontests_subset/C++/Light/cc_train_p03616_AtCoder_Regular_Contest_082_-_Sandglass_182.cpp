#include <iostream>
#include <cstdlib>
#include <cstdio>
using namespace std;
typedef bool boolean;

int X, n, q;
int *rs;
boolean down = true;

typedef class Data {
	public:
		int L, R;
		int low;

		Data() {	}

		void pass(int t, boolean down) {
			if (down) {
				L -= t, R -= t;
				if (L < 0)
					low += -L, L = 0, low = min(low, X);
				if (R < 0)
					R = 0;
			} else {
				L += t, R += t;
				if (R > X)
					R = X;
				if (L > X)
					low = X, L = X;
			}
		}

		int getVal(int v) {
			if (v < low)
				return L;
			if (v > low + R - L)
				return R;
			return L + v - low;
		}
}Data;

Data d;
inline void solve() {
	scanf("%d", &X);
	scanf("%d", &n);
	rs = new int[(n + 1)];
	for (int i = 1; i <= n; i++)
		scanf("%d", rs + i);
	scanf("%d", &q);
	
	int cur = 0, pr = 1, tc, tv;
	d.L = 0, d.R = X, d.low = 0;
	
	while (q--) {
		scanf("%d%d", &tc, &tv);
		while (pr <= n && rs[pr] <= tc) {
			d.pass(rs[pr] - cur, down);
			down = !down, cur = rs[pr], pr++;
		}
		d.pass(tc - cur, down), cur = tc;
		printf("%d\n", d.getVal(tv));
	}
}

int main() {
	solve();
	return 0;
}