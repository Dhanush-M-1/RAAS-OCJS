#include <iostream>
using namespace std;
int n,m;
long long dp[100009];
int a;
int main(){
    cin>>n>>m;
    for(int i=1;i<=n;i++)dp[i]=-1;
    dp[0]=1;
    for(int i=0;i<m;i++){
        cin>>a;
        dp[a]=0;
    }
    if(dp[1]!=0)dp[1]=1;
    for(int i=2;i<=n;i++){
        if(dp[i]==0)continue;
        dp[i]=(dp[i-1]+dp[i-2])%1000000007;
    }
    cout<<dp[n];
    return 0;
}