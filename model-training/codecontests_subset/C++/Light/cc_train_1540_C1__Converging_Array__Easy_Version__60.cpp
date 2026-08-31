#include<bits/stdc++.h>
using namespace std;
const int N = 105;
const int mod = 1e9+7;
int n,c[N],b[N],q,f[N][N*N],ans;
int main() {
	scanf("%d",&n);
	for(int i=1;i<=n;i++) scanf("%d",&c[i]);
	for(int i=1;i<n;i++) scanf("%d",&b[i]);
	for(int i=1;i<n;i++) b[i] += b[i-1];
	for(int i=1;i<n;i++) b[i] += b[i-1];
	scanf("%d",&q);scanf("%d",&q);
	f[0][0] = 1;
	for(int i=1;i<=n;i++)
		for(int j=i*q+b[i-1];j<N*N;j++)
			for(int k=0;k<=c[i]&&k<=j;k++)
				f[i][j] = (f[i][j]+f[i-1][j-k])%mod;
	for(int i=0;i<N*N;i++) ans = (ans+f[n][i])%mod;
	printf("%d\n",ans);
	return 0;
}