#include<bits/stdc++.h>

using namespace std;

#define N 300000
#define LL long long

LL n,m,p,ans,a[N],fa[N];
struct edge{
	LL x,y,c;
	edge(LL x=0,LL y=0,LL c=0):x(x),y(y),c(c){}
	bool operator < (const edge &p) const{return c<p.c;}
}b[N<<5];

LL gfa(LL x){
	return x==fa[x]?x:fa[x]=gfa(fa[x]);
}

void solve(LL l,LL r){
	if (l>=r) return;
	LL mid=(l+r)>>1;
	LL t=0;
	for (LL i=l;i<=mid;++i)
		if (t==0||a[i]+(mid-i)*p<a[t]+(mid-t)*p) t=i;
	for (LL i=mid+1;i<=r;++i) b[++m]=edge(t,i,a[t]+a[i]+(i-t)*p);
	t=0;
	for (LL i=mid+1;i<=r;++i)
		if (t==0||a[i]+(i-mid-1)*p<a[t]+(t-mid-1)*p) t=i;
	for (LL i=l;i<=mid;++i) b[++m]=edge(t,i,a[t]+a[i]+(t-i)*p);
	solve(l,mid); solve(mid+1,r);
}

int main(){
	scanf("%lld%lld",&n,&p);
	for (LL i=1;i<=n;++i) scanf("%lld",a+i);
	solve(1,n);
	sort(b+1,b+m+1);
	for (int i=1;i<=n;++i) fa[i]=i;
	for (LL i=1;i<=m;++i){
		LL x=b[i].x,y=b[i].y; x=gfa(x); y=gfa(y);
		if (x!=y){ans+=b[i].c; fa[x]=y;}
	}
	printf("%lld\n",ans);
	
	return 0;
}
			