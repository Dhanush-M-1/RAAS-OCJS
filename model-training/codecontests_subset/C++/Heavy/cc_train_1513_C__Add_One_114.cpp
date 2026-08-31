#include <bits/stdc++.h>
using namespace std;


#define     F                   first
#define     S                   second
#define     pb                  push_back
#define     gap                 ' '
#define     fastIO              {ios_base::sync_with_stdio(false);cin.tie(NULL);}
#define     Inf                 1e18
#define     MOD                 1000000007
#define     N                   1000006
#define     all(v)              v.begin(),v.end()
#define     For(i, a, b)        for(ll i = a; i <  b; ++i)
#define     Rof(i, a, b)        for(ll i = a; i >= b; --i)
#define     endl                "\n"
#define     yes                 cout<<"YES\n"
#define     no                  cout<<"NO\n"


typedef     long long           ll;
typedef     vector<ll>          vl;
typedef     pair<ll, ll>        pll;
typedef     map<ll, ll>         mll;
typedef     multimap<ll, ll>    mmll;

ll dp[200500];
void start() {
    For(i, 0, 10) dp[i] = 1;
    For(i, 10, 200500)
        dp[i] = (dp[i - 10] + dp[i - 9]) % MOD;

}


void solve()
{
    ll t; t = 1; cin>>t; t:
    start();
    while(t --)
    {
        ll n, m; cin>>n>>m;
        ll ans = 0;
        while(n)
        {
            ll k = n%10;
            ans = (ans + dp[k + m])%MOD;
            n/=10;
        }
        cout<< ans <<endl;
    }

}

int main()
{
    fastIO
    solve();



    return 0;

}
