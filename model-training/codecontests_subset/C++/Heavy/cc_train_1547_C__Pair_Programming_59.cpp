#include <iostream>
#include <iomanip>
#include <algorithm>
#include <cmath>
#include <vector>
#include <string>
#include <cstring>
#include <set>
#include <map>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <deque>
#include <random>
#include <climits>
#include <cstdio>

using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair <ll, ll> pll;
typedef vector <ll> vec;
typedef vector <bool> vecb;
typedef vector <char> vecc;
typedef vector <pll> vecpll;
typedef vector <vec> matrix;
typedef vector <vecpll> matrixpll;
#define fast_io ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0)
#define fixed_out(a) fixed << setprecision(a)
#define rep(i, n) for (ll i = 0; i < n; ++i)
#define rep1(i, n) for (ll i = 1; i < n; ++i)
#define repv1(i, n) for (ll i = 1; i <= n; ++i)
#define repb(i, n) for (ll i = n - 1; i >= 0; --i)
#define rsz resize
#define sz(a) (ll)(a.size())
#define val(a) a.begin(), a.end()
#define pf push_front
#define pb push_back
#define pob pop_back
#define pof pop_front
#define f first
#define s second
#define en '\n'
const ld PI = 3.14159265358979323846;
const ld EPS = 0.0000000000001;
const ll MD_7 = 1000000007;
const ll MD_9 = 1000000009;
const ll MD = 228228227;
const ll INF = INT64_MAX;

void solve() {
	ll k, n, m; cin >> k >> n >> m;
	vec a(n), b(m), rs;
	rep(i, n) cin >> a[i];
	rep(i, m) cin >> b[i];
	ll fit = 0, sit = 0;
	while (fit < n || sit < m) {
		if (fit < n && a[fit] == 0) { ++k; rs.pb(0); ++fit; }
		else if (sit < m && b[sit] == 0) { ++k; rs.pb(0); ++sit; }
		else if (fit == n || (sit != m && a[fit] > b[sit])) {
			if (b[sit] <= k)
				rs.pb(b[sit++]);
			else {
				cout << -1 << en;
				return;
			}
		}
		else if (a[fit] <= k)
			rs.pb(a[fit++]);
		else {
			cout << -1 << en;
			return;
		}
	}
	for (auto el : rs) cout << el << ' ';
	cout << en;
}

int main() {
	fast_io;
	ll t; cin >> t;
	while (t--)
		solve();
	return 0;
}

/**/