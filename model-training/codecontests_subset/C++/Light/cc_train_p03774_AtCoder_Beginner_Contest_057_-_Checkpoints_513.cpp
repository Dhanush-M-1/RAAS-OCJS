#include<iostream>
#include<cstdio>
#include<cmath>
#define N 50+5
using namespace std;
int n,m,a[N],b[N],c[N],d[N];
int main()
{
	scanf("%d%d",&n,&m);
	for(int i=1;i<=n;i++) scanf("%d%d",&a[i],&b[i]);
	for(int i=1;i<=m;i++) scanf("%d%d",&c[i],&d[i]);
	for(int i=1;i<=n;i++)
	{
		int minn=1e9,k;
		for(int j=1;j<=m;j++)
 		{
			int t = abs(c[j]-a[i])+abs(d[j]-b[i]);
			if(t < minn) minn = t,k = j;
		}
		printf("%d\n",k);
	}
	return 0;
}