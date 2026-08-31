#include<cstdio>
int a,b;
int main()
{
	scanf("%d%d",&a,&b);
	a*=b;
	if(a%2==0)
		printf("Even");
	else
		printf("Odd");
}