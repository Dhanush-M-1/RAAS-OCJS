#include <cstdio>
#include <algorithm>
using namespace std;
#define ADD(x) ((x>=mod)?x-mod:x)
const int mod=1e9+7;
int n,c[110],b[110],sum[110],sum1[110],sumc[110],dp[110][10010],ans,Min,T,x;
int main()
{
	scanf("%d",&n);
	for (int i=1;i<=n;i++) scanf("%d",&c[i]),sumc[i]=sumc[i-1]+c[i];
	for (int i=1;i<n;i++) scanf("%d",&b[i]),sum[i]=sum[i-1]+b[i];
	for (int i=1;i<=n;i++) sum1[i]=sum1[i-1]+sum[i-1];
	scanf("%d%d",&T,&x);
	dp[0][0]=1;
	for (int i=1;i<=n;i++)
		for (int j=x*i+sum1[i];j<=sumc[i];j++)
			for (int k=min(j,c[i]);k>=0;k--)
				dp[i][j]=ADD(dp[i][j]+dp[i-1][j-k]);
	for (int i=0;i<=sumc[n];i++) ans=ADD(ans+dp[n][i]);
	printf("%d\n",ans);
	return 0;
}
