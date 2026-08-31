#include <bits/stdc++.h>
using namespace std;

int main() {
  int n,m;
  cin >>n >>m;
  
  vector<int>broken(n+1);
  
  for(int i=0; i<m; i++){
    int a;
    cin >>a;
    broken[a]=1;
  }
  
  vector<int>dp(n+2);
  dp[n]=1;
  
  int x=1000000007;
  
  for(int i=n-1; i>=0; i--){
    if(broken[i]==1){
      dp[i]=0;
      continue;
    }
    dp[i]=(dp[i+1]+dp[i+2])%x;
  }
  cout <<dp[0] <<endl;
}
    