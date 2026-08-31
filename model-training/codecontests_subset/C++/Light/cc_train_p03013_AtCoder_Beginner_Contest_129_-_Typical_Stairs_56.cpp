#include <bits/stdc++.h>
using namespace std;

int main() {
  int n,m;
  cin>>n>>m;
  vector<int> a(m);
  
  vector<long long> dp(n+100);
  vector<bool> dd(n+100,true);
  for(int i=0;i<m;i++){
    cin>>a[i];
    dd[a[i]]=false;
  }
  dp[0]=1;
  if(dd[1]) dp[1]=1;
  else dp[1]=0;
  for(int i=1;i<n+3;i++){
    if(dd[i+1]) dp[i+1]=dp[i]+dp[i-1];
    dp[i+1]%=(1000000000+7);
  }
  cout<<dp[n]<<endl;
}
  
