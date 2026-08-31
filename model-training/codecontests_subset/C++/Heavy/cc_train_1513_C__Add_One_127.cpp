#include<bits/stdc++.h>
#define mp make_pair
#define s second
#define pb push_back
#define eb emplace_back
#define all(v) v.begin(),v.end()
#define mx(a,b) a>b?a:b
#define mn(a,b) a<b?a:b
using namespace std;
const int maxn = 5+2e5;
typedef long long ll;
const int mod = 1e9+7; 
int dp[maxn];
int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);
	int t;
	cin >> t;
	for(int i = 0;i < 9;i++)dp[i] = 2;
	dp[9] = 3;
	for(int i = 10;i < maxn;i++){
		dp[i] = (dp[i-9] + dp[i-10]) % mod;
	}
	while(t--){
		ll sol = 0;
		string k;
		int m;
		cin >> k >> m;
		for(auto i: k){
			if(m + (int)(i-'0') < 10)sol++;
			else sol += dp[m-10+(int)(i-'0')];
			sol %= mod;
		}
		cout << sol << "\n";

	}
}