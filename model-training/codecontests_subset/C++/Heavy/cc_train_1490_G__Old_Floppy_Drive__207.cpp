#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int inf=2e9;
const int maxn=2e5+10;
int t,n,m;
ll tot;
ll a[maxn],sum[maxn];
ll tw[maxn];
int main()
{
	ios::sync_with_stdio(false);cin.tie(0);
	cin>>t;
	while (t--)
	{
		cin>>n>>m;tot=0;tw[0]=-inf;
		for (int i=1;i<=n;i++)
		{
			cin>>a[i];
			tot+=a[i];
			sum[i]=sum[i-1]+a[i];
			tw[i]=max(tw[i-1],sum[i]);
		}
		for (int i=1;i<=m;i++)
		{
			int x;cin>>x;
			if (tw[n]<x && sum[n]<=0) {cout<<-1<<' ';continue;}
			ll res=0;
			if (x<=tw[n]) res+=lower_bound(tw+1,tw+n+1,x)-tw;
			else
			{
				res=(x-tw[n]+sum[n]-1)/sum[n];x-=res*sum[n];
				res*=n;
				res+=lower_bound(tw+1,tw+n+1,x)-tw;
			}
			cout<<res-1<<' ';
		}
		cout<<endl;
		for (int i=1;i<=n;i++) a[i]=sum[i]=tw[i]=0;
	}
	return 0;
}
