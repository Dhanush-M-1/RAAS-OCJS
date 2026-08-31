#pragma GCC optimize ("O3")
#pragma GCC target ("avx")
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define rep(i, n) for(int i = 0; i < (n); i++)
#define rep1(i, n) for(int i = 1; i <= (n); i++)
#define co(x) cout << (x) << "\n"
#define cosp(x) cout << (x) << " "
#define ce(x) cerr << (x) << "\n"
#define cesp(x) cerr << (x) << " "
#define pb push_back
#define mp make_pair
#define chmin(x, y) x = min(x, y)
#define chmax(x, y) x = max(x, y)
#define Would
#define you
#define please


int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);


	ll X, K;
	cin >> X >> K;
	int r[100002];
	rep1(i, K) cin >> r[i];
	r[0] = 0;
	r[K + 1] = 2e9;

	ll L = 0;
	ll R = X;
	ll takasa = 0;
	int katamuki = -1;
	int *ri = r + 1;

	int Q;
	cin >> Q;
	rep(i, Q) {
		ll t, a;
		cin >> t >> a;
		
		while (t > *ri) {
			takasa += katamuki * (*ri - *(ri - 1));
			ll nl = takasa + L;
			ll nr = takasa + R;
			if (katamuki < 0) {
				if (nl < 0) L -= nl;
				if (nr < 0) R -= nr;
			}
			else {
				if (nl > X) L -= nl - X;
				if (nr > X) R -= nr - X;
			}
			ri++;
			katamuki *= -1;
		}

		chmax(a, L);
		chmin(a, R);
		a += takasa + katamuki * (t - *(ri - 1));
		chmax(a, 0ll);
		chmin(a, X);
		co(a);
	}

	Would you please return 0;
}