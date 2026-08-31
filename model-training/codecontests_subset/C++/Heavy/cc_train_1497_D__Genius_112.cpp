#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <vector>
#include <queue>
#include <map>
#include <set>
using namespace std;
#define int long long
#define ull unsigned long long
#define fi first
#define se second
#define mpr make_pair
#define dingyi int mid = l + r >> 1, ls = p << 1, rs = p << 1 | 1
#define y0 y_csyakioi_0
#define y1 y_csyakioi_1
#define rep(i, x, y) for(int i = x; i <= y; ++i)
#define per(i, x, y) for(int i = x; i >= y; --i)
#define repg(i, u) for(int i = head[u]; i; i = e[i].nxt)
inline int read(){
	int x = 0, f = 1; char ch = getchar();
	while(ch < '0' || ch > '9'){ if(ch == '-') f = -1; ch = getchar(); }
	while(ch >= '0' && ch <= '9'){ x = x * 10 + (ch ^ 48); ch = getchar(); }
	return x * f;
}
const int N = 5010;
int n, a[N], b[N], f[N], x, y;
inline int abss(int x){ return x < 0 ? -x : x; }
inline void mian(){
	n = read(); rep(i, 1, n) a[i] = read();
	rep(i, 1, n) b[i] = read(), f[i] = 0;
	rep(i, 2, n) per(j, i - 1, 1){
		if(a[i] == a[j]) continue;
		x = f[i]; y = f[j];
		f[i] = max(f[i], y + abss(b[i] - b[j]));
		f[j] = max(f[j], x + abss(b[i] - b[j]));
	}
	int ans = 0; rep(i, 1, n) ans = max(ans, f[i]);
	printf("%lld\n", ans);
}
signed main(){ int qwq = read(); while(qwq--) mian(); return 0; }