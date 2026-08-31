#include<bits/stdc++.h>
using namespace std;
int main() {
	int n, v, ans = 0;
	cin >> n;
	vector<int> num(n);
	for (int i = 0; i < n; i++) {
		cin >> num.at(i);
	}
	for (int i = 0; i < n; i++) {
		v = i;
		for (int j = i + 1; j < n; j++) {
			if (num[j] < num[v]) {
				v = j;
			}
		}
		if (i != v) {
			swap(num[i], num[v]);
			ans++;
		}
	}
	for (int k = 0; k < n; k++) {
		printf("%d", num.at(k));
		if (k != n - 1)cout << ' ';
		else cout << endl;
	}
	cout << ans << endl;
}
