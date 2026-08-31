#include<iostream>
#include<cstdio>
using namespace std;
const int N=1e5+10;
int sm,n,t,q,a,r[N],v[N];
int main(){
	scanf("%d%d",&sm,&n);
	for (int i=1;i<=n;++i) scanf("%d",r+i);
	for (int i=n;i;--i) v[i]=r[i]-r[i-1];
	int low=0,lh=0;
	int up=sm,uh=sm;
	int pos=0;r[n+1]=2e9;
	scanf("%d",&q);
	while (q--){
		scanf("%d%d",&t,&a);
		while (r[pos+1]<=t){
			++pos;
			if (pos&1){//ÏòÏÂv[pos] 
				if (lh<v[pos]) low+=v[pos]-lh;
				lh=max(lh-v[pos],0);
				uh=max(uh-v[pos],0);
			}else{//ÏòÉÏ 
				if (uh+v[pos]>sm) up-=uh+v[pos]-sm;
				lh=min(lh+v[pos],sm);
				uh=min(uh+v[pos],sm);
			}
			low=min(low,sm);
			up=max(up,0);
		}
		t-=r[pos];
		if (a<=low) a=lh;
		else if (a>=up) a=uh;
		else a=lh+a-low;
		if (pos&1) printf("%d\n",min(a+t,sm));else printf("%d\n",max(a-t,0));
	}
	return 0;
}