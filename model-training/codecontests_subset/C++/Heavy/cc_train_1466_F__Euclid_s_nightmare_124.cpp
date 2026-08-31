#include<bits/stdc++.h>
#define mod 1000000007
using namespace std;
int fa[500005];
int vis[500005];
int num[500005];
vector<int> tt;
long long ans=1;
int n,m;
int t;
struct nod{
	int tp,a,b,id;
}arr[500005];
int cmp(nod a,nod b)
{
	if (a.tp!=b.tp) return a.tp<b.tp;
	return a.id<b.id;
}
int find(int x){return x==fa[x]?x:fa[x]=find(fa[x]);}
void work()
{
	scanf("%d%d",&n,&m);
	for (int i=1;i<=m;i++) {fa[i]=i,vis[i]=0; num[i]=0;}
	for (int i=1;i<=n;i++)
	{
		scanf("%d",&arr[i].tp);
		arr[i].id=i;
		if (arr[i].tp==1)
			scanf("%d",&arr[i].a);
		else
			scanf("%d%d",&arr[i].a,&arr[i].b);
	}
//	sort(arr+1,arr+n+1,cmp);
	for (int i=1;i<=n;i++)
	{
		if (arr[i].tp==1)
		{
			if (num[find(arr[i].a)]==0)
			{
				num[find(arr[i].a)]=1;
				ans=ans+ans;
				if (ans>=mod) ans-=mod;
				tt.push_back(arr[i].id);
			}
		}
		else
		{
			if (find(arr[i].a)!=find(arr[i].b))
			{
				if (num[find(arr[i].a)]==0 || num[find(arr[i].b)]==0)
				{
					num[find(arr[i].a)]+=num[find(arr[i].b)];
					fa[find(arr[i].b)]=find(arr[i].a);
					ans=ans+ans;
					if (ans>=mod) ans-=mod;
					tt.push_back(arr[i].id);
				}
				else
				{
					num[find(arr[i].a)]+=num[find(arr[i].b)];
					fa[find(arr[i].b)]=find(arr[i].a);
				}
			}
		}
	}
	printf("%lld %d\n",ans,(int)(tt.size()));
//	sort(tt.begin(),tt.end());
	int len=tt.size();
	for (int i=0;i<len;i++)
		printf("%d ",tt[i]);
	printf("\n");
}
int main()
{
	work();
}