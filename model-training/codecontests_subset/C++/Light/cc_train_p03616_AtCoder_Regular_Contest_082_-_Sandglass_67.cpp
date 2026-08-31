#include <bits/stdc++.h>
using namespace std;
const int MAX = (1e5)+1;

int X, n, q;
long long r[MAX], t[MAX], a[MAX];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin >> X >> n;
	for(int i = 1; i <= n; i++) cin >> r[i];
	cin >> q;
	long long mn = 0, mx = X, sum = 0;
	for(int i = 1, j = 1, mul = -1; i <= q; i++) {
		cin >> t[i] >> a[i];
		while(j <= n && r[j] <= t[i]) {
			sum += mul * (r[j] - r[j-1]);
			mn += mul * (r[j] - r[j-1]);
			mx += mul * (r[j] - r[j-1]);
			mn = max(0ll, mn);
			mn = min(1ll * X, mn);
			mx = max(0ll, mx);
			mx = min(1ll * X, mx);
			mul *= -1;
			++j;
		}
		
		a[i] += sum;
		if(a[i] < mn) a[i] = mn;
		if(a[i] > mx) a[i] = mx;
		a[i] += mul * (t[i] - r[j-1]); // always over 1
		a[i] = max(0ll, a[i]);
		a[i] = min(1ll * X, a[i]);

		cout << a[i] << '\n';
	}
}
