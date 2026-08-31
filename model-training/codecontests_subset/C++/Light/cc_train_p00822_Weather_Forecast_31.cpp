#include <bits/stdc++.h>
#define rep(i,n) for(int i = 0; i < n; i++)
#define INF 100000000
#define EPS 1e-10
#define MOD 1000000007
using namespace std;
typedef pair<int,int> P;

int n;
int f[4][4];
bool dp[400][3][3][7][7][7][7];

void solve(){
	rep(i,400) rep(j1,3) rep(j2,3) rep(k1,7) rep(k2,7) rep(k3,7) rep(k4,7) dp[i][j1][j2][k1][k2][k3][k4] = false;
	bool ok = true;
	rep(i,n){
		rep(j,4) rep(k,4) cin >> f[j][k];
		if(!ok) continue;
		if(i == 0){
			if(f[1][1]+f[1][2]+f[2][1]+f[2][2] > 0){
				ok = false;
				continue;
			}
			dp[0][1][1][1][1][1][1] = true;
			continue;
		}
		rep(j,3) rep(k,3){
			if(f[j][k]+f[j+1][k]+f[j][k+1]+f[j+1][k+1] > 0) continue;
			rep(j1,3) rep(k1,3){
				if(abs(j1-j)>0 && abs(k1-k)>0) continue;
				rep(l1,7) rep(l2,7) rep(l3,7) rep(l4,7){
					if(j==0&&k==0){
						if(l2 == 0 || l3 == 0 || l4 == 0) continue;
						rep(x,7) dp[i][j][k][0][l2][l3][l4] |= dp[i-1][j1][k1][x][l2-1][l3-1][l4-1];
					} else if(j==0&&k==2){
						if(l1 == 0 || l3 == 0 || l4 == 0) continue;
						rep(x,7) dp[i][j][k][l1][0][l3][l4] |= dp[i-1][j1][k1][l1-1][x][l3-1][l4-1];
					} else if(j==2&&k==0){
						if(l1 == 0 || l2 == 0 || l4 == 0) continue;
						rep(x,7) dp[i][j][k][l1][l2][0][l4] |= dp[i-1][j1][k1][l1-1][l2-1][x][l4-1];
					} else if(j==2&&k==2){
						if(l1 == 0 || l2 == 0 || l3 == 0) continue;
						rep(x,7) dp[i][j][k][l1][l2][l3][0] |= dp[i-1][j1][k1][l1-1][l2-1][l3-1][x];
					}else {
						if(l1 == 0 || l2 == 0 || l3 == 0 || l4 == 0) continue;
						dp[i][j][k][l1][l2][l3][l4] |= dp[i-1][j1][k1][l1-1][l2-1][l3-1][l4-1];
					}
				}
			}
		}
		bool yes = false;
		rep(j,3) rep(k,3) rep(l1,7) rep(l2,7) rep(l3,7) rep(l4,7) if(dp[i][j][k][l1][l2][l3][l4]) yes = true;
		if(!yes){
			ok = false;
			continue;
		}
	}
	if(!ok) puts("0");
	else puts("1");
}

int main(){
	while(cin >> n){
		if(n == 0) break;
		solve();
	}
}