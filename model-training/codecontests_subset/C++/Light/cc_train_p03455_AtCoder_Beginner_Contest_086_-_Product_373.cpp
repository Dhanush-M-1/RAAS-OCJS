#include <cstdio>
int a,b;
int main ()
{
	scanf ("%d %d",&a,&b);
	printf ("%s\n",a*b%2?"Odd":"Even");
	return 0;
}
