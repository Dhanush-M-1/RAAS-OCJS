#include<stdio.h>
#include<algorithm>
using namespace std;
long long dist[40];
int main(){
	long long a,b,c,d,e,f;
	scanf("%lld%lld%lld%lld%lld%lld",&a,&b,&c,&d,&e,&f);
	if(c==1&&d==1){
		long long v=b%(e+f);
		long long g=b/(e+f);
		long long ret=v+max(0LL,g-a)*(e+f);
		g++;
		v=e+f-v;
		ret=min(ret,v+max(0LL,g-a)*(e+f));
		printf("%lld\n",ret);
		
		return 0;
	}
	int sz=0;
	for(int i=0;i<a;i++){
		long long L=e;
		long long R=f;
		long long Q=b;
		for(int j=0;j<i;j++)Q/=max(c,d);
		if(Q==0)break;
		for(int j=0;j<i;j++)L*=c;
		for(int j=0;j<i;j++)R*=d;
		long long t=L+R;
		if(t>b*2)break;
		dist[sz++]=t;
	//	printf("%lld ",dist[sz-1]);
	}
	if(d==1){
		swap(c,d);
		swap(e,f);
	}
	if(c==1){
		long long ret=b;
		for(int i=0;i<sz;i++)dist[i]-=e;
		for(int i=1;i<=sz;i++){
			long long tmp=b-(long long)i*e;
			if(tmp<0)break;
			int rem=i;
			for(int j=sz-1;j>=0;j--){
				if(tmp>=dist[j]){
					rem--;
					tmp-=dist[j];
				}else{
					long long cost=dist[j]-tmp;
					if(rem-1<=j){
						for(int k=0;k<rem-1;k++){
							cost+=dist[k];
						}
				//		printf("%d %d: %lld\n",i,j,cost);
						ret=min(ret,cost);
					}
				}
				if(rem==0)break;
			}
			
			if(rem==0)ret=min(ret,tmp);
			//printf("%d: %lld\n",i,ret);
		}
		printf("%lld\n",ret);
		return 0;
	}
	long long ret=b;
	long long tmp=b;
	for(int i=sz-1;i>=0;i--){
		if(tmp>=dist[i])tmp-=dist[i];
		else ret=min(ret,dist[i]-tmp);
		ret=min(ret,tmp);
	}
	printf("%lld\n",ret);
}
//11 12 14 18