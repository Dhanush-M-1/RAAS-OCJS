#include"bits/stdc++.h"
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)
#define int long long
int r[100006];
int t[100005], a[100005];
signed main() {
	int x, k; cin >> x >> k;
	rep(i, k)cin >> r[i+1];
	int q; cin >> q;
	rep(i, q)cin >> t[i] >> a[i];
	t[q] = 1145141919;
	r[k + 1] = 1145141919;
	int u = 0, d = x, ux = 0, dx = x;
	int now = 0;
	rep(i, k+1) {
		while (t[now] < r[i+1]) {
			int ft = a[now];
			if (ft < u)ft = u;
			else if (d < ft)ft = d;
			int D = t[now] - r[i];
			if (i & 1) {
				ft += D + ux - u;
				ft = min(ft, x);
				cout << ft << endl;
			}
			else {
				ft -= D; ft += ux - u;
				ft = max(0ll, ft);
				cout << ft << endl;
			}
			now++;
		}
		int D = r[i + 1] - r[i];
		if (i & 1) {
			ux += D; dx += D;
			if (dx > x) {
				d -= dx - x;
				dx = x;
			}
			if (ux > x) {
				u = d = x;
				ux = dx = x;
			}
		}
		else {
			ux -= D; dx -= D;
			if (ux < 0) {
				u += -ux;
				ux = 0;
			}
			if (dx < 0) {
				u = d = ux = dx = 0;
			}
		}
	}
}