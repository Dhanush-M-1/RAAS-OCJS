#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9+7;

int s[100005];
int dp[100005];
int main(void){
	int N,M;
	cin >> N >> M;
	for(int i=0;i<M;i++){
		int a;cin >> a;
		s[a]=1;
	}
	dp[0]=1;
	for(int i=1;i<=N;i++){
		if(s[i]!=1){
			if(i==1){ dp[i] = dp[i-1];}
			else {
				dp[i]=dp[i-1]+dp[i-2];
				dp[i]%=mod;
			}
		}else{
			dp[i]=0;
		}
	}
	cout << dp[N] << endl;
}