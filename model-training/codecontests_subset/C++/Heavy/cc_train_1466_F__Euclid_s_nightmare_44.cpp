#include <bits/stdc++.h>
#define MOD 1000000007
using namespace std;

typedef pair<int, int> ii;

int p[500001];

int find(int a) {
	if (a == p[a]) return a;
	else return p[a] = find(p[a]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);

	if (a != b) {
		p[a] = b;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	vector<int> one(m, 0);
	vector<vector<int>> two(m);
	vector<int> ans;

	for (int i = 0; i <= m; ++i) p[i] = i;

	int k, a, b;
	for (int i = 0; i < n; ++i) {
		cin >> k;
		if (k == 1) {
			cin >> a;
			int aa = find(a);
			if (aa != 0) {
				ans.push_back(i);
				// deleta a
				p[aa] = 0;
			}
		}
		else {
			cin >> a >> b;
			int aa = find(a), bb = find(b);
			if (aa == 0 && bb == 0) continue;
			else if (aa == 0) {
				ans.push_back(i);
				// deleta b
				p[bb] = 0;
			}
			else if (bb == 0) {
				ans.push_back(i);
				// deleta a
				p[aa] = 0;
			}
			else {
				if (aa != bb) {
					merge(a, b);
					ans.push_back(i);
				}
			}
		}				
	}
	long long p = 1;
	for (int i = 0; i < ans.size(); ++i) {
		(p *= 2) %= MOD;
	}
	cout << p << ' ' << ans.size() << '\n';
	for (int u: ans) cout << u + 1 << ' ';
	cout << '\n';
}