#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef pair<ll, ll> pll;

const int Max = 2e6 + 10;
const int Mod = 1e9 + 7;
const ll Inf = 1LL << 62;

ll ar[Max];
ll pos[Max];
ll x[Max];

void Solve() {
	ll n, m;
	cin >> n >> m;
	ll sum = 0, mx = -Inf;

	for (ll i = 1; i <= n; i++) {
		cin >> ar[i];
		sum += ar[i];
		mx = max(mx, sum);
		pos[i] = mx;
	}

	for (ll i = 1; i <= m; i++) {
		cin >> x[i];
	}

	for (ll i = 1; i <= m; i++) {
		if (x[i] <= mx) {
			ll l = 1, r = n, ans = -1;

			while (l <= r) {
				ll mid = (l + r) >> 1;

				if (pos[mid] >= x[i]) {
					ans = mid - 1;
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}

			cout << ans << " ";
		} else if(sum <= 0) {
			cout << "-1" << " ";
		} else {
			ll res = Inf;
			ll mm = x[i];
			mm -= mx;
			ll now = mm / sum;

			for (ll j = now - 1; j <= now + 1; j++) {
				if(j < 1) {
					continue;
				}

				ll now = j * n - 1;
				ll l = 1, r = n, ans = -1;

				while (l <= r) {
					ll mid = (l + r) >> 1;

					if (pos[mid] + j * sum >= x[i]) {
						ans = mid;
						r = mid - 1;
					} else {
						l = mid + 1;
					}
				}

				if (ans != -1) {
					res = min(res, now + ans);
				}
			}

			now = x[i] / sum;

			for (ll j = now - 1; j <= now + 1; j++) {
				if(j < 1) {
					continue;
				}

				ll now = j * n - 1;
				ll l = 1, r = n, ans = -1;

				while (l <= r) {
					ll mid = (l + r) >> 1;

					if (pos[mid] + j * sum >= x[i]) {
						ans = mid;
						r = mid - 1;
					} else {
						l = mid + 1;
					}
				}

				if (ans != -1) {
					res = min(res, now + ans);
				}
			}

			if (res == Inf) {
				res = -1;
			}

			cout << res << " ";
		}
	}

	cout << endl;
}

int main(int argc, char const *argv[]) {
	ios_base::sync_with_stdio();
	cin.tie(0);
	int T = 1;
	cin >> T;

	while (T--) {
		Solve();
	}

	return 0;
}