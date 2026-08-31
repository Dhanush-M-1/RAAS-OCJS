#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define inf 1000000007

int main() {
	ll n,m,a[100010],dp[100010];
	cin>>n>>m;
	for(int i=0;i<100010;i++){
		a[i]=0;
	}
	for(int i=0;i<m;i++){
		int z;
		cin>>z;
		a[z]=1;
	}
	dp[0]=1;
	if(a[1]!=1){
		dp[1]=1;
	}
	for(int i=2;i<=n;i++){
		dp[i]=dp[i-1]+dp[i-2];
		dp[i]%=inf;
		if(a[i]==1){
			dp[i]=0;
		}
	}
	cout << dp[n];
}