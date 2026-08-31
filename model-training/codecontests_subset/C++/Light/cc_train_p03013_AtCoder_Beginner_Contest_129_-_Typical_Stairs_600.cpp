#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll mod=1e9+7;

int main(){
	ll n,m,a1,r1;
	cin>>n>>m;
	vector<ll> dp(n+5,0);
	vector<ll> no(n+5,0);
	for(a1=0;a1<m;++a1){
		cin>>r1;
		no[r1]=1;
	}
	dp[0]=1;
	for(a1=1;a1<=n;++a1){
		if(no[a1]) continue;
		int x=0;
		if(a1-2>=0) x=dp[a1-2];
		dp[a1]=(dp[a1-1]+x)%mod;
	}
	cout<<dp[n];
	return 0;
}