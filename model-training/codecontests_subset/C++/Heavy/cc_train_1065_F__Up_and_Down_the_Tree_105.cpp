#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
template <typename T>
void uin(T &a, T b) {
  if (b < a) a = b;
}
template <typename T>
void uax(T &a, T b) {
  if (b > a) a = b;
}
const long long maxn = 1000 * 1000 + 228;
long long n, k;
long long dp[maxn], p[maxn];
long long dpret[maxn], hret[maxn];
vector<long long> g[maxn];
void dfs(long long v, long long deep = 0) {
  hret[v] = deep;
  if ((long long)g[v].size() == 1 && v != 1) {
    dp[v] = 1;
    dpret[v] = 1;
    hret[v] = max(0LL, deep - k);
  } else {
    for (long long to : g[v]) {
      if (to != p[v]) {
        dfs(to, deep + 1);
        if (hret[to] <= deep) {
          dpret[v] += dpret[to];
          uin(hret[v], hret[to]);
        }
      }
    }
    dp[v] = dpret[v];
    for (long long to : g[v]) {
      if (to != p[v]) {
        if (hret[to] <= deep) {
          uax(dp[v], dp[to] + dpret[v] - dpret[to]);
        } else {
          uax(dp[v], dp[to] + dpret[v]);
        }
      }
    }
  }
}
void solve() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  for (long long i = 2; i <= n; ++i) {
    cin >> p[i];
    g[i].push_back(p[i]);
    g[p[i]].push_back(i);
  }
  dfs(1);
  cout << dp[1] << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  solve();
  return 0;
}
