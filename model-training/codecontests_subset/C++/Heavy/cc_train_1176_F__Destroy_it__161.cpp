#include <bits/stdc++.h>
using namespace std;
const int Maxn = 200005;
int n, len[Maxn];
long long ans;
vector<long long> a[Maxn][4];
long long dp[Maxn][10], f[4][2];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", len + i);
    for (int j = 0; j < len[i]; ++j) {
      int x;
      long long y;
      scanf("%d %lld", &x, &y);
      a[i][x].push_back(y);
    }
    for (int j = 1; j < 4; ++j) {
      sort(a[i][j].rbegin(), a[i][j].rend());
      while ((int)a[i][j].size() * j > 3) a[i][j].pop_back();
    }
  }
  memset(dp, -63, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    memset(f, -63, sizeof(f));
    f[0][0] = 0;
    vector<pair<int, long long> > b;
    for (int j = 1; j < 4; ++j)
      for (auto &x : a[i][j]) b.push_back({j, x});
    sort(b.begin(), b.end());
    do {
      int cost = 0, cnt = 0;
      long long mx = 0, now = 0;
      for (auto &[t, c] : b) {
        cnt++, cost += t;
        if (cost > 3) break;
        mx = max(mx, c), now += c;
        f[cnt][0] = max(f[cnt][0], now);
        f[cnt][1] = max(f[cnt][1], now + mx);
      }
    } while (next_permutation(b.begin(), b.end()));
    for (int j = 0; j < 10; ++j)
      for (int k = 0; k <= 3; ++k) {
        bool flag = j + k >= 10;
        long long now = dp[i - 1][j] + f[k][flag];
        dp[i][(j + k) % 10] = max(dp[i][(j + k) % 10], now);
      }
  }
  for (int i = n; ~i; --i)
    for (int j = 9; ~j; --j) ans = max(ans, dp[i][j]);
  printf("%lld\n", ans);
  return 0;
}
