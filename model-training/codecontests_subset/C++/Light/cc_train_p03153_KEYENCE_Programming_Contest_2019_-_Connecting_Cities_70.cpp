#include<bits/stdc++.h>
using namespace std;
long long n,d,a[222222],ps,ans;
struct node
{
	long long mn,pos;
	pair<long long,long long> x,y;//ai+id,ai-id
	pair<long long,long long> xx,yy;
}tree[888888];
long long Min(long long a,long long b,long long c,long long d)
{
	return min(a,min(b,min(c,d)));
}
void pushup(long long node)
{
	tree[node].x=min(tree[node<<1].x,tree[(node<<1)|1].x);
	tree[node].y=min(tree[node<<1].y,tree[(node<<1)|1].y);
	tree[node].xx=min(tree[node<<1].xx,tree[(node<<1)|1].xx);
	tree[node].yy=min(tree[node<<1].yy,tree[(node<<1)|1].yy);
	tree[node].mn=Min(tree[node<<1].mn,tree[(node<<1)|1].mn,tree[node<<1].y.first+tree[(node<<1)|1].xx.first,tree[(node<<1)|1].x.first+tree[node<<1].yy.first);
	if (tree[node].mn==tree[node<<1].mn) tree[node].pos=tree[node<<1].pos;
	else if (tree[node].mn==tree[(node<<1)|1].mn) tree[node].pos=tree[(node<<1)|1].pos;
	else if (tree[node].mn==tree[node<<1].y.first+tree[(node<<1)|1].xx.first) tree[node].pos=tree[(node<<1)|1].xx.second;
	else tree[node].pos=tree[node<<1].yy.second;
}
void build(long long l,long long r,long long node)
{
	if (l==r)
	{
		tree[node].mn=1e18;
		if (l==1) 
		{
			tree[node].x=make_pair(a[l]+l*d,l);
			tree[node].y=make_pair(a[l]-l*d,l);
			tree[node].xx=make_pair(1e18,1e18);
			tree[node].yy=make_pair(1e18,1e18);
		} 
		else
		{
			tree[node].xx=make_pair(a[l]+l*d,l);
			tree[node].yy=make_pair(a[l]-l*d,l);
			tree[node].x=make_pair(1e18,1e18);
			tree[node].y=make_pair(1e18,1e18);
		}
		return;
	}
	long long mid=(l+r)>>1;
	build(l,mid,node<<1);
	build(mid+1,r,(node<<1)|1);
	pushup(node);
}
void upd(long long x,long long l,long long r,long long node) 
{
	if (l==r)
	{
		swap(tree[node].x,tree[node].xx);
		swap(tree[node].y,tree[node].yy);
		return;
	}
	long long mid=(l+r)>>1;
	if (x>mid) upd(x,mid+1,r,(node<<1)|1);
	else upd(x,l,mid,node<<1);
	pushup(node);
}
int main()
{
	scanf("%lld%lld",&n,&d);
	for (long long i=1;i<=n;i++)
	{
		scanf("%lld",&a[i]);
	}
	build(1,n,1);
	for (long long i=1;i<n;i++)
	{
		ans+=tree[1].mn;
		ps=tree[1].pos;
		upd(ps,1,n,1);
	}
	printf("%lld\n",ans);
	return 0;
} 