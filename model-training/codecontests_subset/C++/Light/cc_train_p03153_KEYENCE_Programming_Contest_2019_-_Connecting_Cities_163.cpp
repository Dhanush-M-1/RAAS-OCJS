#include <bits/stdc++.h>
using namespace std;
#define ref(i,x,y)for(int i=x;i<=y;++i)
#define mp make_pair
#define fi first
#define se second
typedef long long LL;
typedef pair<LL,int> PII;
const int N=200010;
const LL inf=1e18;
int n,D,s[N];
struct node{
	int x,y;
	PII p; LL s;
	PII s1[2],s2[2];
}a[N*5];
void pushup(int t){
	int l=t<<1,r=l|1;PII pp;LL ss;
	ref(d,0,1)a[t].s1[d]=min(a[l].s1[d],a[r].s1[d]);
	ref(d,0,1)a[t].s2[d]=min(a[l].s2[d],a[r].s2[d]);
	if(a[l].s<a[r].s) a[t].p=a[l].p,a[t].s=a[l].s;
		else a[t].p=a[r].p,a[t].s=a[r].s;
	pp=mp(a[l].s2[0].se,a[r].s1[1].se);
	ss=a[l].s2[0].fi+a[r].s1[1].fi;
	if(ss<a[t].s)a[t].p=pp,a[t].s=ss;
	pp=mp(a[r].s1[0].se,a[l].s2[1].se);
	ss=a[l].s2[1].fi+a[r].s1[0].fi;
	if(ss<a[t].s)a[t].p=pp,a[t].s=ss;
}
void build(int x,int y,int t){
	a[t].x=x;a[t].y=y;
	if(x==y){
		a[t].p=mp(0,0); a[t].s=inf;
		a[t].s1[0]=mp(s[x]+(LL)D*x,x);a[t].s1[1]=mp(inf,0);
		a[t].s2[0]=mp(s[x]-(LL)D*x,x);a[t].s2[1]=mp(inf,0);
		return;
	}
	int m=(x+y)>>1;
	build(x,m,t<<1);
	build(m+1,y,t<<1|1);
	pushup(t);
}
void update(int x,int y,int t,int p){
	if(x==y){
		swap(a[t].s1[0],a[t].s1[1]);
		swap(a[t].s2[0],a[t].s2[1]);
		return;
	}
	int m=(x+y)>>1;
	if(p<=m)update(x,m,t<<1,p);
	else update(m+1,y,t<<1|1,p);
	pushup(t);
}
int main(){
	cin>>n>>D;
	ref(i,1,n)cin>>s[i];
	build(1,n,1);
	update(1,n,1,1);
	LL ans=0;
	ref(i,1,n-1){
		PII p=a[1].p;LL s=a[1].s;
		update(1,n,1,p.fi);ans+=s;
	}
	cout<<ans<<endl;
}