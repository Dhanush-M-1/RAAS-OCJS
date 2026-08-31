// abca29c.cpp : Typical Stairs
#include <bits/stdc++.h>
using namespace std;
#define MOD 1000000007

int main(){
	int n,m; cin>>n>>m;

	vector<bool> ok(n+1,true);
	for(int i=0;i<m;i++){
		int a; cin>>a;
		ok[a] = false;
	}

	vector<int> dp(n+1);
	dp[0] = 1;
	if(ok[1]) dp[1] = 1;
	for(int i=2; i<=n; i++)
		if(ok[i]) dp[i] = (dp[i-1] + dp[i-2]) % MOD;

	cout<< dp[n] <<endl;
}