#include<bits/stdc++.h>
#define ll long long
#define ull unsigned long long
ll mod=1000000007;
using namespace std;
ll gcd(ll a, ll b)
{
if (b == 0)
return a;
return gcd(b, a % b);
}
ll dp[10][200001];
//ll dp[200001][10];
// void calc()
// {
//    for(int i=0;i<=9;i++) dp[0][i]=1;//base case
//    for(int i=1;i<=200000;i++)
//    {
// 	   for(int j=0;j<9;j++)
// 	   dp[i][j]=dp[i-1][j+1];
// 	   dp[i][9]=(dp[i-1][1]+dp[i-1][0])%mod;
//    }
// }
ll fun(ll n,ll m)
{
	//cout<<"Tej ";
   if(m==0) return 1;
   if(dp[n][m]!=-1) return dp[n][m];
   if(n==9)
   dp[n][m]=fun(1,m-1)+fun(0,m-1);
   else
   dp[n][m]=fun(n+1,m-1);
   return dp[n][m]%mod;
}

void solve()
{
	ll n,m;
	cin>>n>>m;
	ll ans=0;
	while(n)
	{
		ans=(ans + fun(n%10,m))%mod;
		n/=10;
	}
	cout<<ans<<endl;
}
int main()
{
ios_base::sync_with_stdio(false);
cin.tie(0);cout.tie(0);
memset(dp,-1,sizeof(dp));
//calc();
int t=1;cin>>t;
while(t--)
{
solve();
}
return 0;
}