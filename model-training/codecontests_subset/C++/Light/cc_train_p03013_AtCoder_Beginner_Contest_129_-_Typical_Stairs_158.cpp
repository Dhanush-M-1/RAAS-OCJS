#include<bits/stdc++.h>
using namespace std;

const int mn=1e5+7,mod=1e9+7;
int vis[mn],f[mn],n,m,a;

int main()
{
	scanf("%d%d",&n,&m);
	for(int i=1;i<=m;++i) {scanf("%d",&a);a++;vis[a]=1;}
	f[1]=1;
	for(int i=2;i<=n+1;++i) {
		if(!vis[i-1]) f[i]+=f[i-1];
		f[i]%=mod;
		if(!vis[i-2]) f[i]+=f[i-2];
		f[i]%=mod;
	}
	printf("%d",f[n+1]);
}