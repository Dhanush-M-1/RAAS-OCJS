#include <bits/stdc++.h>
using namespace std;
int u[200005], v[200005];
int cnt[200005];
unordered_set<int> adj[200005];
unordered_set<int> take;
stack<int> ans;
queue<int> cac, toerase;
int n, m, k;
void emptycac() {
  while (cac.size()) {
    int node = cac.front();
    cac.pop();
    for (auto j : adj[node]) {
      if (take.count(j)) {
        adj[j].erase(node);
        if (adj[j].size() < k) {
          take.erase(j);
          cac.push(j);
        }
      }
    }
    while (toerase.size()) {
      take.erase(toerase.front());
      toerase.pop();
    }
  }
}
signed main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> u[i] >> v[i];
    adj[u[i]].insert(v[i]);
    adj[v[i]].insert(u[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (adj[i].size() >= k) {
      take.insert(i);
      for (auto j : adj[i]) {
        take.insert(j);
      }
    }
  }
  for (auto i : take) {
    if (adj[i].size() < k) {
      cac.push(i);
      toerase.push(i);
    }
  }
  while (toerase.size()) {
    take.erase(toerase.front());
    toerase.pop();
  }
  emptycac();
  for (int i = m; i >= 1; i--) {
    ans.push(take.size());
    if (take.count(u[i]) && take.count(v[i])) {
      adj[u[i]].erase(v[i]);
      adj[v[i]].erase(u[i]);
      if (adj[v[i]].size() < k) {
        take.erase(v[i]);
        cac.push(v[i]);
      }
      if (adj[u[i]].size() < k) {
        take.erase(u[i]);
        cac.push(u[i]);
      }
      emptycac();
    }
  }
  while (ans.size()) {
    cout << ans.top() << endl;
    ans.pop();
  }
}
