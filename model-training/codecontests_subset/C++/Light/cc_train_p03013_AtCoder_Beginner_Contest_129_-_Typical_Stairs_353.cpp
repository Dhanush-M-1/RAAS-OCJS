#include <bits/stdc++.h>
using namespace std;
int main(){
  int N, M;
  cin >> N >> M;
  vector<long long>A(N+1, 1);
  for(int i=0; i<M; i++){
    int a;
    cin >> a;
    A[a]=0;
  }
  for(int i=0; i<N-1; i++){
    if(A[i+2]==0) continue;
    A[i+2]=A[i]+A[i+1];
    A[i+2]%=1000000007;
  }
  cout << A[N] << endl;
}