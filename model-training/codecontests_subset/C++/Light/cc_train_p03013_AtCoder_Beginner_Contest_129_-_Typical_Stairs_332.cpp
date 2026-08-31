#include <iostream>
#include <set>
using namespace std;
long long dp[100010],mod = 1000000007;
set<int> s;
int main(){
	int i,n,m;
	cin >> n >> m;
	for(i=0;i<m;i++){
		int a; cin >> a;
		s.insert(a);
	}
	dp[0] = 1;
	for(i=0;i<=n;i++){
		if(s.count(i)) dp[i] = 0;
		(dp[i+1] += dp[i]) %= mod;
		(dp[i+2] += dp[i]) %= mod;
	}
	cout << dp[n] << endl;
}