#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int P=1e9+7;

int main(){
  int N,M;
  cin >> N >> M;
  set<int> A;
  for(int i=0;i<M;i++){
    int a;
    cin >> a;
    A.insert(a);
  }
  vector<int> dp(100005,0);
  dp[0]=1;
  for(int i=0;i<=N;i++){
    if(!A.count(i)){
      dp[i+1]=(dp[i+1]+dp[i])%P;
      dp[i+2]=(dp[i+2]+dp[i])%P;
    }
  }
  cout << dp[N] << endl;
}