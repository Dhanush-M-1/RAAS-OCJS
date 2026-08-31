#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int N = 200005;

int n, d;
int a[N];
ll ans, opt;
vector<pair<ll,int>> vals;

int main() {
	scanf("%d %d", &n, &d);
	for (int i = 1; i <= n; ++i) {
		scanf("%d", a + i);
	}
	for (int i = 2; i <= n; ++i) {
		ll x = (ll) a[i] + (ll) i * d;
		while (vals.size() && vals.back().first >= x) {
			vals.pop_back();
		}
		vals.push_back(make_pair(x, i));
	}
	int now = 2;
	opt = a[1] - d;
	for (auto p : vals) {
		int nxt = p.second;
		ans += p.first + opt;
		for (int i = now; i < nxt; ++i) {
			ans += a[i] + min(p.first - (ll) i * d, opt + (ll) i * d);
			opt = min(opt, a[i] - (ll) i * d);
		}
		opt = min(opt, a[nxt] - (ll) nxt * d);
		now = nxt + 1;
	}
	printf("%lld\n", ans);
}