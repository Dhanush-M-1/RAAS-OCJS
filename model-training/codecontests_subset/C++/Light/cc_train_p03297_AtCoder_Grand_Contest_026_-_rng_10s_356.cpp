#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<algorithm>
using namespace std;
long long gcd(long long x,long long y)
{
	if(y==0)
		return x;
	return gcd(y,x%y);
}
int main()
{
	int T;
	long long a,b,c,d;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(a<b||d<b)
		{
			printf("No\n");
			continue;
		}
		a%=b;
		d=gcd(d,b);
		if(d!=b)
		{
			a%=d;
			a=a+b-d;
		}
		if(a>c)
			printf("No\n");
		else
			printf("Yes\n");
	}
	return 0;
}