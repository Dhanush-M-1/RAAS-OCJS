#include <bits/stdc++.h>
#define fu(i,a,b) for (long long i=a; i<=b; i++)
#define fd(i,a,b) for (long long i=a; i>=b; i--)
using namespace std;
typedef long long ll;
const ll N=2e5+10;
ll n,q,a[N],s[N],ma[N],query[N];
void Solve()
{
    cin>>n>>q;
    fu(i,1,n)
    {
        cin>>a[i];
    }
    fu(i,1,q)
    {
        cin>>query[i];
    }
    fu(i,1,n)
    {
        s[i]=s[i-1]+a[i];
    }
    ma[0]=0;
    fu(i,1,n)
    {
        ma[i]=max(ma[i-1],s[i]);
    }
//    fu(i,1,n)
//    {
//        cout<<s[i]<<" ";
//    }
//    cout<<"\n";
//    fu(i,1,n)
//    {
//        cout<<ma[i]<<" ";
//    }
//    cout<<"\n";
    if (s[n]<=0)
    {
        fu(i,1,q)
        {
            ll x=query[i];
            ll l=1,r=n,res=0;
            while (l<=r)
            {
                ll mid=(l+r)/2;
                if (ma[mid]>=x)
                {
                    res=mid;
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            cout<<res-1<<" ";
        }
        cout<<"\n";
        return;
    }
    fu(i,1,q)
    {
        ll x=query[i];
        ll L=0,R=(x/s[n])+10,res=0;
//        cout<<"Tra loi "<<x<<":\n";
        while (L<=R)
        {
            ll MID=(L+R)/2;
//            cout<<MID<<":\n";
            ll val=MID*s[n];
            ll l,r,o=-1;
            if (MID==0) {l=1;} else {l=0;}
            r=n;
            while (l<=r)
            {
                ll mid=(l+r)/2;
//                cout<<l<<" "<<r<<" "<<mid<<"\n";
                if (ma[mid]>=x-val)
                {
                    o=mid;
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
//            cout<<"\n";
//            cout<<o<<"\n";
            if (o==-1)
            {
                L=MID+1;
            }
            else
            {
                res=MID*n+o;
                R=MID-1;
            }
        }
        cout<<res-1<<" ";
//        cout<<"\n";
    }
//    cout<<"---------------\n";
    cout<<"\n";
}
int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    ll T;
    cin>>T;
    while (T--)
    {
        Solve();
    }
}
