#include <bits/stdc++.h>
#define ll long long
using namespace std;
int main()
{
  int n,m; cin >> n >> m; vector<ll> A(n+1,0); int a;
  for (int i=0;i<m;i++)
  {  cin >> a;
  	A[a]=-1;
  }
  vector<ll> dp(n+1,0);
  ll mod=1e9+7;
  dp[0]=1; dp[1]=(A[1]==0);
  for (int i=2;i<=n;i++)
  {
    if (A[i]==-1) dp[i]=0;
    else
    {
      dp[i]=(dp[i-1]+dp[i-2])%mod;
    }
  }
  cout << dp[n];
  return 0;
}
