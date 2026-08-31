#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int,int> P;

int mod;
int m;

int cal(string x){	
	if(x.size() == 1) return (x[0]-'0')/m + 1;
	int dp[2][600][10][2][2]; //桁数, 余り, 数字, 最大, 増減
	memset(dp,0,sizeof(dp));
	dp[0][0][0][0][0] = 1;
	int top = x[0]-'0';
	for (int i = 1;i < top;i++){
		dp[0][i%m][i][0][0] = 1;
		dp[0][i%m][i][0][1] = 1;
	}
	dp[0][top%m][top][1][0] = 1;
	dp[0][top%m][top][1][1] = 1;
	int cur = 0, next = 1;
	for (int d = 0;d < x.size()-1;d++){
		memset(dp[next],0,sizeof(dp[next]));
		for (int rem = 0;rem < m;rem++){
			for (int num = 0;num < 10;num++){
				for (int isMax = 0;isMax<2;isMax++){
					for (int isL = 0;isL<2;isL++){
						if(dp[cur][rem][num][isMax][isL] == 0) continue;
						int crt = dp[cur][rem][num][isMax][isL];
						crt %= mod;
						if(num == 0 && isL == 0){
							dp[next][0][0][0][0] += crt;
							for (int i = 1;i < 10;i++){
								dp[next][i%m][i][0][0] += crt;
								if(d != x.size()-2)dp[next][i%m][i][0][1] += crt;
							}
						}else if(isMax == 1){
							int xn = x[d+1]-'0';
							if(isL == 0){
								for (int i = num-1;i >= 0;i--){
									if(i > xn) continue;
									else if(i == xn) dp[next][(rem*10+i)%m][i][1][1] += crt;
									else dp[next][(rem*10+i)%m][i][0][1] += crt;
								}
							}else{
								for (int i = num+1;i <= xn;i++){
									if(i == xn) dp[next][(rem*10+i)%m][i][1][0] += crt;
									else dp[next][(rem*10+i)%m][i][0][0] += crt;
								}
							}
						}else if(isL == 0){
							for (int i = num-1;i >= 0;i--){
								dp[next][(rem*10+i)%m][i][0][1] += crt;
							}
						}else if(isL == 1){
							for (int i = num+1;i <= 9;i++){
								dp[next][(rem*10+i)%m][i][0][0] += crt;
							}
						}
					}
				}
			}
		}
		swap(cur,next);
	}
	int ret = 0;
	for (int i = 0;i < 10;i++){
		for (int j = 0;j < 2;j++){
			for (int k = 0;k < 2;k++){
				ret += dp[cur][0][i][j][k];
				//if(dp[cur][0][i][j][k] != 0) cout << i << " " << ret << endl;
				ret %= mod;
			}
		}
	}
	return ret;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	string  a,b; cin >> a >> b >> m;
	mod = 10000;

	bool f = false;
    
	for (int i = a.size()-1;i >= 0;i--){
		if(f && a[i] == '0'){
			a[i] = '9';
		}else if(f){
			a[i]--; break;
		}else if(a[i] == '0'){
			a[i] = '9'; f = true;
		}else{
			a[i]--; break;
		}
	}
	
	if(a[0] == '0' && a.size() >= 2){
		string c = "";
		for (int i = 0;i < a.size()-1;i++){
			c += a[i+1];
		}
		a = c;
	}


	//cout << a << endl;

	//cout << cal(a) << " " << cal(b) << endl;
	cout << (mod+cal(b) - cal(a))%mod << endl;

	return 0;

}

