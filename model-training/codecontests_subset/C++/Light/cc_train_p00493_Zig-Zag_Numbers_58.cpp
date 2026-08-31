#include <iostream>
#include <string>
#include <algorithm>
#define llint long long
#define mod 10000

using namespace std;

string a, b;
llint m;
llint beki[505];
llint dp[505][505][10][2][2];

llint calc(string &s)
{
	int n = s.size();
	
	llint ret = 0;
	for(int i = n-1; i >= 0; i--){
		for(int j = 0; j < m; j++){
			for(int k = 0; k < 10; k++){
				for(int l = 0; l < 2; l++){
					for(int b = 0; b < 2; b++){
						dp[i][j][k][l][b] = 0;
					}
				}
			}
		}
	}
	for(int i = n-1; i >= 0; i--){
		for(int j = 1; j <= 9; j++){
			if(i == n-1 && j > s[i]-'0') continue;
			for(int k = 0; k < 2; k++){
				if(i == 0 && k == 1) continue;
				int l = 1;
				if(i == n-1 && j == s[i]-'0') l = 0;
				dp[i][(j*beki[i])%m][j][l][k] = 1;
			}
		}
	}
	for(int i = n-1; i > 0; i--){
		for(int j = 0; j < m; j++){
			for(int k = 0; k < 10; k++){
				for(int l = 0; l < 2; l++){
					for(int b = 0; b < 2; b++){
						for(int nk = 0; nk < 10; nk++){
							if(b == 0 && k >= nk) continue;
							if(b == 1 && k <= nk) continue;
							if(l == 0 && nk > s[i-1]-'0') continue;
							int nl = l;
							if(nk < s[i-1]-'0') nl = 1;
							(dp[i-1][(j+nk*beki[i-1])%m][nk][nl][1-b] += dp[i][j][k][l][b]) %= mod;
						}
					}
				}
			}
		}
	}
	for(int k = 0; k < 10; k++){
		for(int l = 0; l < 2; l++){
			for(int b = 0; b < 2; b++){
				ret += dp[0][0][k][l][b], ret %= mod;
			}
		}
	}
	
	return ret;
}

int main(void)
{
	cin >> a >> b >> m;
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());
	
	beki[0] = 1;
	for(int i = 1; i < 505; i++) beki[i] = beki[i-1] * 10 % m;
	
	llint ans = (calc(b) - calc(a) + mod) % mod;
	
	llint sum = 0;
	for(int i = 0; i < a.size(); i++) sum += beki[i]*(a[i]-'0'), sum %= m;
	
	bool flag = true;
	for(int i = 1; i < a.size()-1; i++){
		int x = a[i-1]-'0', y = a[i]-'0', z = a[i+1]-'0';
		if((y-x)*(z-y) >= 0) flag = false;
	}
	
	if(flag && sum == 0) ans++, ans %= mod;
	cout << ans << endl;
	
	return 0;
}

