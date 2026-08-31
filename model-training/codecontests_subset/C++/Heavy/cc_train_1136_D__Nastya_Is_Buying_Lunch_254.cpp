#include <bits/stdc++.h>
using namespace std;
const int maxn = 300001;
vector<int> g[maxn];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> p(n);
  for (int i = 0; i < n; i++) cin >> p[i];
  int u, v;
  for (int i = 0; i < m; i++) {
    cin >> u >> v;
    g[u].push_back(v);
  }
  unordered_set<int> need;
  need.insert(p[n - 1]);
  int ans = 0;
  for (int i = n - 2; i > -1; i--) {
    int cnt = 0;
    for (auto it : g[p[i]]) {
      if (need.count(it)) cnt++;
    }
    if (cnt == need.size())
      ans++;
    else
      need.insert(p[i]);
  }
  cout << ans << "\n";
  return 0;
}
