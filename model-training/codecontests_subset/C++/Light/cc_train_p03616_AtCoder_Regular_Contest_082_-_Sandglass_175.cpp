#include<iostream>
#include<iomanip>
#include<vector>
#include<set>
#include<string>
#include<algorithm>
#include<math.h>
#include<queue>
#include<unordered_set>
using namespace std;
const int MAX = 100002;
const int INF = 1000000000;

int main() {
	int X, K, Q;
	int m[MAX], ub[MAX], lb[MAX], up[MAX], lo[MAX];
	vector<int> r;
	
	cin >> X >> K;
	r.push_back(0);
	for (int i = 1; i <= K; i++) {
		int temp;
		cin >> temp;
		r.push_back(temp);
	}
	r.push_back(INF);

	m[0] = 0;
	ub[0] = X;
	lb[0] = 0;
	up[0] = 0;
	lo[0] = 0;

	bool b = true;
	for (int i = 1; i < r.size(); i++) {
		int td = r[i] - r[i - 1];

		if (b) {
			ub[i] = max(0, ub[i - 1] - td);
			lb[i] = max(0, lb[i - 1] - td);
			m[i] = m[i - 1] - td;
		}
		else {
			ub[i] = min(X, ub[i - 1] + td);
			lb[i] = min(X, lb[i - 1] + td);
			m[i] = m[i - 1] + td;
		}

		up[i] = max(m[i], up[i - 1]);
		lo[i] = min(m[i], lo[i - 1]);

		b = !b;
	}

	cin >> Q;

	for (int i = 0; i < Q; i++) {
		int t, a;
		cin >> t >> a;

		vector<int>::iterator it = upper_bound(r.begin(), r.end(), t);

		int index = distance(r.begin(), it) - 1;

		int ans = 0;

		if (a + up[index] > X) {
			ans = ub[index];
		}
		else if (a + lo[index] < 0) {
			ans = lb[index];
		}
		else {
			ans = m[index] + a;
		}

		t -= r[index];
		if (index & 1) {
			ans = min(X, ans + t);
		}
		else {
			ans = max(0, ans - t);
		}

		cout << ans << endl;
	}
	return 0;
}