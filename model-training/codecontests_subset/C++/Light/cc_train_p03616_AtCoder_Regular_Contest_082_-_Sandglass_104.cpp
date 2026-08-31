#include<bits/stdc++.h>
using namespace std;
const int maxn=1e5+20;
int X,K,Q,solve();
int hehe=solve(),r[maxn],mx[maxn],mn[maxn],c[maxn];
int solve(){
	scanf("%d",&X);
	scanf("%d",&K);
	for(int i=1;i<=K;++i){
		scanf("%d",&r[i]); 
	}
	mx[0]=X;
	for(int i=1;i<=K;++i){
		mx[i]=mx[i-1];mn[i]=mn[i-1];
		if(i&1){
			mn[i]=max(mn[i],min(r[i]-r[i-1]-c[i-1],mx[i]));
			c[i]=max(c[i-1]+mn[i-1]-r[i]+r[i-1],0)-mn[i]; 
		}
		else{
			mx[i]=min(mx[i],max(X-r[i]+r[i-1]-c[i-1],mn[i]));
			c[i]=min(c[i-1]+mx[i-1]+r[i]-r[i-1],X)-mx[i];
		}
	}
	scanf("%d",&Q);
	for(int a,t,pl,ans;Q--;){
		scanf("%d%d",&t,&a);
		ans=c[pl=(upper_bound(r+1,r+K+1,t)-r-1)];
		if(a<=mn[pl])ans+=mn[pl];
		else if(a>=mx[pl])ans+=mx[pl];
		else ans+=a;
		if(pl&1)ans=min(X,ans+t-r[pl]);
		else ans=max(0,ans-t+r[pl]);
		printf("%d\n",ans);     
	}
	return 0;
}
int main(){};