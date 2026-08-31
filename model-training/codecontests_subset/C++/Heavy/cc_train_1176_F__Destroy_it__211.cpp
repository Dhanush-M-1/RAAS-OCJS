#include <bits/stdc++.h>
using namespace std;
long long n;
vector<long long> g[200005][4];
long long dp[200005][11];
long long call(long long pos, long long turn) {
  if (pos == n + 1) return 0;
  if (dp[pos][turn] != -1) return dp[pos][turn];
  long long ret = 0;
  for (long long i = 0; i <= 3 and i <= g[pos][1].size(); i++) {
    for (long long j = 0; i + 2 * j <= 3 and j <= g[pos][2].size(); j++) {
      for (long long k = 0; i + 2 * j + 3 * k <= 3 and k <= g[pos][3].size();
           k++) {
        long long mx = 0;
        long long sum = 0;
        for (long long I = 0; I < i; I++)
          sum += g[pos][1][I], mx = max(mx, g[pos][1][I]);
        for (long long J = 0; J < j; J++)
          sum += g[pos][2][J], mx = max(mx, g[pos][2][J]);
        for (long long K = 0; K < k; K++)
          sum += g[pos][3][K], mx = max(mx, g[pos][3][K]);
        if (turn + i + j + k >= 10) {
          ret = max(ret, sum + mx + call(pos + 1, (turn + i + j + k) % 10));
        } else {
          ret = max(ret, sum + call(pos + 1, (turn + i + j + k) % 10));
        }
      }
    }
  }
  return dp[pos][turn] = ret;
}
int cmp(long long x, long long y) { return x > y; }
int main() {
  ios_base::sync_with_stdio(0);
  memset(dp, -1, sizeof(dp));
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long k;
    cin >> k;
    for (long long j = 1; j <= k; j++) {
      long long c, d;
      cin >> c >> d;
      g[i][c].push_back(d);
    }
  }
  for (long long i = 1; i <= n; i++) {
    for (long long j = 1; j <= 3; j++) {
      if (!g[i][j].empty()) {
        sort(g[i][j].begin(), g[i][j].end(), cmp);
      }
    }
  }
  cout << call(1, 0) << "\n";
}
