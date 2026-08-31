#include<iostream>
#include<cstdio>
#include<cstring>
#include<cstdlib> 
using namespace std;
int t;
long long a,b,c,d;
long long mygcd(long long x,long long y)
{
	return !y?x:mygcd(y,x%y);
}
int main()
{
	scanf("%d",&t);
	while(t--)
	{
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(d<b || a<b)
		{
			puts("No");
			continue;
		}
		if(c>=b)
		{
			puts("Yes");
			continue;
		}
		long long g=mygcd(b,d%b);
		if(b-g+a%g>c)puts("No");
		else puts("Yes");
	}
	return 0;
}