#include <bits/stdc++.h>
using namespace std;

int main(){
  int N, M;
  cin >>N>>M;
  vector<int> A(M);
  vector<bool> row(N+1,1);
  for (int i=0;i<M;i++){
    cin >> A[i];
    row[A[i]] = 0;
  }
  
  vector<long long> ans(N+1,1);
  for (long long i=N-2;i>=0;i--){
    ans[i] = row[i+1]*ans[i+1] + row[i+2]*ans[i+2];
    ans[i] %= 1000000007;
  }
  cout << ans[0] << endl;
}