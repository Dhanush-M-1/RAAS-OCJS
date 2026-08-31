#include <bits/stdc++.h>
#define int long long
using namespace std;
const int maxl=105,maxs=10005,mod=1e9+7;

int read(){
	int s=0,w=1;char ch=getchar();
	while (ch<'0'||ch>'9'){if (ch=='-')  w=-w;ch=getchar();}
	while (ch>='0'&&ch<='9'){s=(s<<1)+(s<<3)+(ch^'0');ch=getchar();}
	return s*w;
}
int n,l,r,L,ans;
int c[maxl],b[maxl],pre[maxl],f[maxl][maxs];

void chksum(int x,int &y){y=(x+y)%mod;}

signed main(){
	n=read();
	for (int i=1;i<=n;i++)  c[i]=read();
	for (int i=1;i<=n;i++)  b[i]=read(),pre[i]=pre[i-1]+b[i];
	L=read();
	
	f[0][0]=1;
	for (int i=1;i<=n;i++){
		l+=(L+pre[i-1]),r+=c[i];
		for (int j=max(l,0ll);j<=r;j++){
			for (int k=0;k<=min(j,c[i]);k++)  chksum(f[i-1][j-k],f[i][j]);
		}
	}
	for (int i=0;i<=r;i++)  chksum(f[n][i],ans);
	cout<<ans<<endl;
	
	return 0;
}