#include<iostream>
#include<algorithm>
using namespace std;
int n,m,dp[100001],a[100001],b;
int main() {
  cin >> n >> m;
  for(int i=0; i<m; i++) {
    cin >> b;
    a[b]=1;
  }
  dp[0]=1;
  for(int i=1; i<=n; i++) {
    if(a[i-1]==0) {
      dp[i]+=dp[i-1];
    }
    if(a[i-2]==0) {
      dp[i]+=dp[i-2];
    }
    dp[i]%=1000000007;
  }
  cout << dp[n] << '\n';
}