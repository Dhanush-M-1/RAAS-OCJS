#include <iostream>
#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5+50;
typedef long long ll;
int r[maxn];
int x,k,q,t,a;
int sgn=-1;
int pos=1,und,ds;
ll mx,mn,all;
void cal(ll &y)
{
    if(y<0)
        y=0;
    if(y>x)
        y=x;
}
void solve()
{
    while(r[pos]<=t&&pos<=k)
    {
        ll ds=(r[pos]-r[pos-1])*sgn;
        mx+=ds;
        mn+=ds;
        all+=ds;
        cal(mx);
        cal(mn);
        pos++;
        sgn*=-1;
        //cout << all << endl;
    }
    ll ans=a+all;
    if(ans>mx)
        ans=mx;
    if(ans<mn)
        ans=mn;
    ll temp=(t-r[pos-1])*sgn;
    ans+=temp;
    cal(ans);
    printf("%lld\n",ans);
}
int main()
{
    //ios::sync_with_stdio(false);
    scanf("%d%d",&x,&k);
    for(int i=1; i<=k; i++)
    {
        scanf("%d",&r[i]);
        //cin>>r[i];
    }
    pos=1;
    mx=x,mn=0,all=0;
    sgn=-1;
    r[0]=0;
    scanf("%d",&q);
    while(q--)
    {

        //cin>>t>>a;
        scanf("%d%d",&t,&a);
        solve();
    }
    //cout << "Hello world!" << endl;
    return 0;
}
