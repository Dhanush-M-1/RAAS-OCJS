#include <iostream>
using namespace std;

int cnt[252521];

int main() {
	int n, a, b, i;
	
	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> a >> b;
		cnt[a + b]++;
	}
	
	for (i = 0; i < 252500; i++) {
		cnt[i + 1] += cnt[i] / 2;
		cnt[i] %= 2;
	}
	
	for (i = 0; i < 252500; i++) {
		if (cnt[i]) {
			cout << i << " " << 0 << endl;
		}
	}
	return 0;
}