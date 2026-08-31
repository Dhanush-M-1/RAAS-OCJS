#include<bits/stdc++.h>
#define pb emplace_back
#define AI(i) begin(i), end(i)
using namespace std;
using ll = long long;
template<class T>
bool chmax(T &val, T nv) { return val < nv ? (val = nv, true) : false; }
template<class T>
bool chmin(T &val, T nv) { return nv < val ? (val = nv, true) : false; }
#ifdef KEV
#define DE(args...) kout("[ " + string(#args) + " ] = ", args)
void kout() {cerr << endl;}
template<class T1, class ...T2>
void kout (T1 v, T2 ...e) { cerr << v << ' ', kout(e...); }
template<class T>
void debug(T L, T R) { while (L != R) cerr << *L << " \n"[next(L)==R], ++L; }
#else
#define DE(...) 0
#define debug(...) 0
#endif
// What I should check
// 1. overflow
// 2. corner cases
// Enjoy the problem instead of hurrying to AC
// Good luck !
const int MAX_N = 500010, p = 1e9 + 7;
int n, m;
vector<vector<int>> vs;
struct dsu {
	vector<int> g, sz, mxv;
	dsu() {}
	dsu(int n) { g.resize(n+1), sz.resize(n+1, 1), mxv.resize(n+1), iota(AI(g), 0), iota(AI(mxv), 0); }
	int F(int i) { return i == g[i] ? i : g[i] = F(g[i]); }
	bool M(int a, int b) {
		a = F(a), b = F(b);
		if (a == b) return false;
		if (sz[a] < sz[b]) swap(a, b);
		return g[b] = a, sz[a] += sz[b], chmax(mxv[a], mxv[b]), true;
	}
	int operator()(int i) { return F(i); }
};
ll bin_pow(ll v, ll t) {
	ll res = 1;
	for (;t;t>>=1, v = v * v % p)
		if (t&1) res = res * v % p;
	return res;
}

int pa[MAX_N];
int getpa(int i) { return i == pa[i] ? i : pa[i] = getpa(pa[i]); }
int32_t main() {
	ios_base::sync_with_stdio(0), cin.tie(0);
	cin >> n >> m;
	vs.resize(n);
	for (auto &v : vs) {
		int len;
		cin >> len;
		v.resize(len);
		for (auto &x : v) cin >> x;
		sort(AI(v));
	}

	iota(pa, pa+m+5, 0);

	vector<int> res;

	int bad = m + 2;

	for (int i = 0;i < n;++i) {
		auto &vec = vs[i];
		for (int &u : vec) u = getpa(u);
		sort(AI(vec));
		while (vec.size() && vec.back() == bad) vec.pop_back();

		if (vec.empty() || (vec.size() == 2 && vec[0] == vec[1])) continue;
		if (vec.size() == 1) 
			pa[vec[0]] = bad;
		else 
			pa[vec[0]] = vec[1];
		res.pb(i);
	}

//	for (int i = 0;i < n;++i) {
//		if (vs[i].size() > 1) D.M(vs[i][0], vs[i][1]);
//	}
//
//	{
//		vector<vector<int>> lisan(m + 1);
//		for (int i = 0;i < n;++i) {
//			auto &vec = lisan[ D(vs[i][0]) ];
//			vec.insert(end(vec), AI(vs[i]));
//		}
//		for (auto &vec : lisan) sort(AI(vec)), vec.resize(unique(AI(vec)) - begin(vec));
//
//		for (int i = 0;i < n;++i) {
//			auto &vec = lisan[ D(vs[i][0]) ];
//			for (auto &u : vs[i]) u = lower_bound(AI(vec), u) - begin(vec);
//		}
//	}
//	// lisan is done
//	//
//	// then I need to calculate thing
//	vector<int> res;
//
//	vector<dsu> DS(m+1);
//	for (int i = 0;i < n;++i) {
//	}

	cout << bin_pow(2, res.size()) << ' ' << res.size() << '\n';
	for (int u : res) cout << u+1 << " \n"[u==res.back()];

}
