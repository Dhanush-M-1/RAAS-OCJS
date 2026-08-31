#include <bits/stdc++.h>
using namespace std;
int a[100001];
long long f[100001];
int main()
{
	int n,m,u,i;
	scanf("%d%d",&n,&m);
	for(i=1;i<=m;i++)
	{
		scanf("%d",&u);
		a[u]=1;
	}
	f[0]=1;
	f[1]=(a[1]?0:1);
	for(i=2;i<=n;i++)
	{
		if(a[i])
			continue;
		f[i]=(f[i-2]+f[i-1])%1000000007;
	}
	printf("%lld",f[n]);
    return 0;
}