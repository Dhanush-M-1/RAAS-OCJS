#include<stdio.h>
int main(void)
{
	int n,m;
	scanf("%d %d",&n,&m);
	if(n*m%2==0) printf("Even\n");
	else printf("Odd\n");
	return 0;
}