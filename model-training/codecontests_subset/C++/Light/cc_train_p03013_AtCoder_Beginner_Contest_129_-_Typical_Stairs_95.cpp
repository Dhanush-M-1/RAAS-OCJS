#include <bits/stdc++.h>
using namespace std;
int main()
  {int N, M; cin >> N >> M;
  vector<bool> bs(N + 2);
  while (M--)
    {int a; cin >> a;
    bs[a] = true;}
  vector<long long> dp(N + 2);
  dp[0] = 1;
  for (int i = 0; i < N; ++i)
    {for (int j = 1; j <= 2; ++j)
      {if (!bs[i + j]) dp[i + j] = (dp[i + j] + dp[i]) % 1000000007;}}
  cout << dp[N] << endl;}