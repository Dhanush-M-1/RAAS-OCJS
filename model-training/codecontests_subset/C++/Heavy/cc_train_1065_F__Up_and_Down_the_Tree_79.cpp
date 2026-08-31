#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long long infl = 2e18;
const long long infi = 1e9;
const long long mod = 998244353;
mt19937 rang(chrono::high_resolution_clock::now().time_since_epoch().count());
auto clk = clock();
long long rng(long long lim) {
  uniform_int_distribution<long long> uid(0, lim - 1);
  return uid(rang);
}
long long p[1000005];
long long dp[1000005][2];
long long leafy[1000005];
vector<long long> gra[1000005];
long long tot[1000005];
long long n, k;
void dfs(long long fr, long long at) {
  if (gra[at].empty())
    tot[at] = 1;
  else {
    leafy[at] = infi;
    for (long long i : gra[at]) {
      dfs(at, i);
      leafy[at] = min(leafy[at], leafy[i] + 1);
      tot[at] += tot[i];
    }
  }
}
void dfs(long long at) {
  long long mm = 0;
  if (gra[at].empty()) {
    dp[at][0] = 1;
    dp[at][1] = 1;
    return;
  }
  for (long long i : gra[at]) {
    dfs(i);
    if (leafy[i] < k) {
      dp[at][0] += dp[i][0];
      mm = max(mm, dp[i][1] - dp[i][0]);
    } else
      mm = max(mm, dp[i][1]);
  }
  dp[at][1] = dp[at][0] + mm;
}
void solve() {
  cin >> n >> k;
  if (n == 1) {
    cout << 0 << '\n';
    return;
  }
  for (long long i = 2; i <= n; i++) {
    cin >> p[i];
    gra[p[i]].push_back(i);
  }
  dfs(1, 1);
  dfs(1);
  cout << dp[1][1] << '\n';
}
signed main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  srand(chrono::high_resolution_clock::now().time_since_epoch().count());
  cout << fixed << setprecision(10);
  long long t = 1;
  while (t--) solve();
  return 0;
}
