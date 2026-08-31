#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N=2e5+7;
int n,fa[N];
ll ans,d,a[N],l[N],r[N];
int main()
{
	cin>>n>>d;
	ans=(n-1)*d;
	for(int i=1;i<=n;i++)scanf("%lld",&a[i]),ans+=a[i],l[i]=r[i]=1e18;
	l[1]=a[1];
	for(int i=2;i<=n;i++)l[i]=min(l[i-1],a[i]-(i-1)*d);
	r[n]=a[n]+(n-1)*d;
	for(int i=n-1;i;i--)r[i]=min(r[i+1],a[i]+(i-1)*d);
	for(int i=2;i<n;i++)ans+=min((i-1)*d+l[i],r[i]-(i-1)*d);
	cout<<ans<<endl;
}