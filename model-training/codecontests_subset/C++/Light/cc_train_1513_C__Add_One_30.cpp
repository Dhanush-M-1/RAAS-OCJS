// amit
#include<bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(NULL); cout.tie(NULL);
#define ll long long int
using namespace std;

#define rep(i,n) for(int i=0;i<n;i++)
#define pi pair<ll,ll>
#define pb push_back

ll dp[200022]={1,1,1,1,1,1,1,1,1,1};
void fun()
{
    for(int i=10;i<200022;i++)
        dp[i]=(dp[i-10]+dp[i-9])%1000000007;
}

int main()

{
   fast;
   int t;cin>>t;
   fun();
   while(t--)
   {
    ll n,m;cin>>n>>m;
    ll ans=0;
    while(n)
    {
        ans=(ans+dp[m+(n%10)])%1000000007;
        n/=10;
    }


     cout<<ans<<'\n';


   }

   return 0;
}
