#include <bits/stdc++.h>
using namespace std;
const int mod=1000000007;
long long dp[100005];
bool a[100005];
int n,m,x;
int main()
{
    scanf(" %d %d",&n,&m);
    for(int i=0;i<m;i++){
        scanf(" %d",&x);
        a[x]=1;
    }
    dp[0]=1;dp[1]=(a[1]==1?0:1);
    for(int i=2;i<=n;i++)
        dp[i]=(a[i]==1?0:dp[i-1]+dp[i-2])%mod;
    cout<<dp[n]<<endl;
    return 0;
}
