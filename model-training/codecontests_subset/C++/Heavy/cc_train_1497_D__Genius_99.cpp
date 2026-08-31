#include<bits/stdc++.h>
typedef long long ll;
using namespace std;
const int MAXN = 5005;
int tag[MAXN],s[MAXN];
ll dp[MAXN];
int main(){
    ios::sync_with_stdio(false);
    int t;cin>>t;
    while(t--){
        int n;cin>>n;
        for(int i=1;i<=n;i++){
            cin>>tag[i];
        }
        for(int i=1;i<=n;i++){
            cin>>s[i];
            dp[i]=0;
        }
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                if(tag[i]==tag[j]) continue;
                ll di=dp[i],dj=dp[j],add=abs(s[i]-s[j]);
                dp[i]=max(dp[i],dj+add);
                dp[j]=max(dp[j],di+add);
            }
        }
        ll ans=0;
        for(int i=1;i<=n;i++){
            ans=max(ans,dp[i]);
        }
        cout<<ans<<'\n';
    }
    return 0;
}
