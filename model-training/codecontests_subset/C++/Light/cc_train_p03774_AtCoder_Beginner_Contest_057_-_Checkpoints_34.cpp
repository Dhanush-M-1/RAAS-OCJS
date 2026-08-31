// luogu-judger-enable-o2
#include<bits/stdc++.h>
using namespace std;
int n,m,minn,ans;
int a[10000000],b[10000000],c[10000000],d[10000000];
int main()
{
	cin>>n>>m;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i]>>b[i];
	}
	for(int i=1;i<=m;i++)
	{
		cin>>c[i]>>d[i];
	}
	for(int i=1;i<=n;i++)
	{
		minn=1e9;
		for(int j=1;j<=m;j++)
		{
			if(abs(c[j]-a[i])+abs(d[j]-b[i])<minn)
			{
				minn=abs(c[j]-a[i])+abs(d[j]-b[i]);
				ans=j;
			}
		}
		cout<<ans<<endl;
	}
	return 0;
}