/* --- author: dxm --- */
#include<bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;

#define INF 1e9
#define Inf 1e18
#define rep(i,n) for(int (i)=0;(i)<n;i++)
#define REP(i,n) for(int (i)=1;(i)<=n;i++)
#define mp make_pair
#define pb push_back
#define fst first
#define snd second
typedef long long ll;
typedef double db;
typedef long double ldb;
typedef unsigned int uint;
typedef unsigned long long ull;
typedef pair<int,int> pii;
typedef pair<long long,long long> pll;

void qread(int &x){
	int neg=1;x=0;
	char c=getchar();
	while(c<'0'||c>'9'){if(c=='-')neg=-1;c=getchar();}
	while(c>='0'&&c<='9')x=10*x+c-'0',c=getchar();
	x*=neg;
}

const int maxn=200005;
int n,d,tot;
int a[maxn];
ll ans;
class Edge{
public:
	int u,v;
	ll w;
	Edge(int _u=0,int _v=0,ll _w=0):u(_u),v(_v),w(_w){}
	bool operator < (const Edge &o)const{
		return w<o.w;
	}
}e[maxn*20];

namespace Dsu{
	int f[maxn];
	void init(){
		REP(i,n)f[i]=i;
	}
	int find(int x){
		return f[x]==x?x:f[x]=find(f[x]);
	}
}

void solve(int l,int r){
	if(l==r)return;
	int mid=l+r>>1;
	pair<ll,int>mn=mp(Inf,0);
	for(int i=l;i<=mid;i++)mn=min(mn,mp(-1LL*i*d+a[i],i));
	for(int i=mid+1;i<=r;i++)e[++tot]=Edge(mn.snd,i,mn.fst+1LL*i*d+a[i]);
	mn=mp(Inf,0);
	for(int i=mid+1;i<=r;i++)mn=min(mn,mp(1LL*i*d+a[i],i));
	for(int i=l;i<=mid;i++)e[++tot]=Edge(i,mn.snd,-1LL*i*d+a[i]+mn.fst);
	solve(l,mid);solve(mid+1,r);
}

int main(){
#ifdef FILE
	freopen("FILE.in","r",stdin);
	freopen("FILE.out","w",stdout);
#endif
	scanf("%d%d",&n,&d);
	REP(i,n)scanf("%d",&a[i]);
	solve(1,n);
	sort(e+1,e+1+tot);
	Dsu::init();
	REP(i,tot){
		int u=Dsu::find(e[i].u),v=Dsu::find(e[i].v);
		if(u==v)continue;
		ans+=e[i].w;
		Dsu::f[u]=v;
	}
	printf("%lld\n",ans);
#ifdef TIME
	printf("Running Time = %d ms\n",int(clock()*1000.0/CLOCKS_PER_SEC));
#endif
	return 0;
}

/*
Input:
-----------------
Output:
*/
