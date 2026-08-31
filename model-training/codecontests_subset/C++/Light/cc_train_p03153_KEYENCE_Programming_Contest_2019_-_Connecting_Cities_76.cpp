//https://atcoder.jp/contests/keyence2019/tasks/keyence2019_e 
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
struct Dsu {
	int par[MAXN];
	Dsu() {
		rep (i, 1, MAXN - 1) {
			par[i] = i;
		}
	}
	inline int find(int x) {
		return x == par[x] ? x : par[x] = find(par[x]);
	}
	inline void mry(int a, int b) {
		par[find(a)] = find(b);
	}
	inline bool tog(int a, int b) {
		return find(a) == find(b);
	}
}	dsu;
ll A[MAXN], n, d;
vector<pair<ll,pii> > edge;
inline void solve(int l, int r) {
	if (l == r) return;
	int m = (l + r) >> 1;
	ll ml = 1e18, li = 0;
	rep (i, l, m) {
		if (ml > A[i] - i * d) {
			ml = A[i] - i * d;
			li = i;
		}
	}
	ll mr = 1e18, ri = 0;
	rep (i, m + 1, r) {
		if (mr > A[i] + i * d) {
			mr = A[i] + i * d;
			ri = i;
		}
	}
	rep (i, l, m) {
		edge.pb(mp(A[i] - i * d + mr,mp(i, ri)));
	}
	rep (i, m + 1, r) {
		edge.pb(mp(A[i] + i * d + ml,mp(i, li)));
	}
	solve(l, m);
	solve(m + 1, r);
}
int main() {
	cin >> n >> d;
	rep (i, 1, n) {
		cin >> A[i];
	}
	solve(1, n);
	sort(all(edge));
	ll ans = 0;
	for (auto e : edge) {
	//	cerr << e.sed.fst << ' ' << e.sed.sed <<endl;
		if (!dsu.tog(e.sed.fst, e.sed.sed)) {
			ans += e.fst;
			dsu.mry(e.sed.fst, e.sed.sed);
		}
	}
	cout << ans << endl;
	return 0;
}