#include<bits/stdc++.h>
#define pb push_back
#define mp make_pair
#define X first 
#define Y second
using namespace std;
typedef pair<int, int> pii;
const int N = 222222;
vector<pii> a;
int x, n, ac[N], res[N], q;
int main() {
	scanf("%d", &x);
	scanf("%d", &n);
	for (int i = 1; i <= n; ++i) {
		int t;
		scanf("%d", &t);
		a.pb(mp(t, -1));
	}
	scanf("%d", &q);
	for (int i = 1; i <= q; ++i) {
		int t;
		scanf("%d%d", &t, &ac[i]);
		a.pb(mp(t, i));
	}
	sort(a.begin(), a.end());
	int i = 0, j = x, yi = 0, yj = x, dir = 0, t0 = 0;
	for (int _ = 0; _ < a.size(); ++_) {
		int t = a[_].X;
		if (t != t0) {
			int dt = t - t0;
			if (dir == 0) {
				if (yi >= dt) {
					yi -= dt;
					yj -= dt;
				} else if (yj < dt) {
					yj = yi = 0;
					i = j = 0;
				} else {
					i += dt - yi;
					yi = 0;
					yj -= dt;
				}
			} else {
				if (yj + dt <= x) {
					yi += dt;
					yj += dt;
				} else if (yi + dt > x) {
					i = j = 0;
					yi = yj = x;
				} else {
					j -= yj + dt - x;
					yi += dt;
					yj = x;
				}
			}
		}
		t0 = t;
		int id = a[_].Y;
		if (~id) {
			if (ac[id] <= i) res[id] = yi;
			else if (ac[id] >= j) res[id] = yj;
			else res[id] = yi + ac[id] - i;
		}
		else dir ^= 1;
	}
	for (int i = 1; i <= q; ++i) printf("%d\n", res[i]);
	return 0;
} 