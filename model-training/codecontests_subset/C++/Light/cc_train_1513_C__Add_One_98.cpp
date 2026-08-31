#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    int m=200000;
    int p=1000000007;
    vector<int> dp(m+1);
    for(int i=0;i<9;i++){dp[i]=2;}
    dp[9]=3;
    for(int i=10;i<=m;i++){dp[i]=(dp[i-10]+dp[i-9])%p;}
    int t;
    cin>>t;
    while(t--){
        int n,x;
        cin>>n>>x;
        int ans=0;
        while(n!=0){
            int d=n%10;
            n/=10;
            if(d+x<10){ans=(ans+1)%p;}
            else{ans=(ans+dp[d+x-10])%p;}
        }
        cout<<ans<<endl;
    }
    return 0;
}