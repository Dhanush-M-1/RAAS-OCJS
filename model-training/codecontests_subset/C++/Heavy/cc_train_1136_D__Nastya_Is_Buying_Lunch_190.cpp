#include <bits/stdc++.h>
using namespace std;
int const maxn = 400000;
int p[maxn];
bool is_good[maxn];
bool block[maxn];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m, s;
  cin >> n >> m;
  vector<vector<int>> adj(n);
  for (int i = 0; i < n; ++i) {
    cin >> p[i];
    p[i]--;
  }
  s = p[n - 1];
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    --u;
    --v;
    adj[u].push_back(v);
    if (v == s) is_good[u] = true;
  }
  int ans = 0;
  int bad = 0;
  for (int i = n - 2; i >= 0; --i) {
    int u = p[i];
    if (!is_good[u]) {
      bad++;
      block[u] = true;
      continue;
    }
    if (bad > adj[u].size()) {
      bad++;
      block[u] = true;
      continue;
    }
    int cnt = 0;
    for (int j = 0; j < adj[u].size(); ++j) {
      cnt += block[adj[u][j]];
    }
    if (cnt == bad)
      ++ans;
    else {
      bad++;
      block[u] = true;
    }
  }
  cout << ans << endl;
  return 0;
}
