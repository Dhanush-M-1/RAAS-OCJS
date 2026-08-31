#include<bits/stdc++.h>
using namespace std;
const int mod=1e9+7;
int n,m,tmp;
bool cant[1000010];
long long dp[1000010];
int main(){
    cin>>n>>m;
    while(m--){
        scanf("%d",&tmp);
        cant[tmp]=1;
    }
    dp[0]=1;
    if(!cant[1]) dp[1]=1;
    for(int i=2;i<=n;i++){
        if(!cant[i]) dp[i]=(dp[i-1]+dp[i-2])%mod;
    }
    cout<<dp[n];
}
