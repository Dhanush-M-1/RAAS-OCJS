#include<cstdio>
int main()
{
	int m,n,t;
	while(scanf("%d%d%d",&m,&n,&t)!=EOF)
	{
		if(m+n==t||m+t==n||n+t==m)
		printf("Yes\n");
		else
		printf("No\n");
	}
return 0;
}