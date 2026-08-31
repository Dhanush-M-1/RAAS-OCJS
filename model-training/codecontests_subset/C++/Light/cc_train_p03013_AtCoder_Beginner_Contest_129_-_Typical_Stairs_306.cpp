#include<bits/stdc++.h>
#define mod 1000000007
using namespace std;
int n,m;
int a[100005],x;
int dp[100005];

int main(){
	scanf("%d %d",&n,&m);
	for(int i=1;i<=m;i++){
		scanf("%d",&x);
		a[x]=1;
	}
	dp[0]=1;
	for(int i=1;i<=n;i++){
		if(a[i]==0){
			if(i<2) dp[i]=dp[i-1];
			else dp[i]=(dp[i-1]+dp[i-2])%mod;
		}
	}
	printf("%d\n",dp[n]);
	
	return 0;
}