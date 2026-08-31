#include<cstdio>
int a,b;
int main()
{
	scanf("%d %d",&a,&b);
	if(!(a%2)||!(b%2))
		puts("Even");
	else puts("Odd");
	return 0;
}