#include<bits/stdc++.h>
using namespace std;
#define mod 1000000007
long long dp[100009];
bool f[100009];

int main(){
  int n,m;
  cin>>n>>m;
  for(int i=0;i<m;i++){
    int a;
    cin>>a;
    f[a]=true;
  }
  dp[0]=1;
  if(f[1]==false)dp[1]=dp[0];
  for(int i=2;i<=n;i++){
    if(f[i]==false){
      dp[i]=dp[i-1]+dp[i-2];
      dp[i]%=mod;
    }
  }
  cout<<dp[n]<<endl;
  return(0);
}
