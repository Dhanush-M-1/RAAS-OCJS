#include <bits/stdc++.h>
using namespace std;
int n, m;
int main() {
  scanf("%d", &n);
  scanf("%d", &m);
  vector<int> p(n), pos(n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &p[i]);
    p[i]--;
    pos[p[i]] = i;
  }
  vector<set<int>> g(n);
  for (int i = 0; i < m; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    u--;
    v--;
    g[u].insert(v);
  }
  int tot = 1, sol = 0;
  vector<int> moved(n);
  for (int i = n - 2; i >= 0; --i) {
    int u = p[i];
    int cnt = 0;
    for (auto v : g[u]) {
      if (pos[v] <= pos[u]) continue;
      if (moved[v]) continue;
      cnt++;
    }
    if (cnt == tot) {
      moved[u] = 1;
      sol++;
    } else
      tot++;
  }
  cout << sol << "\n";
  return 0;
}
