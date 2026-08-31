#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
const int MAX_N=200005;
LL A[MAX_N],dp1[MAX_N],dp2[MAX_N]; 
LL ans,D;
int n;
int main()
{
	cin>>n>>D;
	ans+=(n-1)*D;
	for(int i=0;i<n;i++)
	{
		cin>>A[i];
		ans+=A[i];
	}
	dp1[0]=A[0];
	dp2[n-1]=A[n-1];
	for(int i=1;i<n;i++)dp1[i]=min(dp1[i-1]+D,A[i]);
	for(int i=n-2;i>=0;i--)dp2[i]=min(dp2[i+1]+D,A[i]);
	for(int i=1;i<n-1;i++)ans+=min(dp1[i],dp2[i]);
	if(n==1)ans=0;
	cout<<ans<<endl;
	return 0;
}
