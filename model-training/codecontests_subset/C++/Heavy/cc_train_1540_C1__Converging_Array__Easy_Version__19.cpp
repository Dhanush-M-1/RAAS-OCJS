#include <bits/stdc++.h>
using namespace std;
#define ll long long
const int maxn = 105;
const int maxm = 10005;
const int mod = 1e9 + 7;
inline int add(int x, int y) {
	x += y;
	return x >= mod ? x - mod : x;
}
inline int sub(int x, int y) {
	x -= y;
	return x < 0 ? x + mod : x;
}
inline int mul(int x, int y) {
	return 1ll * x * y % mod;
}
int n, q, c[maxn], b[maxn], preb[maxn];
int _ans[maxm << 1], *ans = _ans + maxm;
int calc(int x) {
	static int f[maxm], _s[maxm], *sum = _s + 1;
	f[0] = 1;
	int low = 0, upp = 0;
	for(int i = 1; i <= n; i++) {
		sum[low - 1] = 0;
		for(int j = low; j <= upp; j++)
			sum[j] = add(sum[j - 1], f[j]);
		int st = max(0, x * i + preb[i]), ed = upp + c[i];
		if(st > ed)
			return 0;
		for(int j = st; j <= ed; j++) 
			f[j] = sub(sum[min(j, upp)], sum[max(j - c[i], low) - 1]);
		low = st, upp = ed;
	}
	int ans = 0;
	for(int i = low; i <= upp; i++)
		ans = add(ans, f[i]);
	return ans;
}
int main() {
	scanf("%d", &n);
	int all = 1;
	for(int i = 1; i <= n; i++) 
		scanf("%d", &c[i]), all = mul(all, c[i] + 1);	
	for(int i = 1; i < n; i++) {
		scanf("%d", &b[i]);		
		preb[i + 1] = preb[i] + b[i];
	}
	for(int i = 2; i <= n; i++)
		preb[i] += preb[i - 1];
	int L = 0, R = 1;
	ans[0] = calc(0), ans[1] = calc(1);
	for(; ans[R]; R++, ans[R] = calc(R));
	for(; ans[L] != all; L--, ans[L] = calc(L));
	scanf("%d", &q);
	for(int i = 1, x; i <= q; i++) {
		scanf("%d", &x);
		if(x > R)
			puts("0");
		else if(x < L)
			printf("%d\n", all);
		else
			printf("%d\n", ans[x]);
	}
	return 0;
}