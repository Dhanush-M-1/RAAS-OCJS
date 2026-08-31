#include<bits/stdc++.h> 
using namespace std;
#define fast ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define take ll a[n]; for(int i=0;i<n;i++){cin>>a[i];}
#define ll long long int
#define output for (int i=0;i<n;i++){cout<<a[i]<<' ';}cout<<endl;
#define vv vector<ll> 
#define VIN(a) for(auto &it:a) cin>>it;
#define pb push_back 
#define CIN(x,i,a,b) for(int i=a;i<b;i++){cin>>x[i];}
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define se(a) a.begin(),a.end()
#define ppi vector<pair <ll,ll>>
const int MAX_N = 1e5 + 1;
const int MOD = 1e9 + 7;
const int INF = 1e9;
#define Endl endl;
#define DP(n,w) int dp[n+1][w+1]; memset(dp, 0, sizeof(dp));
#define INIT int t[200005]; memset(t,-1,sizeof(t));
#define INITDP int t[200005][200005]; memset(t,-1,sizeof(t));
#define mem(a,x) memset(a,x,sizeof(a));
ll dp[200001];
void solve() 
{
      ll n,m;
      cin>>n>>m;
      
      
      ll ans=0;
      while(n>0)
      {
            ll x=n%10;
            if(x+m<10)
            {
                  ans+=1;
            }
            else
            {
                  ans+=dp[x+m-10];
            }
            ans%=MOD;
            n/=10;
      }
      cout<<ans<<endl;
}
int main() 
{
fast
for(int i=0;i<9;i++)
{
      dp[i]=2;
}
dp[9]=3;
for(int i=10;i<200001;i++)
{
      dp[i]=(dp[i-9]+dp[i-10])%MOD;
}
int q=1; cin >> q; while(q--){ solve();}
}