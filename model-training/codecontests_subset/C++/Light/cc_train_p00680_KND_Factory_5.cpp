#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

using Array = vector<double>;
using vec = vector<double>;
using Matrix = vector<Array>;
using mat = vector<Array>;
const double eps = 1e-8;

vec gauss_jordan(const mat&A, const vec&b) {
	int n = A.size();
	mat B(n, vec(n + 1));
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)B[i][j] = A[i][j];
	for(int i = 0; i < n; i++)B[i][n] = b[i];
	for(int i = 0; i < n; i++) {
		int pivot = i;
		for(int j = i; j<n; j++)
			if(abs(B[j][i])>abs(B[pivot][i]))pivot = j;
		swap(B[i], B[pivot]);
		if(abs(B[i][i]) < 0.0000001)return vec();
		for(int j = i + 1; j <= n; j++)B[i][j] /= B[i][i];
		for(int j = 0; j < n; j++) {
			if(i != j)
				for(int k = i + 1; k <= n; k++)B[j][k] -= B[j][i] * B[i][k];
		}
	}
	vec x(n);
	for(int i = 0; i < n; i++)x[i] = B[i][n];
	return x;
}
const int MAX_V = 100010;
typedef int Capacity;
typedef double Cost;
const Cost inf = 1e9;

struct Edge {
	int dst;
	Capacity cap, cap_orig;
	Cost cost;
	int revEdge; bool isRev;
	Edge(int dst, Capacity cap, Cost cost, int revEdge, bool isRev)
		:dst(dst), cap(cap), cap_orig(cap), cost(cost), revEdge(revEdge), isRev(isRev) {
	}
};

struct PrimalDual {
	int n;
	vector<vector<Edge> > g;
	vector<int> top;
	PrimalDual(int n_) : n(n_), g(vector<vector<Edge> >(n_)) {}
	void add_edge(int src, int dst, Capacity cap, Cost cost) { // ?????????
		g[src].push_back(Edge{ dst, cap, cost, (int)g[dst].size(), false });
		g[dst].push_back(Edge{ src, 0, -cost, (int)g[src].size() - 1, true });
	}
	Cost solve(int s, int t, int f) {
		Cost res = 0;
		static Cost h[MAX_V], dist[MAX_V];
		static int prevv[MAX_V], preve[MAX_V];

		fill(h, h + n, 0);
		if(top.size()) {
			assert(top.size() == n);
			for(int i = 0; i < n; i++) {
				int v = top[i];
				for(int i = 0; i < g[v].size(); i++) {
					Edge& e = g[v][i];
					if(e.cap == 0) continue;
					int u = e.dst;
					h[u] = min(h[u], h[v] + e.cost);
				}
			}
		}

		while(f > 0) {
			typedef pair<Cost, int> pcv;
			priority_queue<pcv, vector<pcv>, greater<pcv> > q;
			for(int i = 0; i < n; i++) {
				dist[i] = inf;
			}
			dist[s] = 0;
			q.push(pcv(0, s));
			while(q.size()) {
				pcv p = q.top(); q.pop();
				int v = p.second;
				if(dist[v] < p.first) continue;
				for(int i = 0; i < g[v].size(); i++) {
					Edge &e = g[v][i];
					if(e.cap > 0 && dist[e.dst] > dist[v] + e.cost + h[v] - h[e.dst] + eps) {
						dist[e.dst] = dist[v] + e.cost + h[v] - h[e.dst];
						prevv[e.dst] = v;
						preve[e.dst] = i;
						q.push(pcv(dist[e.dst], e.dst));
					}
				}
			}
			if(abs(dist[t] - inf) < eps) {
				return -1;
			}
			for(int v = 0; v < n; v++) {
				h[v] += dist[v];
			}
			// s-t ????????????????????£??????????????????
			int d = f;
			for(int v = t; v != s; v = prevv[v]) {
				d = min(d, g[prevv[v]][preve[v]].cap);
			}
			f -= d;
			res += d * h[t];
			for(int v = t; v != s; v = prevv[v]) {
				Edge &e = g[prevv[v]][preve[v]];
				e.cap -= d;
				g[v][e.revEdge].cap += d;
			}
		}
		return res;
	}
	// ??????????????????=???????????????-?????¨??????????????¨???
	void view() {
		for(int i = 0; i < g.size(); i++) {
			for(int j = 0; j < g[i].size(); j++) {
				if(!g[i][j].isRev) {
					Edge& e = g[i][j];
					printf("%3d->%3d (flow:%d)\n", i, e.dst, e.cap_orig - e.cap);
				}
			}
		}
	}
};

int d[1000];
int f[1000];

void solve() {

	int N, S, T, F;
	cin >> N >> S >> T >> F;

	Matrix A(N, Array(N));
	Array b(N);
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
		cin >> b[i];
	}

	Array tm = gauss_jordan(A, b);

	PrimalDual pd(N);
	for(int i = 0; i < N; i++) {
		int M;
		cin >> M;
		for(int j = 0; j < M; j++) {
			cin >> d[j];
		}
		for(int j = 0; j < M; j++) {
			cin >> f[j];
		}
		for(int j = 0; j < M; j++) {
			pd.add_edge(i, d[j], f[j], abs(tm[i] - tm[d[j]]));
		}
	}
	Cost res = pd.solve(S, T, F);
	if(res == -1) {
		cout << "impossible" << endl;
	}
	else {
		cout << fixed << setprecision(15) << res << endl;
	}
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	int T;
	cin >> T;
	while(T--) solve();
}