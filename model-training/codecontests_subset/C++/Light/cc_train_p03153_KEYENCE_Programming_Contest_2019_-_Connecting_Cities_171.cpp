/***********************
*  Author: xuziyuan    * 
***********************/

#include <bits/stdc++.h>

#define rt0 return 0
#define rep(i,n) for(int i=0;i<n;i++)
#define repn(i,n) for(int i=1;i<=n;i++)
#define replet(c) for(char c='a';c<='z';c++)
#define LL long long
#define pii pair <int,int>
#define pb push_back
#define fi first
#define se second
#define mpr make_pair
#define sqr(a) ((a)*(a))

using namespace std;

const LL MOD=1e9+7;

LL n,d,a[200010],ans=0,dpl[200010],dpr[200010];

int main()
{
	cin>>n>>d;
	rep(i,n) scanf("%I64d",&a[i]),ans+=a[i];
	if(n==1)
	{
		puts("0");
		rt0;
	}
	ans+=(n-1)*d;
	dpl[0]=a[0];
	for(int i=1;i<n;i++) dpl[i]=min(a[i],dpl[i-1]+d);
	dpr[n-1]=a[n-1];
	for(int i=n-2;i>=0;i--) dpr[i]=min(a[i],dpr[i+1]+d);
	for(int i=1;i<n-1;i++) ans+=min(dpl[i],dpr[i]);//cout<<min(dpl[i],dpr[i])<<' ';
	//cout<<endl;
	cout<<ans<<endl;
	rt0;
}