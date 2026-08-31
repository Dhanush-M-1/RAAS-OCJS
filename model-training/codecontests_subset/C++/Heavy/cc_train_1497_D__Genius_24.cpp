#include<bits/stdc++.h>
using namespace std;
#define ll long long
int main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        ll tag[n], s[n], dp[n];
        for(int i=0;i<n;i++) cin>>tag[i];
        for(int j=0;j<n;j++) cin>>s[j];
        memset(dp,0,sizeof(dp));
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(tag[i]==tag[j]) continue;
                ll di = dp[i], dj = dp[j], p = abs(s[i]-s[j]);
                dp[i] = max(dp[i],dj+p);
                dp[j] = max(dp[j], di+p);
            }
        }
        ll maxi=0;
        for(int i=0;i<n;i++){
            maxi = max(dp[i],maxi);
        }
        cout<<maxi<<endl;
    }
}