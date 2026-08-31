#include <bits/stdc++.h>
using namespace std;
int n, k;
int res;
vector<set<int>> g;
vector<int> used;
vector<int> selected;
void bfs(int start) {
  vector<int> seen = {start};
  queue<int> q;
  used[start] = 1;
  q.push(start);
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    assert(selected[v]);
    assert((int)g[v].size() < k);
    selected[v] = 0;
    res--;
    for (auto t : g[v]) {
      g[t].erase(v);
      if (selected[t] && (int)g[t].size() < k && !used[t]) {
        seen.push_back(t);
        used[t] = 1;
        q.push(t);
      }
    }
  }
  for (auto t : seen) {
    used[t] = 0;
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int m;
  cin >> n >> m >> k;
  used.resize(n);
  g.resize(n);
  vector<pair<int, int>> q;
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--;
    v--;
    g[u].insert(v);
    g[v].insert(u);
    q.push_back({u, v});
  }
  reverse(q.begin(), q.end());
  selected.assign(n, 1);
  res = n;
  for (int i = 0; i < n; i++) {
    if ((int)g[i].size() < k && selected[i]) {
      bfs(i);
    }
  }
  vector<int> ans;
  for (auto [u, v] : q) {
    ans.push_back(res);
    g[u].erase(v);
    g[v].erase(u);
    if ((int)g[u].size() < k && selected[u]) {
      bfs(u);
    }
    if ((int)g[v].size() < k && selected[v]) {
      bfs(v);
    }
  }
  reverse(ans.begin(), ans.end());
  for (auto t : ans) {
    cout << t << '\n';
  }
}
