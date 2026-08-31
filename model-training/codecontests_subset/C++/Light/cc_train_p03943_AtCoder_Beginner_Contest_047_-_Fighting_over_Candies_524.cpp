#include<cstdio>
int main()
{
	int a,b,c;
	scanf("%d %d %d",&a,&b,&c);
	if(a+b==c||a+c==b||c+b==a)
	{
printf("Yes\n");
	}
else
{
	printf("No\n");
}
return 0;
}
