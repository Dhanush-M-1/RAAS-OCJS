#include<iostream>
#include<algorithm>
#include<vector>
#include<cstdio>
#include<list>
#include<queue>
#include<string.h>
#include<functional>
#include<stack>
#include<deque>
#include<string>
#include<limits.h>
#include<map>
#include<set>
#include<unordered_map>
#include<unordered_set>
#define mod 10000 
using namespace std;

int dp[10][505][2][2][501][2];
/*
i?????????A
???i?????????????????????
A????????§???????????????
B???????°?????????????
M??§?????£????????????
????????£????????????????????£?????????
*/
int A[505], B[505];
signed main() {
	int ans = 10000;
	string a, b; int m; cin >> a >> b >> m;
	if (a.length() == 1) {
		for (int j = 1; j <= 9; j++) {
			if (j >= a[0] - '0'&&j%m == 0)ans--;
		}
	}
	while (a.length() < b.length()) {
		a = '0' + a;
	}
	for (int i = 0; i < a.length(); i++) {
		A[i] = a[i] - '0';
		B[i] = b[i] - '0';
	}
	int S = 0, G = 0;
	for (int i = 0; i < a.length(); i++) {
		if (S <= 10)S = S * 10 + A[i];
		if (G <= 10)G = G * 10 + B[i];
		//i?????????????§???????
		for (int j = 1; j <= 9; j++) {
			if (j == S) {
				if (j == G) {
					dp[j][i][0][0][j%m][0]++;
					dp[j][i][0][0][j%m][1]++;
				}
				else if (j < G) {
					dp[j][i][0][1][j%m][0]++;
					dp[j][i][0][1][j%m][1]++;
				}
			}
			else if (j > S) {
				if (j == G) {
					dp[j][i][1][0][j%m][0]++;
					dp[j][i][1][0][j%m][1]++;
				}
				else if (j < G) {
					dp[j][i][1][1][j%m][0]++;
					dp[j][i][1][1][j%m][1]++;
				}
			}
		}
		for (int j = 0; j < m; j++) {
			for (int k = 0; k <= 9; k++) {//????????°
				for (int l = 0; l <= 9; l++) {//???????????°
					dp[k][i][0][0][j][0] %= mod;
					dp[k][i][0][0][j][1] %= mod;
					dp[k][i][0][1][j][0] %= mod;
					dp[k][i][0][1][j][1] %= mod;
					dp[k][i][1][0][j][0] %= mod;
					dp[k][i][1][0][j][1] %= mod;
					dp[k][i][1][1][j][0] %= mod;
					dp[k][i][1][1][j][1] %= mod;
					if (k == l)continue;
					if (l > A[i+1]) {
						if (l > B[i+1]) {
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][0][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
						}
						else if (l == B[i + 1]) {
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][0][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
							dp[l][i + 1][1][0][(j * 10 + l) % m][k < l] += dp[k][i][0][0][j][k > l];
							dp[l][i + 1][1][0][(j * 10 + l) % m][k < l] += dp[k][i][1][0][j][k > l];
						}
						else
						{
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][0][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][0][0][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][0][j][k > l];
						}
					}
					else if (l == A[i + 1]) {
						if (l > B[i + 1]) {
							
							dp[l][i + 1][0][1][(j * 10 + l) % m][k < l] += dp[k][i][0][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
						}
						else if (l == B[i + 1]) {
							
							dp[l][i + 1][0][1][(j * 10 + l) % m][k < l] += dp[k][i][0][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
							dp[l][i + 1][0][0][(j * 10 + l) % m][k < l] += dp[k][i][0][0][j][k > l];
							dp[l][i + 1][1][0][(j * 10 + l) % m][k < l] += dp[k][i][1][0][j][k > l];
						}
						else
						{
							dp[l][i + 1][0][1][(j * 10 + l) % m][k < l] += dp[k][i][0][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
							dp[l][i + 1][0][1][(j * 10 + l) % m][k < l] += dp[k][i][0][0][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][0][j][k > l];
						}
					}
					else
					{
						if (l > B[i + 1]) {
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
						}
						else if (l == B[i + 1]) {
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
							dp[l][i + 1][1][0][(j * 10 + l) % m][k < l] += dp[k][i][1][0][j][k > l];
						}
						else
						{
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][1][j][k > l];
							dp[l][i + 1][1][1][(j * 10 + l) % m][k < l] += dp[k][i][1][0][j][k > l];
						}
					}
				}
			}
		}
	}
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			for (int l = 0; l < 2; l++) {
				for (int n = 0; n <= 9; n++) {
					ans += dp[n][a.length() - 1][i][j][0][l];
					ans %= mod;
				}
			}
		}
	}
	cout << ans << endl;
}