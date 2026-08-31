#include <cstdio>
#include <algorithm>
using namespace std;
const int maxn=1e5+10;

int x,k,a,b,c,r[maxn];
int q,t[maxn],g[maxn];

int main()
{
	scanf("%d%d",&x,&k);
	for(int i=1;i<=k;i++) scanf("%d",&r[i]);
	r[0]=0;r[k+1]=1e9+10;
	scanf("%d",&q);
	for(int i=1;i<=q;i++) scanf("%d%d",&t[i],&g[i]);
	int pos=1;
	
	a=0;b=x;c=0;
	for(int i=0;i<=k;i++)
	{
		while(pos<=q && t[pos]<=r[i+1])
		{
			g[pos]=max(g[pos],a);
			g[pos]=min(g[pos],b);
			g[pos]+=c;
			if (i%2) g[pos]+=t[pos]-r[i];
			else g[pos]-=t[pos]-r[i];
			g[pos]=max(g[pos],0);
			g[pos]=min(g[pos],x);
			
			printf("%d\n",g[pos]);
			pos++;
		}
		
		int tmp=r[i+1]-r[i];
		if (i%2)
		{
			c+=tmp;
			if (b+c>x)
			{
				if (a+c<=x) b=x-c;
				else
				{
					a=0;b=0;
					c=x;
				}
			}
		}
		else
		{
			c-=tmp;
			if (a+c<0) 
			{
				if (b+c>=0) a=-c;
				else 
				{
					a=0;b=0;
					c=0;
				}	 
			}
		}
	}
	
	return 0;
}