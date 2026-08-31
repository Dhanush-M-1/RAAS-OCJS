#include<cstdio>
#define mod 1000000007
typedef long long ll;
const int MAXN=100000+10;
int n,m;
int a[MAXN];
int dp[MAXN];
bool vis[MAXN];
int main(){
	scanf("%d%d",&n,&m);
	for(int i=1;i<=m;i++){
		scanf("%d",&a[i]);
		vis[a[i]]=1;
	}
	dp[0]=1;
	for(int i=1;i<=n;i++){
		if(vis[i]) continue;
		dp[i]=dp[i-1]+dp[i-2];
		dp[i]%=mod;
	}
	printf("%d\n",dp[n]%mod);
	return 0;
}