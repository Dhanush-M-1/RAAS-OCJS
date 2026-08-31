#include <bits/stdc++.h>
using namespace std;

int main() {
  int N,M,mod=1000000007;
  cin >> N >> M;
  vector<long long> V(N+1,-1);
  for(int i=0;i<M;i++){
    int a;
    cin >> a;
    V[a] = 0;
  }
  
  V[0] = 1;
  if(V[1]==-1) V[1] = 1;
  for(int i=2;i<=N;i++){
    if(V[i]==0) continue;
    V[i] = V[i-1] + V[i-2];
    V[i] %= mod;
  }
  
  cout << V[N] << endl;
  return 0;
}
