#include <bits/stdc++.h>
using namespace std;
int main()
  {int N, M; cin >> N >> M;
  vector<bool> bs(N + 1);
  while (M--)
    {int a; cin >> a;
    bs[a] = true;}
  vector<long long> dp(N + 1);
  dp[0] = 1;
  for (int i = 1; i <= N; ++i)
    {if (!bs[i]) dp[i] = (dp[i - 1] + (i < 2 ? 0 : dp[i - 2])) % 1000000007;}
  cout << dp[N] << endl;}