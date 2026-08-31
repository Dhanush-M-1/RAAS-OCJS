#include <iostream>
using namespace std;

int const N = 1e5+5;
long long const MOD = 1e9+7;
long long dp[N];
bool b[N];
int n,m,i,j;


int main() {
	// your code goes here
	cin>>n>>m;
	for(i=0;i<m;i++){
		cin>>j;
		b[j] = true;
	}
	dp[0] = 1;
	dp[1] = (b[1]==false);
	
	for(i=2;i<=n;i++){
		if(b[i]==true) continue;
		dp[i] = dp[i-1]+dp[i-2];
		dp[i] %= MOD;
	}
	
	cout<<dp[n];
	return 0;
}