#include<cstdio>
int n,m,a[100005],f[100005];
int main()
{
	scanf("%d%d",&n,&m);
	f[0]=1;
	for (int i=1;i<=m;i++)
	{
		int x;
		scanf("%d",&x);
		a[x]=1;
	}
	if(!a[1]) f[1]=1;
	for (int i=2;i<=n;i++) if (!a[i]) f[i]=(f[i-1]+f[i-2])%1000000007;
	printf("%d\n",f[n]);
}