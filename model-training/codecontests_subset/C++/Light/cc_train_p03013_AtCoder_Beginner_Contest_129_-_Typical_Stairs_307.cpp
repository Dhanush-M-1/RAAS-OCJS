#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int main() 
{
	ll n, m; cin >> n >> m;
	vector<ll> dp(n, 0);
	for (ll i = 0; i < m; i++)
	{
		ll e; cin >> e;
		dp[e - 1] = 1;
	}
	dp[0] = (dp[0] ? 0 : 1);
	dp[1] = (dp[1] ? 0 : dp[0] + 1);
	for (ll i = 2; i < n; i++)
		if (dp[i])
			dp[i] = 0;
		else
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
	cout << dp[n - 1];
	return 0;
}