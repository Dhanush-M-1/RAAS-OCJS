//Bismillahir Rahmanir Raheem
#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
#define fast ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define mod 1000000007
ll dp[200001][11];
ll f(ll m,ll x){
    if(m==0)return 0;
    if(dp[m][x]!=-1)return dp[m][x];
    dp[m][x]=0;
    if(m>=(10-x)){
    	dp[m][x]=(1+(f(m-(10-x),0))%mod+(f(m-(10-x),1))%mod)%mod;
    }
    return dp[m][x];
}



int main()
{
    fast;
    memset(dp,-1,sizeof(dp));
    f(200001,0);
    f(200001,1);
	int t;
	cin>>t;
	while(t--)
	{
	  ll n,m;
      string s;
	  cin>>s>>m;
	  ll ans=0;
	  n=s.size();
	  for(int i=0;i<n;i++){
	  	ll v=s[i]-'0';
	  	ans=(ans+1+f(m,v))%mod;
	  }
	  cout<<ans<<endl;

	}
	return 0;
}