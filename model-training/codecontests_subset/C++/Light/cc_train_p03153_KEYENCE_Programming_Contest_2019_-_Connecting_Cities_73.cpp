#include <bits/stdc++.h>
using namespace std;

#define rep(i, N) for (int i = 0; i < (N); i++)
#define all(a) (a).begin(), (a).end()
#define pb push_back

using ll = long long;
using i_i = tuple<int, int>;

struct edge { int u, v; ll w; };

struct union_find {
	vector<int> v;
	union_find(int n) : v(n, -1) {}
	int find(int x) { return v[x] < 0 ? x : v[x] = find(v[x]); }
	void unite(int x, int y) {
		x = find(x); y = find(y);
		if (x == y) return;
		if (-v[x] < -v[y]) swap(x, y);
		v[x] += v[y]; v[y] = x;
	}
	bool root(int x) { return v[x] < 0; }
	bool same(int x, int y) { return find(x) == find(y); }
	int size(int x) { return -v[find(x)]; }
};

bool kr_cmp(const edge& l, const edge& r) { return l.w < r.w; }

ll kruskal(int N, vector<edge> E) {
	sort(E.begin(), E.end(), kr_cmp);
	union_find uf(N);
	ll sum = 0;
	for (edge e: E)
		if (!uf.same(e.u, e.v)) {
			uf.unite(e.u, e.v);
			sum += e.w;
		}
	return sum;
}

int N;
ll D;
vector<edge> E;
ll a[200010];

void f(int l, int r) {
    if (r - l == 1) return;
    int m = (l + r) / 2;
    f(l, m);
    f(m, r);
    int i0, j0;
    {
        ll mi = LLONG_MAX;
        for (int i = l; i < m; i++) {
            ll x = a[i] - D * i;
            if (x < mi) {
                mi = x;
                i0 = i;
            }
        }
    }
    {
        ll mi = LLONG_MAX;
        for (int j = m; j < r; j++) {
            ll x = a[j] + D * j;
            if (x < mi) {
                mi = x;
                j0 = j;
            }
        }
    }
    for (int i = l; i < m; i++)
        E.pb({i, j0, a[i] + a[j0] + D * (j0 - i)});
    for (int j = m; j < r; j++)
        E.pb({i0, j, a[i0] + a[j] + D * (j - i0)});
}

int main() {
    cin >> N >> D;
    rep(i, N) scanf("%lld", &a[i]);
    f(0, N);
    cout << kruskal(N, E) << endl;
}
