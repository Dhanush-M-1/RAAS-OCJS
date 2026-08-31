#include <bits/stdc++.h>

typedef long long int ll;
using namespace std;

const ll MOD = 1e9 + 7;

int main()
{
	int n,k; cin>>n>>k;
	vector<ll> dp(n+1,0);

	map<int,int> mp;

	for(int i=0;i<k;i++){
		int x; cin>>x; mp[x]++;
	}

	dp[0]=1;

	for(int i=1;i<=n;i++){
		if(mp[i]) continue;
		dp[i] += dp[i-1];
		if(i-2>=0) dp[i] += dp[i-2];
		dp[i] %= MOD;
	}

	cout<<dp[n];
}














