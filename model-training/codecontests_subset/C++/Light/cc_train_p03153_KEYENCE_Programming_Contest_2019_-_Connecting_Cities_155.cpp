
#include <bits/stdc++.h>

#define ln                 '\n'
#define all(dat)           dat.begin(), dat.end()
#define loop(i, to)        for (int i = 0; i < to; ++i)
#define cont(i, to)        for (int i = 1; i <= to; ++i)
#define circ(i, fm, to)    for (int i = fm; i <= to; ++i)
#define foreach(i, dat)    for (__typeof(dat.begin()) i = dat.begin(); i != dat.end(); ++i)

typedef long long          num;

using namespace std;

const int nsz = 2e5;
int n, d, a[nsz + 5];
num w1[nsz + 5], w2[nsz + 5];
vector< pair<num, pair<int, int> > > e;

struct union_find {
	int sz, pr[nsz + 5];
	
	int inline operator [] (int id) { return qry(id); }
	
	void inline init(int sz = n) {
		this->sz = sz;
		cont (u, n)  pr[u] = u;
	}
	
	int qry(int u) {
		return pr[u] == u ? u : pr[u] = qry(pr[u]);
	}
	
	bool inline link(int u, int v) {
		int pu = qry(u), pv = qry(v);
		if (pu == pv)  return 0;
		pr[pv] = pu;
		return 1;
	}
};
union_find uf;

num inline w(int u, int v) {
	if (u < v)  swap(u, v);
	return w1[u] + w2[v];
}

void graph_init(int el = 1, int er = n) {
	if (el == er)  return;
	int md = (el + er) >> 1, ml = 1, mr = md + 1;
	circ (u, el, md) {
		w2[u] < w2[ml] && (ml = u);
	}
	circ (u, md + 1, er) {
		w1[u] < w1[mr] && (mr = u);
	}
	circ (u, el, md) {
		e.push_back({w(u, mr), {u, mr}});
	}
	circ (u, md + 1, er) {
		e.push_back({w(u, ml), {u, ml}});
	}
	graph_init(el, md);
	graph_init(md + 1, er);
}

num inline kruskal(vector< pair<num, pair<int, int> > > &e = ::e) {
	int cnt = 0;
	num res = 0;
	uf.init();
	sort(all(e));
	loop (i, e.size()) {
		int u = e[i].second.first, v = e[i].second.second;
		num w = e[i].first;
		if (uf.link(u, v)) {
			res += w;
			if (++cnt == n - 1)  break;
		}
	}
	return res;
}

int main() {
	scanf("%d%d", &n, &d);
	cont (i, n) {
		scanf("%d", &a[i]);
		w1[i] = (num) a[i] + (num) d * i;
		w2[i] = (num) a[i] - (num) d * i;
	}
	graph_init();
	printf("%lld\n", kruskal());
}