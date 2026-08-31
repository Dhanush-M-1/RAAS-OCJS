#include<bits/stdc++.h>
using namespace std;

#define ll long long
#define pll pair<ll,ll>
ll inf = 4e18, mod = 1e9 + 7;

inline ll power(ll x, ll n, ll m = LLONG_MAX)
{
	ll res = 1; x = (x % m + m) % m;
	while (n)
	{	if (n & 1) res = (res * x) % m;
		x = (x * x) % m;  n >>= 1;
	}
	return res;
}

int dsu[500005], siz[500005];
vector<int> res;

void init() {
	for (int i = 0; i < 500005; i++) dsu[i] = i, siz[i] = 1;
}

int find_parent(int x) {
	return dsu[x] == x ? x : find_parent(dsu[x]);
}

void merge(int x, int y, int z) {
	x = find_parent(x);
	y = find_parent(y);
	if (x == y) return;

	if (siz[x] < siz[y]) swap(x, y);
	siz[x] += siz[y];
	dsu[y] = x;
	res.push_back(z);
}

void solve()  {
	int n, m;
	cin >> n >> m;
	init();

	set <pair<int, pair<int, int>>> s;

	for (int i = 1; i <= n; i++) {
		int k, x, y;
		cin >> k;
		if (k == 1) {
			cin >> x;
			s.insert({i, {0, x}});
		}
		else {
			cin >> x >> y;
			s.insert({i, {x, y}});
		}
	}

	while (!s.empty()) {
		auto it = s.begin();
		pair<int, pair<int, int>> p = *it;
		s.erase(it);
		merge(p.second.first, p.second.second, p.first);
	}

	cout << power(2, res.size(), mod) << " " << res.size() << endl;
	for (auto it : res)
		cout << it << " ";
	cout << endl;
}

int main()  {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int t = 1;
	while (t--) solve();
}