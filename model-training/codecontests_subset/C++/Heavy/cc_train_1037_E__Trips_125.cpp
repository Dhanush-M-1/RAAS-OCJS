#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int k;
  cin >> k;
  vector<set<int>> g(n);
  vector<int> x(m), y(m);
  for (int i = 0; i < m; i++) {
    cin >> x[i] >> y[i], x[i]--, y[i]--;
    g[x[i]].emplace(y[i]);
    g[y[i]].emplace(x[i]);
  }
  int ans = n;
  queue<int> que;
  vector<int> alive(n, true);
  for (int i = 0; i < n; i++)
    if ((int)g[i].size() < k) {
      que.emplace(i), alive[i] = false, ans--;
    }
  vector<int> res(m);
  for (int i = m - 1; i >= 0; i--) {
    while (!que.empty()) {
      int u = que.front();
      que.pop();
      for (int v : g[u]) g[v].erase(u);
      for (int v : g[u])
        if (alive[v] && (int)g[v].size() < k) {
          que.emplace(v), alive[v] = false, ans--;
        }
      g[u].clear();
    }
    res[i] = ans;
    int u = x[i], v = y[i];
    g[u].erase(v), g[v].erase(u);
    if (alive[u] && (int)g[u].size() < k) {
      que.emplace(u), alive[u] = false, ans--;
    }
    if (alive[v] && (int)g[v].size() < k) {
      que.emplace(v), alive[v] = false, ans--;
    }
  }
  for (int e : res) cout << e << endl;
  return 0;
}
