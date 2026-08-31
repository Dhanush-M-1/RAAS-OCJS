#include<cstring>
#include<cstdlib>
#include<cstdio>
#include<algorithm>

using namespace std;
typedef long long LL;

const int MX=100011;

LL x,k;int q;
LL r[MX];
struct Func{
	LL k,b,L,R;//A=min(X,max(0,kt+b+a)),in[L,R]
	Func(int _k=0,int _b=0,int _L=0,int _R=0):k(_k),b(_b),L(_L),R(_R){}
	inline LL V(LL a,LL t){return min(x,max(0LL,k*t+b+min(R,max(L,a))));}
}f[MX];

int main(){
	scanf("%lld%lld",&x,&k);
	for(int i=1;i<=k;i++)scanf("%lld",&r[i]);
	int K=-1;
	Func cur(K,0,0,x);
	f[0]=cur;
	for(int i=1;i<=k;i++){
		LL vl=f[i-1].V(f[i-1].L,r[i]),vr=f[i-1].V(f[i-1].R,r[i]);
		K=-K;
		if(vl>0&&vr<x){
			f[i]=cur=Func(K,vl-f[i-1].L-K*r[i],f[i-1].L,f[i-1].R);
		}else if(vr<x&&vr>0){
			f[i]=cur=Func(K,vr-f[i-1].R-K*r[i],f[i-1].R-vr,f[i-1].R);
		}else if(vl>0&&vl<x){
			f[i]=cur=Func(K,vl-f[i-1].L-K*r[i],f[i-1].L,f[i-1].L+x-vl);
		}else{//(vl==vr)
			f[i]=cur=Func(K,vl-K*r[i],0,0);
		}
	}
	scanf("%d",&q);
	for(int i=1;i<=q;i++){
		LL t,a;scanf("%lld%lld",&t,&a);
		printf("%lld\n",f[upper_bound(r,r+k+1,t)-r-1].V(a,t));
	}
	return 0;
}
