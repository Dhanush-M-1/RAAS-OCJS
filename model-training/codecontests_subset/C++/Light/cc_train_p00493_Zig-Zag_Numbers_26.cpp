#include <iostream>
#include <string>
#define int long long
#define MOD 10000
using namespace std;

int m;
int dp[510][500][10][4][2] = {};//keta,mod,prevnum,UorDorNoorZero,limit

int calc(string s){
	for(int i = 0;i <= s.length();i++){
		for(int j = 0;j < m;j++){
			for(int k = 0;k < 10;k++){
				for(int l = 0;l < 4;l++){
					for(int o = 0;o < 2;o++) dp[i][j][k][l][o] = 0;
				}
			}
		}
	}
	dp[0][0][0][3][1] = 1;
	for(int i = 0;i < s.length();i++){
		for(int j = 0;j < m;j++){
			for(int k = 0;k < 10;k++){
				for(int l = 0;l < 10;l++){
					if(k < l){
						(dp[i + 1][(j * 10 + l) % m][l][0][0] += dp[i][j][k][1][0] + dp[i][j][k][2][0]) %= MOD;
						if(l < s[i] - '0') (dp[i + 1][(j * 10 + l) % m][l][0][0] += dp[i][j][k][1][1] + dp[i][j][k][2][1]) %= MOD;
						else if(l == s[i] - '0') (dp[i + 1][(j * 10 + l) % m][l][0][1] += dp[i][j][k][1][1] + dp[i][j][k][2][1]) %= MOD;
					}
					else if(k > l){
						(dp[i + 1][(j * 10 + l) % m][l][1][0] += dp[i][j][k][0][0] + dp[i][j][k][2][0]) %= MOD;
						if(l < s[i] - '0') (dp[i + 1][(j * 10 + l) % m][l][1][0] += dp[i][j][k][0][1] + dp[i][j][k][2][1]) %= MOD;
						else if(l == s[i] - '0') (dp[i + 1][(j * 10 + l) % m][l][1][1] += dp[i][j][k][0][1] + dp[i][j][k][2][1]) %= MOD;
					}
					if(!k){
						if(!l) (dp[i + 1][j][0][3][0] += dp[i][j][k][3][0] + dp[i][j][k][3][1]) %= MOD;
						else{
							(dp[i + 1][(j * 10 + l) % m][l][2][0] += dp[i][j][k][3][0]) %= MOD;
							if(l < s[i] - '0') (dp[i + 1][(j * 10 + l) % m][l][2][0] += dp[i][j][k][3][1]) %= MOD;
							else if(l == s[i] - '0') (dp[i + 1][(j * 10 + l) % m][l][2][1] += dp[i][j][k][3][1]) %= MOD;
						}
					}
				}
			}
		}
	}
	int ans = 0;
	for(int i = 0;i < 10;i++){
		for(int j = 0;j < 3;j++){
			for(int k = 0;k < 2;k++){
				ans = (ans + dp[s.length()][0][i][j][k]) % MOD;
			}
		}
	}
	return ans;
}

signed main(){
	string a,b;
	cin >> a >> b >> m;
	for(int i = a.length() - 1;i >= 0;i--){
		if(a[i] != '0'){
			a[i]--;
			if(!i && a[i] == '0') a = a.substr(1,a.length() - 1);
			break;
		}
		a[i] = '9';
	}
	//cout << calc(b) << endl;
	cout << (calc(b) - calc(a) + MOD) % MOD << endl;
	return 0;
}