#include<cstdio>
#include<functional>
#include<algorithm>
using namespace std;
int main(void)
{
	int i,a[52],suu,n,e,j;
	char b[5]="SHCD",c;
	for(i=0;i<52;i++)	a[i]=0;
	scanf("%d",&n);
	for(i=0;i<n;i++)	{
		scanf(" %c %d",&c,&suu);
		for(j=0;j<4;j++)	if(b[j]==c)	e=j;
		a[e*13+suu-1]=1;
	}
	for(i=0;i<52;i++)	{
		if(a[i]==0)	{
			e=i/13;
			suu=i%13;
			printf("%c %d\n",b[e],suu+1);
		}
	}
	return 0;
}
