//by xxj
#include<bits/stdc++.h>
using namespace std;
#define mp make_pair
#define ll long long
#define pii pair<int,int>
#define lowbit(x) x&-x
const int inf=1e9+7;
const double eps=1e-10;
const ll linf=1e18+7;
const ll hh=523;
//const int mod=;
ll a[200007];
int fa[200007];
int n;
ll d;
vector<pair<ll,pii> > edge;
int ff(int x){
	if (fa[x]==x){
		return x;
	}
	return fa[x]=ff(fa[x]);
}
void solve(int l,int r){
	if (l==r){
		return;
	}
	int mid=(l+r)>>1;
	ll mnl=linf,mnr=linf;
	int pl,pr;
	ll t;
	for (int i=mid;i>=l;i--){
		t=a[i]-1ll*i*d;
		if (t<mnl){
			mnl=t;
			pl=i;
		}
	}
	for (int i=mid+1;i<=r;i++){
		t=a[i]+1ll*i*d;
		if (t<mnr){
			mnr=t;
			pr=i;
		}
	}
	for (int i=mid;i>=l;i--){
		t=a[i]-1ll*i*d;
		edge.push_back(mp(t+mnr,mp(pr,i)));
	}
	for (int i=mid+1;i<=r;i++){
		t=a[i]+1ll*i*d;
		edge.push_back(mp(t+mnl,mp(pl,i)));
	}
	solve(l,mid);
	solve(mid+1,r); 
}
int main(){
	//freopen(".in","r",stdin);
	//freopen(".out","w",stdout);
	scanf("%d%lld",&n,&d);
	for (int i=0;i<n;i++){
		scanf("%lld",a+i);
		fa[i]=i;
	}
	solve(0,n-1);
	sort(edge.begin(),edge.end());
	int f1,f2;
	ll ans=0;
	for (int i=0;i<edge.size();i++){
		pii p=edge[i].second;
		f1=ff(p.first);
		f2=ff(p.second);
		if (f1!=f2){
			ans+=edge[i].first;
			fa[f1]=f2;
		}
	}
	printf("%lld\n",ans);
	return 0;
}
/*
input:
*/