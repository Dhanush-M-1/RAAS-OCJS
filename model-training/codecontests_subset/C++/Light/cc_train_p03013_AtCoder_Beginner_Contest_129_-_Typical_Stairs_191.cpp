#include<bits/stdc++.h>
using namespace std;

int main()
{
	int i, n, m, x, mod1=1000000007;
	cin >> n >> m;
	int ans[n+1];
	for(i=0; i<=n; i+=1)
		ans[i]=1;
	for(i=0; i<m; i+=1)
	{
		cin >> x;
		ans[x]=0;
	}
	for(i=2; i<=n; i+=1)
	{
		if(ans[i]!=0)
			ans[i]=(ans[i-1]+ans[i-2])%mod1;
	}
	cout << ans[n] << endl;
}