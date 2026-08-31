#include<bits/stdc++.h>
using namespace std;
const int N=100005,mod=1000000007;
int a[N],b[N],dp[N];
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	for(int i=1;i<=m;i++)
	{
		int x;
		scanf("%d",&x);
		b[x]=1;
	}
	dp[0]=1;
	dp[1]=b[1]^1;
	for(int i=2;i<=n;i++)
	{
		if(b[i])
			continue;
		dp[i]=(dp[i-1]+dp[i-2])%mod;
	}
	printf("%d\n",dp[n]);
	return 0;
}
