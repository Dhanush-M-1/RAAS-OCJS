#include <bits/stdc++.h>
using namespace std;
long long n,m,i,j,l[200005],r[200005],mil[200005][19],mir[200005][19],x,y,aa[200005],d,lg[200005],ans;
long long fndl(long long x){if (l[x]==x) return x;return l[x]=fndl(l[x]);}
long long fndr(long long x){if (r[x]==x) return x;return r[x]=fndr(r[x]);}
struct f
{
	long long x,id;
}a[200005];
bool cmp(f x,f y){return x.x<y.x;}
void merge(long long x,long long y)
{
	if (x>y) swap(x,y);
	l[fndl(y)]=fndl(x);
	r[fndr(x)]=fndr(y);
}
long long ql(long long x,long long y)
{
	if (x>y) return 1ll<<60;
	long long k=lg[y-x+1];
	return min(mil[x][k],mil[y-(1<<k)+1][k]);
}
long long qr(long long x,long long y)
{
	if (x>y) return 1ll<<60;
	long long k=lg[y-x+1];
	return min(mir[x][k],mir[y-(1<<k)+1][k]);
}
bool isb(long long x,long long y)
{
	long long f=min(ql(1,fndl(x)-1)+qr(fndl(x),fndr(x)),qr(fndr(x)+1,n)+ql(fndl(x),fndr(x)));
	if (f<y) return 0;
	if (f==y) return 1;
	if (f>y) exit(-1);
}
void solve(long long x)
{
	long long i,j;
	for (i=fndl(x)-1;i>=1;i=fndl(i)-1)
	{
		long long d=ql(fndl(i),fndr(i))+qr(fndl(x),fndr(x));
		if (isb(i,d))
		{
			merge(i,x);
			ans+=d;
		}
		else break;
	}
	for (i=fndr(x)+1;i<=n;i=fndr(i)+1)
	{
		long long d=qr(fndl(i),fndr(i))+ql(fndl(x),fndr(x));
		if (isb(i,d))
		{
			merge(i,x);
			ans+=d;
		}
		else break;
	}
}
int main()
{
	scanf("%lld%lld",&n,&m);
	lg[1]=0;
	for (i=2;i<=n;i++) lg[i]=lg[i/2]+1; 
	for (i=1;i<=n;i++) 
	{
		scanf("%lld",&aa[i]);
		a[i].x=aa[i];
		a[i].id=i;
		mil[i][0]=aa[i]-i*m;
		mir[i][0]=aa[i]+i*m;
	}
	for (j=1;(1<<j)<=n;j++)
	{
		for (i=1;i+(1<<j)-1<=n;i++)
		{
			mil[i][j]=min(mil[i][j-1],mil[i+(1<<(j-1))][j-1]);
			mir[i][j]=min(mir[i][j-1],mir[i+(1<<(j-1))][j-1]);
		}
	}
	sort(a+1,a+n+1,cmp);
	for (i=1;i<=n;i++) l[i]=r[i]=i;
	for (i=1;i<=n;i++) solve(i);
	cout<<ans<<endl;
	return 0;
}
