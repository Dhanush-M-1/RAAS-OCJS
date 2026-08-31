//accept
#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
#define mp make_pair
typedef long long ll;
using namespace std;
const int inf=1025352128;
int n,d;
int a[200005];
int f[200005];
int rk[200005];
vector <pair<ll,pair<int,int> > >vec;

int find(int x)
{
	if(f[x]==x)
	{
		return x;
	}
	else
	{
		rk[x]=1;
		return f[x]=find(f[x]);
	}
}

void merge(int x,int y)
{
	x=find(x);
	y=find(y);
	if(rk[x]==rk[y])
	{
		if(rand()&1)
		{
			rk[x]++;
			f[y]=x;
		}
		else
		{
			rk[y]++;
			f[x]=y;
		}
		return;
	}
	if(rk[x]>rk[y])
	{
		f[y]=x;
		return;
	}
	if(rk[y]>rk[x])
	{
		f[x]=y;
		return;
	}
}

void init()
{
	for(int i=0;i<n;i++)
	{
		f[i]=i;
		rk[i]=1;
	}
}

inline ll cost(int i,int j)
{
	return 1LL*a[i]+1LL*a[j]+1LL*(j-i)*d;
}

void add(int l,int r)
{
	if(r-l<=1) return;
	int m=l+r>>1;
	ll minx=inf,tl,tr;
	for(int i=l;i<m;i++)
	{
		if(1LL*a[i]-1LL*i*d<minx)
		{
			minx=1LL*a[i]-1LL*i*d;
			tl=i;
		}
	}
	minx=1LL*inf*inf;
	for(int i=m;i<r;i++)
	{
		if(1LL*a[i]+1LL*i*d<minx)
		{
			minx=1LL*a[i]+1LL*i*d;
			tr=i;
		}
	}
	for(int i=l;i<m;i++)
	{
		vec.push_back(mp(cost(i,tr),mp(i,tr)));
	}
	for(int i=m;i<r;i++)
	{
		vec.push_back(mp(cost(tl,i),mp(tl,i)));
	}
	add(l,m);
	add(m,r);
}

int main()
{
	scanf("%d%d",&n,&d);
	init();
	for(int i=0;i<n;i++)
	{
		scanf("%d",a+i);
	}
	add(0,n);
	sort(vec.begin(),vec.end());
	vec.erase(unique(vec.begin(),vec.end()),vec.end());
	ll res=0;
	int s=1;
	for(int i=0;i<vec.size();i++)
	{
		pair<ll,pair<int,int> > x=vec[i];
		if(find(x.second.first)==find(x.second.second)) continue;
		merge(x.second.first,x.second.second);
		s++;
		res+=x.first;
		if(s==n) break;
	}
	cout<<res<<endl;
	return 0;
}