#include <cstring>
#include <iostream>
using namespace std;
int n, a[375][22]; bool vis[375][3][3][7][7][7][7], dp[375][3][3][7][7][7][7];
int solve(int pos, int x, int y, int d1, int d2, int d3, int d4) {
	if (pos == n) return true;
	int b = x * 4 + y;
	if (a[pos][b] || a[pos][b + 1] || a[pos][b + 4] || a[pos][b + 5]) return false;
	if (vis[pos][x][y][d1][d2][d3][d4]) return dp[pos][x][y][d1][d2][d3][d4];
	bool ret = false;
	for (int i = 0; i <= 2 && !ret; i++) {
		for (int j = 0; j <= 2 && !ret; j++) {
			if (i != x && j != y) continue;
			int nd1 = d1 + 1, nd2 = d2 + 1, nd3 = d3 + 1, nd4 = d4 + 1;
			if (i == 0 && j == 0) nd1 = 0;
			if (i == 0 && j == 2) nd2 = 0;
			if (i == 2 && j == 0) nd3 = 0;
			if (i == 2 && j == 2) nd4 = 0;
			if (nd1 < 7 && nd2 < 7 && nd3 < 7 && nd4 < 7 && solve(pos + 1, i, j, nd1, nd2, nd3, nd4)) ret = true;
		}
	}
	vis[pos][x][y][d1][d2][d3][d4] = true;
	dp[pos][x][y][d1][d2][d3][d4] = ret;
	return ret;
}
int main() {
	while (cin >> n, n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 16; j++) {
				cin >> a[i][j];
			}
		}
		memset(vis, 0, sizeof(vis));
		memset(dp, 0, sizeof(dp));
		bool ret = solve(0, 1, 1, 1, 1, 1, 1);
		cout << (ret ? 1 : 0) << endl;
	}
	return 0;
}
