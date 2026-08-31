#include<bits/stdc++.h>
using namespace std;

int main(){
  
  int N, M, i;
  cin >> N >> M;
  vector<long long> st(N + 1, -1);
  
  st[0] = 1; st[1] = 1;
  for(i = 0; i < M; i++){
    int a;
    cin >> a;
    st[a] = 0;
  }
  
  for(i = 2; i < N + 1; i++){
    if(st[i] != 0) st[i] = (st[i - 1] + st[i - 2]) % 1000000007;
  }
  
  cout << st[N] << endl;
  return 0;
}