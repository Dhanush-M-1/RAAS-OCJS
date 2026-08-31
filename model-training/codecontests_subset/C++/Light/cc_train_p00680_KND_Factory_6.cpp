#include "bits/stdc++.h"
using namespace std;

/* verified AOJ1327 One-Dimensional Cellular Automaton
~Matrix~
??????????°????????¨?????????§??????
vector iostream cmath cassert ??????
Matrix a(VV), b(VV);
?????????:a*b
????????????:l*a
???:a+b
???:a-b
??¢???:a.transport()
?????????:a.cofactor()
?????????:a.det()
a???i???j??????:a.get(i,j)???
a???i??????j?????????k?????£??\:set(i,j,k)
????????????a[i][j] (a[i][j]=k)
a???x???:a.pow(x)
n*n?????¬??????E:Matrix(n)
m*n 0??????:Matrix(m,n)
m*n ??¨????´????p?????????:Matrix(m,n,p)
Row???row??§????????????(m*1??????):Matrix(row)
**(??´??°??????)**
????§????:a.triangulate()
?????????:a.rank()
?????????:a.inverse()
//(????????????a.det()?????????a.pre_inverse()??§?±??????? ??´??°???)
??¬??????????¶???????:a.rowReduction()
//??£???????¬?????¨????????§£??????
***
*/

#include <vector>
#include <iostream>
#include <cmath>
#include <cassert>
using namespace std;

typedef double Elem;
typedef vector<Elem> Row;
typedef vector<Row> VV;

typedef long double ld;
const ld EPS = 1e-11;

const bool isZero(const Elem e) {
	return abs(e) < EPS;
}

struct Matrix {
	VV matrix;
	int n, m;

	Matrix(const VV &matrix_);
	explicit Matrix(int n_);
	explicit Matrix(const Row &row);
	Matrix(int m_, int n_);
	Matrix(int m_, int n_, Elem e);

	const Elem get(const int i, const int j) const;
	void set(const int x, const int y, const Elem k);

	const Matrix operator + (const Matrix &rhs) const;
	const Matrix operator * (const Matrix &rhs) const;
	const Matrix operator - (const Matrix &rhs) const;
	Matrix &operator += (const Matrix &rhs);
	Matrix &operator *= (const Matrix &rhs);
	Matrix &operator -= (const Matrix &rhs);

	Row &operator[](const int x);

	const Matrix transport() const;
	const Matrix pow(int x) const;
	const Matrix cofactor(int x, int y) const;
	const Elem det() const;

	const Matrix triangulate() const;
	const int rank() const;

	//?????????????????¨????????°???(?????????)*(?????????)?????????
	//A:matrix,return det A * A^-1
	const Matrix pre_inverse() const;
	const Matrix inverse() const;
	const Matrix rowReduction() const;
};

const Matrix operator * (const Elem lambda, const Matrix &rhs) {
	Matrix tmp(rhs);
	for (int i = 0; i < rhs.m; i++)
		for (int j = 0; j < rhs.n; j++)
			tmp.set(i, j, tmp.get(i, j) * lambda);
	return tmp;
}

Matrix::Matrix(const VV &matrix_) : matrix(matrix_) {
	m = matrix_.size();
	if (m == 0) n = 0;
	else n = matrix_[0].size();
}
Matrix::Matrix(int n_) : m(n_), n(n_) {
	matrix = VV(n, Row(n, 0));
	for (int i = 0; i < n; ++i)
		set(i, i, 1);
}
Matrix::Matrix(const Row &row) : m(1), n(row.size()), matrix(VV(1, row)) {
	//size???m???vector<Elem>??????mx1???????????????
	(*this) = transport();
}
Matrix::Matrix(int m_, int n_) : m(m_), n(n_) {
	matrix = VV(m, Row(n, 0));
}
Matrix::Matrix(int m_, int n_, Elem e) : m(m_), n(n_) {
	matrix = VV(m, Row(n, e));
}

const Elem Matrix::get(const int i, const int j) const {
	if (0 <= i && i < m && 0 <= j && j < n)
		return matrix[i][j];

	cerr << "get(" << i << "," << j << ")is not exist." << endl;
	throw;
}
void Matrix::set(const int i, const int j, const Elem k) {
	if (0 <= i && i < m && 0 <= j && j < n) {
		*(matrix[i].begin() + j) = k;
		return;
	}
	cerr << "set(" << i << "," << j << ")is not exist." << endl;
	throw;
}

const Matrix Matrix::operator + (const Matrix &rhs) const {
	assert(m == rhs.m && n == rhs.n);

	Matrix tmp(m, n, 0);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			tmp.set(i, j, get(i, j) + rhs.get(i, j));
		}
	}
	return tmp;
}

