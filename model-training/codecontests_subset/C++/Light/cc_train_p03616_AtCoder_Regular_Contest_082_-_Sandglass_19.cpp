#include <bits/stdc++.h>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	int X;
	int K;
	cin >> X >> K;
	vector<int> r(K + 1);
	r[0] = 0;
	for (int i = 1; i <= K; i++) cin >> r[i];
	int Q;
	cin >> Q;
	int L = 0, R = X, c = 0;
	for (int i = 0, j = 1; i < Q; i++) {
		int t, a;
		cin >> t >> a;
		while (j <= K && t >= r[j]) {
			if (j % 2 == 1) {
				c -= r[j] - r[j - 1];
			} else {
				c += r[j] - r[j - 1];
			}
			R = max(min(R, X - c), -c);
			L = min(max(L, -c), X - c);
			j++;
		}
		int ans;
		if (a < L) {
			ans = L + c;
		} else if (a > R) {
			ans = R + c;
		} else {
			ans = a + c;
		}
		if (j % 2 == 1) ans = max(ans - t + r[j - 1], 0);
		else ans = min(ans + t - r[j - 1], X);
		cout << ans << endl;
	}
	return 0;
}