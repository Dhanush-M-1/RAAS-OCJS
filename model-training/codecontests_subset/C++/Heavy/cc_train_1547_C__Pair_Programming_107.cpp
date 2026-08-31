#include <iostream>
#include <vector>

using namespace std;

void solve() {
	int k, n, m;
	cin >> k >> n >> m;
	vector<int> v1, v2;
	for (int i = 0; i < n; i++) {
		int p;
		cin >> p;
		v1.push_back(p);
	}
	for (int i = 0; i < m; i++) {
		int p;
		cin >> p;
		v2.push_back(p);
	}
	vector<int> ans;
	int a = 0, b = 0;
	for (int i = 0; i < n + m; i++) {
		if (a < n && v1[a] == 0) {
			ans.push_back(v1[a]);
			k++;
			a++;
			continue;
		}
		if (b < m && v2[b] == 0) {
			ans.push_back(v2[b]);
			k++;
			b++;
			continue;
		}
		if (a < n && b < m) {
			if (min(v1[a], v2[b]) > k) {
				cout << -1 << endl;
				return;
			}
			if (v1[a] < v2[b]) {
				ans.push_back(v1[a]);
				a++;
				continue;
			}
			else {
				ans.push_back(v2[b]);
				b++;
				continue;
			}
		}
		if (a < v1.size()) {
			if(v1[a]>k) {
				cout << -1 << endl;
				return;
			}
			ans.push_back(v1[a]);
			a++;
			continue;
		}
		else {
			if (v2[b] > k) {
				cout << -1 << endl;
				return;
			}
			ans.push_back(v2[b]);
			b++;
			continue;
		}
	}
	for (auto i : ans) {
		cout << i << ' ';
	}
	cout << endl;

}

int main()
{
	int t;
	cin >> t;
	while (t--) {
		solve();
	}

}