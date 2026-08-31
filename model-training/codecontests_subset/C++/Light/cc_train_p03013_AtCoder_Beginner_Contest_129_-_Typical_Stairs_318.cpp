#include<bits/stdc++.h>
using namespace std;
int main(){
  int N, M;
  cin >> N >> M;
  vector<int> dp(N+1, true);
  int tmp;
  for (int i = 0; i < M; i++){
    cin >> tmp;
    dp[tmp] = false;
  }
  for (int i = 2; i <= N; i++){
    if (dp[i] == false)
      continue;
    dp[i] = dp[i-1] + dp[i-2];
    dp[i] %= 1000000007;
  }
  cout << dp[N] << endl;
  return 0;
}