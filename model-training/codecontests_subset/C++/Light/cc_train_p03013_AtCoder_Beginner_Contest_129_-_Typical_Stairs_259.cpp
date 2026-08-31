#include <bits/stdc++.h>
using namespace std;
int main()
  {int N, M; cin >> N >> M;
  vector<bool> bs(N);
  while (M--) {int a; cin >> a; bs[--a] = true;}
  vector<int64_t> dp(N + 1); dp[0] = 1;
  for (int i = 0; i < N; ++i) if (!bs[i]) dp[i + 1] = (dp[i] + (i >= 1 ? dp[i - 1] : 0)) % 1000000007;
  cout << dp[N] << endl;}