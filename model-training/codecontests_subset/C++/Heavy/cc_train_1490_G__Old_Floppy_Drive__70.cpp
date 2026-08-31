#include <bits/stdc++.h>
#define pb push_back
typedef long long ll;
using namespace std;
int main() {
	int t;
	cin >> t;
	while (t--) {
		int n, m;
		cin >> n >> m;
		vector <ll> vec(n);
		vector <pair<ll, int>> add;
		ll sum1 = 0, sum2 = 0;
		for (int i = 0; i < n; ++i) {
			cin >> vec[i];
			sum1 += vec[i];
			if (sum1 > sum2) {
				add.pb({sum1, i});
				sum2 = sum1;
			}
		}
		vector <ll> add2;
		for (auto it : add)
			add2.pb(it.first);
		while (m--) {
			ll x;
			cin >> x;
			int pos = lower_bound(add2.begin(), add2.end(), x) - add2.begin();
			if (pos < add2.size())
				cout << add[pos].second << " ";
			else {
				if (sum1 <= 0)
					cout << -1 << " ";
				else {
					ll l = 1, r = 2e9;
					ll ans2 = -1;
					while (l <= r){
						ll mid = (l + r) >> 1;
						ll temp = x - mid * sum1;
						ll ans = n * mid - 1;
						bool f = true;
						if (temp > 0){
							int pos = lower_bound(add2.begin(), add2.end(), temp) - add2.begin();
							if (pos < add2.size())
								ans += add[pos].second + 1;
							else
								f = false;
						}
						if (f){
							ans2 = ans;
							r = mid - 1;
						}
						else
							l = mid + 1;
					}
					cout << ans2 << " ";
				}
			}
		}
		cout << endl;
	}
}