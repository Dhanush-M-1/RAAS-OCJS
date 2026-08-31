#include<cstdio>
#include<cmath>
#include<algorithm>
#include<vector>
using namespace std;
typedef long long ll;
typedef pair<ll,int> pli;
#define fir first
#define sec second
#define Mp make_pair
const int MAXN = 2e5 + 5;

int a[MAXN];
ll lval[MAXN],rval[MAXN];

struct Edge
{
	int u,v;
	ll w;
};
inline bool cmp(const Edge &p,const Edge &q){ return p.w<q.w;}
vector<Edge> e;

int fa[MAXN];
inline void init(int n){ for(int i=1; i<=n; ++i) fa[i]=i;}
int find(int u){ return fa[u]==u? u: fa[u]=find(fa[u]);}
void connect(int u,int v){ fa[find(u)]=find(v);}

void gao(int l,int r)
{
	if(l==r) return;
	int mid = (l+r)>>1;
	
	ll lmn = lval[l];
	int lpos = l;
	for(int i=l; i<=mid; ++i)
		if(lmn > lval[i])
			lmn = lval[i], lpos = i;
	ll rmn = rval[r];
	int rpos = r;
	for(int i=mid+1; i<=r; ++i)
		if(rmn > rval[i])
			rmn = rval[i], rpos = i;
	
	for(int i=l; i<=mid; ++i)
		e.push_back((Edge){ i, rpos, lval[i] + rmn});
	for(int i=mid+1; i<=r; ++i)
		e.push_back((Edge){ lpos, i, lmn + rval[i]});
	
	gao(l,mid); gao(mid+1,r);
}

int main(void)
{
	int n;
	ll d;
	scanf("%d%lld",&n,&d);
	for(int i=1; i<=n; ++i) scanf("%d",&a[i]);
	
	for(int i=1; i<=n; ++i)
		lval[i] = a[i] - d*i,
		rval[i] = a[i] + d*i;
	
	gao(1,n);
	sort(e.begin(),e.end(),cmp);
	
	ll ans=0;
	init(n);
	for(int i=0; i<(int)e.size(); ++i)
	{
		int u=e[i].u, v=e[i].v;
		ll w=e[i].w;
		if(find(u) == find(v)) continue;
		ans += w;
		connect(u,v);
	}
	printf("%lld",ans);
	return 0;
}