		
#include<bits/stdc++.h>
using namespace std;

#define int long long
#define ll long long

const int N = 2e5 + 5, M = 1e9 + 7;
vector<vector<int>> dp;

void pre() {
	dp = vector<vector<int>> (N, vector<int> (10, 1));
	for(int i = 1 ; i < N ; i++) {
		for(int j = 0 ; j < 9 ; j++) {
			dp[i][j] = dp[i - 1][j + 1];
		}
		dp[i][9] = (dp[i - 1][0] + dp[i - 1][1]) % M;
	}
}

void solve() {
	int res = 0;
	int n, m;
	cin >> n >> m;
	while(n) {
		res = (res + dp[m][n % 10]) % M;
		n /= 10;
	}
	cout << res << "\n";
}

signed main() {
	ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	int t = 1;
	pre();
	cin >> t;
	while(t--)
		solve();
	return 0;
}