#include <bits/stdc++.h>
using namespace std;
 
#define int long long

const int N = 1e5 + 10, mod = 1e9 + 7;
int n, m, ar[N], dp[N];

int32_t main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		ar[x] = 1;
	}
	
	dp[0] = 1;
	for (int i = 1; i <= n; i++)
		if (!ar[i])
			dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
	cout << dp[n];
}