#include <iostream>
using namespace std;

int main() {
	int n;

	while(cin >> n, n) {
		int a[128];
		bool flag = true;
		int ans = 0;

		for(int i = 0; i < n; i++)
			cin >> a[i];

		while(flag) {
			flag = false;
			for(int i = 0; i < n - 1; i++) {
				if(a[i] > a[i + 1]) {
					int tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					ans++;
					flag = true;
				}
			}
		}
		cout << ans << endl;
	}

	return 0;
}