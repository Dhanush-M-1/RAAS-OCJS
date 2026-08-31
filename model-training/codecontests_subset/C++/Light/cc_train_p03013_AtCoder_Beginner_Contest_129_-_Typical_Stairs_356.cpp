#include <bits/stdc++.h>
using namespace std;

int N,M;
using ll=long long;
ll dp[100010];
const int MOD=1000000007;

int main(){
  cin >> N >> M;
  set<int> S;
  for(int i=0;i<M;i++){
    int x;
    cin >> x;
    S.insert(x);
  }
  dp[0]=1;
  for(int i=0;i<N;i++){
    if (S.count(i)) continue;
    dp[i+2]=(dp[i+2]+dp[i])%MOD;
    dp[i+1]=(dp[i+1]+dp[i])%MOD;
  }
  
  cout << dp[N] << endl;
}