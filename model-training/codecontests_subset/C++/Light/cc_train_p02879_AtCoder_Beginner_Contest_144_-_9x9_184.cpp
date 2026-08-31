#include<stdio.h>
int main()
{
	int A,B;
	scanf("%d %d",&A,&B);
	if(A>9||B>9)
  	  printf("-1\n");
	else
		printf("%d\n",A*B);
	return 0;
}

  