#include <bits/stdc++.h>
using namespace std;
int f(int x){
  string S = to_string(x);
  int N = S.size();
  int ans = 0;
  for (int i = 1; i < N; i++){
    ans = max(ans, stoi(S.substr(0, i)) * stoi(S.substr(i)));
  }
  return ans;
}
int main(){
  vector<int> r(1000001, 0);
  for (int i = 10; i <= 1000000; i++){
    r[i] = r[f(i)] + 1;
  }
  int Q;
  cin >> Q;
  for (int i = 0; i < Q; i++){
    int N;
    cin >> N;
    cout << r[N] << endl;
  }
}
