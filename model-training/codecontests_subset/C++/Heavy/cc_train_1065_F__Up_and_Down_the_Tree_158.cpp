#include <bits/stdc++.h>
using namespace std;
long long n, k;
long long up[1000006], lvl[1000006], last[1000006];
pair<long long, long long> dp[1000006];
vector<long long> child[1000006];
long long b[1000006];
void bfs() {
  long long st = 1, en = 1;
  b[st] = 1;
  lvl[1] = 1;
  while (st <= en) {
    long long node = b[st];
    st++;
    for (long long i = 1; i <= child[node].size(); i++) {
      en++;
      b[en] = child[node][i - 1];
      lvl[b[en]] = lvl[node] + 1;
    }
    if (!child[node].size()) {
      dp[node].first = 1;
      dp[node].second = lvl[node];
      last[node] = 1;
    }
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin >> n >> k;
  if (n == 1) {
    cout << 0;
    return 0;
  }
  lvl[1] = 1;
  for (long long i = 1; i <= n; i++) {
    dp[i].first = 0, dp[i].second = 999999999;
  }
  for (long long i = 2; i <= n; i++) {
    cin >> up[i];
    child[up[i]].push_back(i);
  }
  bfs();
  long long ans = 0;
  for (long long i = n; i > 1; i--) {
    if (dp[b[i]].second - lvl[up[b[i]]] <= k) {
      dp[up[b[i]]].first += dp[b[i]].first;
      dp[up[b[i]]].second = min(dp[up[b[i]]].second, dp[b[i]].second);
    }
  }
  for (long long i = n; i >= 1; i--) {
    for (long long j = 0; j < child[b[i]].size(); j++) {
      long long temp = 0;
      if (dp[child[b[i]][j]].second - lvl[b[i]] <= k) {
        temp = dp[child[b[i]][j]].first;
      }
      last[b[i]] =
          max(last[b[i]], last[child[b[i]][j]] + dp[b[i]].first - temp);
      ans = max(ans, last[b[i]]);
    }
  }
  cout << ans;
}
