#include<bits/stdc++.h>
using namespace std;
#define int long long
int n,d,ret,a[200005],dpl[200005],dpr[200005];
signed main()
{
	cin>>n>>d;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
		ret+=a[i];
	}
	ret+=(n-1)*d;
	dpr[0]=a[0];
	for(int i=1;i<n;i++)
		dpr[i]=min(a[i],dpr[i-1]+d);
	dpl[n-1]=a[n-1];
	for(int i=n-2;i>=0;i--)
		dpl[i]=min(a[i],dpl[i+1]+d);
	for(int i=1;i<n-1;i++)
		ret+=min(dpl[i],dpr[i]);
	cout<<ret<<endl;
	return 0;
}
