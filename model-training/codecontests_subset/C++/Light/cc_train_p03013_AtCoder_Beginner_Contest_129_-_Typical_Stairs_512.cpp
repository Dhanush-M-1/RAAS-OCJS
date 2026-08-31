#include<bits/stdc++.h>
using namespace std;
long long n,m,a[100005],dp[100005],x;
int main()
{
	cin>>n>>m;
	for(int i=0;i<m;i++)
    {
        cin>>x;
        a[x]=1;
    }
    dp[0]=1;
    if(a[1]) dp[1]=0;
    else dp[1]=1;
    for(int i=2;i<=n;i++)
    {
        if(a[i]) dp[i]=0;
        else dp[i]=(dp[i-1]+dp[i-2])%1000000007;
    }
    cout<<dp[n]<<endl;

	return 0;
}
