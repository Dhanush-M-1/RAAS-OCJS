#include<bits/stdc++.h>
using namespace std;

int main() {
  int N;
  cin >> N;

  const int M = 300000;

  int dp[M] = {};

  for(int i = 0; i < N; ++i) {
    int a, b;
    cin >> a >> b;
    ++dp[a + b];
  }

  for(int i = 0; i < M - 1; ++i) {
    if(dp[i] & 1) cout << i << " " << 0 << endl;
    dp[i + 1] += dp[i] / 2;
  }
}