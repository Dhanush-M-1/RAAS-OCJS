#include<iostream>

using namespace std;

const int MAX_N=1e5+5;
const int MOD=1e9+7;
int a[MAX_N];
int dp[MAX_N];
int main(){
  int n,m;
  cin>>n>>m;
  for(int i=0;i<m;i++)cin>>a[i];
  int cnt=0;
  dp[0]=1;
  for(int i=1;i<=n;i++){
    if(a[cnt]==i){
      cnt++;
      continue;
    }
    else{
      if(i>1)dp[i]=(dp[i-1]+dp[i-2])%MOD;
      else dp[i]=1;
    }
  }
  cout<<dp[n]<<endl;
}
