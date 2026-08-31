#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

const int N = 5e3 + 10;
const int M = 1e7 + 10;

ll t;
ll n;
int tag[N];
int s[N];
ll dp[N];

void solve() {
	cin >> n;
	for(int i = 1; i <= n; i++)
		cin >> tag[i], dp[i] = 0;
	for(int i = 1; i <= n; i++)
		cin >> s[i];
	ll ans = 0;
	for(int i = 2; i <= n; i++) {
		dp[i] = 0;
		ll tim = 0;
		for(int j = i - 1; j >= 1; j--) {
			ll z = dp[j];
			if(tag[i] != tag[j])
				dp[j] = max(dp[j], dp[i] + abs(s[j] - s[i])),
				dp[i] = max(dp[i], z + abs(s[j] - s[i])),
				ans = max(ans,max(dp[j], dp[i]));       
		}
	}
	cout << ans << '\n';
}

int main() {
	ios_base::sync_with_stdio(0), cin.tie(0);  
	cin >> t;
	while(t--) {
		solve();
	}
}
