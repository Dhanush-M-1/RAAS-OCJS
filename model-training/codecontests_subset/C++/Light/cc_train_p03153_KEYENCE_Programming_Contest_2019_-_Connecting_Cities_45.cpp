#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <algorithm>
#define maxn 200005
#define ll long long
#define ld double
#define mod 998244353
using namespace std;
int n, d;
int a[maxn];
struct eg
{
	int u, v;
	ll c;
	bool operator < (const eg &t)const
	{
		return c < t.c;
	}
}as[maxn * 20];
int ncnt = 0;
int fa[maxn];
int gfa(int a)
{
	if(fa[a] == a) return a;
	return fa[a] = gfa(fa[a]);
}
ll b[maxn];
void work(int l, int r)
{
	if(l == r) return;
	int mid = (l + r) >> 1;	
	int lmin = l, rmin = mid + 1;
	for(int i = l; i <= mid; i++)
	{
		b[i] = a[i] - 1ll * i * d;
		if(b[i] < b[lmin]) lmin = i;
	}
	for(int i = mid + 1; i <= r; i++)
	{
		b[i] = a[i] + 1ll * i * d;
		if(b[i] < b[rmin]) rmin = i;
	}
	for(int i = l; i <= mid; i++)
		as[ncnt].u = i, as[ncnt].v = rmin, 
		as[ncnt++].c = b[rmin] + b[i];
	for(int i = mid + 1; i <= r; i++)
		as[ncnt].u = i, as[ncnt].v = lmin, 
		as[ncnt++].c = b[lmin] + b[i];
	work(l, mid), 
	work(mid + 1, r);
}
int main()
{
	scanf("%d%d", &n, &d);
	for(int i = 1; i <= n; i++)
		scanf("%d", &a[i]);
	work(1, n);
	sort(as, as + ncnt);
	for(int i = 1; i <= n; i++)
		fa[i] = i;
	ll ans = 0;
	for(int i = 0; i < ncnt; i++)
	{
		int ufa = gfa(as[i].u), vfa = gfa(as[i].v);
		if(ufa != vfa)
			ans += as[i].c, fa[ufa] = vfa;
	}
	printf("%lld\n", ans);
	return 0;
} 