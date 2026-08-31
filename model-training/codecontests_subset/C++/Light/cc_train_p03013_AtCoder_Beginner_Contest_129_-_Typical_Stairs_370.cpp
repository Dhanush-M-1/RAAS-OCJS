#include<bits/stdc++.h>
#include<iostream> 
using namespace std;
const int mod=1000000007;
int a[100005];
int dp[100005];
int main(){
	int n,m;
	scanf("%d %d",&n,&m);
	for(int i=1;i<=m;i++) scanf("%d",&a[i]);
	int k=1;
	dp[0]=1;
	for(int i=1;i<=n;i++){
		if(i==a[k]){
			k++;
			dp[i]=0;
			continue;
		}
		dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
	}
	printf("%d",dp[n]%mod);
	return 0;
}