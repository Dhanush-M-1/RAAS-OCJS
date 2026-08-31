#include <bits/stdc++.h>
#define LL long long
#define rep(i, s, t) for (register int i = (s), i##end = (t); i <= i##end; ++i)
#define dwn(i, s, t) for (register int i = (s), i##end = (t); i >= i##end; --i)
using namespace std;
inline int read() {
	int x = 0, f = 1;
	char ch = getchar();
	for (; !isdigit(ch); ch = getchar()) if (ch == '-') f = -f;
	for (; isdigit(ch); ch = getchar()) x = 10 * x + ch - '0';
	return x * f;
}
int a[500010], fa[500010], vis[500010], mod = 1e9 + 7;
inline int find(int x) { return x==fa[x]?x:fa[x]=find(fa[x]); }
int main() {
	int n = read(), m = read(), T = 0;
	rep(i, 1, m) fa[i] = i;
	rep(i, 1, n) {
		int opt = read();
		if(opt == 2) {
			int u = read(), v = read();
			u = find(u), v = find(v);
			if((vis[u] && vis[v]) || u == v) continue;
			fa[u] = v; vis[v] |= vis[u];
			a[i] = 1; ++T;
		} else {
			int u = read(); u = find(u);
			if(!vis[u]) a[i] = 1, T++, vis[u] = 1;
		}
	}
	int cur = T, pns = 1, bs = 2;
	rep(i, 1, T) pns = 2LL * pns % mod;
	cout << pns << " " << T << endl;
	rep(i, 1, n) if(a[i]) cout << i << " ";
}