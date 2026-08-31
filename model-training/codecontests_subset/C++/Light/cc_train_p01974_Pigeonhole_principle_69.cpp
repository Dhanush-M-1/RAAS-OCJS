#include<cstdio>
#include<functional>
#include<algorithm>
using namespace std;
int main(void)
{
	int n,i,j,x,a[1000],x1,y1;
	scanf("%d",&n);
	for(i=0;i<n;i++)	scanf("%d",&a[i]);
	for(i=0;i<n-1;i++)	{
		for(j=i+1;j<n;j++)	{
			x=a[i]-a[j];
			if(x<0)	x=-x;
			if(x%(n-1)==0)	{
				x1=a[i];	y1=a[j];
				j=n;	i=n-1;
			}
		}
	}
	printf("%d %d\n",x1,y1);
    return 0;
}
