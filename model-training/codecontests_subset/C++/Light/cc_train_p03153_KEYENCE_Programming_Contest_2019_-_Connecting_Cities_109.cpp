/* cerberus97 - Hanit Banga */

#include <iostream>
#include <iomanip>
#include <cassert>
#include <cmath>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <map>
#include <set>
#include <queue>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

#define pb push_back
#define fast_cin() ios_base::sync_with_stdio(false); cin.tie(NULL)

typedef long long ll;
typedef long double ld;
typedef pair <int, int> pii;
typedef pair <ll, ll> pll;

const int N = 2e5 + 10;

struct edge {
	int u, v; ll w;
	bool operator<(const edge &o) const {
		return w < o.w;
	}
};

int a[N], sz[N], par[N];
vector<edge> edges;

bool merge(int u, int v);
int get_root(int u);

int main() {
	fast_cin();
	int n; ll d;
	cin >> n >> d;
	for (int i = 1; i <= n; ++i) {
		cin >> a[i];
		sz[i] = 1;
		par[i] = i;
	}
	priority_queue<pll, vector<pll>, greater<pll>> q;
	for (int i = 1; i <= n; ++i) {
		while (!q.empty()) {
			int j = q.top().second;
			if (a[j] > a[i]) {
				q.pop();
				continue;
			} else {
				edges.pb({i, j, a[i] + a[j] + d * (i - j)});
				break;
			}
		}
		q.push({a[i] - d * i, i});
	}
	while (!q.empty()) {
		q.pop();
	}
	for (int i = n; i >= 1; --i) {
		while (!q.empty()) {
			int j = q.top().second;
			if (a[j] > a[i]) {
				q.pop();
				continue;
			} else {
				edges.pb({i, j, a[i] + a[j] + d * (j - i)});
				break;
			}
		}
		q.push({a[i] + d * i, i});
	}
	sort(edges.begin(), edges.end());
	ll ans = 0;
	for (auto &e : edges) {
		if (merge(e.u, e.v)) {
			ans += e.w;
		}
	}
	cout << ans;
}

bool merge(int u, int v) {
	u = get_root(u);
	v = get_root(v);
	if (u == v) {
		return false;
	}
	if (sz[u] < sz[v]) {
		swap(u, v);
	}
	sz[u] += sz[v];
	par[v] = u;
	return true;
}

int get_root(int u) {
	if (par[u] != u) {
		par[u] = get_root(par[u]);
	}
	return par[u];
}