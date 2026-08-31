#include<stdio.h>
#include<string.h>
#include<math.h>
#include<algorithm>
//#include<iostream>
using namespace std;

#define LL long long
int n,m;
#define maxn 200011
struct event
{
	int t,a,id;
	bool operator < (const event &b) const {return t<b.t;}
}e[maxn];int le=0;
LL X,ans[maxn];
int main()
{
	scanf("%lld%d",&X,&n);
	for (int i=1;i<=n;i++) le++,scanf("%d",&e[le].t),e[le].id=e[le].a=0;
	scanf("%d",&m);
	for (int i=1;i<=m;i++) le++,scanf("%d%d",&e[le].t,&e[le].a),e[le].id=i;
	sort(e+1,e+1+le);
//	for (int i=1;i<=le;i++) cout<<e[i].t<<' '<<e[i].a<<' '<<e[i].id<<endl;
	LL Min=0,Max=X,pre=0;
	for (int i=1,sig=-1,last=0;i<=le;i++)
	{
		LL now=(e[i].t-last)*sig;
		if (e[i].id)
		{
			LL v=e[i].a+pre;
			if (v<Min) v=Min;
			if (v>Max) v=Max;
			v+=now;
			if (v<0) v=0;
			if (v>X) v=X;
			ans[e[i].id]=v;
		}
		else
		{
			Min+=now;Max+=now;
			if (Min<0) Min=0;if (Max<0) Max=0;
			if (Min>X) Min=X;if (Max>X) Max=X;
			pre+=now;sig*=-1;last=e[i].t;
		}
	}
	for (int i=1;i<=m;i++) printf("%lld\n",ans[i]);
	return 0;
}