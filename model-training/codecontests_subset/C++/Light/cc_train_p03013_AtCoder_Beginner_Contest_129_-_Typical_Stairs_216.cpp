#include <bits/stdc++.h>
using namespace std;

long long dp[100002];
int a[100002];
long long MOD = 1e9 + 7;
map<int,int> ma;
int main() {
	int n, m;
	cin>>n>>m;
	int i;
	dp[0] = 1;
	for(i=1;i<=n;i++) cin >> a[i], ma[a[i]]++;
	for(i=1;i<=n;i++) {
	    if(ma[i]) continue;
	    if(i-2>=0)
	        dp[i]+=dp[i-2];
	   dp[i]+=dp[i-1];
	   dp[i]%=MOD;
	}
	cout<<dp[n];
	return 0;
}