#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int inf=1000000000;

int g[300000],q[300000],w[300000];
long long h[300000],v[300000];
int i,k,m,n,o,t,l,r,mid;
long long M;

inline bool cmp(int x,int y)
{
	return q[x]<q[y];
}

int main()
{
	scanf("%d",&t);
	for (o=1;o<=t;o++)
	{
		scanf("%d%d",&n,&m);
		for (i=1;i<=n;i++)
			scanf("%d",&g[i]),h[i]=h[i-1]+g[i];
		M=g[1];
		for (i=1;i<=n;i++)
			M=max(M,h[i]);
		for (i=1;i<=m;i++)
			scanf("%d",&q[i]),w[i]=i;
		memset(v,0,sizeof(v));
		if (h[n]>0)
			for (i=1;i<=m;i++)
				if (q[i]>M)
				{
					l=1,r=inf;
					while (l<r)
					{
						mid=(l+r)/2;
						if (q[i]-1LL*mid*h[n]<=M)
							r=mid;
						else
							l=mid+1;
					}
					q[i]=q[i]-1LL*l*h[n];
					v[i]=v[i]+1LL*l*n;
				}
		sort(w+1,w+m+1,cmp);
		for (i=1,k=1;i<=m;i++)
			if (q[w[i]]<=M)
			{
				while (h[k]<q[w[i]])
					k++;
				v[w[i]]=v[w[i]]+k-1;
			}
			else
				v[w[i]]=-1;
		for (i=1;i<=m;i++)
			printf("%lld ",v[i]);
		printf("\n");
	}
	return 0;
}