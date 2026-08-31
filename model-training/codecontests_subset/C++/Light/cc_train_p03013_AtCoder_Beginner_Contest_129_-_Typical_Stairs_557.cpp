#include <bits/stdc++.h>
using namespace std;

int main() {
	int n,m,t;
	cin>>n>>m;
	long long int dp[n+1];
	fill(dp,dp+n,INT_MAX);
	dp[n]=1;
	dp[n-1]=1;
	for(int i=0;i<m;i++){
		cin>>t;
		dp[t]=0;
	}
	for(int i=n-2;i>=0;i--){
		if(dp[i]!=0)
		dp[i]=dp[i+1]+dp[i+2];
		dp[i]=dp[i]%1000000007;
	//	cout<<dp[i]<<endl;
	}
	long long int y=dp[0];
	y=y%1000000007;
	cout<<y;
	return 0;
}