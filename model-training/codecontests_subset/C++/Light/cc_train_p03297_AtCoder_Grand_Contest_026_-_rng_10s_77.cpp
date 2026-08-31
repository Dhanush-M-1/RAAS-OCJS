#include<bits/stdc++.h>
using namespace std;

long long mygcd(long long a,long long b)
{
	return b?mygcd(b,a%b):a;
}

void mokou()
{
	long long a,b,c,d;
	scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
	if(a<b || d<b)
	{
		puts("No");
		return;
	}
	a%=b;
	if(c>=b-1)
	{
		puts("Yes");
		return;
	}
	long long e=mygcd(b,d);
	//cout<<a<<" "<<b<<" "<<c<<" "<<e<<endl;
	puts((b-a-1)/e==(c-a)/e && a<=c?"Yes":"No");
}

int main()
{
	int t;
	scanf("%d",&t);
	for(int i=0;i<t;i++)
	{
		mokou();
	}
	return 0;
}