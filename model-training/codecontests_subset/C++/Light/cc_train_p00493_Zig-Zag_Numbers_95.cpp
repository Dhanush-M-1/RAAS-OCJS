#include<iostream>
#include<string>

using namespace std;

int dp[501 + 10][2][10][3][500];
//dp[a][b][c][d][e]:a桁目 b1で自由に使える0で自由に使えない 今の桁はc
//d1で前より上がってる2で前より下がってる0で前と変わらない eは余り
int MOD = 10000;
int M;
string A, B;

//1~nまでのジグザグ数%10000
int calc(string n) {
	for (int i = 0; i <= 500; i++)for (int j = 0; j < 2; j++)for (int k = 0; k < 10; k++)
		for (int l = 0; l < 3; l++)for (int m = 0; m < 500; m++)dp[i][j][k][l][m] = 0;
	
	for (int i = 0; i < n[0] - '0'; i++)
		dp[1][1][i][0][i % M] = 1;

	dp[1][0][(n[0] - '0')][0][(n[0] - '0') % M] = 1;

	for (int a = 1; a < n.size(); a++) {
		for (int b = 0; b < 2; b++) {
			int limit = b ? 9 : n[a] - '0';
			for (int c = 0; c <= limit; c++) {
				for (int d = 0; d <= (b ? 9 : n[a - 1] - '0'); d++) {
					for (int e = 0; e < 3; e++) {
						for (int f = 0; f < M; f++) {
							if (e == 0) {
								//前と比べて増加も減少もしてない
								if (d == 0) {
									(dp[a + 1][b || c < limit][c][0][(f * 10 + c) % M] += dp[a][b][d][e][f]) %= MOD;
								}
								else {
									if (c < d) {
										(dp[a + 1][b || c < limit][c][2][(f * 10 + c) % M] += dp[a][b][d][e][f]) %= MOD;
									}
									if (c > d) {
										(dp[a + 1][b || c < limit][c][1][(f * 10 + c) % M] += dp[a][b][d][e][f]) %= MOD;
									}
								}
								
							}
							else if (e == 1) {
								//今増加→次減少
								if (c >= d)continue;
								(dp[a + 1][b || c < limit][c][2][(f * 10 + c) % M] += dp[a][b][d][e][f]) %= MOD;
							}
							else if (e == 2) {
								//今減少→次増加
								if (c <= d)continue;
								(dp[a + 1][b || c < limit][c][1][(f * 10 + c) % M] += dp[a][b][d][e][f]) %= MOD;
							}
						}
					}
				}
			}
		}
	}

	int ans = 0;
	for (int b = 0; b < 2; b++)for (int c = 0; c <= 9; c++)for (int e = 0; e <= 2; e++)
		ans += dp[n.size()][b][c][e][0];
	ans--;
	ans %= MOD;

	return ans;

}

bool isZigZag(string n) {
	bool f;
	if (n.size() == 1)return true;
	if (n[0] == n[1])return false;
	if (n[0] > n[1])f = true;
	if (n[0] < n[1])f = false;

	for (int i = 1; i < n.size() - 1; i++) {
		if (f) {
			if (n[i + 1] <= n[i])return false;
			f = !f;
		}
		else {
			if (n[i + 1] >= n[i])return false;
			f = !f;
		}
	}
	return true;

}

int main() {

	cin >> A >> B >> M;

	cout << (calc(B) - calc(A) + isZigZag(A) + MOD) % MOD << endl;

	return 0;
}

