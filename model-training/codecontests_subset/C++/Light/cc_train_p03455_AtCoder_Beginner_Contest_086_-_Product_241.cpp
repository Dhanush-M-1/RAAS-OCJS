/*Lucky_Glass*/
#include<cstdio>
int main()
{
	long long a,b,c;
	scanf("%lld%lld",&a,&b);
	c=a*b;
	puts(c%2? "Odd":"Even");
	return 0;
}