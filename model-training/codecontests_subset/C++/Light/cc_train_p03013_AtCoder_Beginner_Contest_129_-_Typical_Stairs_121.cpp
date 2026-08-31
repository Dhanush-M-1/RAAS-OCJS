#include <bits/stdc++.h>
using namespace std;

const int mod = 1E9 + 7;

int main() {
	int n, m;
	cin >> n >> m;
	vector<int> A(n+1, 0);
	vector<int> flg(n+1, 0);

	for (int i = 1; i <= m; i++) {
		int x;
		cin >> x;
		A[x] = 1;
	}

	flg[0] = 1;

	for (int i = 1; i <= n; i++) {
		if (!A[i])
			flg[i] = (flg[i-1] + flg[i-2]) % mod;
	}

	cout << flg[n] << endl;
}