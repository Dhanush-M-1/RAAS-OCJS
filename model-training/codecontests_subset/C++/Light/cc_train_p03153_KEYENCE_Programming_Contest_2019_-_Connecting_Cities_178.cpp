#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define inf 0x3f3f3f3f3f3f3f3f
const int maxn=2e5+10;
ll A[maxn];
ll D;
struct Edge
{
	int u,v;
	ll cst;
	Edge(){}
	Edge(int u,int v,ll cst):u(u),v(v),cst(cst){}
	bool operator < (const Edge &t)const
	{
		return cst<t.cst;
	}
};
vector<Edge> edge;
void solve(int l,int r)
{
	if(l==r)return;
	int mid=(l+r)>>1;
	
	int v1=0;
	ll mn=inf;
	for(int i=l;i<=mid;i++)
	{
		ll vl=A[i]-D*1ll*i;
		if(vl<mn)
		{
			mn=vl;
			v1=i;
		}
	}
	
	int v2=0;
	mn=inf;
	
	for(int i=mid+1;i<=r;i++)
	{
		ll vl=A[i]+D*1ll*i;
		if(vl<mn)
		{
			mn=vl;
			v2=i;
		}
	}
	
	for(int i=l;i<=mid;i++)
	{
	//	cout<<(A[v2]+A[i]+D*(v2-i))<<" "<<v2<<" "<<i<<endl;
		edge.push_back(Edge(v2,i,A[v2]+A[i]+D*1ll*(v2-i)));
	}
	
	for(int i=mid+1;i<=r;i++)
	{
	//	cout<<(A[v1]+A[i]+D*(i-v1))<<" "<<i<<" "<<v1<<endl;
		edge.push_back(Edge(v1,i,A[v1]+A[i]+D*1ll*(i-v1)));
	}
//	system("pause");
	
	solve(l,mid);
	solve(mid+1,r);
}
int fa[maxn];
inline int getfa(int x)
{
	return fa[x]==x?x:fa[x]=getfa(fa[x]);
}
int main()
{
	int n;
	scanf("%d%lld",&n,&D);
	for(int i=0;i<n;i++)scanf("%lld",&A[i]);
	
	solve(0,n-1);
	
	sort(edge.begin(),edge.end()); 
	
	for(int i=0;i<n;i++)fa[i]=i; 
	ll ans=0;
	for(int i=0;i<edge.size();i++)
	{
		int u=edge[i].u,v=edge[i].v;
		if(getfa(u)==getfa(v))continue;
	//	cout<<u<<" "<<v<<endl;
		fa[getfa(u)]=getfa(v);
		ans+=edge[i].cst;
	}
	printf("%lld\n",ans);
	return 0;
}