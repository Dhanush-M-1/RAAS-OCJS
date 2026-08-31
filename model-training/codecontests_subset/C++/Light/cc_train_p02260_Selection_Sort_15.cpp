#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	int n, a[100];
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	int ans = 0;
	for (int i = 0; i < n; i++) {
		int minj = i;
		for (int j = i; j < n; j++)
			if (a[j] < a[minj])
				minj = j;
		if (i != minj) {
			swap(a[i], a[minj]);
			ans++;
		}
	}
	for (int i = 0; i < n; i++)
		cout << a[i] << (i == n - 1 ? '\n' : ' ');
	cout << ans << endl;
}
