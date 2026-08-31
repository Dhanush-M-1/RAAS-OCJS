#include <bits/stdc++.h>
using namespace std;
int n, m, k, x, y, deg[200010];
set<pair<int, int>> s;
pair<int, int> p[200010];
vector<int> rez;
set<int> v[200010];
map<bool, int> mp[200010];
void rem() {
  while (!s.empty() and s.begin()->first < k) {
    x = s.begin()->second;
    for (auto it : v[x]) {
      s.erase({deg[it], it});
      --deg[it];
      v[it].erase(x);
      if (deg[it] > 0) s.insert({deg[it], it});
    }
    s.erase({deg[x], x});
    deg[x] = 0;
    v[x].clear();
  }
}
int main() {
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> p[i].first >> p[i].second;
    deg[p[i].first]++, deg[p[i].second]++;
    v[p[i].first].insert(p[i].second), v[p[i].second].insert(p[i].first);
  }
  for (int i = 1; i <= n; i++) s.insert({deg[i], i});
  for (int i = m - 1; i >= 0; i--) {
    rem();
    rez.push_back((int)s.size());
    x = p[i].first, y = p[i].second;
    if (deg[x] == 0 or deg[y] == 0) continue;
    v[x].erase(y), v[y].erase(x);
    s.erase({deg[x], x}), s.erase({deg[y], y});
    --deg[x], --deg[y];
    if (deg[x] > 0) s.insert({deg[x], x});
    if (deg[y] > 0) s.insert({deg[y], y});
  }
  reverse(rez.begin(), rez.end());
  for (auto ans : rez) cout << ans << endl;
  return 0;
}
