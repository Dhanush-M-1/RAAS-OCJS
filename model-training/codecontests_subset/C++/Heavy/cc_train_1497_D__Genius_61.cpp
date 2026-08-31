#include<bits/stdc++.h>
using namespace std;
#define fast ios_base::sync_with_stdio(false),cin.tie(nullptr),cout.tie(nullptr);
#define int long long
int32_t main(){
	fast;
	int t;
	cin >> t;
	while(t--){
		int n;
		cin >> n;
		vector<int> tag(n);
		vector<int> s(n);
		for(int i = 0; i < n; i++)cin >> tag[i];
		for(int i = 0; i < n; i++)cin >> s[i];

		vector<int> dp(n + 1,0);
		int ans = -1;
		for(int j = 1; j < n; j++){
			for(int i = j - 1; i >= 0; i--){
				if(tag[i] != tag[j]){
					int p = abs(s[i] - s[j]);
					int xx = dp[i];
					int yy = dp[j];
					dp[j] = max(dp[j], xx + p);
					dp[i] = max(dp[i] , yy + p);
					ans = max(ans, max(dp[i],dp[j]));
				}
			}
		}
		// for(auto it : dp){
		// 	cout << it << " ";
		// }
		// cout << '\n';
		cout << ((ans == -1) ? 0 : ans) << '\n';
	}
}