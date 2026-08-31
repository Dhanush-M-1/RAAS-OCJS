#include <bits/stdc++.h>
#define ll long long
using namespace std;
int t,n,tag[5010];ll f[5010],ans,s[5010];
int main()
{
	scanf("%d",&t);
	while(t--)
	{
		ans=0;
		scanf("%d",&n);
		for(int i=1;i<=n;i++)
			scanf("%d",&tag[i]),f[i]=0;
		for(int i=1;i<=n;i++)
			scanf("%lld",&s[i]);
		for(int i=1;i<=n;i++)
			for(int j=i-1;j>=1;j--)
			{
				if(tag[i]==tag[j]) continue;
				ll tmpi=f[i];
				f[i]=max(f[i],f[j]+abs(s[i]-s[j]));
				f[j]=max(f[j],tmpi+abs(s[i]-s[j]));
			}
		for(int i=1;i<=n;i++)
			ans=max(ans,f[i]);
		printf("%lld\n",ans);
	}
}