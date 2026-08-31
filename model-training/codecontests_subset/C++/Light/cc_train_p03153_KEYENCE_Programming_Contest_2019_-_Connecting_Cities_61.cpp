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

	ll ans = accumulate(a.begin(), a.end(), 0LL) + (n - 1LL) * D;
	if (n >= 3)
		ans += accumulate(b.begin() + 1, b.end() - 1, 0LL);
	cout << ans;
	return 0;
}
