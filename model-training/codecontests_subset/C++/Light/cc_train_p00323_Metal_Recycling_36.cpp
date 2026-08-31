#include<iostream>
using namespace std;
int a[100000], b[100000], n, c[1000000];
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i] >> b[i]; c[a[i] + b[i]]++;
	}
	for (int i = 0; i < 999999; i++) {
		c[i + 1] += c[i] / 2; c[i] %= 2;
		if (c[i] == 1)cout << i << ' ' << 0 << endl;
	}
	return 0;
}