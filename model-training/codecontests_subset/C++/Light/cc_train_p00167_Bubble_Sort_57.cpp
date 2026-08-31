#include<cstdio>
#include<algorithm>
using namespace std;
int main(void)
{
	int a[100],n,i,j,wk,cnt;
	while(1)	{
		scanf("%d",&n);
		if(n==0)	break;
		for(i=0;i<n;i++)	scanf("%d",&a[i]);
		cnt=0;
		for(i=n-2;i>=0;i--)	{
			for(j=0;j<=i;j++)	{
				if(a[j]>a[j+1])	{
					swap(a[j],a[j+1]);
					cnt++;
				}
			}
		}
		printf("%d\n",cnt);
	}
	return 0;
}
