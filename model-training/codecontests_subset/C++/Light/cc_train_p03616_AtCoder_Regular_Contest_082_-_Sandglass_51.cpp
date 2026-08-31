# include <iostream>
# include <algorithm>
# include <vector>
# include <string>
# include <set>
# include <map>
# include <cmath>
# include <iomanip>
# include <functional>
# include <utility>
# include <stack>
# include <queue>
# include <list>
using namespace std;
using LL = long long;
constexpr int MOD = 1000000000 + 7;
constexpr int INF = 2000000000;
const double PI = acos(-1);

int main() {
	int x, k;
	cin >> x >> k;
	int r[100000];
	for (int i = 0; i < k; i++) {
		cin >> r[i];
	}
	int q;
	cin >> q;
	int t[100000], a[100000];
	for (int i = 0; i < q; i++) {
		cin >> t[i] >> a[i];
	}
	int L = 0, R = x;
	int j = 0, p = 0, d = 0;
	int lv = 0, uv = x;
	for (int i = 0; i < q; i++) {
		while (j < k&&r[j] <= t[i]) {
			if (j % 2 == 0) {
				p += r[j] - d;
				lv = max(lv - (r[j] - d), 0);
				uv = max(uv - (r[j] - d), 0);
			}
			else {
				p -= r[j] - d;
				lv = min(lv + (r[j] - d), x);
				uv = min(uv + (r[j] - d), x);
			}
			L = max(L, p);
			R = min(R, x + p);
			d = r[j++];
		}
		int c;
		if (L <= a[i] && a[i] <= R) c = a[i] - p;
		if (a[i]<L) c = lv;
		if (R<a[i]) c = uv;
		if (j % 2 == 0) c = max(c - (t[i] - d), 0);
		else c = min(c + (t[i] - d), x);
		cout << c << endl;
	}
}
