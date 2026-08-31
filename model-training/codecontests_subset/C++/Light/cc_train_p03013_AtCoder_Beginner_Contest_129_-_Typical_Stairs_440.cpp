#include <iostream>
using namespace std;

const int MAXN = 1e6 + 10, MOD = 1e9 + 7;
long long dp[MAXN];
bool O[MAXN];
int n, m;

int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		O[a] = 1;
	}
	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
		if (O[i])
			continue;
		dp[i] = dp[i - 1] + dp[i - 2];
		dp[i] %= MOD;
	}
	cout << dp[n];
}
