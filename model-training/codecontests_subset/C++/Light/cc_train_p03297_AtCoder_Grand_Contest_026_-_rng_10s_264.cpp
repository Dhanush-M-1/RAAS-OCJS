#include<cstdio>
#include<cstring>
#include<map>
#include<algorithm>
using namespace std;
typedef long long LL;
LL a,b,c,d;
inline LL gcd(LL x,LL y)
{
	return !y?x:gcd(y,x%y);
}
int main()
{
	int T;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(a<b||d<b||a%b>c)
		{
			printf("No\n");
			continue;
		}
		if(b<c||d%b==0)
		{
			printf("Yes\n");
			continue;
		}
		LL x=a%b,y=gcd(d,b);
		if((((c+1-x)%y+b-c-2)>=y||(c+1-x)%y==0)&&b-c>1)
			printf("No\n");
		else
			printf("Yes\n");
	}
}