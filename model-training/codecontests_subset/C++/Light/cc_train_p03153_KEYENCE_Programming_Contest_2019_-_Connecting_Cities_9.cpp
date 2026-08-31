#ifndef BZ
#pragma GCC optimize "-O3"
#endif
#include <bits/stdc++.h>

#define FASTIO
#define ALL(v) (v).begin(), (v).end()
#define rep(i, l, r) for (int i = (l); i < (r); ++i)

#ifdef FASTIO
#define scanf abacaba
#define printf abacaba
#endif

typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;

using namespace std;


/*
ll pw(ll a, ll b) {
	ll ans = 1; while (b) {
		while (!(b & 1)) b >>= 1, a = (a * a) % MOD;
		ans = (ans * a) % MOD, --b;
	} return ans;
}
*/

const int MAXN = 210000;

ll d;

int n;

ll a[MAXN];

int main() {
#ifdef FASTIO
	ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
#endif
	cin >> n >> d;
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	vector<pair<ll, int>> vv;
	for (int i = 1; i < n; ++i) {
		ll x = a[i] + d * i;
		while (!vv.empty() && vv.back().first >= x)
			vv.pop_back();
		vv.emplace_back(x, i);
	}
	int now = 1;
	ll bst = a[0];
	ll ans = 0;
	for (int i = 0; i < vv.size(); ++i) {
		int nw = vv[i].second;
		ans += vv[i].first + bst;
		for (int j = now; j < nw; ++j) {
			ans += a[j] + min(vv[i].first - j * d, bst + j * d);
			bst = min(bst, a[j] - j * d);
		}
		bst = min(bst, a[nw] - nw * d);
		now = nw + 1;
	}
	cout << ans << "\n";
	return 0;
}


