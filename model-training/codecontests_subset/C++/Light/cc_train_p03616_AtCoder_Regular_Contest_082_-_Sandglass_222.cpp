#include<cstdio>
const int MaxK=100010,MaxQ=100010;
int X,K,r[MaxK],Q,t[MaxQ],a[MaxQ];
int L,R,b,T;
bool dir;
int min(int a,int b){return a<b?a:b;}
int max(int a,int b){return a>b?a:b;}
void mov(int t){
	if(dir){
		b+=min(t-T,X-b-L);
		R=min(R,X-b);
	}
	else{
		b-=min(t-T,b+R);
		L=max(L,-b);
	}
	T=t;
}
int main(){
	scanf("%d%d",&X,&K);
	for(int i=0;i<K;i++)scanf("%d",r+i);
	scanf("%d",&Q);
	for(int i=0;i<Q;i++)scanf("%d%d",t+i,a+i);
	R=X;
	for(int i=0,j=0;i<K||j<Q;){
		if(j==Q||i<K&&r[i]<t[j]){
			mov(r[i++]);
			dir^=1;
		}
		else{
			mov(t[j]);
			printf("%d\n",b+min(max(a[j++],L),R));
		}
	}
}