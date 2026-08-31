#include<bits/stdc++.h>
using namespace std;

int f[100003];
int n,m,x;
int main()
{
	scanf("%d %d", &n,&m);
	f[0]=1;
	f[1]=1;
	for (int i=1;i<=m;++i)
	{
		scanf("%d",&x);
		f[x]=-1;
	}
	if (f[1]==-1) f[1]=0;
	for (int i=2;i<=n;++i)
	{
		if (f[i]==-1)f[i]=0;else f[i]=(f[i-1]+f[i-2])%1000000007;
	}
	printf("%d\n",f[n]);
	return 0;
}
