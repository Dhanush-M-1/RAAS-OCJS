#include "bits/stdc++.h"
using namespace std;
#ifdef _DEBUG
#include "dump.hpp"
#else
#define dump(...)
#endif

#define int long long
#define rep(i,a,b) for(int i=(a);i<(b);i++)
#define rrep(i,a,b) for(int i=(b)-1;i>=(a);i--)
#define all(c) begin(c),end(c)
const int INF = sizeof(int) == sizeof(long long) ? 0x3f3f3f3f3f3f3f3fLL : 0x3f3f3f3f;
const int MOD = (int)(1e9) + 7;
template<class T> bool chmax(T &a, const T &b) { if (a < b) { a = b; return true; } return false; }
template<class T> bool chmin(T &a, const T &b) { if (b < a) { a = b; return true; } return false; }

#define EPS 1e-8
struct MinimumCostFlow {
	using Flow = int;
	using Cost = double;
	const Cost kInfCost = INF;
	struct Edge {
		int to, rev;
		Flow cap;
		Cost cost;
		Edge() {}
		Edge(int to, int rev, Flow cap, Cost cost) :to(to), rev(rev), cap(cap), cost(cost) {}
	};
	int n;
	vector<vector<Edge>> g;
	vector<Cost> dist;
	vector<int> prevv, preve;
	MinimumCostFlow(int n) :n(n), g(n), dist(n), prevv(n), preve(n) {}
	void addArc(int from, int to, Flow cap, Cost cost) {
		g[from].emplace_back(to, (int)g[to].size(), cap, cost);
		g[to].emplace_back(from, (int)g[from].size() - 1, Flow(), -cost);
	}
	// s??????t????????????f???????°??????¨???
	// ??????????????´?????? kInfCost
	Cost minimumCostFlow(int s, int t, Flow f) {
		Cost total = Cost();
		while (f > 0) {
			// Bellman-Ford
			fill(dist.begin(), dist.end(), kInfCost);
			dist[s] = 0;
			bool update = true;
			while (update) {
				update = false;
				for (int v = 0; v < n; v++) {
					if (dist[v] == kInfCost)continue;
					for (int i = 0; i < g[v].size(); i++) {
						Edge &e = g[v][i];
						if (e.cap > Flow() && dist[e.to] > EPS + dist[v] + e.cost) {
							dist[e.to] = dist[v] + e.cost;
							prevv[e.to] = v;
							preve[e.to] = i;
							update = true;
						}
					}
				}
			}
			// ????????\???????????????
			if (dist[t] == kInfCost)
				return kInfCost;
			// ?????????????????£??????????????????
			Flow d = f;
			for (int v = t; v != s; v = prevv[v])
				d = min(d, g[prevv[v]][preve[v]].cap);
			f -= d;
			total += dist[t] * d;
			for (int v = t; v != s; v = prevv[v]) {
				Edge &e = g[prevv[v]][preve[v]];
				e.cap -= d;
				g[v][e.rev].cap += d;
			}
		}
		return total;
	}
};

// ??¬??????????¶???????, Gauss elimination
// O(n^3)
// ???????¶????, forward elimination
// ????????£??\, back substitution

using Num = double;
using Vec = vector<Num>;
using Mat = vector<Vec>;
Vec gaussianElimination(Mat A, Vec b) {
	const int n = A.size(), m = A[0].size();
	int pi = 0, pj = 0;
	while (pi < n && pj < m) {
		for (int i = pi + 1; i < n; i++)
			if (abs(A[i][pj]) > abs(A[pi][pj]))
				A[i].swap(A[pi]), swap(b[i], b[pi]);
		if (abs(A[pi][pj]) > 0) {
			Num d = A[pi][pj];
			for (int j = 0; j < m; j++)
				A[pi][j] /= d;
			b[pi] /= d;
			for (int i = pi + 1; i < n; i++) {
				Num k = A[i][pj];
				for (int j = 0; j < m; j++)
					A[i][j] -= k * A[pi][j];
				b[i] -= k * b[pi];
			}
			pi++;
		}
		pj++;
	}
	for (int i = pi; i < n; i++)
		if (abs(b[i]) > 0)
			return Vec();
	if (pi < m || pj < m)
		return Vec();
	for (int j = m - 1; j >= 0; j--)
		for (int i = 0; i < j; i++)
			b[i] -= b[j] * A[i][j];
	return b;
}

signed main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	int T; cin >> T;
	cout << fixed << setprecision(10);
	while (T--) {
		int N, s, t, F; cin >> N >> s >> t >> F;
		MinimumCostFlow mcf(N);
		Mat a(N, Vec(N));
		Vec c(N);
		rep(i, 0, N) rep(j, 0, N + 1) {
			if (j == N)cin >> c[i];
			else cin >> a[i][j];
		}
		Vec x = gaussianElimination(a, c);
		dump(x);
		rep(i, 0, N) {
			int M; cin >> M;
			vector<int> d(M); rep(j, 0, M) {
				cin >> d[j];
			}
			vector<int> f(M); rep(j, 0, M) {
				cin >> f[j];
			}
			rep(j, 0, M) {
				mcf.addArc(i, d[j], f[j], abs(x[i] - x[d[j]]));
			}
		}
		auto res = mcf.minimumCostFlow(s, t, F);
		if (res == INF)
			cout << "impossible" << endl;
		else
			cout << res << endl;
	}
	return 0;
}