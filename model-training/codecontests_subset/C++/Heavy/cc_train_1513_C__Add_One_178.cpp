#include <iostream>
#include <bits/stdc++.h>
#define ll long long
using namespace std;

const int M = 1e9+7;
ll mod(ll x){
    return (x%M + M)%M;
}

ll mul(ll a, ll b){
    return mod((mod(a)*mod(b)));
}

ll add(ll a , ll b){
    return mod(mod(a)+mod(b));
}


void solve(){
    vector<vector<int>>dp(200001,vector<int>(10));
    for(int i=0;i<10;i++) dp[0][i]=1;
    for(int i=1;i<=200000;i++){
        for(int j=0;j<10;j++){
            if(j<=8) dp[i][j]=dp[i-1][j+1];
            else dp[i][j]=add(dp[i-1][0],dp[i-1][1]);
        }
    }
    int t;
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        int m;
        cin>>m;
        vector<int>f(10,0);
        for(auto i : s) f[i-'0']++;
        ll ans=0;
        for(int i=0;i<10;i++){
            ans=add(ans,mul(f[i],dp[m][i]));
        }
        cout<<ans<<"\n";
    }
}  
int main(){
    ios::sync_with_stdio(0);
            cin.tie(0);
            cout.tie(0);
            cout<<fixed;
            cout<<setprecision(10);
    //        freopen("timber_input.txt", "r", stdin);
    //        freopen("timber_output.txt", "w", stdout);
            int t=1;
            // cin>>t;
            for(int i=1;i<=t;i++){
            //    cout<<"Case #"<<i<<": ";  
                solve();
    }
    return 0;
}


