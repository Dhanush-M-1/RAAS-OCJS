#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const ll mod=1e9+7;
const int N=1e5+10;

int n, m, x;
int vis[N];
ll dp[N];

int main() {
	cin>>n>>m;
	for(int i=1; i<=m; i++) {
		cin>>x;
		vis[x]=1;
	}
	dp[0]=1;
	for(int i=1; i<=n; i++) {
		if (vis[i]) continue;
		dp[i]=dp[i-1];
		if (i>=2) dp[i]+=dp[i-2];
		dp[i]%=mod;
	}
	cout<<dp[n]<<endl;
	return 0;
}
