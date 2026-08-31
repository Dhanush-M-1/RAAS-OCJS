#include <stdio.h>

int main()
{
	int A,B,re;
	scanf("%d %d",&A,&B);
	if(A > 9 || B >9)re = -1;
	else re = A * B;
	printf("%d",re);
	return 0;
}