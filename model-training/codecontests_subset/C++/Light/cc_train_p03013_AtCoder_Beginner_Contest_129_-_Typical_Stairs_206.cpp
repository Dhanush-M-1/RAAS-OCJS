#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n,m,a,mod=1e9+7,dp[114514];
bool f[114514];
int main() {

	cin>>n>>m;
	for(int i=0;i<m;i++){
		cin>>a;
		f[a]=1;
	}
	dp[0]=1;
	if(!f[1])dp[1]=1;
	for(int i=2;i<=n;i++)if(!f[i]){
		dp[i]=dp[i-1]+dp[i-2];
		dp[i]%=mod;
	}
	cout<<dp[n];
	return 0;
}
