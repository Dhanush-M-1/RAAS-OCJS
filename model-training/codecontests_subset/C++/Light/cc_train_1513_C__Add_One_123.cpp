#include<bits/stdc++.h>
#define MAX 200000
#define MOD 1000000007
using namespace std;
int dp[11][MAX+10];
int go(int x,int m)
{
	if(dp[x][m]!=-1)	
		return dp[x][m];
	if(m==0)
		return dp[x][m] = 1;
	if(x==9)
		return dp[x][m] = (go(1,m-1)+go(0,m-1))%MOD;
	return dp[x][m] = go(x+1,m-1);
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0;i<=9;++i)
		for(int j=0;j<=MAX;++j)
			dp[i][j] = -1;
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		int m;
		cin>>m;
		long long ans = 0;
		for(char c:s)
			ans += go(c-'0',m)*1LL, ans %= MOD;
		cout<<ans<<endl;
	}
	return 0;
}