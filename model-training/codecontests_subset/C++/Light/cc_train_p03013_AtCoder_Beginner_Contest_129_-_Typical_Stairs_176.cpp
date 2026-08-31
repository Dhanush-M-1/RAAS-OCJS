#include<bits/stdc++.h>

using namespace std;
const long long mod = 1e9+7;

int main(){
	int N, M;
	cin >> N >> M;
	vector<int>oks(N+1, true);
	
	for(int i=0; i<M; ++i){
		int a;
		cin >> a;
		oks[a] = false;
	}
	vector<long long int>dp(N+1, 0);
	dp[0] = 1;
	if(oks[1]==true) dp[1] = 1;
	for(int i=2; i <=N; i++){
		if(oks[i]==true){
			dp[i]=(dp[i-1]+dp[i-2])%mod;
		}
	}

	cout << dp[N] << endl;


}
