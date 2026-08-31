#include<bits/stdc++.h>
#define ll long long
#define N 100009
using namespace std;

int n,a[N],b[N]; ll m;
int main(){
	scanf("%lld%d",&m,&n);
	int i;
	for (i=1; i<=n; i++){
		scanf("%d",&a[i]); b[i]=a[i]-a[i-1];
		if (i&1) b[i]=-b[i];
	}
	int cas; scanf("%d",&cas);
	ll l=0,r=m,x=0,y=m,tg=0,u,v; i=1;
	while (cas--){
		scanf("%lld%lld",&u,&v);
		for (; i<=n && u>=a[i]; i++){
			tg+=b[i]; x+=b[i]; y+=b[i];
			x=min(m,max(0ll,x));
			y=min(m,max(0ll,y));
			r=min(r,m-tg); l=max(l,-tg);
		}
		if (l<=v && v<=r) v+=tg;
		else v=v<l?x:y;
		if (i&1) v-=u-a[i-1]; else v+=u-a[i-1];
		printf("%lld\n",min(m,max(0ll,v)));
	}
	return 0;
}