const Matrix Matrix::operator * (const Matrix &rhs) const {
	assert(n == rhs.m);

	Matrix tmp(m, rhs.n, 0);
	Elem sum;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < rhs.n; j++) {
			sum = 0;
			for (int k = 0; k < n; k++) {
				sum += get(i, k) * rhs.get(k, j);
			}
			tmp.set(i, j, sum);
		}
	return tmp;
}

const Matrix Matrix::operator - (const Matrix &rhs) const {
	return *this + ((Elem)-1 * rhs);
}

Matrix &Matrix::operator += (const Matrix &rhs) {
	return *this = *this + rhs;
}

Matrix &Matrix::operator *= (const Matrix &rhs) {
	return *this = *this * rhs;;
}

Matrix &Matrix::operator -= (const Matrix &rhs) {
	return *this = *this - rhs;
}

Row &Matrix::operator[](const int x) {
	return matrix[x];
}

const Matrix Matrix::transport() const {
	VV tmp;
	for (int i = 0; i < n; i++) {
		Row row;
		for (int j = 0; j < m; j++)
			row.push_back(get(j, i));
		tmp.push_back(row);
	}
	return tmp;
}

const Matrix Matrix::pow(int x) const {
	Matrix tmp(*this), e(m);
	for (int i = 1; i <= x; i <<= 1) {
		if ((x & i) > 0)
			e = e * tmp;
		tmp = tmp * tmp;
	}
	return e;
}

const Matrix Matrix::cofactor(int x, int y) const {
	VV tmp;
	for (int i = 0; i < m; i++) {
		if (x == i) continue;
		Row row;
		for (int j = 0; j < n; j++) {
			if (y == j) continue;
			row.push_back(get(i, j));
		}
		tmp.push_back(row);
	}
	return Matrix(tmp);
}

const Elem Matrix::det() const {
	assert(n == m);
Matrix tri = triangulate();
Elem ans = 1;
for (int i = 0; i < n; ++i) {
	ans *= tri[i][i];
}
return ans;

	if (m == 1)
		return get(0, 0);
	Elem sum = 0;
	for (int i = 0; i < m; i++) {
		sum += ((i % 2 == 0 ? 1 : -1) * get(i, 0)) * Matrix(cofactor(i, 0)).det();
	}
	return sum;
}

const Matrix Matrix::triangulate() const {
	Matrix tmp(*this);
	Elem e;
	int p = 0;
	for (int i = 0; i < m && p < n; i++, p++) {
		if (isZero(tmp.get(i, p))) {
			tmp.set(i, p, 0);
			bool flag = true;
			for (int j = i + 1; j < m; j++)
				if (!isZero(tmp.get(j, p))) {
					for (int k = 0; k < n; k++)
						tmp.set(i, k, tmp.get(i, k) + tmp.get(j, k));
					//tmp[i].swap(tmp[j]);
					flag = false;
					break;
				}
			if (flag) {
				i--;
				continue;
			}
		}
		for (int j = i + 1; j < m; j++) {
			e = tmp.get(j, p) / tmp.get(i, p);
			for (int k = 0; k < n; k++)
				tmp.set(j, k, tmp.get(j, k) - tmp.get(i, k) * e);
		}
	}
	return tmp;
}

const int Matrix::rank() const {
	Matrix tmp(triangulate());
	for (int i = min(tmp.m - 1, tmp.n - 1); i >= 0; i--) {
		for (int j = tmp.n - 1; j >= i; j--)
			if (isZero(tmp.get(i, j)))
				continue;
			else
				return i + 1;
	}
	return 0;
}

const Matrix Matrix::pre_inverse() const {
	assert(m == n);

	Matrix tmp(m, n, 0);
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			tmp.set(i, j, ((i + j) % 2 == 0 ? 1 : -1)*cofactor(i, j).det());
	return tmp.transport();
}

/*O(n!)????£?
const Matrix Matrix::inverse() const {
Matrix tmp(pre_inverse());
Elem e = det();
assert(!isZero(e));
tmp = 1 / e * tmp;
return tmp.transport();
}*/

const Matrix Matrix::inverse() const {
	assert(m == n);

	Matrix tmp(m, n * 2), tmp2(m, n);
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			tmp.set(i, j, get(i, j));
	for (int i = 0; i < m; i++)
		tmp.set(i, i + n, 1);

	tmp = tmp.rowReduction();

	//?????????????????¨??????????????????????????§??????
	for (int i = 0; i < m; i++)
		assert(isZero(tmp.get(i, i) - 1));

	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			tmp2.set(i, j, tmp.get(i, j + n));

	return tmp2;
}

