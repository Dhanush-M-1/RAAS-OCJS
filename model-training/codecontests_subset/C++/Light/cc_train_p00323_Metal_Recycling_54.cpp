#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> d(201000, 0);
	int a, b;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		d[a + b]++;
	}
	for (int i = 0; i < 201000; i++) {
		if (d[i] > 0) {
			int k = d[i] / 2;
			int kk = d[i] % 2;
			if (kk > 0) {
				cout << i << ' ' << 0 << endl;
			}
			d[i + 1] += k;
		}
	}
	return 0;
}