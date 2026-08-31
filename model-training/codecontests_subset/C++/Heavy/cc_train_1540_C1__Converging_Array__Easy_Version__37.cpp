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
int f[109][10009],g[10009];
int pt[109],smc[109];
pii q[100009];
int ans[100009];
void dp()
{
	f[0][0]=1;
	for(int i=1;i<=n;i++)
	{
		smc[i]=smc[i-1]+c[i];
		for(int j=0;j<=smc[i];j++)
		{
			for(int k=0;k<=min(j,c[i]);k++)
				f[i][j]=(f[i][j]+f[i-1][j-k])%mod;
		}
	}
}
int mo(int x)
{
	memset(f,0,sizeof(f));
	f[0][0]=1;
	for(int i=1;i<=n;i++)
	{
		int mn=i*x+ssb[i-1];
		for(int j=max(0,mn);j<=smc[i];j++)
		{
			for(int k=0;k<=min(j,c[i]);k++)
				f[i][j]=(f[i][j]+f[i-1][j-k])%mod;
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
		scanf("%d",c+i);
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
	dp();
	for(int i=1;i<=m;i++)
		ans[q[i].se]=mo(q[i].fi);
	for(int i=1;i<=m;i++)
		printf("%d\n",ans[i]);
	return 0;
}