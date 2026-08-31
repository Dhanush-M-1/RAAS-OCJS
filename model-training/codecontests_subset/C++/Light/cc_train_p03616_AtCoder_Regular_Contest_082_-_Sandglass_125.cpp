#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int X, K, Q, v[100009], t[100009], a[100009], ans[100009]; vector<int> g[100009];
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	cin >> X >> K; K++;
	for (int i = 1; i < K; i++) cin >> v[i];
	cin >> Q;
	for (int i = 0; i < Q; i++) {
		cin >> t[i] >> a[i];
		g[lower_bound(v, v + K, t[i] + 1) - v - 1].push_back(i);
	}
	int l = 0, r = X, e = 0;
	for (int i = 0; i < K; i++) {
		for (int j : g[i]) {
			int val = (a[j] < l ? e : (a[j] > r ? e + r - l : e + a[j] - l));
			ans[j] = (i & 1 ? min(X, val + t[j] - v[i]) : max(0, val - t[j] + v[i]));
		}
		if (i & 1) {
			e += v[i + 1] - v[i];
			if (e + r - l > X) {
				r -= e + r - l - X;
				if (r < l) r = l;
				e = X - r + l;
			}
		}
		else {
			e -= v[i + 1] - v[i];
			if (e < 0) {
				l -= e; e = 0;
				if (l > r) l = r;
			}
		}
	}
	for (int i = 0; i < Q; i++) cout << ans[i] << '\n';
	return 0;
}