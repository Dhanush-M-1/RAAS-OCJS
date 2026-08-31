#include <bits/stdc++.h>
using namespace std;
int p[300010];
set<int> vertices[300010], save;
int main() {
  ios::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    vertices[u].insert(v);
  }
  save.insert(p[n]);
  for (int i = n - 1; i >= 1; i--) {
    int flag = 1;
    for (auto v : save)
      if (vertices[p[i]].find(v) == vertices[p[i]].end()) {
        flag = 0;
        break;
      }
    if (!flag) save.insert(p[i]);
  }
  cout << n - (int)save.size();
  return 0;
}
