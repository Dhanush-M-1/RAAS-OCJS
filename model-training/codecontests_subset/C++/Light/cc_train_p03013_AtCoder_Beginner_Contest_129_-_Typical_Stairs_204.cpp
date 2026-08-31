#include <bits/stdc++.h>
using namespace std;

long long dp[100002];

int main() {
  int n, m; cin >> n >> m;

  int a;
  for(int i=0; i<m; ++i){
    cin >> a;
    dp[a] = -1;
  }

  dp[0] = 1;
  for(int i=0; i<n; ++i){
    if(dp[i] == -1) continue;
    if(dp[i+2] != -1) dp[i+2] += dp[i] % 1000000007;
    if(dp[i+1] != -1) dp[i+1] +=  dp[i] % 1000000007;
  }

  cout << dp[n] % 1000000007 << endl;
}
