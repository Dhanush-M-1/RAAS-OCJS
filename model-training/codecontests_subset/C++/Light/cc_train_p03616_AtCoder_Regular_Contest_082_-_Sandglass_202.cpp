#include<bits/stdc++.h>
#define N 100005
using namespace std;
int q,x,k;
int r[N];
struct node
{
	int a,t,op,y;
	friend bool operator < (const node &aa,const node &bb)
	{
		return aa.t<bb.t;
	}
}p[N*2];
int ans[N];
int main()
{
	scanf("%d%d",&x,&k);
	for(int i=1;i<=k;i++)scanf("%d",&r[i]),p[i].t=r[i],p[i].op=1;
	scanf("%d",&q);
	for(int i=1;i<=q;i++)
	{
		p[i+k].op=2;p[i+k].y=i;
		scanf("%d%d",&p[i+k].t,&p[i+k].a);
	}
	sort(p+1,p+q+k+1);
	int t1=x,t2=0,ts=0;
	int now=1;
	for(int i=1;i<=k+q;i++)
	{
		if(now==1)
		{
			t1-=p[i].t-p[i-1].t;
			t2-=p[i].t-p[i-1].t;
			if(t1<0)t1=0;
			if(t2<0)t2=0;
		}
		else 
		{
			t1+=p[i].t-p[i-1].t;
			t2+=p[i].t-p[i-1].t;
			if(t1>x)ts+=t1-x,t1=x;
			if(t2>x)t2=x;
			if(ts>x)ts=x;
		}
		if(p[i].op==1)now^=1;
		else 
		{
			int tmp=x-p[i].a;
			int tt=max(0,min(t1,t1-tmp+ts));
			if(tt<t2)tt=t2;
			ans[p[i].y]=tt;
		}
	}
	for(int i=1;i<=q;i++)
	{
		printf("%d\n",ans[i]);
	}
	return 0;
}
