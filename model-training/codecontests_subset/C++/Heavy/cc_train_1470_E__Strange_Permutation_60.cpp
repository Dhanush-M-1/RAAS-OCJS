#include<bits/stdc++.h>
using namespace std;
#define ll long long
const int maxn = 30005;
const int maxm = 240005;
int T, n, c, q, a[maxn];
inline ll C(int n, int m) {
	if(!m) return 1;
	if(n < m) return 0;
	ll res = 1;
	for(int i = 0; i < m; i++) res *= n - i;
	for(int i = 2; i <= m; i++) res /= i;
	return res;
}
inline ll calc(int len, int cs) {
	ll res = 0;
	for(int i = 0; i <= cs; i++) res += C(len - 1, i);
	return res;
}

int L[5][maxn], R[5][maxn];
struct data {
	int l, r; 
	ll w;
	data(int _l = 0, int _r = 0, ll _w = 0) { l = _l, r = _r, w = _w; }
};
data A[5][maxm];
ll sum[5][maxm];
data solve(int l, int cs, ll k) {
	int nL = L[cs][l], nR = R[cs][l];
	int pos = lower_bound(sum[cs] + nL, sum[cs] + nR + 1, sum[cs][nL - 1] + k) - sum[cs];
	return data(A[cs][pos].l, A[cs][pos].r, sum[cs][pos - 1] - sum[cs][nL - 1]);
}

int main() {
	scanf("%d", &T);
	while(T--) {
		scanf("%d%d%d", &n, &c, &q);
		for(int i = 1; i <= n; i++) scanf("%d", &a[i]);
		for(int j = 1; j <= c; j++) L[j][n] = R[j][n] = n * c, A[j][L[j][n]] = data(n, n, 1);
		static int bot[5], tot;
		for(int i = n - 1; i >= 1; i--) 
			for(int j = 1; j <= c; j++) {
				tot = 0;
				L[j][i] = L[j][i + 1];
				R[j][i] = R[j][i + 1];
				
				for(int k = 1; k <= j && i + k <= n; k++) bot[++tot] = i + k;
				sort(bot + 1, bot + tot + 1, [=] (int x, int y) -> bool { return a[x] < a[y]; });
				for(int k = tot; k >= 1; k--)
					if(a[bot[k]] < a[i]) A[j][--L[j][i]] = data(i, bot[k], calc(n - bot[k], j - bot[k] + i));
				for(int k = 1; k <= tot; k++)
					if(a[bot[k]] > a[i]) A[j][++R[j][i]] = data(i, bot[k], calc(n - bot[k], j - bot[k] + i));
			}
		for(int j = 1; j <= c; j++) {
			sum[j][L[j][1] - 1] = 0;
			for(int i = L[j][1]; i <= R[j][1]; i++) sum[j][i] = sum[j][i - 1] + A[j][i].w;
		}
			
		ll all = calc(n, c), x = 0;
		int y = 0;
		while(q--) {
			scanf("%d%lld", &y, &x);
			if(x > all) {
				puts("-1");
				continue;
			}
			int res = a[y], nowp = 1, nowc = c;
			while(x && nowc && nowp <= n) {
				data now = solve(nowp, nowc, x);
				if(now.l <= y && y <= now.r) {
					res = a[now.l + now.r - y];
					break;
				}
				x -= now.w;
				nowp = now.r + 1;
				nowc -= now.r - now.l;
			}
			printf("%d\n", res);
		}
	}
	return 0;
}