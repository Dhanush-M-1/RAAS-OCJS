#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const int mod=1000000007;

int main(){
  int n, m;
  cin >> n >> m;
  vector<int>dp(n+1, -1);
  dp[0]=1;
  dp[1]=1;
  for(int i=0; i<m; i++){
    int tmp;
    cin >> tmp;
    dp[tmp]=0;
  }
  for(int i=2; i<=n; i++){
    if(dp[i]==0)continue;
    dp[i]=(dp[i-2]+dp[i-1])%mod;
  }
  cout << dp[n];
  return 0;
}
