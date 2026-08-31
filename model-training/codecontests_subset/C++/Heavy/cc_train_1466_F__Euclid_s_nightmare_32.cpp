#include<bits/stdc++.h>

#define fi first
#define se second
#define mp make_pair
#define em emplace
#define eb emplace_back
#define pb pop_back
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()

using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;

mt19937 rnd(chrono::steady_clock::now().time_since_epoch().count());

const int N = 5e5 + 5, MOD = 1e9 + 7;

int mul(int x, int y) {
	return 1ll * x * y % MOD;
}

int n, m;
int p[N];

int get(int x) {
	return x == p[x] ? x : p[x] = get(p[x]);
}

bool unite(int x, int y) {
	x = get(x);
	y = get(y);
	if (x == y) {
		return false;
	}
	p[y] = x;
	return true;
}

int32_t main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i <= m; ++i) {
		p[i] = i;
	}
	int ans = 1;
	vector<int> answ;
	for (int i = 1; i <= n; ++i) {
		int k, x, y = 0;
		cin >> k >> x;
		if (k == 2) {
			cin >> y;
		}
		if (unite(x, y)) {
			ans = mul(ans, 2);
			answ.eb(i);
		}
	}
	cout << ans << " " << sz(answ) << "\n";
	sort(all(answ));
	for (int x : answ) {
		cout << x << " ";
	}
	cout << "\n";
	return 0;
}