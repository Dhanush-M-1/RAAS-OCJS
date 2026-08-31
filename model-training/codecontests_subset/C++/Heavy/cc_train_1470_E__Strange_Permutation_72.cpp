#include <bits/stdc++.h>
using namespace std;

#define mk make_pair
#define fi first
#define se second
#define SZ(x) ((int)(x).size())

typedef unsigned int uint;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;

template<typename T> inline void ckmax(T& x, T y) { x = (y > x ? y : x); }
template<typename T> inline void ckmin(T& x, T y) { x = (y < x ? y : x); }

const int MAXC = 4;
const int MAXN = 3e4;

int n, c, q, a[MAXN + 5];

ll ways_eq(int len, int c) {
	// 长度为 len, 操作代价和恰好为 c
	// comb(len - 1, c)
	if (len <= 1) {
		return c == 0;
	}
	if (len - 1 < c) {
		return 0;
	}
	
	ll res = 1;
	for (int i = len - 1; i >= len - c; --i) {
		res *= i;
	}
	for (int i = c; i > 1; --i) {
		res /= i;
	}
	return res;
}
ll ways_leq(int len, int c) {
	// 长度为 len, 操作代价和小于或等于 c
	ll res = 0;
	for (int i = 0; i <= c; ++i) {
		res += ways_eq(len, i);
	}
	return res;
}

struct Node {
	int l, r;
	ll w; // 后面的操作方案数
	
	Node() {}
	Node(int _l, int _r, ll _w) {
		l = _l;
		r = _r;
		w = _w;
	}
};

Node dq[MAXC + 1][MAXN * MAXC * 2 + 10];
int ql[MAXC + 1], qr[MAXC + 1];
int sum[MAXC + 1][MAXN + 5];
ll sumw[MAXC + 1][MAXN * MAXC + 5];

bool cmp(Node lhs, Node rhs) {
	return a[lhs.r] < a[rhs.r];
}

Node F(int st, int s, ll rank) {
	int i = sum[s][st]; // 在 st 之前的, 一共有这么多区间
	/*
	// 暴力查找
	ll cur = 0;
	for (i = ql[s] + i; i <= qr[s]; ++i) {
		cur += dq[s][i].w;
		assert(cur == sumw[s][i - ql[s] + 1] - sumw[s][sum[s][st]]);
		if (cur >= rank) {
			return Node(dq[s][i].l, dq[s][i].r, cur - dq[s][i].w);
		}
	}
	*/
	
	int l = i + 1, r = qr[s] - ql[s] + 2;
	while (l < r) {
		int mid = (l + r) >> 1;
		if (sumw[s][mid] - sumw[s][i] >= rank) {
			r = mid;
		} else {
			l = mid + 1;
		}
	}
	assert(l <= qr[s] - ql[s] + 1);
	return Node(dq[s][ql[s] + l - 1].l, dq[s][ql[s] + l - 1].r, sumw[s][l - 1] - sumw[s][i]);
}

void solve_case() {
	cin >> n >> c >> q;
	for (int i = 1; i <= n; ++i) {
		cin >> a[i];
	}
	for (int s = 1; s <= c; ++s) { // 总代价小于或等于 s
		
		
//		cerr << "-------- maxcost " << s << " --------" << endl;
		ql[s] = MAXN * MAXC + 5, qr[s] = MAXN * MAXC + 4; // 队列清空
		for (int i = 1; i <= n; ++i)
			sum[s][i] = 0;
		
		dq[s][++qr[s]] = Node(n, n, 1); // 什么都不翻转
		for (int i = n - 1; i >= 1; --i) {
			int dl = 0, dr = 0;
			for (int j = 1; j <= min(s, n - i); ++j) {
				// 翻转区间 [i, i + j]
				ll w = ways_leq(n - (i + j), s - j);
				
				if (a[i + j] < a[i]) {
					// 翻转后是 a[i + j], 不翻转是 a[i], 两者比一比
					// 翻转后更小, push_front
					dq[s][ql[s] - (++dl)] = Node(i, i + j, w);
					sum[s][i + 1]++;
				} else {
					dq[s][qr[s] + (++dr)] = Node(i, i + j, w);
				}
			}
			
			if (dl) {
				sort(dq[s] + ql[s] - dl, dq[s] + ql[s], cmp);
				ql[s] -= dl;
			}
			if (dr) {
				sort(dq[s] + qr[s] + 1, dq[s] + qr[s] + dr + 1, cmp);
				qr[s] += dr;
			}
		}
//		cerr << "print queue: " << endl;
//		for (int i = ql[s]; i <= qr[s]; ++i) {
//			cerr << dq[s][i].l << " " << dq[s][i].r << " " << dq[s][i].w << endl;
//		}
//		cerr << "queue end" << endl;
		
		for (int i = 1; i <= n; ++i) {
			sum[s][i] += sum[s][i - 1];
		}
		for (int i = ql[s]; i <= qr[s]; ++i) {
			sumw[s][i - ql[s] + 1] = sumw[s][i - ql[s]] + dq[s][i].w;
		}
	}
	
	ll lim = ways_leq(n, c);
	for (int tq = 1; tq <= q; ++tq) {
		int pos;
		ll rank;
//		cerr << "-------- query: " << endl;
		cin >> pos >> rank;
		
		if (rank > lim) {
			cout << -1 << endl;
			continue;
		}
		
		vector<pii> revs;
		int p = 1;
		int s = c;
		while (1) {
			Node t = F(p, s, rank);
			
//			cerr << "** " << t.l << " " << t.r << " " << t.w << endl;
			
			revs.push_back(make_pair(t.l, t.r));
			
			assert(t.w < rank);
			rank -= t.w;
			s -= (t.r - t.l);
			p = t.r + 1;
			
			if (!s)
				break;
			if (p > n)
				break;
		}
		
		/*
		// 暴力翻转
		static int aa[MAXN + 5];
		for (int i = 1; i <= n; ++i) {
			aa[i] = a[i];
		}
		for (int i = 0; i < SZ(revs); ++i) {
			reverse(aa + revs[i].fi, aa + revs[i].se + 1);
		}
		cout << aa[pos] << endl;
		*/
		
		bool flag = 0;
		for (int i = 0; i < SZ(revs); ++i) {
			if (revs[i].fi <= pos && revs[i].se >= pos) {
				cout << a[revs[i].se - (pos - revs[i].fi)] << endl;
				flag = 1;
				break;
			}
		}
		if (!flag) {
			cout << a[pos] << endl;
		}
	}
}
int main() {
	int T; cin >> T; while (T--) {
		solve_case();
	}
	return 0;
}