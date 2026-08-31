#include<bits/stdc++.h>
#define pii pair<int,int>
#define fi first
#define se second
#define ll long long
#define mod 1000000007
using namespace std;
int n,m;
int c[109],b[109];
int smb[109],ssb[109];
int f[109][10009],sf[109][10009],g[10009];
int pt[109],smc[109];
pii q[100009];
int ans[100009];
int mo(int x)
{
	f[0][0]=1;
	for(int i=1;i<=n;i++)
	{
		int mn=i*x+ssb[i-1],lp=0;
		ll sm=0;
		for(int j=0;j<=smc[i];j++)
		{
			sm+=f[i-1][j];
			(lp<j-c[i])&&(sm+=mod-f[i-1][lp]);
			lp+=(lp<j-c[i]);
			// printf("i:%d j:%d lp:%d sm:%d\n",i,j,lp,sm);
			f[i][j]=j>=mn?sm%mod:0;
		}
	}
	int ans=0;
	for(int i=0;i<=smc[n];i++)
		ans=(ans+f[n][i])%mod;
	return ans;
}
int main()
{
	scanf("%d",&n);
	for(int i=1;i<=n;i++)
	{
		scanf("%d",c+i);
		smc[i]=smc[i-1]+c[i];
	}
	for(int i=1;i<=n-1;i++)
	{
		scanf("%d",b+i);
		smb[i]=smb[i-1]+b[i];
		ssb[i]=ssb[i-1]+smb[i];
	}
	scanf("%d",&m);
	for(int i=1;i<=m;i++)
	{
		scanf("%d",&q[i].fi);
		q[i].se=i;
	}
	sort(q+1,q+m+1);
	for(int k=1;k<=1000;k++)
	for(int i=1;i<=m;i++)
		ans[q[i].se]=mo(q[i].fi);
	for(int i=1;i<=m;i++)
		printf("%d\n",ans[i]);
	return 0;
}