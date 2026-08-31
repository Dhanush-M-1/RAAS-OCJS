#include <bits/stdc++.h>
using namespace std;
mt19937 gen(chrono::system_clock::now().time_since_epoch().count());
const int M = 1e9 + 7;
const int N = 1e6 + 7;
int n, k, p, kol[N], d[N], h[N], dp[N];
vector<int> g[N];
void dfs(int v, int p) {
  int leaf = 1;
  h[v] = 1e9;
  dp[v] = -1e9;
  d[v] = d[p] + 1;
  for (auto to : g[v]) {
    if (to == p) continue;
    dfs(to, v);
    h[v] = min(h[v], h[to]);
    kol[v] += kol[to];
    dp[v] = max(dp[v], dp[to] - kol[to]);
    leaf = 0;
  }
  if (leaf && v) {
    dp[v] = 1;
    kol[v] = 1;
    h[v] = d[v];
  } else {
    dp[v] += kol[v];
    if (h[v] - d[v] >= k) kol[v] = 0;
  }
  return;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  if (n == 1) {
    cout << 0;
    return 0;
  }
  for (int i = 1; i < n; i++) {
    cin >> p;
    p--;
    g[i].push_back(p);
    g[p].push_back(i);
  }
  dfs(0, 0);
  cout << dp[0];
  return 0;
}
