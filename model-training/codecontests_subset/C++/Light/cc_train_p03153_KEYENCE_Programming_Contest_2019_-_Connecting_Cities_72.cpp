#include <bits/stdc++.h>
#define int LL
using namespace std;
typedef long long LL;
const int MAX_N=200005;
struct edge
{
	int u,v,cost;
	edge(){}
	edge(int _u,int _v,int _cost)
	{
		u=_u;
		v=_v;
		cost=_cost;
	}
	bool operator < (const edge &A) const 
	{
		return cost<A.cost;
	} 
};
const LL INF=0x3f3f3f3f3f3f3f3f;
LL A[MAX_N];
LL ans,n,D;
int fa[MAX_N];
LL Ai_Di[MAX_N],Aj_Dj[MAX_N];
vector <edge> g;
void init()
{
	for(int i=0;i<n;i++)fa[i]=i;
}
int find(int x)
{
	return x==fa[x]?x:fa[x]=find(fa[x]);
}
void unite(int u,int v)
{
	fa[find(u)]=find(v);
}
bool same(int u,int v)
{
	return find(u)==find(v);
}
void solve(int l,int r)
{
	if(l==r)return;
	int mid=(l+r)/2;
	int pl=-1;
	LL vl=INF;
	for(int i=l;i<=mid;i++)
	{
		if(Ai_Di[i]<vl)
		{
			vl=Ai_Di[i];
			pl=i;
		}
	}
	int pr=-1;
	LL vr=INF;
	for(int i=mid+1;i<=r;i++)
	{
		if(Aj_Dj[i]<vr)
		{
			vr=Aj_Dj[i];
			pr=i;
		}
	}
	for(int i=l;i<=mid;i++)
	{
		g.push_back(edge(i,pr,vr+Ai_Di[i]));
	}
	for(int i=mid+1;i<=r;i++)
	{
		g.push_back(edge(i,pl,vl+Aj_Dj[i]));
	}
	solve(l,mid);
	solve(mid+1,r);
}
signed main()
{
	cin>>n>>D;
	init();
	for(int i=0;i<n;i++)cin>>A[i];
	for(int i=0;i<n;i++)Ai_Di[i]=A[i]-D*i;
	for(int i=0;i<n;i++)Aj_Dj[i]=A[i]+D*i;
	solve(0,n-1);
	sort(g.begin(),g.end());
	for(int i=0;i<g.size();i++)
	{
		int u=g[i].u;
		int v=g[i].v;
		int cost=g[i].cost;
		if(!same(u,v))
		{
			unite(u,v);
			ans+=cost;
		}
	}
	cout<<ans<<endl;
	return 0;
}
