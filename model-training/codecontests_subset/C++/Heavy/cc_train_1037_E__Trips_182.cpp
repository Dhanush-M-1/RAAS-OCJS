#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int> > arr(m);
  vector<vector<int> > G(n);
  vector<int> in(n), vis(n);
  for (auto& it : arr) {
    int u, v;
    cin >> u >> v;
    in[--u]++;
    in[--v]++;
    it = {u, v};
    G[u].push_back(v);
    G[v].push_back(u);
  }
  queue<int> q;
  for (int i = 0; i < n; i++) {
    if (in[i] < k) {
      q.push(i);
      vis[i] = 1;
    }
  }
  int cur = n - q.size();
  set<pair<int, int> > cnt;
  while (!q.empty()) {
    auto x = q.front();
    q.pop();
    for (auto& it : G[x]) {
      auto node = minmax(x, it);
      if (cnt.find(node) == cnt.end()) {
        cnt.insert(node);
        if (!vis[it] && --in[it] < k) {
          vis[it] = 1;
          q.push(it);
          cur--;
        }
      }
    }
  }
  reverse(arr.begin(), arr.end());
  vector<int> ans;
  for (auto& it : arr) {
    ans.push_back(cur);
    auto node = minmax(it.first, it.second);
    if (cnt.find(node) == cnt.end()) {
      cnt.insert(node);
      if (!vis[it.first] && --in[it.first] < k) {
        vis[it.first] = 1;
        q.push(it.first);
        cur--;
      }
      if (!vis[it.second] && --in[it.second] < k) {
        vis[it.second] = 1;
        q.push(it.second);
        cur--;
      }
      while (!q.empty()) {
        auto x = q.front();
        q.pop();
        for (auto& jt : G[x]) {
          auto node = minmax(x, jt);
          if (cnt.find(node) == cnt.end()) {
            cnt.insert(node);
            if (!vis[jt] && --in[jt] < k) {
              vis[jt] = 1;
              q.push(jt);
              cur--;
            }
          }
        }
      }
    }
  }
  reverse(ans.begin(), ans.end());
  for (auto& it : ans) cout << it << endl;
  return 0;
}
