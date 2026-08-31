#include <bits/stdc++.h>
using namespace std;
const int sz = 3e5 + 5;
int n, m, q[sz] = {0};
vector<int> sw[sz];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> q[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    sw[u].push_back(v);
  }
  int steps = 0, tot = 0;
  bool vis[sz] = {0};
  vis[q[n - 1]] = 1;
  tot = 1;
  for (int i = n - 2; i >= 0; i--) {
    int u = q[i], cnt = 0;
    for (int j = 0; j < sw[u].size(); j++)
      if (vis[sw[u][j]]) cnt++;
    if (cnt == tot)
      steps++;
    else {
      vis[u] = 1;
      tot++;
    }
  }
  cout << steps << endl;
  return 0;
}
