#include<bits/stdc++.h>
using namespace std;

#define  all(x)        (x).begin(),(x).end()
#define  pb            push_back
#define  lb            lower_bound
#define  ub            upper_bound
#define  fi            first
#define  se            second
#define  pii           pair<int,int>
#define  fastIO        ios_base::sync_with_stdio(false); cin.tie(NULL);
#define  mp            make_pair
#define endl '\n'
#define int long long

typedef double db;
typedef long long ll;

const int N = 2e5 + 5;
const int MOD = 1e9 + 7;
const int INF = 1e9;

void solve() {

	int k, n, m; cin >> k >> n >> m;
	vector<int> a(n), b(m);
	for (int i = 0; i < n; i++) cin >> a[i];
	for (int i = 0; i < m; i++) cin >> b[i];

	int i = 0, j = 0;
	vector<int> res;

	while (i < n && j < m) {

		if (a[i] == 0 || a[i] <= k) {
			res.pb(a[i]);
			if (a[i] == 0) ++k;
			++i;
		}
		else if (b[j] == 0 || b[j] <= k) {
			res.pb(b[j]);
			if (b[j] == 0) ++k;
			++j;
		}
		else {
			cout << -1 << endl;
			return;
		}
	}

	while (i < n) {
		if (a[i] == 0 || a[i] <= k) {
			res.pb(a[i]);
			if (a[i] == 0) ++k;
			++i;
		}
		else {
			cout << -1 << endl;
			return;
		}
	}

	while (j < m) {
		if (b[j] == 0 || b[j] <= k) {
			res.pb(b[j]);
			if (b[j] == 0) ++k;
			++j;
		}
		else {
			cout << -1 << endl;
			return;
		}
	}

	for (int x : res) cout << x << " ";
	cout << endl;
}

signed main() {

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	fastIO

	int t = 1;
	cin >> t;

	for (int tt = 1; tt <= t; tt++) {
		solve();
	}
}