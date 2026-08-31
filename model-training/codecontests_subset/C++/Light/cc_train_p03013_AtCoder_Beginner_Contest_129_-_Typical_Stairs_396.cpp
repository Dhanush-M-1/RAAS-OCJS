#include<bits/stdc++.h>
using namespace std;
int n,m;
long long dp[100005];
int main()
{
	memset(dp,-1,sizeof(dp));
	cin>>n>>m;
	for(int i=1;i<=m;i++)
	{
		int a;
		cin>>a;
		dp[a]=0;
	}
	dp[0]=1;
	for(int i=1;i<=n;i++)
	{
		if(dp[i]==0) continue;
		if(i==1) dp[i]=dp[i-1];
		else dp[i]=dp[i-1]+dp[i-2];
		dp[i]%=1000000007;
	}
	cout<<dp[n]<<endl;
	return 0;
}
