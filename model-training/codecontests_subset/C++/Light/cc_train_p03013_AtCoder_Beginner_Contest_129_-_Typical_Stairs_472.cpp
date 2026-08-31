#include <iostream>
using namespace std;
#define MOD 1000000007

long n, m, a[100010], dp[100010];
int j;

int main(){
	cin >> n >> m;
	for (int i = 0; i < m; ++i) cin >> a[i];
	dp[0] = 1;
	dp[1] = (a[0] == 1) ? 0 : 1;
	j = (a[0] == 1) ? 1: 0;
	for (int i = 2; i <= n; ++i){
		if (a[j] == i){
			dp[i] = 0;
			j++;
		}
		else{
			dp[i] = (dp[i-1] + dp[i-2]) % MOD;
		}
	}
	cout << dp[n];
}