#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
struct node {
  long long id, add, val;
};
node p[100];
long long n, dp[100][100];
bool f[100];
bool cmp(node x, node y) { return x.add < y.add; }
deque<long long> ans;
void print(long long x, long long y) {
  if (!y) return;
  if (x && dp[x][y] == dp[x - 1][y - 1] + (x - 1) * p[y].add + p[y].val) {
    ans.emplace_front(y);
    print(x - 1, y - 1);
  } else {
    f[y] = 1;
    print(x, y - 1);
  }
}
void solve() {
  long long k;
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) cin >> p[i].val >> p[i].add, p[i].id = i;
  memset(dp, 0, sizeof(dp));
  sort(p + 1, p + n + 1, cmp);
  for (long long i = 1; i <= k; i++) {
    for (long long j = 0; j <= n; j++) dp[i][j] = -1e17;
  }
  dp[0][0] = 0;
  for (long long i = 1; i <= n; i++)
    dp[0][i] = dp[0][i - 1] + (k - 1) * p[i].add;
  for (long long i = 1; i <= k; i++) {
    for (long long j = i; j <= n; j++) {
      dp[i][j] = max(dp[i - 1][j - 1] + (i - 1) * p[j].add + p[j].val,
                     dp[i][j - 1] + (k - 1) * p[j].add);
    }
  }
  ans.clear();
  memset(f, 0, sizeof(f));
  print(k, n);
  cout << n * 2 - k << '\n';
  long long t = ans.back();
  ans.pop_back();
  for (auto u : ans) cout << p[u].id << ' ';
  for (long long i = 1; i <= n; i++) {
    if (f[i]) {
      cout << p[i].id << ' ' << -p[i].id << ' ';
    }
  }
  cout << p[t].id << ' ';
  cout << '\n';
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) solve();
  return 0;
}
