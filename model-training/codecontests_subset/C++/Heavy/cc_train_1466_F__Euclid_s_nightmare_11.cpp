#include <bits/stdc++.h>

using namespace std;

#define debbuging false
#define _ if(!debbuging) ios_base::sync_with_stdio(0);cin.tie(0);
#define debug if(debbuging) cout
#define endl '\n'

typedef long long ll;
typedef tuple<int,int,int> t3;

const int INF = 0x3f3f3f3f;
const ll LINF = 0x3f3f3f3f3f3f3f3fll;

const int MOD = 1e9 + 7;

struct dsu {
	vector<int> id, sz;
	dsu(int sz_) : id(sz_), sz(sz_,1) { iota(id.begin(), id.end(),0); }

	int find(int a) { return id[a] = a == id[a] ? a : find(id[a]); }

	void unite(int a, int b) {
		a = find(a), b = find(b);
		if(a == b) return;
		if(sz[a] < sz[b]) swap(a,b);
		sz[a] += sz[b];
		id[b] = a;
	}
};

int main(){ _

	int n, m; cin >> n >> m;
	vector<vector<int>> g(m+1);
	vector<t3> edg;
	for(int i = 0; i < n; i++) {
		int k; cin >> k;
		if(k == 1) {
			int a; cin >> a; a--;
			g[m].push_back(a);
			g[a].push_back(m);
			edg.push_back({i,a,m});
		}
		else {
			int a, b; cin >> a >> b; a--, b--;
			g[a].push_back(b);
			g[b].push_back(a);
			edg.push_back({i,a,b});
		}
	}

	vector<int> vans;
	sort(edg.begin(), edg.end());
	dsu dsu(m+1);
	for(auto [id,a,b] : edg) if(dsu.find(a) != dsu.find(b)) {
		vans.push_back(id);
		dsu.unite(a,b);
	}

	vector<ll> p2(m+1);
	ll p = 1;
	for(int i = 0; i <= m; i++) p2[i] = p, p = (p * 2) % MOD;

	cout << p2[vans.size()] << ' ' << vans.size() << endl;
	sort(vans.begin(), vans.end());
	for(auto u : vans) cout << u + 1 << ' ';
	cout << endl;

	return 0;
}