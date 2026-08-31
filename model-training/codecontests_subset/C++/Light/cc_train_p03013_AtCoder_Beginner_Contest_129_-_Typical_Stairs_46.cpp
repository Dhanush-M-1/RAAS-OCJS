#include <bits/stdc++.h>
using namespace std;
int main(){
	int N, M; cin >> N >> M; 
	bool broken[100010] = {}; 
	for(int i = 0; i < M; i++){
		int a; cin >> a; 
		broken[a] = true; 
	}
	long long P = 1000000007; 
	long long dp[100010] = {}; 
	dp[0] = 1; 
	if(!broken[1]) dp[1] = 1; 
	for(int i = 2; i <= N; i++){
		if(!broken[i]) dp[i] = (dp[i-2] + dp[i-1]) % P; 
	} 
	cout << dp[N] << endl; 
}