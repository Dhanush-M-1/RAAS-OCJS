#include <stdio.h>
#include <algorithm>
using namespace std;
using ll = long long;

int n, m, a[100010];
ll dp[100010], mod = 1e9 + 7;
int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", a + i);
		dp[a[i]] = -2e18;
	}
	dp[0] = 1;
	for (int i = 0; i < n; i++) {
		dp[i] = max(0ll, dp[i]) % mod;
		dp[i + 1] += dp[i];
		dp[i + 2] += dp[i];
	}
	printf("%lld\n", dp[n] % mod);
}