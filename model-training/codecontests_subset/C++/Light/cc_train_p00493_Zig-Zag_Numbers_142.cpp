#include <cstdlib>
#include <cstring>
#include <iostream>
using namespace std;

constexpr int mod = 10000;
constexpr int MAX_DIGIT = 500;
constexpr int MAX_M = 500;

int dp[MAX_DIGIT + 1][MAX_M][10][2][2]; // digit, modulo m, prev, less flag, zig-zag flag

int calc(const string &limit, int m) {
	const int n = limit.size();

	memset(dp, 0, sizeof(dp));

	for(int i = 0; i < n; ++i) {
		for(int j = 0; j < 10; ++j) {
			const bool lt = (j < limit[i] - '0');
			const bool le = (j <= limit[i] - '0');

			if(j && (i || le)) {
				(dp[i + 1][j % m][j][i || lt][true] += 1) %= mod;
				(dp[i + 1][j % m][j][i || lt][false] += 1) %= mod;
			}

			for(int k = 0; k < m; ++k) {
				const int next_rest = (k * 10 + j) % m;

				for(int l = 0; l < j; ++l) {
					(dp[i + 1][next_rest][j][true][true] += dp[i][k][l][true][false]) %= mod;

					if(le) {
						(dp[i + 1][next_rest][j][lt][true] += dp[i][k][l][false][false]) %= mod;
					}
				}

				for(int l = j + 1; l < 10; ++l) {
					(dp[i + 1][next_rest][j][true][false] += dp[i][k][l][true][true]) %= mod;

					if(le) {
						(dp[i + 1][next_rest][j][lt][false] += dp[i][k][l][false][true]) %= mod;
					}
				}
			}
		}
	}

	int res = 0;
	for(int i = 0; i < 10; ++i) {
		res += dp[n][0][i][true][true];
		res += dp[n][0][i][true][false];

		if(i && (n > 1 || i < limit.back() - '0') && i % m == 0) {
			--res;
		}
	}

	return res % mod;
}

int main() {
	cin.tie(nullptr);
	ios::sync_with_stdio(false);

	string a, b;
	int m;

	cin >> a >> b >> m;

	int carry = 1;
	for(int i = b.size() - 1; i >= 0; --i) {
		b[i] += carry;
		if(b[i] <= '9') {
			carry = 0;
			break;
		}
		else {
			b[i] = '0';
		}
	}

	if(carry) b = '1' + b;

	cout << (calc(b, m) - calc(a, m) + mod) % mod << endl;

	return EXIT_SUCCESS;
}