#include<bits/stdc++.h>
#define ll long long
#define sz(x) ((int)x.size())
#define fi first
#define se second
#define pii pair<int,int>
#define pk push_back
const int maxn=1e2+5;
const int mo=1e9+7;
const int Max=1e5;
const int maxm=2e5+5;
using namespace std;
int rd(){
	int x=0,f=1;char c=getchar();
	while(!isdigit(c)){if(c=='-')f=-1;c=getchar();}
	while(isdigit(c))x=(x<<3)+(x<<1)+c-'0',c=getchar();
	return x*f;
}
int n,b[maxn],c[maxn],q,lim=1,L,R,m,ans[maxm],all;
int f[maxm],g[maxm];
int sum_b[maxn];
int pls(int x,int y){return x+y>=mo?x+y-mo:x+y;}
int dec(int x,int y){return x-y<0?x-y+mo:x-y;}
int solve(int x){
	int res=0;
	for(int i=1;i<=all;i++)f[i]=0;f[0]=1;
	for(int i=1;i<=n;i++){
		for(int j=0;j<=all;j++)g[j]=pls(f[j],(j?g[j-1]:0)),f[j]=0;
		for(int j=max(0,sum_b[i]+x*i);j<=all;j++)f[j]=dec(g[j],(j>c[i]?g[j-c[i]-1]:0));
	}
	for(int i=0;i<=all;i++)res=pls(res,f[i]);
	return res;
}
int main(){
	n=rd();
	for(int i=1;i<=n;i++)c[i]=rd(),lim=1LL*lim*(c[i]+1)%mo,m=max(m,c[i]),all+=c[i];
	for(int i=1;i<n;i++)b[i]=rd();
	q=rd();
	for(int i=1;i<=n;i++)for(int j=1;j<i;j++)sum_b[i]+=(i-j)*b[j];
	L=0,R=Max;
	for(int i=1;i<=n;i++)L=min(L,-((sum_b[i]-1)/i+1)),R=min(R,(n*m-sum_b[i]-1)/i+1);L=max(L,-Max);
	for(int i=L;i<=R;i++)ans[i+Max]=solve(i);
	for(int x;q;q--){
		x=rd();
		if(x<L)printf("%d\n",lim);
		else if(x>R)puts("0");
		else printf("%d\n",ans[x+Max]);
	}
	return 0;
}
