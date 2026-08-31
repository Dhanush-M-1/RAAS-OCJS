#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	int q, n, m, i, j, a, b, d, cnt, max;

	cin >> q;

	for (i = 0; i < q; i++) {
		cnt = 0; 
		cin >> n;

		while (n / 10 != 0) {
			d = 1; m = n; max = 0;

			while (m / 10 != 0) {
				m /= 10;
				d++;
			}

			for (j = 1; j < d; j++) {
				a = n / pow(10, j);
				b = n - a * pow(10, j);
				if (a * b > max) {
					max = a * b;
				}
			}

			n = max;
			cnt++;
		}
		
		cout << cnt << endl;
	}
}