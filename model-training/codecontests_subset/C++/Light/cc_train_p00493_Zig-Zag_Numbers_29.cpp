#include <string>
#include <iostream>
#include <algorithm>
using namespace std;
const int mod = 10000;
string a, b; int m, power[509], modm[6009], dp[509][11][2][509];
int solve(string s, int z) {
	// [1, s]
	int n = s.size();
	int ret1 = 0;
	for (int i = z; i < n - 1; i++) {
		for (int j = 1; j <= 9; j++) ret1 += dp[i][j][z][0];
		while (ret1 >= mod) ret1 -= mod;
	}
	int mod1 = 0;
	for (int i = n - 1; i >= 0; i--) {
		int r = s[i] - 48, tl = (i == n - 1 ? 1 : 0), tr = (i == 0 ? r : r - 1);
		if (i != n - 1) {
			if ((i + z) & 1) tl = max(tl, s[i + 1] - 48 + 1);
			else tr = min(tr, s[i + 1] - 48 - 1);
		}
		for (int j = tl; j <= tr; j++) ret1 += dp[i][j][z][mod1];
		while (ret1 >= mod) ret1 -= mod;
		mod1 = (mod1 - r * power[i] + r * m) % m;
		if (i != n - 1) {
			if (((i + z) & 1) && s[i + 1] >= s[i]) break;
			if (!((i + z) & 1) && s[i + 1] <= s[i]) break;
		}
	}
	return ret1;
}
int main() {
	cin >> a >> b >> m;
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());
	a[0]--;
	for (int i = 0; i < a.size(); i++) {
		if (a[i] < 48) {
			a[i] += 10;
			a[i + 1]--;
		}
	}
	if (a.back() == 48) a.pop_back();
	if (a == "") a = "0";
	for (int i = 0; i <= 6000; i++) modm[i] = i % m;
	power[0] = modm[1];
	for (int i = 1; i <= 500; i++) power[i] = power[i - 1] * 10 % m;
	for (int i = 0; i <= 9; i++) dp[0][i][0][i % m] = dp[0][i][1][i % m] = 1;
	for (int i = 1; i <= 500; i++) {
		for (int j = 0; j <= 9; j++) {
			for (int k = 0; k < m; k++) {
				int z = modm[k - j * power[i] + j * m];
				if (i & 1) {
					for (int l = 0; l < j; l++) dp[i][j][0][k] += dp[i - 1][l][0][z];
					for (int l = 9; l > j; l--) dp[i][j][1][k] += dp[i - 1][l][1][z];
				}
				else {
					for (int l = 9; l > j; l--) dp[i][j][0][k] += dp[i - 1][l][0][z];
					for (int l = 0; l < j; l++) dp[i][j][1][k] += dp[i - 1][l][1][z];
				}
				while (dp[i][j][0][k] >= mod) dp[i][j][0][k] -= mod;
				while (dp[i][j][1][k] >= mod) dp[i][j][1][k] -= mod;
			}
		}
	}
	int ret1 = (solve(a, 0) + solve(a, 1)) % mod;
	int ret2 = (solve(b, 0) + solve(b, 1)) % mod;
	cout << (ret2 - ret1 + mod) % mod << endl;
	return 0;
}