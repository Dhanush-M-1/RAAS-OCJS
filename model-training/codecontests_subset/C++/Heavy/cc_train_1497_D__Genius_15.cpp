#include <algorithm>
#include <iostream>

using pii = std::pair<int, int>;
using ll = long long;

int s[5005];
int tag[5005];
ll dp[5005];

ll calc(int n) {
	dp[1] = 0;
	for (int i = 2; i <= n; i++) {
		dp[i] = 0;
		for (int j = i - 1; j != 0; j--) {
			if (tag[i] == tag[j]) continue;
			ll p1, p2;
			p1 = std::max(dp[j], dp[i] + std::abs(s[i] - s[j]));
			p2 = std::max(dp[i], dp[j] + std::abs(s[i] - s[j]));
			dp[j] = p1, dp[i] = p2;
		}
	}
	ll ret = 0;
	for (int i = 1; i <= n; i++)
		ret = std::max(ret, dp[i]);
	return ret;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(0); std::cout.tie(0);

	int t, n;
	std::cin >> t;
	while (t--) {
		std::cin >> n;
		for (int i = 1; i <= n; i++)
			std::cin >> tag[i];
		for (int i = 1; i <= n; i++)
			std::cin >> s[i];
		std::cout << calc(n) << '\n';

	}
	return 0;
}
