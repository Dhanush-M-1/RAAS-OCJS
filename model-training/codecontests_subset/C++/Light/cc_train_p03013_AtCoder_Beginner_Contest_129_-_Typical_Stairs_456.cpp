#include<bits/stdc++.h>
using namespace std;
int const MAXN=110000, MOD=1e9+7;
int n, m, dp[MAXN];
bool broken[MAXN];
int main(){
	cin>>n>>m;
	int temp;
	for(int i=0;i<m;i++){
		cin>>temp;
		broken[temp]=true;
	}
	dp[n]=1;
	for(int i=n-1;i>=0;i--)
		if(!broken[i])
			dp[i]=(dp[i+1]+dp[i+2])%MOD;
	cout<<dp[0];
}