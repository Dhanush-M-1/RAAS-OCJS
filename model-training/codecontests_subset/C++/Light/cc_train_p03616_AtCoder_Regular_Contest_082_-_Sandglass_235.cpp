#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <memory.h>
#include <math.h>

using namespace std;
typedef long long LL;
const int maxn = 100005;
int o[maxn],X,n,Q,t[maxn],a[maxn];
int l[maxn],fl[maxn],r[maxn];
int main()
{
	#ifdef Amberframe
		freopen("arc082f.in","r",stdin);
		freopen("arc082f.out","w",stdout);
	#endif
	scanf("%d %d",&X,&n);r[0]=X;
	for (int i=1;i<=n;i++) scanf("%d",&o[i]);
	for (int i=1;i<=n;i++)
	if (i&1) {
		int d=o[i]-o[i-1];
		if (l[i-1]==r[i-1])
			l[i]=r[i]=l[i-1],fl[i]=max(0,fl[i-1]-d);
		else if (fl[i-1]>=d)
			l[i]=l[i-1],r[i]=r[i-1],fl[i]=fl[i-1]-d;
		else if (l[i-1]+d-fl[i-1]>=r[i-1])
			l[i]=r[i]=0,fl[i]=0;
		else
			l[i]=l[i-1]+d-fl[i-1],r[i]=r[i-1],fl[i]=0;
	}
	else {
		int d=o[i]-o[i-1];
		if (l[i-1]==r[i-1])
			l[i]=r[i]=l[i-1],fl[i]=min(X,fl[i-1]+d);
		else if (fl[i-1]+r[i-1]-l[i-1]+d<=X)
			l[i]=l[i-1],r[i]=r[i-1],fl[i]=fl[i-1]+d;
		else if (fl[i-1]+d>=X)
			l[i]=r[i]=0,fl[i]=X;
		else
			l[i]=l[i-1],r[i]=r[i-1]-(fl[i-1]+r[i-1]-l[i-1]+d-X),fl[i]=fl[i-1]+d;
	}
	scanf("%d",&Q);
	for (int i=1;i<=Q;i++)
		scanf("%d %d",&t[i],&a[i]);
	for (int pos=0,i=1;i<=Q;i++)
	{
		while (pos<n&&o[pos+1]<=t[i]) ++pos;
		int cur=(a[i]<=l[pos]?fl[pos]:fl[pos]+min(r[pos],a[i])-l[pos]);
		int d=t[i]-o[pos];pos&1?cur=min(cur+d,X):cur=max(cur-d,0);
		printf("%d\n",cur);
	}
	return 0;
}