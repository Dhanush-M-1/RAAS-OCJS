//JSD
#include<iostream>
#define Mod 1000000007
#include<cmath>
#include<limits.h>
#define ll long long 
using namespace std;
int main(){
	ll n,m;
	cin>>n>>m;
	ll a[m];
	ll dp[n+1];
	for(int i=0;i<=n;i++ ) dp[i]=-1;
	dp[0]=1,dp[1]=1;
	for(int i=0;i<m;i++){
		cin>>a[i];
		dp[a[i]]=0;
	}
	for(int i=2;i<=n;i++){
		if(dp[i]==-1){
			dp[i]=(dp[i-1]+dp[i-2])%Mod;
		}
	}
	cout<<dp[n];
	
	return 0;
}