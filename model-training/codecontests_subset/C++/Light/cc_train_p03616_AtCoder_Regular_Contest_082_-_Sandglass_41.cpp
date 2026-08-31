#include <bits/stdc++.h>
using namespace std;
#define N 101000
#define ll long long

struct query {
	int t,s;
}e[N];
int n,m,sgn=-1,k=1;
int T[N];
ll mx,mn,h,X;

void cal(ll &k) {
	if (k>X) k=X;
	if (k<0) k=0;
}

int main()
{
	scanf("%lld%d",&X,&n);
	for (int i=1;i<=n;i++) scanf("%d",&T[i]);
	scanf("%d",&m);
	for (int i=1;i<=m;i++) scanf("%d%d",&e[i].t,&e[i].s);
	
	mn=0; mx=X;
	for (int i=1;i<=m;i++)
	{
		while (k<=n && T[k]<=e[i].t)
		{
			ll v=(T[k]-T[k-1])*sgn;
			mx+=v; mn+=v; h+=v;
			cal(mx); cal(mn);
			sgn*=-1; k++;
		}
		ll now=e[i].s+h,nowh=(e[i].t-T[k-1])*sgn;
		if (now>mx) now=mx;
		if (now<mn) now=mn;
		now+=nowh;
		cal(now);
		printf("%lld\n",now);
	}
	return 0;
}