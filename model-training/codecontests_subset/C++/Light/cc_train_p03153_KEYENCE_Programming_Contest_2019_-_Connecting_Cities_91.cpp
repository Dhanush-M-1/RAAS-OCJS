#include<bits/stdc++.h>
using namespace std;

#define pb push_back
#define fi first
#define se second
#define ll long long
#define pq priority_queue
#define mp make_pair
#define pii pair<int,int>
#define mod 998244353

int lowbit(int x) {return x&(-x);}

int n,d;
int a[200010];

vector <pair<ll,pii> > e;

struct UF{
	int p[200010],rank[200010];	
	void init() {
		for (int i=0;i<200010;i++) p[i]=i;
		for (int i=0;i<200010;i++) rank[i]=0;
	}
	int getf(int x){
		if (p[x]==x) return x;
		return getf(p[x]);
	}
	bool same(int x,int y) {
		return getf(x)==getf(y);
	}
	void unite(int x,int y) {
		int xx=getf(x);
		int yy=getf(y);
		if (xx!=yy) {
			if (rank[xx]<rank[yy]) p[xx]=yy;
			else {
				p[yy]=xx;
				if (rank[xx]==rank[yy]) rank[xx]++;
			}
		}
	}
}uf;

void solve(int l,int r) {
	if (l==r) return;
	int mid=l+r>>1;
	ll mn=1e18;
	int pl,pr;
	for (int i=l;i<=mid;i++) {
		ll cur=(ll)a[i]-(ll)d*(ll)i;
		if (cur<mn) {
			mn=cur;
			pl=i;
		}
	}
	mn=1e18;
	for (int j=mid+1;j<=r;j++) {
		ll cur=a[j]+(ll)d*(ll)j;
		if (cur<mn) {
			mn=cur;
			pr=j;
		}
	}
	for (int i=mid+1;i<=r;i++) {
		ll vl=(ll)a[pl]-(ll)d*(ll)pl;
		ll vr=(ll)a[i]+(ll)d*(ll)i;
		e.pb(mp(vl+vr,mp(pl,i)));
	}
	for (int i=l;i<=mid;i++) {
		ll vl=(ll)a[i]-(ll)d*(ll)i;
		ll vr=(ll)a[pr]+(ll)d*(ll)pr;
		e.pb(mp(vl+vr,mp(i,pr)));
	}
	solve(l,mid);
	solve(mid+1,r);
}

int main(){
	scanf("%d%d",&n,&d);
	for (int i=0;i<n;i++) scanf("%d",&a[i]);
	solve(0,n-1);
	sort(e.begin(),e.end());
	uf.init();
	ll ans=0ll;
	for (int i=0;i<e.size();i++) {
		int u=e[i].se.fi,v=e[i].se.se;
		if (!uf.same(u,v)) {
			uf.unite(u,v);
			ans+=e[i].fi;
//			cout<<e[i].fi<<" "<<u<<" "<<v<<endl;
		}
	}
	cout<<ans;
	return 0;
}
