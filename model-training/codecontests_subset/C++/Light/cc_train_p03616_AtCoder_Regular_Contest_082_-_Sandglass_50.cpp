#include<cstdio>
#include<cctype>
#include<algorithm>
using namespace std;
int x,k,q,r[100010],maxn[100010],mini[100010],c[100010];
int rd(){
	int x=0;
	char c;
	do c=getchar();
	while(!isdigit(c));
	do{
		x=(x<<1)+(x<<3)+(c^48);
		c=getchar();
	}while(isdigit(c));
	return x;
}
void InitInput(){
	x=rd(),k=rd();
	for(int i=1;i<=k;i++)
		r[i]=rd();
	maxn[0]=x,r[0]=mini[0]=c[0]=0;
	for(int i=1;i<=k;i++){
		maxn[i]=maxn[i-1];
		mini[i]=mini[i-1];
		if(i&1){
			mini[i]=max(mini[i],min(r[i]-r[i-1]-c[i-1],maxn[i]));
			c[i]=max(c[i-1]+mini[i-1]-r[i]+r[i-1],0)-mini[i];
		}else{
			maxn[i]=min(maxn[i],max(x-r[i]+r[i-1]-c[i-1],mini[i]));
			c[i]=min(c[i-1]+maxn[i-1]+r[i]-r[i-1],x)-maxn[i];
		}
	}
	return;
}
void Ask(){
	q=rd();
	for(int i=1;i<=q;i++){
		int t=rd(),a=rd();
		int pos=upper_bound(r+1,r+k+1,t)-r-1,ans=c[pos];
		if(a<=mini[pos])
			ans+=mini[pos];
		else if(a>=maxn[pos])
			ans+=maxn[pos];
		else
			ans+=a;
		if(pos&1)
			ans=min(x,ans+t-r[pos]);
		else ans=max(0,ans-t+r[pos]);
		printf("%d\n",ans);
	}
}
int main(){
	InitInput();
	Ask();
	return 0;
}