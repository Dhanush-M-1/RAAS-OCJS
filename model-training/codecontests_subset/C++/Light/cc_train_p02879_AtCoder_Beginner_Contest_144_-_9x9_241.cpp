#include<stdio.h>
int main()
{
	int a,b,c;
	while(~scanf("%d%d",&a,&b))
	{if(a<10&&b<10)c=a*b;
	 else c=-1;
	 printf("%d\n",c);
	}
}