#include<bits/stdc++.h>
using namespace std;
#define MOD (1000000007)
int main(){
  #define int long
  int n,m,a=-1;
  cin>>n>>m;
  vector<int> dp(n+1,0);
  dp[0]=1;
  for(int i=1;i<=n;++i){
    if(a==-1)cin>>a;
    if(i==a){
      dp[a]=-1;
      a=-1;
    }
    else{
      dp[i]=((i-1>=0&&dp[i-1]>=0?dp[i-1]:0)%MOD+(i-2>=0&&dp[i-2]>=0?dp[i-2]:0)%MOD)%MOD;
    }
  }
  cout<<dp[n];
}