#include<bits/stdc++.h>
using namespace std;
const int N=2e5+10;
struct opt{int t,id;}Q[N];
bool cmp(opt a,opt b){return a.t<b.t;}
int X,n,q,a[N],ans[N],pre,suf,pre_V,suf_V;
int last,sig;
int main()
{
	scanf("%d%d",&X,&n);
	for (int i=1;i<=n;i++) scanf("%d",&Q[i].t);
	scanf("%d",&q);
	for (int i=1;i<=q;i++) scanf("%d%d",&Q[n+i].t,&a[i]),Q[n+i].id=i;
	sort(Q+1,Q+n+q+1,cmp);
	pre=pre_V=0;suf=suf_V=X;sig=-1;
	for (int i=1;i<=n+q;i++){
		int d=sig*(Q[i].t-last);last=Q[i].t;
		pre_V+=d;suf_V+=d;
		if (pre_V<0) pre=min(pre-pre_V,X),pre_V=0;
		pre_V=min(pre_V,X);
		if (suf_V>X) suf=max(suf+X-suf_V,0),suf_V=X;
		suf_V=max(suf_V,0);
		if (pre>=suf) pre=X,suf=0;
		if (Q[i].id){
			int id=Q[i].id;
			if (a[id]<=pre) ans[id]=pre_V;else
			if (a[id]>=suf) ans[id]=suf_V;else
			ans[id]=pre_V+a[id]-pre;
		}
		else sig=-sig;
	}
	for (int i=1;i<=q;i++) printf("%d\n",ans[i]);
	return 0;
}