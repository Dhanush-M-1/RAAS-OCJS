#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
int u[200050];
int v[200050];
int ans[200050];
int n, m, k;
set<int> s, num[200050];
void dfs(int u) {
  if (num[u].size() < k && s.erase(u)) {
    for (auto i : num[u]) {
      num[i].erase(u);
      dfs(i);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &u[i], &v[i]);
    num[u[i]].insert(v[i]);
    num[v[i]].insert(u[i]);
  }
  for (int i = 1; i <= n; i++) s.insert(i);
  for (int i = 1; i <= n; i++) dfs(i);
  for (int i = m; i; i--) {
    ans[i] = s.size();
    if (s.empty()) break;
    num[u[i]].erase(v[i]);
    num[v[i]].erase(u[i]);
    dfs(u[i]);
    dfs(v[i]);
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
