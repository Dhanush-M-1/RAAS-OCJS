#include<bits/stdc++.h>
#define N 200005
#define ll long long
#define pb push_back
using namespace std; 
int fa[N],n;
ll ans,a[N],m;
struct node
{
	int L,R;
	ll val;
	node(ll x,int y,int z){val=x,L=y,R=z;}
	bool operator < (const node &x) const
	{
		return val<x.val;
	}
};
int search(int x)
{
	if(fa[x]==-1)return x;
	return fa[x]=search(fa[x]);
}
vector<node> v;
void solve(int l,int r)
{
	if(l==r)return;
	int mid=l+r>>1,min_l,min_r;
	ll mn=-1;
	for(int i=l;i<=mid;i++)
	{
		ll value=a[i]-m*(ll)i;
		if(mn==-1||mn>value)
		min_l=i,mn=value;
	}
	mn=-1;
	for(int i=mid+1;i<=r;i++)
	{
		ll value=a[i]+m*(ll)i;
		if(mn==-1||mn>value)
		min_r=i,mn=value;
		ll tmp=a[i]+a[min_l]+m*(ll)(i-min_l);
		v.pb(node(tmp,min_l,i));
	}
	for(int i=l;i<=mid;i++)
	{
		ll tmp=a[i]+a[min_r]+m*(ll)(min_r-i);
		v.pb(node(tmp,i,min_r));
	}
	solve(l,mid);
	solve(mid+1,r);
}
int main()
{
    memset(fa,-1,sizeof(fa));
	scanf("%d%lld",&n,&m);
	for(int i=1;i<=n;i++)
	scanf("%lld",a+i);
	solve(1,n);
	sort(v.begin(),v.end());
    n--;
	for(int i=0;;i++)
	{
		int x=search(v[i].L),y=search(v[i].R);
		if(x==y)continue;
		ans+=v[i].val;n--;
		if(!n)
		{
		printf("%lld\n",ans);
	    return 0;
		}
		fa[x]=y;
	}
}