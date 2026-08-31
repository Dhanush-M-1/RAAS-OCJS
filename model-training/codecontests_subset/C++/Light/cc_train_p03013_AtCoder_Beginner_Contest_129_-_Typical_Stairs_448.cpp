#include<bits/stdc++.h>
using namespace std;
#define int long long
const int mod=1e9+7;
const int N=1e6+5;
int n,m,x,b[N],f[N];
signed main()
{
	cin>>n>>m;
	for(int i=1;i<=m;i++)
	{
		scanf("%d",&x);
		b[x]=1;
	}
	f[0]=1;
	for(int i=1;i<=n;i++)
	{
		if(b[i])continue;
		f[i]=(f[i-1]+f[i-2])%mod;
	}
	cout<<f[n];
}