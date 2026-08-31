#include<bits/stdc++.h>
#define ll long long 
using namespace std;
const int mxn=2e5+10,mod=1e9+7;
int dp[12][mxn];
int main()
{
    int arr[]={1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2};
    for(int i=0;i<=9;i++)
        for(int j=0;j<10;j++)
            dp[i][j]=arr[i+j];
    for(int i=0;i<=9;i++)
        for(int j=10;j<mxn;j++)
            dp[i][j]=(dp[i][j-10]%mod+dp[i][j-9]%mod)%mod;
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int n,m;
        scanf("%d%d",&n,&m);
        int res=0;
        while(n!=0)
        {
            int rem=n%10;
            res=(res%mod+dp[rem][m]%mod)%mod;
            n/=10;
        }
        printf("%d\n",res);
    }
    return 0;
}