#include "bits/stdc++.h"
using namespace std;
#define int long long
#define rep(i, a, b) for (int i = (a); i < (int)(b); ++i)
#define rrep(i, a, b) for (int i = int(b) - 1; i >= (int)(a); --i)
using pii = pair<int, int>;
using vi = vector<int>;

int solve(int n) {
	vi a(n);
	rep(i, 0, n) {
		string s;
		cin >> s;
		a[i] = s.size();
	}

	const vi seq = { 5, 7, 5, 7, 7 };
	rep(i, 0, n) {
		int s = 0;
		int idx = 0;
		bool ng = false;
		rep(j, i, n) {
			s += a[j];
			if (s == seq[idx]) {
				s = 0;
				idx++;
				if (idx == seq.size())break;
			}
			else if (s > seq[idx]) {
				ng = true;
				break;
			}
		}
		if (!ng) {
			return i + 1;
		}
	}
	return -1;
}

signed main() {
	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;
		cout << solve(n) << endl;
	}
}
