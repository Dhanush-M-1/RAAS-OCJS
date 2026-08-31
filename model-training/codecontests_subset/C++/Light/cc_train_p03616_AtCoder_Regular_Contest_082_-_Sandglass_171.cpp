#include<bits/stdc++.h> 
#define fo(i,a,b) for(i=a;i<=b;i++)
#define fd(i,a,b) for(i=a;i>=b;i--)
#define min(a,b) (a<b?a:b)
#define max(a,b) (a>b?a:b)
typedef long long ll;
using namespace std;
inline int read(){
	int n=0,f=1;char c;
	for(c=getchar();(c<'0'||c>'9')&&c!='-';c=getchar());
	if (c=='-') c=getchar(),f=-1;
	for(;c>='0'&&c<='9';c=getchar()) n=n*10+c-48;
	return n*f;
}
const int maxn=1e5+5;
int T,i,j,now,r[maxn],Q,t,x,mx,mi,c,k,ans,lami,lamx;
bool bz;
int main(){
	T=read(),k=read();
	fo(i,1,k) r[i]=read();
	Q=read();
	mi=0,mx=T,c=0;
	now=1,bz=1;
	for(;Q--;){
		t=read(),x=read();
		for(;now<=k&&t>r[now];now++,bz^=1){
			int len=r[now]-r[now-1];
			if (bz) lami=mi,mi=max(mi,min(mx,len-c)),c=max(0,lami+c-len)-mi;
			else lamx=mx,mx=min(mx,max(mi,T-len-c)),c=min(lamx+c+len,T)-mx;
		}
		if (x<mi) ans=mi+c;else
		if (x<=mx) ans=x+c;else
		ans=mx+c;
		if (bz) ans=max(0,ans-(t-r[now-1]));else
		ans=min(T,ans+(t-r[now-1]));
		printf("%d\n",ans);
	}
}