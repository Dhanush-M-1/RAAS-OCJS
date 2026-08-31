#include <cstdio>
#include <algorithm>
using namespace std;
#define LL long long
#define REP(a,b,c) for(int a=b;a<=c;++a)
#define RREP(a,b,c) for(int a=b;a>=c;--a)

struct node {
	int r,op,a;
}x[300000];
int ans[300000];
int n,m,tim,q,p;
int l,r,y;
int a,b,c,d;

inline bool cmp(node a,node b) {return a.r<b.r;}

int main() {
	scanf("%d%d",&m,&n); y=0,l=0,r=m; d=-1;
	REP(i,1,n) {scanf("%d",&a); x[++p]=(node){a,0,0};}
	scanf("%d",&q); REP(i,1,q) {scanf("%d%d",&a,&b); x[++p]=(node){a,i,b};}
	sort(x+1,x+p+1,cmp);
	REP(i,1,p) {
		if(x[i].op) {
			c=d*(x[i].r-tim);
			if(x[i].a<=l) c+=y;
			else if(x[i].a>=r) c+=y+(r-l);
			else c+=y+(x[i].a-l);
			if(c<0) c=0; if(c>m) c=m; ans[x[i].op]=c;
		} else {
			y+=d*(x[i].r-tim); d=-d; tim=x[i].r;
			if(y<0) {
				if(y+(r-l)<=0) y=l=r=0;
				else {l-=y,y=0;}
			}
			if(y+(r-l)>m) {
				if(y>m) y=l=r=m;
				else r=m+l-y;
			}
		}
	} REP(i,1,q) printf("%d\n",ans[i]); return 0;
}