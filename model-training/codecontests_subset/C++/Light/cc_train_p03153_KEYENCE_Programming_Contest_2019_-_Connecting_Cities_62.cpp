#include<cstdio>
#include<algorithm>
using namespace std;
typedef long long ll;
struct edge
{
	ll x,y,w;
}e[400005];
struct node
{
	ll dsu,w;
}a[200005];
ll n,i,d,u,ans=0,v,cnt=0,tr[2][200005],vp[200005],fx,fy;
const ll inf=1e18;
ll lowbit(ll p){return p&-p;}
bool cmp(node a,node b){return a.w<b.w;}
bool cmp2(edge a,edge b){return a.w<b.w;}
bool cmp3(node a,node b){return a.dsu<b.dsu;}
int getf(int p){return a[p].dsu==p?p:a[p].dsu=getf(a[p].dsu);}
ll vl(ll u,ll v){return d*(v-u)+vp[u]+vp[v];}
ll pvl(ll t,ll u){return u==0?inf:(t==0?(-u*d+vp[u]):(d*u+vp[u]));}
ll ask(ll t,ll p)
{
	ll ans=0,tp,tmp=inf;
	while(p)
	{
		if((tp=pvl(t,tr[t][p]))<tmp)
		{
			ans=tr[t][p];
			tmp=tp;
		}
		p-=lowbit(p);
	}
	return ans;
}
void ins(ll t,ll p,ll v)
{
	ll tmp,tp;
	tp=pvl(t,v);
	while(p<=n)
	{
		tmp=pvl(t,tr[t][p]);
		if(tp<tmp)tr[t][p]=v;
		p+=lowbit(p);
	}
}
int main()
{
	scanf("%lld%lld",&n,&d);
	for(i=1;i<=n;i++)scanf("%lld",&a[i].w),a[i].dsu=i,vp[i]=a[i].w;
	sort(a+1,a+n+1,cmp);
	for(i=1;i<=n;i++)
	{
		u=ask(0,a[i].dsu);
		v=ask(1,n+1-a[i].dsu);
		if(u)e[++cnt]=(edge){u,a[i].dsu,vl(u,a[i].dsu)};
		if(v)e[++cnt]=(edge){a[i].dsu,v,vl(a[i].dsu,v)};
		ins(0,a[i].dsu,a[i].dsu);
		ins(1,n+1-a[i].dsu,a[i].dsu);
	}
	sort(e+1,e+cnt+1,cmp2);
	sort(a+1,a+n+1,cmp3);
	for(i=1;i<=cnt;i++)
	{
		fx=getf(e[i].x);fy=getf(e[i].y);
		if(fx!=fy)
		{
			ans+=e[i].w;
			a[fx].dsu=fy;
		}
	}
	printf("%lld\n",ans);
	return 0;
} 