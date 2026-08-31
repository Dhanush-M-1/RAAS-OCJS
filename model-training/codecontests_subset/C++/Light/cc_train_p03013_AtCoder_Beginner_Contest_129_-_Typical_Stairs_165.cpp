#include <bits/stdc++.h>
using namespace std;
#define ll long long
const ll MOD=1e9+7;
using  P=pair<ll,ll>;
int main(){
  ll N,M,dp[100020];
  cin>>N>>M;
  unordered_map<ll,ll> mp;
  for(ll i=0;i<M;i++){
    ll a;
    cin>>a;
    mp[a]=-1;
  }
  dp[0]=1;
  for(ll i=1;i<=N;i++){
    if(mp[i]!=-1){dp[i]=(dp[i-1]+dp[i-2])%MOD;}
    else{dp[i]=0;}
  }
  cout<<dp[N]%MOD<<endl;
}