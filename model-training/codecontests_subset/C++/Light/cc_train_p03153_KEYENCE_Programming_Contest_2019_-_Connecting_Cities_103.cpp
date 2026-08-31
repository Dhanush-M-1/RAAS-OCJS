#include<bits/stdc++.h>
using namespace std;
#define LL long long
#define pa pair<int,int>
const int Maxn=200010;
const LL inf=(1LL<<60);
int read()
{
	int x=0,f=1;char ch=getchar();
	while(ch<'0'||ch>'9'){if(ch=='-')f=-1;ch=getchar();}
	while(ch>='0'&&ch<='9')x=(x<<3)+(x<<1)+(ch^48),ch=getchar();
	return x*f;
}
int n;LL d,a[Maxn];
struct Node{LL v;int x;Node(LL _v=0,int _x=0){v=_v;x=_x;}};
bool operator<(Node a,Node b){return a.v<b.v;}
struct Seg{int l,r,lc,rc,pos;Node p[5];}tr[Maxn<<1];
int tot;
void up(int x)
{
	int lc=tr[x].lc,rc=tr[x].rc;
	for(int i=0;i<5;i++)
	if(tr[lc].p[i]<tr[rc].p[i])
	{
		tr[x].p[i]=tr[lc].p[i];
		if(i==4)tr[x].pos=tr[lc].pos;
	}
	else
	{
		tr[x].p[i]=tr[rc].p[i];
		if(i==4)tr[x].pos=tr[rc].pos;
	}
	if(tr[lc].p[2].v!=inf&&tr[rc].p[1].v!=inf)
	{
		LL t=tr[lc].p[2].v+tr[rc].p[1].v;
		if(t<tr[x].p[4].v)tr[x].p[4]=Node(t,tr[lc].p[2].x),tr[x].pos=tr[rc].p[1].x;
	}
	if(tr[lc].p[0].v!=inf&&tr[rc].p[3].v!=inf)
	{
		LL t=tr[lc].p[0].v+tr[rc].p[3].v;
		if(t<tr[x].p[4].v)tr[x].p[4]=Node(t,tr[rc].p[3].x),tr[x].pos=tr[lc].p[0].x;
	}
}
void build(int l,int r)
{
	int x=++tot;
	tr[x].l=l;tr[x].r=r;
	for(int i=0;i<5;i++)tr[x].p[i]=Node(inf,0);
	if(l==r)
	{
		if(l!=1)
		{
			tr[x].p[0]=Node(a[l]-(LL)l*d,l);
			tr[x].p[1]=Node(a[l]+(LL)l*d,l);
			tr[x].p[2]=tr[x].p[3]=tr[x].p[4]=Node(inf,0);
		}
		else
		{
			tr[x].p[0]=tr[x].p[1]=tr[x].p[4]=Node(inf,0);
			tr[x].p[2]=Node(a[l]-(LL)l*d,l);
			tr[x].p[3]=Node(a[l]+(LL)l*d,l);
		}		
		return;
	}
	int mid=l+r>>1;
	tr[x].lc=tot+1,build(l,mid);
	tr[x].rc=tot+1,build(mid+1,r);
	up(x);
}
void modify(int x,int p)
{
	for(int i=0;i<5;i++)tr[x].p[i]=Node(inf,0);
	if(tr[x].l==tr[x].r)
	{
		int l=tr[x].l;
		tr[x].p[0]=tr[x].p[1]=tr[x].p[4]=Node(inf,0);
		tr[x].p[2]=Node(a[l]-(LL)l*d,l);
		tr[x].p[3]=Node(a[l]+(LL)l*d,l);
		return;
	}
	int mid=tr[x].l+tr[x].r>>1,lc=tr[x].lc,rc=tr[x].rc;
	if(p<=mid)modify(lc,p);
	else modify(rc,p);
	up(x);
}
int main()
{
	n=read(),d=read();
	for(int i=1;i<=n;i++)a[i]=read();
	build(1,n);
	int m=n-1;LL ans=0;
	while(m--)ans+=tr[1].p[4].v,modify(1,tr[1].pos);
	printf("%lld",ans);
}
