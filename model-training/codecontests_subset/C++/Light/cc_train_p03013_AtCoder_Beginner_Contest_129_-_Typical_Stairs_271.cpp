#include <bits/stdc++.h>
using namespace std;
const int N=100005,Mod=1e9+7;
bool bk[N];int dp[N];
int main (){
	int n,m;scanf ("%d%d",&n,&m);
	for (int i=1;i<=m;i++){
		int x;scanf ("%d",&x);
		bk[x]=true;
	}
	dp[0]=1;
	for (int i=0;i<=n;i++){
		if (bk[i]) dp[i]=0;
		dp[i+1]=(dp[i+1]+dp[i])%Mod;
		dp[i+2]=(dp[i+2]+dp[i])%Mod;
	}
	printf ("%d",dp[n]);
	return 0;
} 