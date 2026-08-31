#include<iostream>
#include<cstdio>
#include<algorithm>

using namespace std;

int X,K,Q,maxn[100001],minn[100001],r[1000001],f[1000001],t,a,ans;

int main(){
	scanf("%d%d",&X,&K);maxn[0]=X;for(int i=1;i<=K;++i)scanf("%d",r+i);
	for(int i=1;i<=K;++i){
		int t=r[i]-r[i-1];maxn[i]=maxn[i-1],minn[i]=minn[i-1];
		if(i&1)minn[i]=max(minn[i],min(maxn[i],t-f[i-1])),f[i]=max(minn[i-1]+f[i-1]-t,0)-minn[i];
		else maxn[i]=min(maxn[i],max(minn[i],X-t-f[i-1])),f[i]=min(maxn[i-1]+f[i-1]+t,X)-maxn[i];
	}
	scanf("%d",&Q);
	for(int i=1;i<=Q;++i){
		scanf("%d%d",&t,&a);
		int j=upper_bound(r+1,r+K+1,t)-r-1,p=t-r[j];
		a=max(minn[j],a),a=min(maxn[j],a);
		ans=a+f[j];
		if(j&1)ans=min(X,ans+p);else ans=max(0,ans-p);
		printf("%d\n",ans);
	}
}