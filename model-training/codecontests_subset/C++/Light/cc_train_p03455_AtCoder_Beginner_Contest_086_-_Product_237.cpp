#include<cstdio>
int a,b;
int main()
{
	scanf("%d%d",&a,&b);
	if(a%2==0||b%2==0)
		printf("Even\n");
	else 
		printf("Odd\n");
}