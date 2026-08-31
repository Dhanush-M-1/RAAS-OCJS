#include<iostream>
using namespace std;
int main(){
  int n,m,i,j = 0;cin >> n >> m;
  int x[m];long long dp[n+1];dp[0] = 1;
  for(i=0;i<m;i++) cin >> x[i];
  for(i=1;i<=n;i++){
    if(x[j]==i){
      dp[i] = 0;j++;
    } else if(i==1) dp[i] = 1;
    else dp[i] = dp[i-2]+dp[i-1];
    dp[i] %= 1000000007;
  }
  cout << dp[n] << endl;
}