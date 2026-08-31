#include<bits/stdc++.h>
using namespace std;
const long long mod=1e9+7;

int main(){
  int n,m; cin>>n >>m;
  vector<bool>k(n+1,true);
  vector<long long int>dp(n+2);dp[0]=1;
  for(int i=0;i<m;i++){
    int a; cin>>a;
    k[a]=false;
  }
  for(int i=0;i<n;i++){
    if(k[i]){
      dp[i+1]+=dp[i];
      dp[i+1]%=mod;
      dp[i+2]+=dp[i];
      dp[i+2]%=mod;
    }
  }
  cout<<dp[n]<<endl;
}