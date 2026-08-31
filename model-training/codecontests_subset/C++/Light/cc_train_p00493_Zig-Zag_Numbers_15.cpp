#include<bits/stdc++.h>
#define MOD 10000
#define INF 0x3f3f3f3f
#define INFL 0x3f3f3f3f3f3f3f3f
#define EPS (1e-10)
#define rep(i,n)for(int i=0;i<n;i++)
using namespace std;
typedef long long ll;
typedef pair<int, int>P;

int dp1[502][2][10][500][3], dp2[502][2][10][500][3], m;
void solve(int dp[][2][10][500][3], string&a) {
	dp[0][0][0][0][0] = 1;
	rep(i, a.size())rep(j, 2)rep(k, 10)rep(l, m)rep(d, 3) {
		int s, g, p = a[i] - '0';
		if (d == 1) { s = k + 1; g = (j ? 9 : p); }
		else if (d == 2) { s = 0; g = (j ? k - 1 : min(k - 1, p)); }
		else { s = 0; g = (j ? 9 : p); }
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
}
int main() {
	string a, b; cin >> a >> b >> m;
	int d = a.size() - 1;
	while (a[d] == '0') {
		a[d] = '9'; d--;
	}
	a[d]--;
	solve(dp1, a); solve(dp2, b);
	int sum1 = 0, sum2 = 0;
	rep(i, 2)rep(j, 10)rep(t, 3) {
		(sum1 += dp1[a.size()][i][j][0][t]) %= MOD;
		(sum2 += dp2[b.size()][i][j][0][t]) %= MOD;
	}
	printf("%d\n", (sum2 + MOD - sum1) % MOD);
}