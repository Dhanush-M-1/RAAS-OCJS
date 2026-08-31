#include <iostream>
using namespace std;

int main() {
	int n,a[100],cnt;
	while (cin >> n, n) {
		cnt = 0;
		for (int i = 0; i < n; i++) cin >> a[i];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) cnt++;
			}
		}
		cout << cnt << endl;
	}
	return 0;
}