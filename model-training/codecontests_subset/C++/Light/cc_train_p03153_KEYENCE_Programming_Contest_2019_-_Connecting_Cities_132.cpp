#include <bits/stdc++.h>
using namespace std;
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n) FOR(i,0,n)
#define ALL(v) begin(v),end(v)
#define fi first
#define se second
template<typename A, typename B> inline bool chmax(A &a, B b) { if (a<b) { a=b; return 1; } return 0; }
template<typename A, typename B> inline bool chmin(A &a, B b) { if (a>b) { a=b; return 1; } return 0; }
using ll = long long;
using pii = pair<int, int>;
constexpr ll INF = 1ll<<30;
constexpr ll longINF = 1ll<<60;
constexpr ll MOD = 1000000007;
constexpr bool debug = 0;
//---------------------------------//

struct UnionFind {
	vector<int> par, rank;
	
	UnionFind(int n) {
		par.resize(n);
		rank.resize(n);
		REP(i, n) {
		 par[i] = i;
		 rank[i] = 0;
		}
	}
	
	int operator[] (int x) {
		return find(x);
	}
	
	int find(int x) {
		if (x == par[x]) return x;
		return par[x] = find(par[x]);
	}
	
	void unite(int x, int y) {
		x = find(x); y = find(y);
		if (x == y) return;
		
		if (rank[x] < rank[y]) swap(x, y);
		
		par[y] = x;
		if (rank[x] == rank[y]) rank[x]++;
	}
	
	bool same(int x, int y) {
		return find(x) == find(y);
	}
	
};


using pll = pair<ll, ll>;
using ll3 = tuple<ll, ll, ll>;
int N, D;
vector<int> A;

void dfs(int l, int r, vector<ll3> &edge) {
	if (r - l <= 1) return;
	int m = (l + r) / 2;
	
	pll mn(longINF, -1);
	FOR(i, m, r) chmin(mn, pll(A[i] + (ll)i * D, i));
	FOR(i, l, m) edge.emplace_back(A[i] - (ll)i * D + mn.fi, i, mn.se);
	
	mn = pll(longINF, -1);
	FOR(i, l, m) chmin(mn, pll(A[i] - (ll)i * D, i));
	FOR(i, m, r) edge.emplace_back(A[i] + (ll)i * D + mn.fi, i, mn.se);
	
	dfs(l, m, edge);
	dfs(m, r, edge);
}

int main() {
	cin >> N >> D;
	A.resize(N);
	REP(i, N) scanf("%d", &A[i]);
	
	vector<ll3> edge;
	dfs(0, N, edge);
	sort(ALL(edge));
	
	UnionFind uf(N);
	ll ans = 0;
	for (ll3 &cur : edge) {
		ll cost, x, y;
		tie(cost, x, y) = cur;
		if (uf.same(x, y)) continue;
		uf.unite(x, y);
		ans += cost;
	}
	
	cout << ans << endl;
}