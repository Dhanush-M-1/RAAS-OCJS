#include<bits/stdc++.h>
using namespace std;
#define ll long long
int main()
{
    ios_base::sync_with_stdio(false),cin.tie(0),cout.tie(0);
    ll t;
    cin>>t;
    ll cnt[10];
    ll dp[200005];
    dp[0] = 1;
    cnt[9] = 1;
    for(ll i=0;i<9;i++)
    {
        cnt[i] = 0;
    }
    for(ll i=1;i<=200000;i++)
    {
        dp[i] = dp[i-1]+cnt[9];
        dp[i] = dp[i]%1000000007;
        ll temp[10];
        for(ll j=0;j<10;j++)
        {
            temp[j] = cnt[j];
            temp[j] = temp[j]%1000000007;
            cnt[j] = cnt[j]%1000000007;
        }
        cnt[0] = temp[9];
        cnt[1] = temp[0]+temp[9];
        for(ll j=2;j<=9;j++)
        {
            cnt[j] = temp[j-1];
        }
    }
    for(ll test=0;test<t;test++)
    {
        ll n,m;
        cin>>n>>m;
        ll temp = n;
        ll cn[10];
        memset(cn,0,sizeof(cn));
        while(temp>0)
        {
            cn[temp%10]++;
            temp/=10;
        }
        ll ans = 0;
        for(ll i=0;i<10;i++)
        {
            if(m-9+i<0)
            {
                ans+= cn[i];
                continue;
            }
            ans+= cn[i]*dp[(m-9+i)];
            ans = ans%1000000007;
        }
        cout<<ans<<"\n";
    }
}
