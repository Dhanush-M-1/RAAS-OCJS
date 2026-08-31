#include <bits/stdc++.h>
using namespace std;
const long double PI = acos(-1.0);
array<long long, 3> a[80];
long long dp[80][80];
long long par[80][80];
void solve() {
  long long n, k;
  cin >> n >> k;
  for (long long i = 0; i < n; ++i) {
    cin >> a[i][1] >> a[i][0];
    a[i][2] = i + 1;
  }
  memset(dp, 0, sizeof dp);
  sort(a, a + n);
  for (long long i = 0; i < n; ++i) {
    for (long long j = 0; j < k + 1; ++j) {
      if (j > i) continue;
      if (dp[i + 1][j] < dp[i][j] + (k - 1) * a[i][0]) {
        dp[i + 1][j] = dp[i][j] + (k - 1) * a[i][0];
        par[i + 1][j] = j;
      }
      if (j != k and dp[i + 1][j + 1] < dp[i][j] + a[i][1] + j * a[i][0]) {
        dp[i + 1][j + 1] = dp[i][j] + a[i][1] + j * a[i][0];
        par[i + 1][j + 1] = j;
      }
    }
  }
  vector<long long> taken;
  vector<long long> not_taken;
  long long cur = k;
  for (long long i = n; i >= 1; --i) {
    if (cur - par[i][cur] == 1) {
      taken.push_back(a[i - 1][2]);
    } else {
      not_taken.push_back(a[i - 1][2]);
    }
    cur = par[i][cur];
  }
  reverse(taken.begin(), taken.end());
  for (long long i : not_taken) {
    long long idx = taken.size() - 1;
    taken.insert(taken.begin() + idx, i);
    ++idx;
    taken.insert(taken.begin() + idx, -i);
  }
  cout << (long long)taken.size() << '\n';
  for (long long i : taken) {
    cout << i << ' ';
  }
  cout << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
