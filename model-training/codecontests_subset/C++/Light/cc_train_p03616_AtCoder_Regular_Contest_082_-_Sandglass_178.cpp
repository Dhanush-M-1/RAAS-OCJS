#include<bits/stdc++.h>
#define N 300005
using namespace std;
int X,n,m,q,op,ans[N];
struct node{
	int t,a,num;
	node(int _t=0,int _a=0,int _num=0){ t=_t,a=_a,num=_num;}
}a[N];
bool cmp(const node &p,const node &q){ return p.t<q.t||(p.t==q.t&&p.num<q.num);}
int main()
{
	int i,x,y,p,l,r,v;
	scanf("%d",&X);
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		scanf("%d",&x),a[++m]=node(x,0,0);
	scanf("%d",&q);
	for(i=1;i<=q;i++)
		scanf("%d %d",&x,&y),a[++m]=node(x,y,i);
	sort(a+1,a+m+1,cmp);
	op=-1,p=l=v=0,r=X;
	for(i=1;i<=m;i++){
		y=(a[i].t-p)*op;
		if(a[i].num!=0){
			x=a[i].a+v;
			x=min(x,r);
			x=max(x,l);
			x+=y;
			x=min(x,X);
			x=max(x,0);
			ans[a[i].num]=x;
		  }
		else{
			r+=y,l+=y,v+=y;
			r=min(r,X),r=max(r,0);
			l=min(l,X),l=max(l,0);
			p=a[i].t,op=-op;
		  }
	  }
	for(i=1;i<=q;i++)
		printf("%d\n",ans[i]);
	return 0;
}
