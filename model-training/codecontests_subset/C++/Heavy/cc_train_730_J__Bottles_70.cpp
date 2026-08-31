#include <bits/stdc++.h>
using namespace std;
uint64_t gcd(uint64_t a, uint64_t b) { return b ? gcd(b, a % b) : a; }
bool cmp(pair<int16_t, int16_t> &a, pair<int16_t, int16_t> &b) {
  return a.second > b.second;
}
int16_t dp[101][10001][101];
int main(int argc, char *argv[]) {
  ios_base::sync_with_stdio(false);
  ifstream in("input.txt");
  ofstream out("output.txt");
  int16_t n, a, b, remaining = 0, available = 0, maxSum = 0, minK = 0;
  for (int32_t i = 0; i < 101; ++i)
    for (int32_t j = 0; j < 10001; ++j)
      for (int32_t k = 0; k < 101; ++k)
        if (k == 0 && j == 0)
          dp[i][j][k] = 0;
        else
          dp[i][j][k] = -1;
  cin >> n;
  vector<pair<int16_t, int16_t>> bottles(n);
  for (int32_t i = 0; i < n; ++i) {
    cin >> a;
    bottles[i].first = a;
    remaining += a;
  }
  for (int32_t i = 0; i < n; ++i) {
    cin >> b;
    bottles[i].second = b;
    available += b;
  }
  sort(bottles.begin(), bottles.end(), cmp);
  int32_t temp = remaining, i = 0;
  for (; i < n && temp > 0; ++i) {
    temp -= bottles[i].second;
    ++minK;
  }
  dp[1][bottles[0].second][1] = bottles[0].first;
  for (int32_t i = 2; i <= n; ++i) {
    for (int32_t j = 1; j <= available; ++j)
      for (int32_t k = 1; k <= i; ++k) {
        dp[i][j][k] = dp[i - 1][j][k];
        if (j - bottles[i - 1].second >= 0 &&
            dp[i - 1][j - bottles[i - 1].second][k - 1] != -1)
          dp[i][j][k] = max<int16_t>(
              dp[i][j][k], dp[i - 1][j - bottles[i - 1].second][k - 1] +
                               bottles[i - 1].first);
      }
  }
  for (int32_t j = remaining; j <= available; ++j)
    maxSum = max(dp[n][j][minK], maxSum);
  cout << minK << " " << remaining - maxSum;
  return 0;
}
