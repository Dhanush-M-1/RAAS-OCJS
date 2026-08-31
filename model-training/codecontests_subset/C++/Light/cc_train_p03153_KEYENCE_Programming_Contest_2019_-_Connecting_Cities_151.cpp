#include<bits/stdc++.h>
using namespace std;
long long n,a[200001],f[200001],g[200001],d;
long long ans;
int main()
{
	scanf("%lld%lld",&n,&d);
	for(int i=1;i<=n;i++)
	{
		scanf("%lld",&a[i]);
		ans+=a[i];
	}
	f[1]=a[1];
	for(int i=2;i<=n;i++)f[i]=min(f[i-1]+d,a[i]);
	g[n]=a[n];
	for(int i=n-1;i>=1;i--)g[i]=min(g[i+1]+d,a[i]);
	for(int i=2;i<=n-1;i++)ans+=min(f[i],g[i]);
	printf("%lld",ans+(n-1)*d);
}