#include<bits/stdc++.h>
using namespace std;
const int N=200005;
struct UnionFind
{
	int parent[N],rnk[N];
	UnionFind(int n)
	{
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;
			rnk[i]=1;
		}
	}
	int root(int x)
	{
		if(parent[x]!=x)
			parent[x]=root(parent[x]);
		return parent[x];
	}
	void connect(int x,int y)
	{
		int rx=root(x),ry=root(y);
		if(rx==ry)
			return;
		if(rx>ry)
		{
			parent[ry]=rx;
			rnk[rx]+=rnk[ry];	
		} 
		if(rx<=ry)
		{
			parent[rx]=ry;
			rnk[ry]+=rnk[rx];
		}
	}
};
long long a[N],d;
vector<pair<long long,pair<int,int>>>edge;
void solve(int l,int r)
{
	if(l==r)
		return;
	int m=(l+r)/2;
	long long mn=LLONG_MAX;
	int pl=-1;
	for(int i=l;i<=m;i++)
	{
		long long vl=a[i]-d*i;
		if(mn>vl)
		{
			mn=vl;
			pl=i;
		}
	}
	mn=LLONG_MAX;
	int pr=-1;
	for(int i=m+1;i<=r;i++)
	{
		long long vl=a[i]+d*i;
		if(mn>vl)
		{
			mn=vl;
			pr=i;
		}
	}
	for(int i=l;i<=m;i++)
	{
		long long vl=a[i]-d*i;
		long long vr=a[pr]+d*pr;
		edge.push_back(make_pair(vl+vr,make_pair(i,pr)));
	}
	for(int i=m+1;i<=r;i++)
	{
		long long vl=a[pl]-d*pl;
		long long vr=a[i]+d*i;
		edge.push_back(make_pair(vl+vr,make_pair(pl,i)));
	}
	solve(l,m);
	solve(m+1,r);
}
int main()
{
	int n;
	scanf("%d%lld",&n,&d);
	for(int i=1;i<=n;i++)
		scanf("%lld",&a[i]);
	solve(1,n);
	sort(edge.begin(),edge.end());
	UnionFind uf(n);
	long long ret=0;
	for(int i=0;i<edge.size();i++)
	{
		pair<int,int> p=edge[i].second;
		if(uf.root(p.first)!=uf.root(p.second))
		{
			uf.connect(p.first,p.second);
			ret+=edge[i].first;
		}
	}
	printf("%lld\n",ret);
	return 0;
}
