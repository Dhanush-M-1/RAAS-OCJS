#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long power(long long a, long long n) {
  a %= 1000000007;
  if (n == 1) return a;
  if (n == 0) return 1;
  if (n % 2)
    return (a * (power((a * a) % 1000000007, n / 2) % 1000000007)) % 1000000007;
  return power((a * a) % 1000000007, n / 2) % 1000000007;
}
const long long inf = (long long)1e18;
long long inverse(long long x) { return power(x, 1000000007 - 2) % 1000000007; }
long long n, dp[200005][15];
vector<long long> adj[200005][4];
long long solve2(long long pos, long long taken) {
  if (pos > n) return 0;
  long long &ans = dp[pos][taken];
  if (ans != -1) return ans;
  ans = 0;
  if (!adj[pos][3].empty()) {
    if (taken == 9)
      ans = max(ans, 2 * adj[pos][3][0] + solve2(pos + 1, 0));
    else
      ans = max(ans, adj[pos][3][0] + solve2(pos + 1, taken + 1));
  }
  if (!adj[pos][2].empty()) {
    if (taken == 9)
      ans = max(ans, 2 * adj[pos][2][0] + solve2(pos + 1, 0));
    else
      ans = max(ans, adj[pos][2][0] + solve2(pos + 1, taken + 1));
    if (!adj[pos][1].empty()) {
      if (taken >= 8)
        ans = max(ans, adj[pos][2][0] + adj[pos][1][0] +
                           max(adj[pos][2][0], adj[pos][1][0]) +
                           solve2(pos + 1, (taken + 2) % 10));
      else
        ans = max(ans,
                  adj[pos][2][0] + adj[pos][1][0] + solve2(pos + 1, taken + 2));
    }
  }
  if (!adj[pos][1].empty()) {
    if (taken == 9)
      ans = max(ans, 2 * adj[pos][1][0] + solve2(pos + 1, 0));
    else
      ans = max(ans, adj[pos][1][0] + solve2(pos + 1, taken + 1));
    if ((long long)adj[pos][1].size() > 1) {
      if (taken >= 8)
        ans = max(ans, 2 * adj[pos][1][0] + adj[pos][1][1] +
                           solve2(pos + 1, (taken + 2) % 10));
      else
        ans = max(ans,
                  adj[pos][1][0] + adj[pos][1][1] + solve2(pos + 1, taken + 2));
    }
    if ((long long)adj[pos][1].size() > 2) {
      if (taken >= 7)
        ans = max(ans, 2 * adj[pos][1][0] + adj[pos][1][1] + adj[pos][1][2] +
                           solve2(pos + 1, (taken + 3) % 10));
      else
        ans = max(ans, adj[pos][1][0] + adj[pos][1][1] + adj[pos][1][2] +
                           solve2(pos + 1, taken + 3));
    }
  }
  ans = max(ans, solve2(pos + 1, taken));
  return ans;
}
void solve() {
  cin >> n;
  for (long long i = 1; i < n + 1; ++i) {
    long long k;
    cin >> k;
    for (long long j = 1; j < k + 1; ++j) {
      long long c, d;
      cin >> c >> d;
      adj[i][c].push_back(d);
      sort(adj[i][c].begin(), adj[i][c].end(), greater<long long>());
      if (c == 3 || c == 2) {
        while ((long long)adj[i][c].size() > 1) adj[i][c].pop_back();
      } else
        while ((long long)adj[i][c].size() > 3) adj[i][c].pop_back();
    }
  }
  memset(dp, -1, sizeof dp);
  cout << solve2(1, 0) << "\n";
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long T = 1;
  for (long long t = 1; t < T + 1; ++t) {
    solve();
  }
  return 0;
}
