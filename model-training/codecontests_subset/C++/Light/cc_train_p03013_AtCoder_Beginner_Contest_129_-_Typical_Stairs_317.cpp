#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n,m,i,temp;
	scanf("%d%d",&n,&m);
	int a[100009];
	memset(a,-1,sizeof(a));
	a[0]=1;
	a[1]=1;
	for (i=0;i<m;i++)
	{
		scanf("%d",&temp);
		a[temp]=0;
	}
	for (i=2;i<=n;i++)
	{
		if (a[i]!=0) a[i]=(a[i-1]+a[i-2])%1000000007;
	}
	printf("%d\n",a[n]);
	return 0;
}