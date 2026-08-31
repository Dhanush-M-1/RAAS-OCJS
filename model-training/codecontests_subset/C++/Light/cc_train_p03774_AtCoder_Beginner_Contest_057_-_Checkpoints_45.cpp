#include <bits/stdc++.h>

using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, M;
	cin >> N >> M;
	vector<pair<int, int>> S(N), C(M);
	for (auto &p : S) {
		cin >> p.first >> p.second;
	}
	for (auto &p : C) {
		cin >> p.first >> p.second;
	}
	for (auto s : S) {
		int d = 1e9, ans;
		for (int i = 0; i < M; ++i) {
			int dd = abs(s.first-C[i].first) + abs(s.second-C[i].second);
			if (dd < d) {
				d = dd;
				ans = i;
			}
		}
		cout << ans+1 << "\n";
	}
}