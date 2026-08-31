#include<bits/stdc++.h>
using namespace std;

const int maxn=2e5+10;

int S,n,m,way=-1;
int La,Lp,Ra,Rp,Ans[maxn];

struct events{
	int t,a,id;
	events() {}
	events(int t,int a,int id):t(t),a(a),id(id) {}
	bool operator < (const events &e) const {return t<e.t;}
}e[maxn];

int main()
{
#ifdef h10
	freopen("F.in","r",stdin);
	freopen("F.out","w",stdout);
#endif
	int i,t,a;
	scanf("%d",&S);
	scanf("%d",&n);
	for (i=1;i<=n;i++)
	{
		scanf("%d",&t);
		e[i]=events(t,-1,0);
	}
	scanf("%d",&m);
	for (i=1;i<=m;i++)
	{
		scanf("%d%d",&t,&a);
		e[n+i]=events(t,a,i);
	}
	sort(e+1,e+n+m+1);

	La=0; Lp=0; Ra=S; Rp=S;
	for (i=1;i<=n+m;i++)
	{
		Lp+=way*(e[i].t-e[i-1].t);
		Rp+=way*(e[i].t-e[i-1].t);
		if (Lp<0)
		{
			if (Rp<0) La=Ra=S,Lp=Rp=0;
			else La-=Lp,Lp=0;
		}
		if (Rp>S)
		{
			if (Lp>S) La=Ra=0,Lp=Rp=S;
			else Ra-=Rp-S,Rp=S;
		}
		if (e[i].a==-1) way=-way;
		else
		{
			int tmp=Lp+e[i].a-La;
			tmp=min(tmp,Rp);
			tmp=max(tmp,Lp);
			Ans[e[i].id]=tmp;
		}
	}
	for (i=1;i<=m;i++)
		printf("%d\n",Ans[i]);
}
