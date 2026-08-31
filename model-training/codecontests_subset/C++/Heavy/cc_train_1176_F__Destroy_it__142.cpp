#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 100, M = 10, inF = 1e17;
long long n, k, c, d, dp[N][M];
vector<long long> vec[M];
vector<pair<long long, long long> > help;
void _max(long long &a, long long b) { a = max(a, b); }
int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  cin >> n;
  for (int i = 0; i < N; i++) fill(dp[i], dp[i] + M, -inF);
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 3; j++) vec[j].clear();
    cin >> k;
    while (k--) {
      cin >> c >> d;
      vec[c].push_back(d);
    }
    help.clear();
    for (int j = 1; j <= 3; j++) {
      sort(vec[j].begin(), vec[j].end());
      for (int dex = 0; dex < (int)vec[j].size() && (dex + 1) * j <= 3; dex++)
        help.push_back(
            pair<long long, long long>(j, vec[j][vec[j].size() - dex - 1]));
    }
    for (int mask = 0; mask < (1 << help.size()); mask++) {
      long long s = 0, maxi = 0, used = 0, cnt = 0;
      for (int i = 0; i < help.size(); i++)
        if (mask & (1 << i))
          s += help[i].second, maxi = max(maxi, help[i].second),
                               used += help[i].first, cnt++;
      if (used > 3) continue;
      for (int j = 0; j < M; j++)
        if (j + cnt >= M)
          _max(dp[i + 1][(j + cnt) - M], dp[i][j] + s + maxi);
        else
          _max(dp[i + 1][j + cnt], dp[i][j] + s);
    }
  }
  cout << *max_element(dp[n], dp[n] + M);
  return 0;
}
