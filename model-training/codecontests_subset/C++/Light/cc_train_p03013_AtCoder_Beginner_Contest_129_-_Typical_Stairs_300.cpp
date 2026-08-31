#include<bits/stdc++.h>
using namespace std;
const int mod=1e9+7;
int main(){
	int n,m,a;
	bool safe[100001];
	cin>>n>>m;
	fill(safe,safe+100001,true);
	while(cin>>a)
		safe[a]=false;
	int dp[100001];
	dp[0]=1;
	for(int i=1;i<=n;i++){
		if(i==1)
			dp[i]=dp[i-1];
		else
			dp[i]=(dp[i-1]+dp[i-2])%mod;
		if(!safe[i])
			dp[i]=0;
	}
	cout<<dp[n]<<endl;
}
