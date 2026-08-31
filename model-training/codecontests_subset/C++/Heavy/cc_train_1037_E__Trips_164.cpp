#include <bits/stdc++.h>
using namespace std;
int deg[200005];
vector<pair<int, int> > g[200005];
bool notInSet[200005];
int main() {
  int n, m, k, x, y, i;
  cin >> n >> m >> k;
  vector<pair<int, int> > v;
  for (i = 0; i < m; i++) {
    cin >> x >> y;
    v.push_back({x, y});
    deg[x]++, deg[y]++;
    g[x].push_back({y, i});
    g[y].push_back({x, i});
  }
  set<pair<int, int> > s;
  for (i = 1; i <= n; i++) {
    s.insert({deg[i], i});
  }
  while (!s.empty() && deg[s.begin()->second] < k) {
    int u = s.begin()->second;
    for (auto it : g[u]) {
      int x = it.first;
      if (!notInSet[x]) {
        s.erase(s.find({deg[x], x}));
        deg[x]--;
        s.insert({deg[x], x});
      }
    }
    s.erase({deg[u], u});
    notInSet[u] = 1;
  }
  vector<int> res(m);
  for (i = m - 1; i >= 0; i--) {
    res[i] = s.size();
    x = v[i].first, y = v[i].second;
    if (!notInSet[x] && !notInSet[y]) {
      s.erase(s.find({deg[x], x}));
      s.erase(s.find({deg[y], y}));
      deg[x]--, deg[y]--;
      s.insert({deg[y], y});
      s.insert({deg[x], x});
      while (!s.empty() && deg[s.begin()->second] < k) {
        int u = s.begin()->second;
        for (auto it : g[u]) {
          int x = it.first;
          int y = it.second;
          if (y >= i) continue;
          if (!notInSet[x]) {
            s.erase(s.find({deg[x], x}));
            deg[x]--;
            s.insert({deg[x], x});
          }
        }
        s.erase({deg[u], u});
        notInSet[u] = 1;
      }
    }
  }
  for (i = 0; i < m; i++) cout << res[i] << endl;
}
