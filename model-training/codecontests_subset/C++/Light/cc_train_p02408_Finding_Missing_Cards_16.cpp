#include <bits/stdc++.h>
using namespace std;

const vector<char> m = {'S', 'H', 'C', 'D'};

signed main() {
	int n;
	cin >> n;
	char c;
	int num;
	map<char, vector<bool>> a;

	for (int i = 0; i < 4; ++i) {
		a[m[i]].resize(13);
	}

	for (int i = 0; i < n; ++i) {
		cin >> c >> num;
		a[c][num - 1] = true; 
	}

	for (int mark = 0; mark < 4; ++mark) {
		for (int i = 0; i < 13; ++i) {
			if (!a[m[mark]][i]) {
				cout << m[mark] << ' ' << i + 1 << endl;
			}
		}
	}
}

