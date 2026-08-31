#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,n) FOR(i,0,n)

int dp[501][10][500][2][3];
string str;
string a, b;
int m;

int dfs(int keta, int num, int mod, bool free, int state) {
	if (keta == str.size()) return mod == 0;
	if (dp[keta][num][mod][free][state] != -1) return dp[keta][num][mod][free][state];
	
	int res = 0;
	
	switch (state) {
		case 0: // next up
			FOR(i, num + 1, free ? 10 : str[keta] + 1)
				res += dfs(keta + 1, i, (mod * 10 + i) % m, free | (!free && str[keta] != i), 1);
			break;
			
		case 1: // next down
			REP(i, free ? num : min(num, str[keta] + 1))
				res += dfs(keta + 1, i, (mod * 10 + i) % m, free | (!free && str[keta] != i), 0);
			break;
				
		case 2: // now zero
			if (keta == str.size() - 1) return (free ? 9 : str[keta]) / m;
			else res += dfs(keta + 1, 0, 0, true, 2);
			
			FOR(i, 1, free ? 10 : str[keta] + 1) {
				res += dfs(keta + 1, i, i % m, free | (!free && str[keta] != i), 0);
				res += dfs(keta + 1, i, i % m, free | (!free && str[keta] != i), 1);
			}
			
			break;
	}
	
	return dp[keta][num][mod][free][state] = res % 10000;
}

int solve() {
	fill(dp[0][0][0][0], dp[501][0][0][0], -1);
	REP(i, str.size()) str[i] -= '0';
	int res = dfs(0, 0, 0, false, 2);
	
	return res;
}

int main() {
	cin >> a >> b >> m;
	
	for (int i = a.size() - 1; i >= 0; i--) {
		if (a[i] == '0') a[i] = '9';
		else {
			a[i]--;
			break;
		}
	}
	if (a != "0" && a[0] == '0') a.erase(a.begin());
	
	str = a;
	int na = solve();
	
	str = b;
	int nb = solve();
	
	cout << (nb - na + 10000) % 10000 << endl;
	
	return 0;
}