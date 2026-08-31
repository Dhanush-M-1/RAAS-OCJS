#include<iostream>
#include<string>
#include<cstdio>
#include<vector>
#include<cmath>
#include<algorithm>
#include<functional>
#include<iomanip>
#include<queue>
#include<ciso646>
#include<random>
#include<map>
#include<set>
#include<complex>
#include<bitset>
#include<stack>
#include<unordered_map>
using namespace std;
typedef long long ll;
typedef unsigned int ui;
const ll mod = 1000000007;
const ll INF = (ll)1000000007 * 1000000007;
typedef pair<int, int> P;
#define stop char nyaa;cin>>nyaa;
#define rep(i,n) for(int i=0;i<n;i++)
#define per(i,n) for(int i=n-1;i>=0;i--)
#define Rep(i,sta,n) for(int i=sta;i<n;i++)
#define rep1(i,n) for(int i=1;i<=n;i++)
#define per1(i,n) for(int i=n;i>=1;i--)
#define Rep1(i,sta,n) for(int i=sta;i<=n;i++)
typedef long double ld;
typedef complex<ld> Point;
const ld eps = 1e-8;
const ld pi = acos(-1.0);
typedef pair<ll, ll> LP;
typedef pair<ld, ld> LDP;
//i日目で、雲がj番目で、最後に〇〇を訪れたのは〇日前
int memo[365][9][7][7][7][7];
int dx[4] = { 0,0,1,1 };
int dy[4] = { 0,1,0,1 };
void init() {
	rep(i, 365) {
		rep(j, 9) {
			rep(k, 7) {
				rep(l, 7) {
					rep(m,7) {
						rep(n,7) {
							memo[i][j][k][l][m][n] = 0;
						}
					}
				}
			}
		}
	}
}
bool check(int k, int a[16]) {
	int x = k / 3; int y = k % 3;
	rep(i, 4) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (a[nx*4+ny])return false;
	}
	return true;
}
int rained(int k) {
	if (k == 0)return 1;
	else if (k == 2)return 2;
	else if (k == 6)return 3;
	else if (k == 8)return 4;
	return 0;
}
bool validroute(int i, int j) {
	int x1 = i / 3; int x2 = j / 3;
	int y1 = i % 3; int y2 = j % 3;
	if (x1 == x2 || y1 == y2)return true;
	return false;
}
int main(){
	int n;
	while (cin >> n, n) {
		init();
		int a[16];
		rep(i, 16) {
			cin >> a[i];
		}
		bool pass = false;
		if (!check(4, a)) {
			cout << 0 << endl;
			pass = true;
		}
		memo[0][4][1][1][1][1] = 1;
		rep(i, n - 1) {
			rep(j, 16) {
				cin >> a[j];
			}
			if (pass)continue;
			rep(j, 9) {
				rep(k, 9) {
					if (!validroute(j, k))continue;
					if (!check(k, a))continue;
					rep(k1, 7) {
						rep(k2, 7) {
							rep(k3, 7) {
								rep(k4, 7) {
									if (!memo[i][j][k1][k2][k3][k4])continue;
									int nex[4] = { k1 + 1,k2 + 1,k3 + 1,k4 + 1 };
									int ch = rained(k);
									if (ch > 0) {
										nex[ch - 1] = 0;
									}
									bool cannex = true;
									rep(aa, 4) {
										if (nex[aa] == 7)cannex = false;
									}
									if (cannex) {
										memo[i+1][k][nex[0]][nex[1]][nex[2]][nex[3]] = 1;
									}
								}
							}
						}
					}
				}
			}
		}
		if (pass)continue;
		int ans = 0;
		rep(j, 9) {
			rep(k1, 7) {
				rep(k2, 7) {
					rep(k3, 7) {
						rep(k4, 7) {
							if (memo[n - 1][j][k1][k2][k3][k4])ans = 1;
						}
					}
				}
			}
		}
		cout << ans << endl;
	}
	return 0;
}
