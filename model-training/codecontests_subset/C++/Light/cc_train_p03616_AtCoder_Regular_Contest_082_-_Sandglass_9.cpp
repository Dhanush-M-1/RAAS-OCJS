#include <cstdio>
int r[100005],X,K,Q,a,b,c,d;
void calc(int v){
	c+=v;
	if (a>X-c) a=b=X-c;
		else b=b>X-c?X-c:b;
	if (b<-c) a=b=-c;
		else a=a<-c?-c:a;
}
int main(){
	scanf("%d%d",&X,&K);
	for (int i=1;i<=K;i++) scanf("%d",&r[i]);
	a=0;b=X;c=d=0;
	scanf("%d",&Q);
	for (int i=1,j=1,k=-1;i<=Q;i++){
		int t,x;
		scanf("%d%d",&t,&x);
		for (;j<=K && r[j]<=t;d=r[j++],k=-k) calc(k*(r[j]-d));
		calc(k*(t-d));d=t;
		if (x<a) printf("%d\n",a+c);
			else if (x<=b) printf("%d\n",x+c);
				else printf("%d\n",b+c);
	}
}