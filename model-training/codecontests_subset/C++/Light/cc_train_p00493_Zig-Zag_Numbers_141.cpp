#include<iostream>
#include<string>
using namespace std;
const int mod = 10000;
int dp[600][600][11][2][2];
string S, T; int power[600], n;
int zen_shori(int Keta) {
	for (int i = 0; i < 360000; i++) {
		for (int j = 0; j < 10; j++) {
			dp[i / 600][i % 600][j][0][0] = 0;
			dp[i / 600][i % 600][j][0][1] = 0;
			dp[i / 600][i % 600][j][1][0] = 0;
			dp[i / 600][i % 600][j][1][1] = 0;
		}
	}
	int F = 0;
	for (int i = 1; i <= 9; i++) { if (i%n == 0)F++; }
	if (Keta == 1)return F;
	if (Keta == 0)return 0;
	dp[0][0][0][0][1] = 1; dp[0][0][10][1][1] = 1;
	for (int i = 0; i < Keta; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < 11; k++) {
				for (int l = 0; l < 2; l++) {
					int L = 0, R = 9;
					if (l == 0)L = k + 1;
					if (l == 1)R = k - 1;
					for (int m = 0; m <= 9; m++) {
						int Plus = (power[i] * m) % n;
						int to = (j + Plus) % n;
						if (L <= m && m <= R) {
							dp[i + 1][to][m][1 - l][0] += dp[i][j][k][l][0]; dp[i + 1][to][m][1 - l][0] %= mod;
						}
						if (m >= 1) { dp[i + 1][to][m][1 - l][0] += dp[i][j][k][l][1]; dp[i + 1][to][m][1 - l][0] %= mod; }
						if (m == 0) { dp[i + 1][to][m][1 - l][1] += dp[i][j][k][l][1]; dp[i + 1][to][m][1 - l][1] %= mod; }
					}
				}
			}
		}
	}
	int sum = 0;
	for (int i = 0; i < 10; i++) { for (int j = 0; j < 2; j++) { sum += dp[Keta][0][i][j][0]; } }
	sum -= F;
	//cout << sum << endl;
	return sum;
}
int solve(string V) {
	for (int i = 0; i < 360000; i++) {
		for (int j = 0; j < 10; j++) {
			dp[i / 600][i % 600][j][0][0] = 0;
			dp[i / 600][i % 600][j][0][1] = 0;
			dp[i / 600][i % 600][j][1][0] = 0;
			dp[i / 600][i % 600][j][1][1] = 0;
		}
	}
	int F = 0;
	for (int i = 1; i <= (int)(V[0] - '0'); i++) { if (i%n == 0)F++; }
	if (V.size() == 1)return F;
	dp[0][0][0][0][1] = 1; dp[0][0][10][1][1] = 1;
	for (int i = 0; i < (int)V.size(); i++) {
		int P = V[i] - '0';
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < 11; k++) {
				for (int l = 0; l < 2; l++) {
					if (dp[i][j][k][l][0] == 0 && dp[i][j][k][l][1] == 0)continue;
					int L = 0, R = 9;
					if (l == 0)L = k + 1;
					if (l == 1)R = k - 1;
					for (int m = L; m <= R; m++) {
						if (i == 0 && m == 0)continue;
						int Plus = (power[i] * m) % n;
						int to = (j + Plus) % n;
						dp[i + 1][to][m][1 - l][0] += dp[i][j][k][l][0]; dp[i + 1][to][m][1 - l][0] %= mod;
						if (P > m) { dp[i + 1][to][m][1 - l][0] += dp[i][j][k][l][1]; dp[i + 1][to][m][1 - l][0] %= mod; }
						if (P == m) { dp[i + 1][to][m][1 - l][1] += dp[i][j][k][l][1]; dp[i + 1][to][m][1 - l][1] %= mod; }
					}
				}
			}
		}
	}
	int sum = 0;
	for (int i = 0; i < 10; i++) { for (int j = 0; j < 2; j++) { sum += dp[V.size()][0][i][j][0] + dp[V.size()][0][i][j][1]; } }
	//cout << sum << endl;
	return sum;
}
int solve2(string V) {
	int v = 1; for (int i = V.size() - 1; i >= 0; i--) { power[i] = v; v *= 10; v %= n; }
	int r1 = solve(V);
	int r2 = zen_shori(V.size() - 1);
	return (r2 + r1) % mod;
}
int main() {
	cin >> S >> T >> n;
	int ii = S.size() - 1; while (S[ii] == '0') { S[ii] = '9'; ii--; } S[ii]--;
	while (S[0] == '0' && S.size() >= 2)S = S.substr(1, S.size() - 1);
	cout << (solve2(T) - solve2(S) + mod) % mod << endl;
	return 0;
}