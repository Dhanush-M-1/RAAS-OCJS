#include<cstdio>
#define LL long long
int t;
LL a,b,c,d;
LL gcd(LL a,LL b)
{
	if(!b) return a;
	return gcd(b,a%b);
}
int main()
{
	scanf("%d",&t);
	while(t--)
	{
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(a<b) printf("No\n");
		else if(d<b) printf("No\n");
		else if(c>=b) printf("Yes\n");
		else if(b-gcd(b,d)+a%gcd(b,d)>c) printf("No\n");
		else printf("Yes\n");
		//printf(" %lld %lld %lld\n",b,gcd(b,d),(c-a%b+b)%b);
	}
}
