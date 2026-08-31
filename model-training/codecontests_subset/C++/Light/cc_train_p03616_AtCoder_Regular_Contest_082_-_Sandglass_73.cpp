#include <bits/stdc++.h>
using std::max;
using std::min;
int x,n,Q,a,t,r[100005];
int main(){
	scanf("%d",&x);
	scanf("%d",&n);
	for (int i=1;i<=n;i++) scanf("%d",&r[i]);
	int lx=0,rx=x,ly=0,ry=x;
	scanf("%d",&Q);
	scanf("%d%d",&t,&a);
	int now=-1;
	for (int i=1;i<=n;i++){
		while (t<=r[i] && Q){
			t=t-r[i-1];
			if (a<=lx) printf("%d\n",min(x,max(ly+t*now,0)));
			else if (a>=rx) printf("%d\n",min(x,max(ry+t*now,0)));
			else printf("%d\n",min(x,max(ly+(a-lx)+t*now,0)));
			Q--;
			if (Q==0) break;
			scanf("%d%d",&t,&a);
		}
		int ti=r[i]-r[i-1]; 
		if (now==-1){
			if (ly-ti<0) lx+=ti-ly;
			if (lx>x){
				lx=x,rx=0;
				ry=0;
			}
			ly=std::max(0,ly-ti);
			ry=std::max(0,ry-ti);
		}else{
			if (ry+ti>x) rx-=(ry+ti-x);
			if (rx<0){
				lx=x,rx=0;
				ly=x;
			}
			ly=std::min(x,ly+ti);
			ry=std::min(x,ry+ti);
		}
		now=now*(-1);
	}
	while (Q){
			t=t-r[n];
			if (a<=lx) printf("%d\n",min(x,max(ly+t*now,0)));
			else if (a>=rx) printf("%d\n",min(x,max(ry+t*now,0)));
			else printf("%d\n",min(x,max(ly+(a-lx)+t*now,0)));
			Q--;
			if (Q==0) break;
			scanf("%d%d",&t,&a);
		}
}