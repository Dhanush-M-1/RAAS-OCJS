#include <bits/stdc++.h>
using u32 = uint32_t;
using i64 = int64_t;
using u64 = uint64_t;
constexpr i64 inf = 1e18;
void solve() {
	int n, c, q;
	std::cin >> n >> c >> q;
	std::vector<int> a(n + 1);
	for (int i = 1; i <= n; i++) {
		std::cin >> a[i];
	}
	std::vector<std::vector<i64>> dp(n + 2, std::vector<i64>(c + 1));
	std::vector<std::vector<i64>> down(n + 2, std::vector<i64>(c + 1));
	std::vector<std::vector<i64>> up(n + 2, std::vector<i64>(c + 1));
	for (int i = 0; i <= c; i++) {
		dp[n + 1][i] = 1;
	}
	for (int i = n; i >= 1; --i) {
		for (int j = 0; j <= c; j++) {
			std::vector<std::pair<int, i64>> tmp;
			for (int k = i; k <= i + j && k <= n; k++) {
				tmp.emplace_back(a[k], dp[k + 1][j - k + i]);
			}
			std::sort(tmp.begin(), tmp.end());
			for (auto t : tmp) {
				if (t.first == a[i]) {
					down[i][j] = dp[i][j];
					up[i][j] = std::min(dp[i][j] + t.second, inf);
				}
				dp[i][j] = std::min(dp[i][j] + t.second, inf);
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= c; j++) {
			up[i][j] -= down[i][j];
			down[i][j] = std::min(down[i][j] + down[i - 1][j], inf);
		}
	}
	while (q--) {
		int i;
		i64 j;
		std::cin >> i >> j;
		if (j > dp[1][c]) {
			std::cout << -1 << "\n";
		} else {
			int pos = 0;
			int lft = c;
			int ans = 0;
			while (!ans) {
				int l = pos;
				int r = n;
				while (l < r) {
					int mid = l + r + 1 >> 1;
					i64 t = j - down[mid][lft] + down[pos][lft];
					if (t >= 1 && t <= up[mid][lft]) {
						l = mid;
					} else {
						r = mid - 1;
					}
				}
				if (l >= i) {
					ans = a[i];
				} else {
					std::vector<std::pair<int, i64>> tmp;
					j -= down[l][lft] - down[pos][lft];
					++l;
					for (int k = l; k <= l + lft && k <= n; k++) {
						tmp.emplace_back(a[k], dp[k + 1][lft - k + l]);
					}
					std::sort(tmp.begin(), tmp.end());
					for (auto t : tmp) {
						if (j > t.second) {
							j -= t.second;
						} else {
							int p = l;
							while (a[p] != t.first) {
								++p;
							}
							if (i <= p) {
								ans = a[l + p - i];
							} else {
								pos = p;
								lft = lft - p + l;
							}
							break;
						}
					}
				}
			}
			std::cout << ans << "\n";
		}
	}
}
int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	int T;
	std::cin >> T;
	while (T--) {
		solve();
	}
	return 0;
}