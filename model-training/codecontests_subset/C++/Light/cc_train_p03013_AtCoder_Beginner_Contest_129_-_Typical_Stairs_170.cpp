#include <bits/stdc++.h>
using namespace std;
const int mod=1e9+7;
int main(){
	int n, m;
	cin >> n >> m;
	vector<int> a(m);
	for(int i=0; i<m; ++i) cin >> a[i];

	vector<int> dp(n+1,1);
	for(int i=0; i<m; ++i) dp[a[i]]=0;
	for(int i=2; i<=n; ++i) dp[i] = dp[i]*(dp[i-1]+dp[i-2])%mod;

	cout << dp[n] << endl;
}