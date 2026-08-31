#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int cnt = 0;

void mulspl(int n) {
	int place = 0, tmp = n, i = 0;
	vector<int> sp(10);
	while (tmp > 0) {
		sp[i] = tmp % 10;
		tmp /= 10;
		place++, i++;
	}
	if (place > 1) {
		int maxi = 0;
		for (int i = 1; i < place; ++i) {
			int x = (n / (int)pow(10, i)) * (n % (int)pow(10, i));
			maxi = max(maxi, x);
		}
		cnt++;
		mulspl(maxi);
	}
}

int main() {
	int q;
	cin >> q;
	int n;
	for (int i = 0; i < q; ++i) {
		cin >> n;
		mulspl(n);
		cout << cnt << endl;
		cnt = 0;
	}

	return 0;
}
