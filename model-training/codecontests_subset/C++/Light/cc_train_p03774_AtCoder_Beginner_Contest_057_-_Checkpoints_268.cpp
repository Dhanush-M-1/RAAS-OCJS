#include<cstdio>
#include<algorithm>
#include<cstring>
using namespace std;

int main(void)
{
	int i,j,n,m,a[51],b[51],c[51],d[51],mn,mm,x,y;
	scanf("%d %d",&n,&m);
	for(i=1;i<=n;i++)	scanf("%d %d",&a[i],&b[i]);
	for(i=1;i<=m;i++)	scanf("%d %d",&c[i],&d[i]);	
	for(i=1;i<=n;i++)	{
		mn=2000000000;
		for(j=1;j<=m;j++)	{
			x=a[i]-c[j];	x=max(x,-x);
			y=b[i]-d[j];	y=max(y,-y);
			if(mn>x+y)	{
				mn=x+y;
				mm=j;
			}
		}
		printf("%d\n",mm);
	}
	return 0;
}