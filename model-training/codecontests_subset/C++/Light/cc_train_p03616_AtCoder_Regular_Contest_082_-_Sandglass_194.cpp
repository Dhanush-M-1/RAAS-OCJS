#include<stdio.h>
#include<algorithm>
using namespace std;
struct que{
	int t;
	int a;
	int wz;
	bool operator<(que b) const
	{
		return t<b.t;
	}
};
que q[262144];
int ans[131072];
int main()
{
	//freopen("c.in","r",stdin);
	//freopen("c.out","w",stdout);
	int x;
	scanf("%d",&x);
	int mn=0,mx=x,inc=0;
	bool isinc=false;
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		scanf("%d",&q[i].t);
		q[i].a=-1;
	}
	int m;
	scanf("%d",&m);
	for(int i=0;i<m;i++)
	{
		scanf("%d%d",&q[i+n].t,&q[i+n].a);
		q[i+n].wz=i;
	}
	sort(q,q+n+m);
	int lt=0;
	for(int i=0;i<n+m;i++)
	{
		int dt=q[i].t-lt;
		if(isinc)
		{
			mn+=dt;
			mx+=dt;
			inc+=dt;
			if(mn>x)
			{
				mn=x;
			}
			if(mx>x)
			{
				mx=x;
			}
		}
		else
		{
			mn-=dt;
			mx-=dt;
			inc-=dt;
			if(mn<0)
			{
				mn=0;
			}
			if(mx<0)
			{
				mx=0;
			}
		}
		lt+=dt;
		if(q[i].a<0)
		{
			isinc^=1;
		}
		else
		{
			int answer=q[i].a+inc;
			if(answer<mn)
			{
				answer=mn;
			}
			if(answer>mx)
			{
				answer=mx;
			}
			ans[q[i].wz]=answer;
		}
	}
	for(int i=0;i<m;i++)
	{
		printf("%d\n",ans[i]);
	}
	return 0;
}