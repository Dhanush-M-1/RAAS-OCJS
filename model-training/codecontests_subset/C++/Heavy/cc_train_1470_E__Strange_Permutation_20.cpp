#include <bits/stdc++.h>
#define rep(i, a, b) for (int i = (a); i <= int(b); i++)
#define per(i, a, b) for (int i = (a); i >= int(b); i--)
#define fi first
#define se second

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<pii, ll> foo;

const int maxn = 3e4, maxm = 4 * maxn;

int T, n, c, q, a[maxn + 5];

ll delta[5][maxn + 5];

bool comp1(const foo &a, const foo &b) {
	return a.se < b.se;
}

bool comp2(foo x, foo y) {
	return a[x.fi.fi + x.fi.se] < a[y.fi.fi + y.fi.se];
}

template<class type>
struct my_deque {
	type q[2 * maxm + 10], *l, *r = l = q + maxm + 5;
	void init() {
		l = r = q + maxm + 5;
	}
	void push_back(type x) {
		*r++ = x;
	}
	void push_front(type x) {
		*--l = x;
	}
};

my_deque<foo> D[5];

ll ways(int n, int c) {
	if (n == 0) {
		return 1;
	}
	ll cur = 1, sum = 1;
	rep(i, 1, c) {
		cur *= (n - i);
		cur /= i;
		sum += cur;
	}
	return sum;
}

void prepare(my_deque<foo> &D) {
	for (foo *x = D.l + 1; x < D.r; x++) {
		x->se += (x - 1)->se;
	}
}

foo query(int x, int c, ll &k) {
	k += delta[c][x];
	foo *p = lower_bound(D[c].l, D[c].r, foo(pii(0, 0), k), comp1);
	assert(k <= p->se);
	return foo(p->fi, p == D[c].l ? 0ll : (p - 1)->se);
}

int main() {
	scanf("%d", &T);
	while (T --> 0) {
		scanf("%d %d %d", &n, &c, &q);
		rep(i, 1, n) {
			scanf("%d", &a[i]);
		}
		rep(i, 0, c) {
			D[i].init();
			D[i].push_back(foo(pii(0, 0), 1ll));
		}
		rep(k, 1, c) {
			memset(delta[k] + 1, 0, n << 3);
			per(i, n - 1, 1) {
				int cl = 0, cr = 0;
				rep(j, 1, min(n - i, k)) {
					foo x = foo(pii(i, j), ways(n - i - j, k - j));
					if (a[i + j] > a[i]) {
						D[k].push_back(x), cr++;
					} else {
						D[k].push_front(x), cl++;
						delta[k][i + 1] += x.se;
					}
				}
				sort(D[k].l, D[k].l + cl, comp2);
				sort(D[k].r - cr, D[k].r, comp2);
			}
			rep(i, 2, n) {
				delta[k][i] += delta[k][i - 1];
			}
			// puts("=====");
			// printf("%d\n", k);
			// for (foo *x = D[k].l; x < D[k].r; x++) {
			// 	printf("%d %d %lld\n", x->fi.fi, x->fi.se, x->se);
			// }
		}
		rep(k, 0, c) {
			prepare(D[k]);
		}
		ll lim = ways(n, c);
		for (int i; q --> 0; ) {
			ll j;
			scanf("%d %lld", &i, &j);
			if (j > lim) {
				puts("-1");
				continue;
			}
			int s = 1, l = c;
			while (s <= n) {
				foo x = query(s, l, j);
				pii p = x.fi;
				if (p == pii(0, 0) || i < p.fi) {
					printf("%d\n", a[i]);
					goto next_query;
				}
				if (i <= p.fi + p.se) {
					printf("%d\n", a[2 * p.fi + p.se - i]);
					goto next_query;
				}
				s = p.fi + p.se + 1;
				j -= x.se;
				l -= p.se;
			}
			next_query: void();
		}
	}
	return 0;
}