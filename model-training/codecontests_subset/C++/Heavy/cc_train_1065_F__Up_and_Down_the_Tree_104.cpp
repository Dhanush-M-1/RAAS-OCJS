#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const int N = 1e6 + 7;
const int INF = 1e9 + 7;
pair<int, int> dp[N];
int val[N];
int p[N], h[N];
int n, k, ans;
vector<int> g[N];
void calc(int v) {
  h[v] = h[p[v]] + 1;
  if (g[v].size() == 0) {
    dp[v].first = val[v] = 1;
    dp[v].second = h[v] - k;
  } else
    dp[v].second = INF;
  for (int to : g[v]) {
    calc(to);
    if (dp[to].second <= h[v]) dp[v].first += dp[to].first;
    dp[v].second = min(dp[v].second, dp[to].second);
  }
  for (int to : g[v]) {
    if (dp[to].second <= h[v])
      val[v] = max(val[v], dp[v].first - dp[to].first + val[to]);
    else
      val[v] = max(val[v], dp[v].first + val[to]);
  }
  ans = max(ans, val[v]);
}
int main() {
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    scanf("%d", &p[i]);
    g[p[i]].push_back(i);
  }
  calc(1);
  cout << ans;
}
