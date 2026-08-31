#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, m, u, v;
  cin >> n >> m;
  vector<int> p(n), pos(n + 1);
  for (int i = 0; i < n; i++) {
    cin >> p[i];
    pos[p[i]] = i;
  }
  vector<int> g[n];
  vector<bool> good(n);
  for (int i = 0; i < m; i++) {
    cin >> u >> v;
    if (v == p.back()) {
      good[pos[u]] = true;
    }
    g[pos[v]].emplace_back(pos[u]);
  }
  int ans = 0, k = 0;
  vector<int> s(n);
  for (int i = n - 2; i >= 0; i--) {
    if (good[i]) {
      if (s[i] == k) {
        ans++;
      } else {
        for (auto &u : g[i]) {
          s[u]++;
        }
        k++;
      }
    } else {
      for (auto &u : g[i]) {
        s[u]++;
      }
      k++;
    }
  }
  cout << ans;
  return 0;
}
