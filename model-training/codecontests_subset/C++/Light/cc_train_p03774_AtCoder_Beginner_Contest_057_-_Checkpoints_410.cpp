#include <bits/stdc++.h>
using namespace std;

int main()
{
	int N, M;
	cin >> N >> M;
	vector<int> a(N), b(N), c(M), d(M);
	for (int i = 0; i < N; i++) {
		cin >> a[i] >> b[i];
	}
	for (int i = 0; i < M; i++) {
		cin >> c[i] >> d[i];
	}
	for (int i = 0; i < N; i++) {
		int res, dis = 1000000000;
		for (int j = 0; j < M; j++) {
			int t = abs(a[i] - c[j]) + abs(b[i] - d[j]);
			if (t < dis) {
				dis = t;
				res = j + 1;
			}
		}
		cout << res << endl;
	}
	return 0;
}
