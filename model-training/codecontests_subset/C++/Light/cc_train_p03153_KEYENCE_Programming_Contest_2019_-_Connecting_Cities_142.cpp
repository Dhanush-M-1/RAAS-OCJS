#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
#include <set>
#include <map>
#include <functional>
#include <cmath>
#include <cassert>
#include <string>
#define SIZE 200005
#define INF 10000000000000000LL

using namespace std;
typedef long long int ll;
typedef pair <int,int> P;
typedef pair <ll,P> PP;

struct UF
{
	int par[SIZE],rank[SIZE];
	
	void init(int n)
	{
		for(int i=0;i<n;i++)
		{
			par[i]=i;
			rank[i]=0;
		}
	}
	int find(int x)
	{
		if(par[x]==x) return x;
		return par[x]=find(par[x]);
	}
	void unite(int x,int y)
	{
		x=find(x);
		y=find(y);
		if(x==y) return;
		if(rank[x]<rank[y]) par[x]=y;
		else
		{
			par[y]=x;
			if(rank[x]==rank[y]) rank[x]++;
		}
	}
	bool same(int x,int y)
	{
		return find(x)==find(y);
	}
}uf;
ll A[SIZE];
ll D;
vector <PP> edge;

void solve(int l,int r)
{
	if(l==r) return;
	int m=(l+r)/2;
	ll mn=INF;
	int pl=-1;
	for(int i=l;i<=m;i++)
	{
		ll vl=A[i]-D*(ll) i;
		if(mn>vl)
		{
			mn=vl;
			pl=i;
		}
	}
	mn=INF;
	int pr=-1;
	for(int i=m+1;i<=r;i++)
	{
		ll vl=A[i]+D*(ll) i;
		if(mn>vl)
		{
			mn=vl;
			pr=i;
		}
	}
	for(int i=l;i<=m;i++)
	{
		ll vl=A[i]-D*(ll) i;
		ll vr=A[pr]+D*(ll) pr;
		edge.push_back(PP(vl+vr,P(i,pr)));
	}
	for(int i=m+1;i<=r;i++)
	{
		ll vl=A[pl]-D*(ll) pl;
		ll vr=A[i]+D*(ll) i;
		edge.push_back(PP(vl+vr,P(pl,i)));
	}
	solve(l,m);
	solve(m+1,r);
}
int main()
{
	int n;
	scanf("%d %lld",&n,&D);
	for(int i=0;i<n;i++) scanf("%lld",&A[i]);
	solve(0,n-1);
	sort(edge.begin(),edge.end());
	uf.init(n+2);
	ll ret=0;
	for(int i=0;i<edge.size();i++)
	{
		P p=edge[i].second;
		if(!uf.same(p.first,p.second))
		{
			uf.unite(p.first,p.second);
			ret+=edge[i].first;
		}
	}
	printf("%lld\n",ret);
	return 0;
}
