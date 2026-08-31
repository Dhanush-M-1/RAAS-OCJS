#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX=2e5+5;
const int INF=0x3f3f3f3f;
template<class T>bool gmax(T &a,T b){return a<b?a=b,1:0;}
template<class T>bool gmin(T &a,T b){return a>b?a=b,1:0;}

ll n,q,t,a,r[MAX],X;
int main()
{
    scanf("%lld%lld",&X,&n);
    for(int i=1;i<=n;i++)scanf("%lld",&r[i]);
    scanf("%lld",&q);
    ll minsand=0,maxsand=X,val=0,k=1,sign=-1;
    while(q--)
    {
        scanf("%lld%lld",&t,&a);
        while(k<=n&&r[k]<=t)
        {
            ll v=sign*(r[k]-r[k-1]);
            minsand+=v;
            maxsand+=v;
            val+=v;
            gmax(minsand,0ll);
            gmin(minsand,(ll)X);
            gmax(maxsand,0ll);
            gmin(maxsand,(ll)X);
            sign*=-1;
            k++;
        }
        ll now=val+a;
        gmax(now,minsand);
        gmin(now,maxsand);
        now+=sign*(t-r[k-1]);
        gmax(now,0ll);
        gmin(now,(ll)X);
        printf("%lld\n",now);
    }
}
