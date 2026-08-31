#include<iostream> 
#include<cstdio>
#include<cmath>
#include<cstdlib>
#include<cstring>
#include<algorithm>
using namespace std;
#define ll long long
#define N 200010
char getc(){char c=getchar();while ((c<'A'||c>'Z')&&(c<'a'||c>'z')&&(c<'0'||c>'9')) c=getchar();return c;}
int gcd(int n,int m){return m==0?n:gcd(m,n%m);}
int read()
{
	int x=0,f=1;char c=getchar();
	while (c<'0'||c>'9') {if (c=='-') f=-1;c=getchar();}
	while (c>='0'&&c<='9') x=(x<<1)+(x<<3)+(c^48),c=getchar();
	return x*f;
}
int n,d,a[N],fa[N],t;
ll ans;
struct data
{
	int x,y;ll z;
	bool operator <(const data&a) const
	{
		return z<a.z;
	}
}e[N<<5];
int find(int x){return fa[x]==x?x:fa[x]=find(fa[x]);}
ll calcl(int i)
{
	return a[i]-1ll*i*d;
}
ll calcr(int i)
{
	return a[i]+1ll*i*d;
}
void solve(int l,int r)
{
	if (l==r) return;
	int mid=l+r>>1;
	solve(l,mid);
	solve(mid+1,r);
	int L=l;
	for (int i=l;i<=mid;i++) if (calcl(i)<calcl(L)) L=i;
	int R=r;
	for (int i=mid+1;i<=r;i++) if (calcr(i)<calcr(R)) R=i;
	for (int i=l;i<=mid;i++) e[++t]=(data){i,R,calcl(i)+calcr(R)};
	for (int i=mid+1;i<=r;i++) e[++t]=(data){L,i,calcl(L)+calcr(i)};
}
signed main()
{
	n=read(),d=read();
	for (int i=1;i<=n;i++) a[i]=read();
	solve(1,n);
	for (int i=1;i<=n;i++) fa[i]=i;
	sort(e+1,e+t+1);
	for (int i=1;i<=t;i++)
	if (find(e[i].x)!=find(e[i].y))
	{
		fa[find(e[i].x)]=find(e[i].y);
		ans+=e[i].z;
	}
	cout<<ans;
	return 0;
	//NOTICE LONG LONG!!!!!
}