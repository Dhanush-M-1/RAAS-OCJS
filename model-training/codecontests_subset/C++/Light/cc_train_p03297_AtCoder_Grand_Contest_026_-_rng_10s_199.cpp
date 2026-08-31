#include <cstdio>
typedef long long ll;

ll Gcd(const ll a,const ll b){return b?Gcd(b,a%b):a;}

int T;
ll A,B,C,D;

bool Limited()
{
    if(A<B)return true;
    if(B>D)return true;
    if(B-C<2)return false;
    ll Gs=Gcd(B,D),L=A-B+1,R=A-C-1;
    ll Boundary=(L+Gs-1)/Gs*Gs;
    return Boundary<=R;
}

int main()
{
    for(scanf("%d",&T);T--;)
    {
        scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
        puts(Limited()?"No":"Yes");
    }
    return 0;
}