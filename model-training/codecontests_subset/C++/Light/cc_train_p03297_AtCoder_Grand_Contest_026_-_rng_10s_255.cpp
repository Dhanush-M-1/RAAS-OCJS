#include<iostream>
#include<string>
#include<string.h>
#include<stdio.h>
#include<algorithm>
using namespace std;
long long gcd(long long x,long long y)
{
	if (y==0) return x;
	else return gcd(y,x%y);
}

int main()
{
	int n;
	scanf("%d",&n);
	while (n--)
	{
		long long a,b,c,d;
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if ((a<b) || (d<b)) {printf("No\n");continue;}
		if (b<=c) {printf("Yes\n");continue;}
		long long g=gcd(b,d);
		if ((a-c-1)/g-(a-b)/g>0) printf("No\n");
		else printf("Yes\n");
	}
	return 0;
}