#include <bits/stdc++.h>
using namespace std;
//#pragma GCC optimize("Ofast")
typedef long long ll;
typedef pair<ll, ll> pll;
typedef pair<int, int> pii;
typedef unsigned long long ull;
#define fst first
#define sed second
#define pb push_back
#define mp make_pair
#define rt register int
#define all(it) it.begin(), it.end()
#define rep(it, f, e) for (rt it = f; it <= e; ++it)
#define per(it, f, e) for (rt it = f; it >= e; --it)
const int MAXN = 2e5 + 10;
int A[MAXN];
ll dpl[MAXN], dpr[MAXN];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);
	int n, d;
	cin >> n >> d;
	ll ans = (n - 1ll) * d;
	rep (i, 1, n) {
		cin >> A[i];
		ans += A[i];
	}
	if (n == 1) {
		cout << 0 << endl;
		return 0;
	}
	dpl[1] = A[1];
	rep (i, 2, n) {
		dpl[i] = min((ll)A[i], dpl[i - 1] + d);
	}
	dpr[n] = A[n];
	per (i, n - 1, 1) {
		dpr[i] = min((ll)A[i], dpr[i + 1] + d);
	}
	rep (i, 2, n - 1) {
		ans += min(dpl[i], dpr[i]);
	}
	cout << ans <<endl;
	return 0;
}
