#include<bits/stdc++.h>
using namespace std;
#define d1(a) {cout<<#a<<"="<<(a)<<'\n';}
#define d2(a,b) {cout<<#a<<"="<<(a)<<"   "<<#b<<"="<<(b)<<'\n';}
#define d3(a,b,c) {cout<<#a<<"="<<(a)<<"   "<<#b<<"="<<(b)<<"   "<<#c<<"="<<(c)<<'\n';}
#define D1(a) {cout<<#a<<"里的元素为 ";for(auto x:a)cout<<x<<' ';cout<<'\n';}
#define D2(a) {cout<<#a<<"里的元素为 ";for(auto [x,y]:a)cout<<x<<' '<<y<<"    ";cout<<'\n';}
#define D3(a) {cout<<#a<<"里的元素为 ";for(auto [x,y,z]:a)cout<<x<<' '<<y<<' '<<z<<"    ";cout<<'\n';}
const int N=2e5+5,mod=1e9+7;
vector<vector<long long> >dp(10,vector<long long>(N));
void solve(){
    int n,m;cin>>n>>m;
    long long ans=0;
    for(auto x:to_string(n))
        ans=(ans+dp[x-'0'][m])%mod;
    cout<<ans<<'\n';
}
int main(){
    ios::sync_with_stdio(false);cin.tie(0);
    
    for(int i=0;i<N;i++)
        for(int j=0;j<10;j++)
            dp[j][i]=(i+j<10?1:(dp[1][i+j-10]+dp[0][i+j-10]))%mod;
    int t;cin>>t;
    while(t--)
        solve();
    return 0;
}
