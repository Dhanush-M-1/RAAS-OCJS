#include<iostream>
#include<algorithm>
using namespace std;
int p(int r) {
	int ans = -1;
	for (int i = 10; i <= r; i *= 10) {
		ans = max(ans, ((r - r % i) / i)*(r % i));
	}
	return ans;
}
int main() {
	int q; cin >> q;
	for (int i = 0; i < q; i++) {
		int k; cin >> k;
		int cnt = 0;
		while (k >= 10) { k = p(k); cnt++; }
		cout << cnt << endl;
	}
}