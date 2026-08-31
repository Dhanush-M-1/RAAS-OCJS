#include<bits/stdc++.h>
using namespace std;

int main(){
    int n , m;
    cin>>n>>m;
    map<int,int>mp;
    for(int i=0;i<m;i++){
        int tt;cin>>tt;
        mp[tt] = 1;
    }
    vector<int>dp(n+3);
    dp[n] = 1;
    for(int i=n-1;i>=0;i--){
        if(mp[i]){dp[i] = 0;}
        else dp[i] = (dp[i+1]+dp[i+2])% 1000000007;

    }
    cout<<dp[0]<<endl;
}
