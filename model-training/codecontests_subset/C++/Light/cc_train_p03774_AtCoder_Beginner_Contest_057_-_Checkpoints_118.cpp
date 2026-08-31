#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a[64], b[64], c[64], d[64];

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; ++i)
		cin >> a[i] >> b[i];

	for (int i = 0; i < m; ++i) 
		cin >> c[i] >> d[i];

	for (int i = 0; i < n; ++i) {
		
		int ans = 1;
		int mini = 1e9 + 9;

		for (int j = 0; j < m; ++j) {
			if (mini > abs(a[i] - c[j]) + abs(b[i] - d[j])) {
				ans = j + 1;
				mini = abs(a[i] - c[j]) + abs(b[i] - d[j]);
			}
		}

		cout << ans << endl;
	}

}
