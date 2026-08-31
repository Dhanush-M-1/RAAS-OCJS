#include "bits/stdc++.h"
using namespace std;
#define sim template < class c
#define ris return * this
#define dor > debug & operator <<
#define eni(x) sim > typename \
  enable_if<sizeof dud<c>(0) x 1, debug&>::type operator<<(c i) {
sim > struct rge { c b, e; };
sim > rge<c> range(c i, c j) { return rge<c> {i, j}; }
sim > auto dud(c* x) -> decltype(cerr << *x, 0);
sim > char dud(...);
struct debug {
#ifdef LOCAL
	~debug() { cerr << endl; }
	eni( != ) cerr << boolalpha << i; ris;
}
eni( == ) ris << range(begin(i), end(i));
}
sim, class b dor(pair < b, c > d) {
	ris << "(" << d.first << ", " << d.second << ")";
}
sim dor(rge<c> d) {
	*this << "[";
	for (auto it = d.b; it != d.e; ++it)
		*this << ", " + 2 * (it == d.b) << *it;
	ris << "]";
}
#else
	sim dor(const c&) { ris; }
#endif
};
#define imie(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
#define int long long
const int mod = 1e9 + 7;
struct DSU {
	vector<int> par;
	DSU(int n) {
		par.resize(n + 1);
		for (int i = 1; i <= n; i++) {
			par[i] = i;
		}
	}
	int find(int a) {
		if (a == par[a])
			return a;
		return par[a] = find(par[a]); //set parent to every node in the path to the root (path compression)
	}
	bool join(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		par[a] = b;
		return true;
	}
};

int binexp(int a, int b) {
	int ress = 1;
	while (b > 0) {
		if (b & 1) {
			ress = ress * a % mod;
		}

		a = a * a % mod;
		b >>= 1;
	}
	return ress;
}
int32_t main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n, m;
	cin >> n >> m;
	DSU dsu(m + 1);
	vector<int>ans;
	for (int i = 0; i < n; i++) {
		int k;
		cin >> k;
		int v1;
		cin >> v1;
		int v2;
		if (k  == 2) {
			cin >> v2;
		}
		else {
			v2 = m + 1;
		}
		if (dsu.join(v1, v2)) {
			ans.push_back(i + 1);
		}
	}

	int t = binexp(2, ans.size());
	cout << t << " " << ans.size() << endl;
	for (auto it : ans) {
		cout << it << " ";
	}
	cout << endl;
}