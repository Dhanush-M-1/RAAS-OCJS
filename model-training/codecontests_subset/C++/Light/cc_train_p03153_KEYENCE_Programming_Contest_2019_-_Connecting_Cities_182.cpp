#include <bits/stdc++.h>
using namespace std;

#define INF_LL (int64)1e18
#define INF (int32)1e9
#define REP(i, n) for(int64 i = 0;i < (n);i++)
#define FOR(i, a, b) for(int64 i = (a);i < (b);i++)
#define all(x) x.begin(),x.end()
#define fs first
#define sc second

using int32 = int_fast32_t;
using uint32 = uint_fast32_t;
using int64 = int_fast64_t;
using uint64 = uint_fast64_t;
using PII = pair<int32, int32>;
using PLL = pair<int64, int64>;

const double eps = 1e-10;

template<typename A, typename B>inline void chmin(A &a, B b){if(a > b) a = b;}
template<typename A, typename B>inline void chmax(A &a, B b){if(a < b) a = b;}

class UnionFind{
private:
	::std::vector<int_fast32_t> par;
	size_t n;

public:
	UnionFind(){}
	UnionFind(size_t n):n(n){
		par.resize(n, -1);
	}

	uint_fast32_t find(uint_fast32_t x){
		return par[x] < 0 ? x : par[x] = find(par[x]);
	}

	size_t size(uint_fast32_t x){
		return -par[find(x)];
	}

	bool unite(uint_fast32_t x, uint_fast32_t y){
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(size(x) < size(y)) std::swap(x, y);
		par[x] += par[y];
		par[y] = x;
		return true;
	}

	bool same(uint_fast32_t x, uint_fast32_t y){
		return find(x) == find(y);
	}
};


int64 N, D;
vector<int64> A, ed;
vector<PII> e;

UnionFind uf;

void dfs(int64 l, int64 r){
	if(r-l == 1) return;
	int64 lmin = INF_LL, lidx = -1;
	int64 rmin = INF_LL, ridx = -1;
	int32 m = (l+r)/2;
	FOR(i, l, m){ if (lmin > A[i]-i*D) { lmin = A[i]-i*D; lidx = i; } }
	FOR(i, m, r){ if (rmin > A[i]+i*D) { rmin = A[i]+i*D; ridx = i; } }
	FOR(i, l, m){ e.emplace_back(i, ridx); ed.emplace_back(rmin+(A[i]-i*D));}
	FOR(i, m, r){ e.emplace_back(lidx, i); ed.emplace_back(lmin+(A[i]+i*D));}
	dfs(l, m); dfs(m, r);
}

int main(void){
	cin >> N >> D;
	A.resize(N);
	uf = UnionFind(N);
	REP(i, N) cin >> A[i];
	dfs(0, N);
	vector<int64> ord(ed.size()); iota(all(ord), 0);
	sort(all(ord), [&](int64 l, int64 r){
			return ed[l] < ed[r];
		});
	int64 res = 0;
	REP(i, e.size()){
		int64 idx = ord[i];
		if(uf.unite(e[idx].fs, e[idx].sc)) res += ed[idx];
	}
	cout << res << endl;
}


