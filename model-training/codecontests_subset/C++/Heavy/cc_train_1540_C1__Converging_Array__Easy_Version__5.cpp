#include<bits/stdc++.h>
using namespace std;
const int N=105,M=1000000007,iv=(M+1)/2;
int n,t,c[N],b[N],q,x,s[N],f[N][N*N],i;
int dfs(int i,int p)
{
	if(i>n)
		return 1;
	if(f[i][p]!=-1)
		return f[i][p];
	int j;
	long long ss=0;
	for(j=0;j<=c[i];++j)
		if(p+j-s[i]>=i*x)
			ss+=dfs(i+1,p+j);
	return f[i][p]=ss%M;
}
int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
#endif
	scanf("%d",&n);
	for(i=1;i<=n;++i)
		scanf("%d",&c[i]);
	for(i=1;i<n;++i)
		scanf("%d",&b[i]);
	scanf("%d",&q);
	scanf("%d",&x);
	for(i=1;i<n;++i)
		s[i+1]=s[i]+b[i];
	for(i=2;i<=n;++i)
		s[i]+=s[i-1];
	memset(f,-1,sizeof(f));
	cout<<dfs(1,0);
}
