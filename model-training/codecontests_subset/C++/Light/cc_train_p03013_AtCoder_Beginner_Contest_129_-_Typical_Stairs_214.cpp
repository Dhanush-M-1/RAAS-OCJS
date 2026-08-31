#include<bits/stdc++.h>
using namespace std;
const int N=1e5+7,mod=1e9+7;
int n,m,a[N],f[N];
int main()
{
	scanf("%d%d",&n,&m);
	for(int i=1,x;i<=m;i++)scanf("%d",&x),a[x]=1;
	f[0]=1;
	for(int i=1;i<=n;i++)if(!a[i])f[i]=(f[i-1]+f[i-2])%mod;
	printf("%d\n",f[n]);
}