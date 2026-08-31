#include<iostream>
using namespace std;
int N;
long long mod = 1e9 + 7, dp[1<<17];
bool out[1<<17];
int main() {
	int M;
    cin >> N >> M;
	for(int i=0; i<M; i++) {
		int a;
        cin >> a;
        out[a] = 1;
	}
	dp[0] = 1;
	for(int i=0; i<N; i++) {
		if(!out[i+1]) (dp[i+1]+=dp[i]) %= mod;
		if(!out[i+2]) (dp[i+2]+=dp[i]) %= mod;
	}
	cout << dp[N] << endl;
}