/*
a b c j
d e f k
g h i l

ax+by+cz=j;
dx+ey+fz=k;
gx+hy+iz=l;

|
V

1 0 0 x
0 1 0 y
0 0 1 z
???????????????
*/
const Matrix Matrix::rowReduction() const {
	Matrix tmp(*this);
	Elem e;
	int p = 0;
	for (int i = 0; i < m && p < n; i++, p++) {
		if (isZero(tmp.get(i, p))) {
			tmp.set(i, p, 0);
			bool flag = true;
			for (int j = i + 1; j < m; j++)
				if (!isZero(tmp.get(j, p))) {
					for (int k = 0; k < n; k++)
						tmp.set(i, k, tmp.get(i, k) + tmp.get(j, k));
					//tmp[i].swap(tmp[j]);
					flag = false;
					break;
				}
			if (flag) {
				i--;
				continue;
			}
		}
		e = 1 / tmp.get(i, p);
		tmp.set(i, p, 1);
		for (int k = i + 1; k < n; k++)
			tmp.set(i, k, tmp.get(i, k)*e);
		for (int j = 0; j < m; j++) {
			if (i == j) continue;
			e = tmp.get(j, p);
			for (int k = 0; k < n; k++)
				tmp.set(j, k, tmp.get(j, k) - tmp.get(i, k) * e);
		}
	}
	return tmp;
}

typedef ld  Weight;
struct Edge {
	int src, dest;
	int cap, rev;
	Weight weight;
	bool operator < (const Edge &rhs) const { return weight > rhs.weight; }
};

const int V = 4000;
typedef vector<Edge> Edges;
typedef vector<Edges> Graph;
typedef vector<Weight> Array;
Weight h[V];                //??????????????£???
Weight dist[V];             //???????????¢
int prevv[V], preve[V];  //??´???????????¨??????

void add_edge(Graph &g, int src, int dest, int cap, Weight weight) {
	g[src].push_back(Edge{ src, dest, cap, (int)g[dest].size(), weight });
	g[dest].push_back(Edge{ dest, src, 0, (int)g[src].size() - 1, -weight });
}
#define REP(i,n) for(int i=0;i<(int)n;++i)
#define FOR(i,c) for(auto i=(c).begin();i!=(c).end();++i)
#define ALL(c) (c).begin(), (c).end()
const Weight INF = 2147483647;
const Weight eps = 1e-9;
//????????????double?????????eps?????????
Weight min_cost_flow(Graph &g, int s, int t, int f) {
	Weight res = 0;
	memset(h, 0, sizeof(h));
	typedef pair<Weight, int> P;
	while (f > 0) {
		priority_queue<P, vector<P>, greater<P> > que;
		fill(dist, dist + V, INF);
		dist[s] = 0;
		que.push(P(0, s));
		while (!que.empty()) {
			P p = que.top(); que.pop();
			const int v = p.second;
			if (dist[v] < p.first) continue;
			REP(i, g[v].size()) {
				Edge &e = g[v][i];
				if (e.cap > 0 && dist[e.dest] > dist[v] + e.weight + h[v] - h[e.dest] + eps) {
					dist[e.dest] = dist[v] + e.weight + h[v] - h[e.dest];
					prevv[e.dest] = v;
					preve[e.dest] = i;
					que.push(P(dist[e.dest], e.dest));
				}
			}
		}
		if (dist[t] == INF) return -1;
		REP(v, V) h[v] = h[v] + dist[v];

		int d = f;
		for (int v = t; v != s; v = prevv[v]) d = min(d, g[prevv[v]][preve[v]].cap);
		f -= d;
		res = res + d * h[t];
		for (int v = t; v != s; v = prevv[v]) {
			Edge &e = g[prevv[v]][preve[v]];
			e.cap -= d;
			g[v][e.rev].cap += d;
		}
	}
	return res;
}

int main() {
	int T; cin >> T;
	while (T--) {
		int N, S, T, F; cin >> N >> S >> T >> F;
		vector<ld>ts;
		{
			Matrix mat(N, N + 1);
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N + 1; ++j) {
					int a; cin >> a;
					mat[i][j] = a;
				}
			}
			mat = mat.rowReduction();
			for (int i = 0; i < N; ++i) {
				ts.push_back(mat[i][N]);
			}
		}
		Graph g(N);
		for (int i = 0; i < N; ++i) {
			int M; cin >> M;
			vector<int>ds, fs;
			for (int j = 0; j < M; ++j) {
				int d; cin >> d; ds.push_back(d);
			}
			for (int j = 0; j < M; ++j) {
				int f; cin >> f; fs.push_back(f);
			}
			for (int j = 0; j < M; ++j) {
				add_edge(g, i, ds[j], fs[j], abs(ts[i] - ts[ds[j]]));
			}
		}
		ld ans = min_cost_flow(g, S, T, F);
		if (ans < 0)cout << "impossible" << endl;
		else
		{

			cout << setprecision(10) << fixed << ans << endl;
		}
	}
	return 0;
}