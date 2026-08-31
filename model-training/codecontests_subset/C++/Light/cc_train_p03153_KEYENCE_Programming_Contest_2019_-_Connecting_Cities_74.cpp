// Code by Denverjin.
#include <bits/stdc++.h>
using namespace std;

using ld = double;
using ll = long long;
using ull = unsigned long long;
const int INF = 1 << 30;
const ll LINF = 1LL << 60;

const int SZ = 1 << 13;
char buff[SZ], *pos = buff + SZ - 1;
#define getchar() (++ pos == buff + SZ ? fread(pos = buff, 1, SZ, stdin), *pos : *pos)

inline ll read() {
	ll x = 0; int f = 1, c = getchar();
	for (;!isdigit(c); c = getchar()) if (c == '-') f = -f;
	for (; isdigit(c); c = getchar()) x = (x<<3) + (x<<1) + (c^48);
	return x * f;
}

const int N = 1 << 24;
int n, D;
int a[N];
ll e[N][3];
int m;
int id[N];

void solve(int l, int r) {
	if (l + 1 >= r) return;
	int md = (l + r) >> 1;
	int mL = l; for (int i = l; i < md; ++ i) if (-1LL * i * D + a[i] < -1LL * mL * D + a[mL]) mL = i;
	int mR = md; for (int i = md; i < r; ++ i) if (1LL * i * D + a[i] < 1LL * mR * D + a[mR]) mR = i;
	for (int i = md; i < r; ++ i) e[m][0] = mL, e[m][1] = i, e[m][2] = 1LL * (i - mL) * D + a[i] + a[mL], id[m] = m ++;
	for (int i = l; i < md; ++ i) e[m][0] = i, e[m][1] = mR, e[m][2] = 1LL * (mR - i) * D + a[i] + a[mR], id[m] = m ++;
	solve(l, md);
	solve(md, r);
}

int par[N];
void init() { for (int i = 0; i < N; ++ i) par[i] = i; }
int find(int x) { return par[x] == x ? x : par[x] = find(par[x]); }
void merge(int x, int y) { x = find(x), y = find(y); par[x] = y; }
bool same(int x, int y) { return find(x) == find(y); }

int main() {
	init();
	n = read(), D = read();
	for (int i = 0; i < n; ++ i) a[i] = read();
	solve(0, n);
	sort(id, id + m, [&](int a, int b) {
		return e[a][2] < e[b][2];
	});
	ll ans = 0;
	for (int ii = 0; ii < m; ++ ii) {
		int i = id[ii];
		if (!same(e[i][0], e[i][1])) {
			merge(e[i][0], e[i][1]);
			ans += e[i][2];
		}
	}
	printf("%lld\n", ans);
	return 0;
}
