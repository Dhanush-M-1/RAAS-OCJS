#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M; cin>>N>>M;
  vector<bool> stair(N+1,true);
  for(int i=0;i<M;i++){
    int a; cin>>a;
    stair[a]=false;
  }
  vector<long long> dp(N+1,0);
  dp[0]=1;
  for(int i=0;i<N;i++){
    for(int j=i+1;j<=min(N,i+2);j++){
      if(stair[j]){
        dp[j]+=dp[i];
        dp[j]%=1000000007;
      }
    }
  }cout<<dp[N]<<endl;
}