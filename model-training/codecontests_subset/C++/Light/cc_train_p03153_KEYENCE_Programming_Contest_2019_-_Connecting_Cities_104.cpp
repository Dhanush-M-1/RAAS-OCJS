#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn=2e5+10;
ll A[maxn],dp[2][maxn];
int main()
{
	int n;scanf("%d",&n);
	ll d;scanf("%lld",&d);
	ll ret=0;
	for(int i=0;i<n;i++)
	{
		scanf("%lld",&A[i]);
		ret+=A[i];
	}
	ret+=d*(n-1);
	dp[0][0]=A[0];
	for(int i=1;i<n;i++)
		dp[0][i]=min(A[i],dp[0][i-1]+d);
	dp[1][n-1]=A[n-1];
	for(int i=n-2;i>=0;i--)
		dp[1][i]=min(A[i],dp[1][i+1]+d);
	for(int i=1;i<n-1;i++)
		ret+=min(dp[0][i],dp[1][i]);
	printf("%lld\n",ret);
	return 0;
}