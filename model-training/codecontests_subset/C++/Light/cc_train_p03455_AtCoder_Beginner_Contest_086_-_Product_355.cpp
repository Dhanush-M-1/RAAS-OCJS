#include<cstdio>
int main()
{
	int a,b;
	scanf("%d %d",&a,&b);
	a=a*b;
	if(a%2==1) printf("Odd\n");
		else printf("Even\n");
}