#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	int j = 1, d[3] = { 1 }, p = 1e9 + 7;
	for (int i = 0; i <= m; i++) {
		int a = n + 1;
		if (i < m)
			scanf("%d", &a);
		for (; j < a; j++)
			(d[j % 3] = d[(j + 1) % 3] + d[(j + 2) % 3]) %= p;
		d[a % 3] = 0;
		j = a + 1;
	}
	cout << d[n % 3] << endl;
	return 0;
}
