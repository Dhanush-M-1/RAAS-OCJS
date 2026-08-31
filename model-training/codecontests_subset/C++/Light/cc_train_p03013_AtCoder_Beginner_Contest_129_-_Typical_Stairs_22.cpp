#include <bits/stdc++.h>

using namespace std;

const long long mod = 1e9 + 7;
vector <bool> B;
vector <long long> dp;

int main()
{
	int n,m;
	cin>>n>>m;
	
	B.resize(n+1,true);
	dp.resize(n+1);
	dp[0]=1;
	
	for (int i=0;i<m;i++){
		int a;
		cin>>a;
		B[a]=false;
	}
	dp[1]=B[1]*1;
	for (int i=2;i<=n;i++){
		dp[i]=(dp[i-1]+dp[i-2])*B[i];
		dp[i]%=mod;
	}
	cout<<dp[n]<<endl;
}