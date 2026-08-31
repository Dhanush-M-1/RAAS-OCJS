#include<bits/stdc++.h>
using namespace std;
const int N=105,mod=1e9+7;
inline int add(int a,int b){return a+b>=mod?a+b-mod:a+b;}
inline int mul(int a,int b){return 1ll*a*b%mod;}
int n,m,l,r;
int b[N],c[N],p[N];
int f[N*N],g[N*N];
map<int,int> ans;
inline int solve(int x){
	for(int i=0;i<=n*100;i++)g[i]=1;
	for(int i=1;i<=n;i++){
		for(int j=0;j<max(i*x+p[i],0);j++)f[j]=0;
		for(int j=max(i*x+p[i],0);j<=n*100;j++){
			if(j>c[i])f[j]=add(g[j],mod-g[j-c[i]-1]);
			else f[j]=g[j];
		}
		g[0]=f[0];
		for(int j=1;j<=n*100;j++)g[j]=add(g[j-1],f[j]);
	}
	return g[n*100];
}
int main(){
	cin>>n;
	for(int i=1;i<=n;i++)cin>>c[i];
	for(int i=1;i<n;i++)cin>>b[i];
	for(int i=1;i<=n;i++)
		for(int j=1;j<i;j++)p[i]+=(i-j)*b[j];
	l=0,r=100000;
	for(int i=1;i<=n;i++)l=min(l,-((p[i]-1)/i+1)),r=min(r,(n*100-p[i]-1)/i+1);
	for(int i=l;i<=r;i++)ans[i]=solve(i);
	int q;
	cin>>q;
	int res=1;
	for(int i=1;i<=n;i++)res=mul(res,c[i]+1);
	while(q--){
		int x;
		scanf("%d",&x);
		if(x<l)printf("%d\n",res);
		else if(x>r)puts("0");
		else printf("%d\n",ans[x]);
	}
	return 0;
}