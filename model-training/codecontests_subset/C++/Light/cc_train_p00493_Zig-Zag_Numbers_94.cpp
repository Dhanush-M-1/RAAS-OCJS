#include<bits/stdc++.h>
#define MOD 10000
#define rep(i,n)for(int i=0;i<n;i++)
using namespace std;

int dp[502][2][10][500][3], m, len[2];
char S[2][550];
int solve(int o) {
	memset(dp, 0, sizeof(dp));
	dp[0][0][0][0][0] = 1;
	rep(i, len[o])rep(j, 2)rep(k, 10)rep(l, m)rep(d, 3) {
		if (dp[i][j][k][l][d] == 0)continue;
		int s, g, p = S[o][i] - '0';
		if (d == 1)s = k + 1, g = (j ? 9 : p);
		else if (d == 2)s = 0, g = (j ? k - 1 : min(k - 1, p));
		else s = 0, g = (j ? 9 : p);
		for (int x = s; x <= g; x++) {
			if (x&&k == x)continue;
			int y;
			if (d == 1)y = 2;
			else if (d == 2)y = 1;
			else {
				if (k == 0)y = 0;
				else if (x < k)y = 1;
				else y = 2;
			}
			(dp[i + 1][j || x < p][x][(l * 10 + x) % m][y] += dp[i][j][k][l][d]) %= MOD;
		}
	}
	int sum = 0;
	rep(i, 2)rep(j, 10)rep(t, 3) {
		if (!i && !o)continue;
		(sum += dp[len[o]][i][j][0][t]) %= MOD;
	}
	return sum;
}
int main() {
	scanf("%s%s%d", S[0], S[1], &m);
	rep(i, 2)len[i] = strlen(S[i]);
	printf("%d\n", (solve(1) + MOD - solve(0)) % MOD);
}