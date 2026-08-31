#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int,int> pii;
typedef pair<ll,pii> ppi;

const int maxn=200003;

vector<ppi> e;
int n,d,a[maxn];

inline ll calcf(int i){
	return a[i]-1ll*d*i;
}

inline ll calcg(int i){
	return a[i]+1ll*d*i;
}

void add(int l,int r){
	e.push_back(make_pair(calcf(l)+calcg(r),make_pair(l,r)));
}

void solve(int l,int r){
	if(l==r) return ;
	int mid=(l+r)/2;
	solve(l,mid);
	solve(mid+1,r);
	ll mn=1e18;
	int pl,pr;
	for(int i=l;i<=mid;++i){
		if(calcf(i)<mn){
			mn=calcf(i);
			pl=i;
		}
	}
	mn=1e18;
	for(int i=mid+1;i<=r;++i){
		if(calcg(i)<mn){
			mn=calcg(i);
			pr=i;
		}
	}
	for(int i=l;i<=mid;++i)
		add(i,pr);
	for(int i=mid+1;i<=r;++i)
		add(pl,i);
}
int fa[maxn];

int fnd(int x){
	return fa[x]==x?x:fa[x]=fnd(fa[x]);
}

int main(){
	scanf("%d%d",&n,&d);
	for(int i=1;i<=n;++i)
		scanf("%d",&a[i]),fa[i]=i;
	solve(1,n);
	sort(e.begin(),e.end());
//	for(int i=0;i<e.size();++i){
//		printf("[%d (%d %d)]\n",e[i].first,e[i].second.first,e[i].second.second);
//	}
	ll res=0;
	for(int i=0;i<e.size();++i){
		int x=e[i].second.first;
		int y=e[i].second.second;
		int fx=fnd(x),fy=fnd(y);
		if(fx!=fy){
			fa[fx]=fy;
			res+=e[i].first;
		}
	}
	printf("%lld\n",res);
	return 0;
}

