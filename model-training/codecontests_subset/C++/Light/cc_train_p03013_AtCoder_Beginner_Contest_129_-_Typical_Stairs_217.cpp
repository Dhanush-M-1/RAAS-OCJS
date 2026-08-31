#include<cstdio>
const int N=1e5+10;
const int mod=1000000007;
int n,a[N],m,k;
long long f[N];
int main()
{
	scanf("%d%d",&n,&m);
	while(m--)
	{
		scanf("%d",&k);
		a[k]=1;
	}
	f[0]=1;
	if(!a[1])f[1]=1;
	for(int i=2;i<=n;i++)
		if(!a[i])
		{
			if(!a[i-1])f[i]=(f[i]+f[i-1])%mod;
			if(!a[i-2])f[i]=(f[i]+f[i-2])%mod;
		}
	printf("%lld",f[n]);
	return 0;
}
