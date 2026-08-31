#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	while ( cin >> n, n ) {
		vector<int> v(n);
		for (int i = 0; i < n; ++i) {
			cin >> v[i];
		}
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (v[j] > v[i]) ++ans;
			}
		}
		cout << ans << endl;
	}
}