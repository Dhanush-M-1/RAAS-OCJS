#include <algorithm>
#include <bitset>
#include <cassert>
#include <cctype>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <vector>
using namespace std;

#define ll long long
#define mp make_pair
#define pb push_back

#define eprintf(...) fprintf(stderr, __VA_ARGS__)

const int maxn = 200005;

int n, d;
int a[maxn];
vector <pair <ll, pair <int, int> > > edges;

struct union_find {
	int fa[maxn], siz[maxn];
	union_find() {
		for (int i = 0; i < maxn; ++ i)
			fa[i] = i, siz[i] = 1;
	}
	int find(int x) {
		return fa[x] == x ? x : fa[x] = find(fa[x]);
	}
	void merge(int x, int y) {
		x = find(x); y = find(y);
		if (x == y) return ;
		if (siz[x] < siz[y]) swap(x, y);
		fa[y] = x;
		siz[x] += siz[y];
	}
} dsu;

void solve(int l, int r) {
	if (l + 1 == r) return ;
	int m = (l + r) >> 1;
	vector <pair <ll, int> > lft, rgt;
	for (int i = l; i < m; ++ i)
		lft.pb(mp(a[i] + 1LL * (m - i) * d, i));
	for (int i = m; i < r; ++ i)
		rgt.pb(mp(a[i] + 1LL * (i - m) * d, i));
	sort(lft.begin(), lft.end());
	sort(rgt.begin(), rgt.end());
	for (int i = 0; i < lft.size(); ++ i)
		edges.pb(mp(lft[i].first + rgt[0].first, mp(lft[i].second, rgt[0].second)));
	for (int i = 0; i < rgt.size(); ++ i)
		edges.pb(mp(lft[0].first + rgt[i].first, mp(lft[0].second, rgt[i].second)));
	solve(l, m); solve(m, r);
}

int main() {
	scanf("%d %d", &n, &d);
	for (int i = 0; i < n; ++ i) scanf("%d", &a[i]);
	solve(0, n);
	sort(edges.begin(), edges.end());
	ll ans = 0;
	for (int i = 0; i < edges.size(); ++ i) {
		ll d = edges[i].first;
		int u = edges[i].second.first;
		int v = edges[i].second.second;
		if (dsu.find(u) != dsu.find(v)) {
			ans += d;
			dsu.merge(u, v);
		}
	}
	printf("%lld\n", ans);
	return 0;
}
