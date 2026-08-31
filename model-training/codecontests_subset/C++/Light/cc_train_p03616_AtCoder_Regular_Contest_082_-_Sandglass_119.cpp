#include <bits/stdc++.h>
using namespace std;

int x,k,q,r[100010],t[100010],a[100010];

void work()
{
	scanf("%d %d",&x,&k);
	for (int i=1; i<=k; i++)  scanf("%d",&r[i]);
	scanf("%d",&q);
	for (int i=1; i<=q; i++)  scanf("%d %d",&t[i],&a[i]);
	if (t[q]>=r[k])  r[++k]=t[q]+1;
	for (int i=1,j=1,L=0,R=x,s=0,ty=-1; i<=k; i++,ty*=-1)
		{
			for (; (j<=q)&&(t[j]<r[i]); j++)
				printf("%d\n",min(max(min(max(a[j]+s,L),R)+ty*(t[j]-r[i-1]),0),x));
			L=min(max(L+ty*(r[i]-r[i-1]),0),x);
			R=min(max(R+ty*(r[i]-r[i-1]),0),x);
			s+=ty*(r[i]-r[i-1]);
		}
}

int main()
{
	work();
	return 0;
}
