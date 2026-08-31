#include<bits/stdc++.h>
using namespace std;
template <class T> ostream &operator << (ostream &os, const vector<T> &p) { os << "["; for (auto&it : p) os << it << " "; return os << "]";}
template <class S, class T> ostream &operator << (ostream &os, const pair<S, T> &p) { return os << "(" << p.first << "," << p.second << ")";}
#ifndef ONLINE_JUDGE
#define deb(...) dbs(#__VA_ARGS__,__VA_ARGS__)
template <class T> void dbs(string str, T t) { cerr << str << ":" << t << "\n";}
template<class T, class...S> void dbs(string str, T t, S... s) { int idx = str.find(','); cerr << str.substr(0, idx) << ":" << t << ","; dbs(str.substr(idx + 1), s...);}
#else
#define deb(...){}
#endif
#define int long long
#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define rep(i,n) for(int i = 0; i < n; i++)
#define sz(x) (int)x.size()
#define nl cout<< '\n'
#define pr(x) {cout << x << "\n"; return;}
#define all(x) x.begin(), x.end()
#define re(i,n) for(int i = 1; i <= n; i++)
#define prl(x) {cout << x << "\n";}
#define ini(x, y) memset(x, y, sizeof(x))
#define fr(i,a,b) for(int i = a; i <= b; i++)
#define fb(i,a,b) for(int i = a; i >= b; i--)
#define vi vector<int>
#define pii pair<int, int>
#define vii vector<pii>
template<class T> bool umin(T &a, T b) { return a > b ? (a = b, true) : false; }
template<class T> bool umax(T &a, T b) { return a < b ? (a = b, true) : false; }

void solve() {
	int n, q; cin >> n >> q;
	vi a(n);
	int mx = -1e18, sum = 0;
	vii v;
	map<int, int> m;
	rep(i, n) {
		int x; cin >> x;
		sum += x;
		a[i] = x;
		if (sum > mx) {
			mx = sum;
			m[sum] = i + 1;
		}
	}
	deb(v);
	while (q--) {
		int x; cin >> x;
		if (sum > 0) {
			int r = (x / sum) * n;
			int rem = x % sum;
			if (rem > 0) {
				auto pos = *m.lower_bound(rem);
				r += pos.se;
			}
			int ans = r;
			int l = 0, ri = 1e9;
			while (l <= ri) {
				int mid = (l + ri) / 2;
				int have = mid * sum;
				int rem = x - have;
				int r = mid * n;
				if (mx >= rem) {
					if (rem > 0) {
						auto pos = *m.lower_bound(rem);
						r += pos.se;
					}
					umin(ans, r);
					ri = mid - 1;
				} else l = mid + 1;
			}
			cout << ans - 1 << ' ';
		} else if (sum <= 0 && mx >= x) {
			int rem = x;
			auto pos = m.lower_bound(rem);
			auto it = *pos;
			deb(it);
			int r = it.se;
			cout << r - 1 << ' ';
		} else cout << "-1 ";
	}
	nl;



}
signed main() {
	ios_base::sync_with_stdio(false), cin.tie(nullptr);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	int q = 1;
	cin >> q;
	while (q--) solve();
	return 0;
}