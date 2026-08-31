#include <iostream>
using namespace std;

int solve(int x) {
	int count = 0;
	while (x >= 10) {
		int ma = 0;
		for (int s = 10; x / s > 0; s *= 10) {
			int d = x / s;
			int m = x % s;
			ma = max(ma, d * m);
		}
		x = ma;
		count++;
	}
	return count;
}

int main () {
	int n;
	for (cin >> n; n; n--) {
		int x;
		cin >> x;
		cout << solve(x) << endl;
	}
	return 0;
}