#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int MOD = 1e9 + 7;

class DSU {
private:
	vector <int> par, sz;
	int n;
	
public:
	DSU(int _n) : n(_n) {
		sz.assign(n + 1, 1);
		par.assign(n + 1, 0);
		iota(par.begin(), par.end(), 0);
	}	
	
	int find_parent(int a) {
		if(a == par[a]) return a;
		return par[a] = find_parent(par[a]);
	}
	
	bool union_sets(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		
		if(a != b) {
			par[b] = a;
			sz[a] += sz[b];
           	return 1;
		}
        	return 0;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(0);
	int n, m;
	cin >> n >> m;

	DSU dsu(m + 1);
	vector <int> ans;

	int res = 1;
	for(int i = 1; i <= n; i++) {
		int k;
		cin >> k;

		int a, b;
		cin >> a;
		if(k > 1) cin >> b;
		else b = m + 1;

		if(dsu.union_sets(a, b)) {
			res = (2LL * res) % MOD;
			ans.push_back(i);
		}
	}

	cout << res << ' ' << ans.size() << '\n';
	for(int &x : ans) {
		cout << x << ' ';
	}
}