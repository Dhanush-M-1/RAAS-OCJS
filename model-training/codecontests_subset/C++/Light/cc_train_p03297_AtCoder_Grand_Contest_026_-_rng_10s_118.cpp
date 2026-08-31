#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cstring>
#include<cmath>
using namespace std;
long long gcd(long long a,long long b)
{
	if (b==0) return a;
	return gcd(b,a%b);
}
int main()
{
	int cas;
	scanf("%d",&cas);
	while (cas--)
	{
		long long a,b,c,d;
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if (a<b || d<b) { puts("No");continue; }
		if (c>=b) { puts("Yes"); continue; }
		long long x=gcd(b,d);a%=x;
		if (a-c+(b-a-1)/x*x>=1) puts("No");
		else puts("Yes");
	}
	return 0;
}
