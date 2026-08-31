#include <iostream>
#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5e3+5;
long long tag[MAXN];
long long s[MAXN];
long long dp[MAXN];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        for(int i=1;i<=n;i++){
            cin>>tag[i];
        }
        for(int i=1;i<=n;i++){
            cin>>s[i];
        }
        for(int i=1;i<=n;i++){
            
            dp[i] = 0;
        }
        long long res = 0;
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                if(tag[i] == tag[j]){
                    continue;
                }
                long long previ = dp[i];
                long long prevj = dp[j];
                
                dp[i] = max(dp[i],prevj+abs(s[i]-s[j]));
                dp[j] = max(dp[j],previ+abs(s[i]-s[j]));
                res = max(res,dp[i]);
                res = max(res,dp[j]);
            }
        }
        cout<<res<<endl;
    }
    
    
}