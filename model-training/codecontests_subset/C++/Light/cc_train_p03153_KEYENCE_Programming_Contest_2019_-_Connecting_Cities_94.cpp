#include<algorithm>
#include<iostream>
#include<cstring>
#include<string>
#include<vector>
#include<cstdio>
#include<cmath>
#include<map>
#include<set>
using namespace std;
long long n,d,a[200005];
typedef pair <int,int> P;
typedef pair <long long,P> PP; 
struct UF
{
	int par[200005],rank[200005];
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
		if(par[x]==x)
		    return x;
		return par[x]=find(par[x]);
	}	
	void unite(int x,int y)
	{
		x=find(x);
		y=find(y);
		if(x==y)
			return;
		if(rank[x]<rank[y])
			par[x]=y;
		else
		{
			par[y]=x;
			if(rank[x]==rank[y])
				rank[x]++;
		}
	}
	bool same(int x,int y)
	{
		return find(x)==find(y);
	}	
}uf;
vector <PP> edge;
void solve(int l,int r)
{
	if(l==r)
	    return;
	//cout<<l<<' '<<r<<endl;
	int m=(l+r)/2;
	long long mn=2e18;
    int pl=-1;
    for(int i=l;i<=m;i++)
    {
    	long long vl=a[i]-d*(long long)i;
    	if(mn>vl)
    	{
    		mn=vl;
    		pl=i;
		}
	}
	mn=2e18;
	int pr=-1;
	for(int i=m+1;i<=r;i++)
	{
		long long vl=a[i]+d*(long long)i;
		if(mn>vl)
		{
			mn=vl;
			pr=i;
		}
	}
	for(int i=l;i<=m;i++)
	{
		long long vl=a[i]-d*(long long)i;
		long long vr=a[pr]+d*(long long)pr;
		edge.push_back(PP(vl+vr,P(i,pr)));
	}
	for(int i=m+1;i<=r;i++)
	{
		long long vl=a[pl]-d*(long long)pl;
		long long vr=a[i]+d*(long long)i;
		edge.push_back(PP(vl+vr,P(pl,i)));
	}
	solve(l,m);
	solve(m+1,r);
}
int main()
{
	scanf("%lld%lld",&n,&d);
	for(int i=0;i<n;i++)
	    scanf("%lld",&a[i]);
	solve(0,n-1);
	sort(edge.begin(),edge.end());
	uf.init(n+2);
	long long ret=0;
	for(int i=0;i<edge.size();i++)
	{
		P p=edge[i].second;
		//cout<<p.first<<' '<<p.second<<endl;
		if(!uf.same(p.first,p.second))
		{
			//cout<<p.first<<' '<<p.second<<endl;
			uf.unite(p.first,p.second);
			ret+=edge[i].first;
		}
	}
	cout<<ret;
	return 0;
}