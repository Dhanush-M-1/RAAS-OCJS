#include<bits/stdc++.h>
#define ll long long
using namespace std;
ll x;
ll r[100005]={0};
ll fun(ll t,ll low,ll high)
{
    if(t<low)return low;
    if(t>high)return high;
    return t; 
}
int main()
{
    int q,k;
    scanf("%lld%d",&x,&k);
    for(int i=1;i<=k;i++)
    scanf("%lld",&r[i]);
    scanf("%d",&q);
    ll l=0,h=x;
    ll add=0;
    int now=1;
    int flag=-1;
    while(q--)
    {
        ll tt,a;
        scanf("%lld%lld",&tt,&a);
        while(tt>=r[now]&&now<=k)
        {
            ll xx=flag*(r[now]-r[now-1]);
            add=add+xx;
            h=fun(h+xx,0,x);
            l=fun(l+xx,0,x);
            flag=-1*flag;
            now++;
        }
        ll ans=fun(add+a,l,h);
        ans=fun(ans+flag*(tt-r[now-1]),0,x);
        printf("%lld\n",ans);
    }
    return 0;
}