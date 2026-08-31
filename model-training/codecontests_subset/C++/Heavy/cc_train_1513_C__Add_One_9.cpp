
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef double dd;
#define f(i,k,n) for(ll i=k;i<n;i++)
#define all(s) s.begin(),s.end()
#define vec vector<ll>
#define pb push_back
#define IOS ios::sync_with_stdio(0),cin.tie(0),cout.tie(0)
const ll maci=200002;
const ll mod=1e9+7;
ll dp[10][maci];
int main(){
    IOS;
    ll t=1;cin>>t;



    f(i,0,10) dp[i][0]=1;
    f(i,1,maci){
        f(j,0,9){
            dp[j][i]=dp[j+1][i-1];
        }
        dp[9][i]=(dp[0][i-1]%mod+dp[1][i-1]%mod)%mod;
    }
    while(t--){
        ll n,m,ans=0;
        cin>>n>>m;
        while(n>0){
            ll p=n%10;
            n/=10;
            ans+=dp[p][m];
            ans=ans%mod;
        }
        cout<<ans<<endl;
    }
    return 0;
}

