#include <bits/stdc++.h>
#define ll long long
#define lf double
#define E complex<lf>
#define inf 0x3f3f3f3f
#define eps 1e-8
#define pa pair<int,int>
#define pb push_back
#define ms(x,y) memset(x,y,sizeof(x))
#define l(x) (x<<1)
#define r(x) (x<<1|1)
#define mod 1000000007
#define N 100010
using namespace std;
inline ll read() {
	ll x=0,f=1;char c=getchar();
	while (c<'0'||c>'9') f=(c=='-')?-1:1,c=getchar();
	while (c>='0'&&c<='9') x=x*10+c-'0',c=getchar();
	return x*f;
}
int n,m;
ll x,t[N],a[N],r[N];
int main() {
	x=read(),n=read();
	for (int i=1; i<=n; i++) r[i]=read();
	m=read();
	for (int i=1; i<=m; i++) t[i]=read(),a[i]=read();
	ll h=0,k=1,opt=-1,mx=x,mn=0;
	for (int i=1; i<=m; i++) {
		while (k<=n&&t[i]>=r[k]) {
			ll v=(r[k]-r[k-1])*opt;
			mx+=v,mn+=v,h+=v;
			mx=min(mx,x),mx=max(mx,0ll);
			mn=min(mn,x),mn=max(mn,0ll);
			k++,opt*=-1;
		}
		ll now=a[i]+h,d=(t[i]-r[k-1])*opt;
		now=max(now,mn),now=min(now,mx);
		now+=d,now=max(now,0ll),now=min(now,x);
		printf("%lld\n",now);
	}
}