#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
#define endl '\n'
#define ll long long
#define pi pair<int, int>
#define f first
#define s second

const int mxn = 30005, mxk = 5;
int n, k, q;
int a[mxn], f[mxn][mxk][mxk];
ll dp[mxn][mxk], s[mxn][mxk];

void answer(){
	cin >> n >> k >> q;
	
	for(int i = 0; i < n; i++) cin >> a[i];
	
	for(int i = 0; i <= k; i++) dp[n][i] = 1, a[n + i] = n + i + 1;
	
	for(int i = n - 1; ~i; i--)
	for(int j = 0; j <= k; j++){
		dp[i][j] = 0;
		for(int l = 0; l <= j && i + l < n; l++){
			dp[i][j] += dp[i + l + 1][j - l];
		} 
	}
	
	for(int i = 0; i < n; i++)
	for(int j = 0; j <= k; j++){
		for(int l = 0; l <= j; l++) f[i][j][l] = l;
		sort(f[i][j], f[i][j] + j + 1, [&](int x, int y){
			return a[i + x] < a[i + y];
		});
	}
	
	for(int j = 0; j <= k; j++)
	for(int i = 1; i <= n; i++){
		s[i][j] = s[i - 1][j];
		for(int l = 0; l <= j && f[i - 1][j][l]; l++){
			s[i][j] += dp[i + f[i - 1][j][l]][j - f[i - 1][j][l]];
		}
	}
	
	while(q--){
		ll w, z;
		cin >> w >> z;
		w--, z--;
		
		if(z >= dp[0][k]){
			cout << -1 << endl;
			continue;
		}
		
		int x = 0, y = k, ret = 0;
		while(!ret){
			for(int i = 0; i <= y; i++){
				int v = f[x][y][i];
				if(z >= dp[x + v + 1][y - v]){
					z -= dp[x + v + 1][y - v];
				}else{
					if(v){
						if(x + v < w) x += v + 1, y -= v;
						else ret = a[2 * x + v - w];
					}else{
						int l = ++x, r = w + 2;
						while(r - l > 1){
							int mid = (l + r) / 2;
							if(s[mid][y] - s[x][y] <= z && s[mid][y] - s[x][y] + dp[mid][y] > z) l = mid;
							else r = mid;
						}	
						z -= s[l][y] - s[x][y], x = l;
						if(x > w) ret = a[w];
					}
					break;
				}
			}
		}
		
		cout << ret << endl;
	}
}

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int t;
	cin >> t;
	
	for(int i = 0; i < t; i++) answer();

	return 0;
}