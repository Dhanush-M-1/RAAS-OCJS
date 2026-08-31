#include <cstdio>
#include <algorithm>

#define Rep(i, n) for (int i = 1; i <= n; i ++)
#define Rep0(i, n) for (int i = 0; i <= n; i ++)
#define RepG(i, x) for (int i = head[x]; i; i = edge[i].next)

using namespace std;

typedef long long LL;
const int N = 100010;

LL r[N], a[N], b[N], z[N];
int main()
{
	LL x, k;
	scanf("%lld%lld", &x, &k);
	a[0] = 0, b[0] = x;
	Rep(i, k) {
		scanf("%lld", &r[i]);
		LL tmp = r[i] - r[i - 1];
		a[i] = a[i - 1], b[i] = b[i - 1], z[i] = z[i - 1];
		if (i & 1) {
			if (z[i] >= tmp) z[i] -= tmp;
			else if (tmp <= b[i] - a[i] + z[i])
				a[i] += tmp - z[i], z[i] = 0; 
			else z[i] = 0, a[i] = 0, b[i] = 0;
		}
		else {
			if (z[i] + b[i] - a[i] + tmp <= x) z[i] += tmp;
			else if (z[i] + tmp <= x)
				z[i] += tmp, b[i] -= z[i] + b[i] - a[i] - x;
			else z[i] = x, a[i] = 0, b[i] = 0;
		}
		//printf("%lld %lld %lld\n", a[i], b[i], z[i]);
	}
	int q;
	scanf("%d", &q);
	Rep(i, q) {
		LL a0, t0;
		scanf("%lld%lld", &t0, &a0);
		LL tmp = (upper_bound(r + 1, r + 1 + k, t0) - r) - 1;
		LL ans;
		if (a0 <= a[tmp]) ans = z[tmp];
		else if (a0 <= b[tmp]) ans = z[tmp] + a0 - a[tmp];
		else ans = z[tmp] + b[tmp] - a[tmp];
		LL tx = t0 - r[tmp];
		if ((tmp + 1) & 1) ans = max(0ll, ans - tx);
		else ans = min(x, ans + tx);
		
		printf("%lld\n", ans);
	}
	
	return 0;
}
/*
50 3
9 35 67
1
92 28
38

*/