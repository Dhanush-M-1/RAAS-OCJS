#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string.h>
using namespace std;
#define endl '\n'
#define ll long long
#define pi pair<int, int>
#define f first
#define s second

const int mod = 1000000007;
const int m = 101, mxk = m * m;
int n, k, q;
int a[m], b[m], f[m], dp[mxk];

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> n;
	k = n * m;
	
	for(int i = 1; i <= n; i++) cin >> a[i];
	for(int i = 2; i <= n; i++) cin >> b[i], b[i] += b[i - 1];
	
	int s = 0x3f3f3f3f, e = 0x3f3f3f3f;
	for(int i = 1, j = 0; i <= n; i++){
		j += a[i], b[i] += b[i - 1];
		s = min(s, -b[i] / i - 1);
		e = min(e, (j - b[i]) / i + 1);
	} 
	
	for(int i = s; i <= e; i++){
		memset(dp, 0, sizeof(dp));
		dp[0] = 1;
		for(int j = 1; j <= n; j++){
			for(int l = 1; l <= k; l++) (dp[l] += dp[l - 1]) %= mod;
			for(int l = k; ~l; l--){
				(dp[l] += mod - (l < i * j + b[j] ? dp[l] : l > a[j] ? dp[l - a[j] - 1] : 0)) %= mod;
			}
		}
		for(int j = 0; j <= k; j++) (f[i - s] += dp[j]) %= mod;
	}
	
	cin >> q;
	
	while(q--){
		int x;
		cin >> x;
		x = max(s, min(e, x));
		cout << f[x - s] << endl;
	}
	
	return 0;
}