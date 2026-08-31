#include <bits/stdc++.h>
#define ll long long
#define mp make_pair
#define pb push_back
#define INF 0x3f3f3f3f
using namespace std;
ll l[200001],dpr[200001],dpl[200001];
void solve()
{
	int n;
	cin>>n;
	ll d;
	cin>>d;
	ll ret=0;
	for (int i=0;i<n;i++) cin>>l[i],ret+=l[i];
	ret+=(n-1)*d;
	dpr[0]=l[0];
	for (int i=1;i<n;i++) dpr[i]=min(l[i],dpr[i-1]+d);
	dpl[n-1]=l[n-1];
	for (int i=n-2;i>=0;i--) dpl[i]=min(l[i],dpl[i+1]+d);
	for (int i=1;i<n-1;i++) ret+=min(dpl[i],dpr[i]);
	cout<<ret;
}
int main()
{
	solve();
	return 0;
}