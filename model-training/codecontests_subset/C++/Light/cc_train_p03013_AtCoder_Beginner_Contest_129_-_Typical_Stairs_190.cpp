#include <bits/stdc++.h>
#define rep(i,n) for (int i=0; i<(n); ++i)
using namespace std;
using ll=long long;
int main(){
    const ll mod=1e9+7;
    int n,m;
    cin>>n>>m;
    vector<ll>dp(n+1,1);
    rep(i,m){
        int a; cin>>a;
        dp[a]=0;
    }
    for(int i=2; i<=n; ++i){
        if(dp[i]!=0)dp[i]=(dp[i-1]+dp[i-2])%mod;
    }
    cout<<dp[n]<<endl;
}
