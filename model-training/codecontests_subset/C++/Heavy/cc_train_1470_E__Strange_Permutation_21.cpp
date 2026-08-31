
// Problem: E. Strange Permutation
// Contest: Codeforces - Codeforces Round #694 (Div. 1)
// URL: https://codeforces.com/problemset/problem/1470/E
// Memory Limit: 256 MB
// Time Limit: 3000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;

#define int long long

typedef pair<int, int> pii;
const int N = 3e4 + 5;

int n, c, q, p[N];

struct Node {
	int w, l, r;
	bool operator < (const Node &rhs) const {
		w < rhs.w;
	}
};

int ql[5], qr[5]; 
Node dq[5][10 * N];

bool cmp(const Node &a, const Node &b) {
	return p[a.r] < p[b.r];
}

int C(int n, int m) {
	if (n <= 0) return m == 0;
	if (n < m) return 0;
	int res = 1;
	for (int i = n; i > n - m; --i) res *= i;
	for (int i = 1; i <= m; ++i) res /= i;
	return res;
}

int ways(int len, int c) {
	int res = 0;
	for (int i = 0; i <= c; ++i) res += C(len - 1, i);
	return res;
}

int sumw[5][5 * N], pre_cnt[5][N];

Node F(int start, int rest, int kth) {
	int s = pre_cnt[rest][start], l = s + 1, r = qr[rest] - ql[rest] + 1;
	while (l < r) {
		int mid = (l + r) >> 1;
		if (sumw[rest][mid] - sumw[rest][s] >= kth) r = mid;
		else l = mid + 1;
	}
	return Node{ sumw[rest][l - 1] - sumw[rest][s], dq[rest][ql[rest] + l - 1].l, dq[rest][ql[rest] + l - 1].r };
}

void solve() {
	cin >> n >> c >> q;
	for (int i = 1; i <= n; ++i) cin >> p[i];
	for (int s = 1; s <= c; ++s) {
		ql[s] = 4 * N + 1, qr[s] = 4 * N; 
		dq[s][++qr[s]] = Node{ 1, n, n };
		for (int i = 1; i <= n; ++i) pre_cnt[s][i] = 0;
		for (int i = n - 1; i; --i) {
			int dl = 0, dr = 0;
			for (int j = 1; j <= min(s, n - i); ++j) {
				int w = ways(n - (i + j), s - j);
				if (p[i + j] < p[i]) dq[s][ql[s] - (++dl)] = Node{ w, i, i + j  }, ++pre_cnt[s][i + 1];
				else dq[s][qr[s] + (++dr)] = Node{ w, i, i + j };
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
		for (int i = 1; i <= n; ++i) pre_cnt[s][i] += pre_cnt[s][i - 1];
		for (int i = ql[s]; i <= qr[s]; ++i) sumw[s][i - ql[s] + 1] = sumw[s][i - ql[s]] + dq[s][i].w;
	}
	int tot = ways(n, c);
	while (q--) {
		int pos, rank; cin >> pos >> rank;
		if (rank > tot) {
			cout << -1 << endl;
			continue;
		}
		vector<pii> rev;
		int start = 1, rest = c;
		while (true) {
			Node u = F(start, rest, rank);
			rev.push_back(make_pair(u.l, u.r));
			rank -= u.w, rest -= (u.r - u.l), start = u.r + 1;
			if (start > n || !rest) break;
		}
		bool flag = false;
		for (int i = 0; i < rev.size(); ++i)
			if (rev[i].first <= pos && rev[i].second >= pos) {
				cout << p[rev[i].second - (pos - rev[i].first)] << endl;
				flag = true;
				break;
			}
		if (!flag) cout << p[pos] << endl;
	}
}

signed main() {
	ios::sync_with_stdio(false);
  	cin.tie(0), cout.tie(0);
	int T;
	cin >> T;
	while (T--) solve();
	return 0;
}