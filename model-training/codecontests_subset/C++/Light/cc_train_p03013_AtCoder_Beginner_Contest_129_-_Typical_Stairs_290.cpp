#include<bits/stdc++.h>
using namespace std;

const int mod = 1e9+7;

long long int dp[1000001];

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n,m;
	cin>>n>>m;
	memset(dp,-1,sizeof dp);
	dp[0]=1;
	for(int i=1,x;i<=m;i++){
		cin>>x;
		dp[x]=0;
	}
	if(dp[1]!=0)
		dp[1]=1;
	for(int i=2;i<=n;i++)
		if(dp[i]==-1)
			dp[i]=(dp[i-1]+dp[i-2])%mod;
	cout<<dp[n]<<endl;
}

