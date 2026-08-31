#include<cstdio>
#include<algorithm>
using namespace std;
#define LL long long
LL gcd(LL a,LL b)
{
	LL tmp;
	while(b)
	{
		tmp=a;
		a=b,b=tmp%b;
	}
	return a;
}
int main()
{
	LL A,B,C,D;
	int tm;
	scanf("%d",&tm);
	while(tm--)
	{
		scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
		bool f=1;
		if(A<B) f=0;
		else if(D<B) f=0;
		else if(C>=B-1);
		else
		{
			LL E=gcd(B,D);
			if((A-B)/E<(A-C-1)/E) f=0;
		}
		if(f) printf("Yes\n");
		else printf("No\n");
	}
}