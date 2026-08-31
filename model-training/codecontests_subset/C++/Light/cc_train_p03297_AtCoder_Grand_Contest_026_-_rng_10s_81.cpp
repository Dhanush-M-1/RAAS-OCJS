#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
#define LL long long
LL gcd(LL x,LL y)
{
    return x%y==0?y:gcd(y,x%y);
}
int main()
{
    int i,j,k,n;
    LL a,b,c,d;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
        if(a<b||d<b||c<a%b||c<b-gcd(b,d))
            printf("No\n");
        else
            printf("Yes\n");
    }
    return 0;
}
