#include <bits/stdc++.h>
using namespace std;

#define MOD 1000000007

int N, M;
long long dp[100005];
bool a[100005];

int main() {
  cin >> N >> M;
  for (int i = 0; i < M; i++) {
    int b;
    cin >> b;
    a[b] = true;
  }

  dp[0] = 1;
  dp[1] = (!a[1]) ? 1 : 0;

  for (int i = 2; i <= N; i++) {
    if (!a[i]) dp[i] = (dp[i-1] + dp[i-2]) % MOD;
  }

  cout << dp[N] << endl;
}
