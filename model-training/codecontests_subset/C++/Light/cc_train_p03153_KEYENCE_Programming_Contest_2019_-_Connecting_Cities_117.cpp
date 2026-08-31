#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);

	ll n, D;
	cin >> n >> D;
	vector<ll> a(n);
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	vector<ll> b = a;
	for (int i = 1; i < n; ++i)
		b[i] = min(b[i], b[i - 1] + D);
	for (int i = n - 2; i >= 0; --i)
		b[i] = min(b[i], b[i + 1] + D);

	const int src = min_element(a.begin(), a.end()) - a.begin();

	ll ans = 0;
	for (int i = src - 1; i >= 0; --i) {
		ans += a[i] + b[i + 1] + D;
	}

	for (int i = src + 1; i < n; ++i) {
		ans += a[i] + b[i - 1] + D;
	}
	cout << ans;
	return 0;
}
