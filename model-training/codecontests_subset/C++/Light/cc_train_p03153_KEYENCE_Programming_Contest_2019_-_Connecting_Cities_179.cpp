/*----------------by syr----------------*/
/*
  -----  -----  -----
  |   |  |---|    _/
  |   |  | \_    /
  -----  |   \  -----

  |---\  \   /  |\  /|
  |   |   \_/   | \/ |
  |   |   / \   |    |
  |---/  /   \  |    |
*/
#include<bits/stdc++.h>

using namespace std;

#define PH push
#define MP make_pair
#define PB push_back
#define fst first
#define snd second
#define FOR(i,x,y) for(int i=(x);i<(y);++i)
#define REP(i,x,y) for(int i=(x);i<=(y);++i)
#define x0 x0123456789
#define y0 y0123456789
#define x1 x1234567890
#define y1 y1234567890
#define x2 x2345678901
#define y2 y2345678901
typedef double db;
typedef long long ll;
typedef long double ldb;
typedef pair<int,int> pii;

const int INF=1e9+7;
const int maxn=2e5+5;

struct Edge{
	ll w;
	int u;
	int v;
	Edge(ll w,int u,int v):w(w),u(u),v(v){}
	inline bool operator <(const Edge &b)const{return w<b.w;}
};

class Dsu{
private:
	int sz;
	int fa[maxn];
public:
	inline void init(int n){
		sz=n;
		FOR(i,0,sz) fa[i]=i;
		return;
	}
	inline int find(int x){return (x==fa[x])?(x):(fa[x]=find(fa[x]));}
	inline void combine(int x,int y){
		x=find(x);y=find(y);
		fa[x]=y;
		return;
	}
}dsu;

int n;
int a[maxn];
ll d,ans;
vector<Edge> vec;

inline void solve(int l,int r){
	if(l==r) return;
	int md=(l+r)>>1;
	solve(l,md);
	solve(md+1,r);
	int va=r,vs=l;
	REP(i,l+1,md) if(a[i]-d*i<=a[vs]-d*vs) vs=i;
	FOR(i,md+1,r) if(a[i]+d*i<=a[va]+d*va) va=i;
	REP(i,l,md)	vec.PB(Edge((va-i)*d+a[va]+a[i],va,i));
	REP(i,md+1,r) vec.PB(Edge((i-vs)*d+a[vs]+a[i],vs,i));
	return;
}

int main(){
	scanf("%d%lld",&n,&d);
	FOR(i,0,n) scanf("%d",a+i);
	solve(0,n-1);
	sort(vec.begin(),vec.end());
	dsu.init(n);
	FOR(i,0,vec.size()){
		int u=vec[i].u,v=vec[i].v;
		if(dsu.find(u)==dsu.find(v)) continue;
		//printf("u=%d v=%d\n",u,v);
		ans+=vec[i].w;
		dsu.combine(u,v);
	}
	printf("%lld\n",ans);
	return 0;
}
