#include <bits/stdc++.h>
using namespace std;

long long MOD=1000000007;

int main(){
	int N,M;
	cin >> N >> M;
	vector<long long> dp(N+1,0LL);
	vector<int> a(M);
	for(auto &i:a)cin >> i;
	
	dp[0]=1;
	for(int i=0;i<=N;i++){
		if(binary_search(a.begin(),a.end(),i))dp[i]=0LL;
		if(dp[i]>=MOD)dp[i]%=MOD;
		if(i<N-1)dp[i+2]+=dp[i];
		if(i<N)dp[i+1]+=dp[i];
	}
	cout << dp[N] << endl;
	return 0;
}