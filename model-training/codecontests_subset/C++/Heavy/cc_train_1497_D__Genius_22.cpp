#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie();
    cout.tie();

    int tt;
    cin>>tt;
    while(tt--){
        long long n;
        cin>>n;
        vector <long long> t(n),s(n);
        for(long long i=0;i<n;i++) cin>>t[i];
        for(long long i=0;i<n;i++) cin>>s[i];
        vector <long long> dp(n);
        for(long long j=1;j<n;j++){
            for(long long i=j-1;i>=0;i--){
                if(t[i]!=t[j]){
                    long long a=dp[i],b=dp[j];
                    long long p=abs(s[i]-s[j]);
                    dp[i]=max(dp[i],b+p);
                    dp[j]=max(dp[j],a+p);
                }
            }
        }
        long long res=0;
        for(long long i=0;i<n;i++) res=max(res,dp[i]);
        cout<<res<<'\n';
    }

    return 0;
}
