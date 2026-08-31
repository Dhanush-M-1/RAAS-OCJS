#include<bits/stdc++.h>
using namespace std;
const int maxn=1e5+100;
typedef long long ll;
const int mod=1e9+7;
ll a[maxn],dp[maxn];
int main()
{
	int n,m;
	cin>>n>>m;
	for(int i=1;i<=m;i++)
	{
		ll w;
		cin>>w;
		a[w]=1;
	}
	dp[0]=1;dp[1]=a[1]?0:1;
	for(int i=2;i<=n;i++)
	{
		if(!a[i])
		{
			dp[i]=(dp[i]+dp[i-1])%mod;
			dp[i]=(dp[i]+dp[i-2])%mod;
		}
	}
	cout<<dp[n]%mod;
	return 0;
}