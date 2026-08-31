#include<iostream>
using namespace std;

int dp[100001] = {0};

int main(){
	int n,m,tmp;
	cin >> n >> m;
	for(int i=0;i<m;++i){
		cin >> tmp;
		dp[tmp] = -1;
	}
	dp[0] = 1;
	for(int i=0;i<n;++i){
		for(int j=1;j<=2;++j){
			int next = i+j;
			if(next > n || dp[next] == -1 || dp[i] == -1) continue;
			dp[next] = (dp[next] +dp[i])%1000000007;
		}
	}

	cout << dp[n] <<endl;
	return 0;
}