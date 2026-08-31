#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define FOR(i,a,b) for(int i=(a);i<=(b);i++)
#define ROF(i,a,b) for(int i=(a);i>=(b);i--)
int n,d;
ll f[200020],g[200020],ans,a[200020];
int main(){
	scanf("%d%d",&n,&d);
	FOR(i,1,n) scanf("%lld",a+i);
	f[1]=a[1];
	FOR(i,2,n) f[i]=min(f[i-1]+d,a[i]);
	g[n]=a[n];
	ROF(i,n-1,1) g[i]=min(g[i+1]+d,a[i]);
	FOR(i,2,n-1) ans+=min(f[i],g[i])+a[i];
	ans+=1ll*d*(n-1)+a[1]+a[n];
	printf("%lld\n",ans);
}