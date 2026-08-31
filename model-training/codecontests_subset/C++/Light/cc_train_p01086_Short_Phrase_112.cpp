#include <bits/stdc++.h>
using namespace std;

int cnt[501];

int main()
{
	int n;
	while (cin >> n, n) {
		fill(cnt, cnt + 501, 0);
		int p = 0;
		cnt[p] = 1;
		for (int i = 0; i < n; i++) {
			string w;
			cin >> w;
			p += w.size();
			cnt[p] = i + 2;
		}
		vector<int> v = { 5, 7, 5, 7, 7 };
		vector<int> sum(6);
		for (int i = 0; i < 5; i++) {
			sum[i + 1] = sum[i] + v[i];
		}
		for (int i = 0; i <= 400; i++) {
			bool ok = true;
			for (int j = 0; j < 6; j++) {
				ok &= cnt[i + sum[j]] > 0;
			}
			if (ok) {
				cout << cnt[i] << endl;
				break;
			}
		}
	}
	return 0;
}

