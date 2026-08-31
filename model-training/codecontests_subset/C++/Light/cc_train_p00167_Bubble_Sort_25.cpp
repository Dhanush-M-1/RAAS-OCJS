#include <bits/stdc++.h>
using namespace std;

int n, a[100];
signed main() {
 cin.tie(0);
 ios::sync_with_stdio(false);

  while (1) {
		cin >> n;
		if (n == 0) break;

		int ans = 0;
		for (int i = 0; i < n; i++) 
			cin >> a[i];
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if (a[j] > a[j+1]) {
					swap(a[j], a[j+1]);
					ans++;
				}
			}
		}
		cout << ans << endl;
	}
  return 0;
}



