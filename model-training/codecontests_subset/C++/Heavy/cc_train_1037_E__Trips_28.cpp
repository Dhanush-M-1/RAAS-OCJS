#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int n, m, k;
bool vis[N];
queue<int> Q;
set<int> G[N];
vector<int> E[N];
int a[N], b[N], ans[N], sum;
void solve() {
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    for (auto v : G[u]) {
      G[v].erase(u);
      if (!vis[v] && G[v].size() < k) {
        sum--;
        vis[v] = 1;
        Q.push(v);
      }
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  sum = n;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &a[i], &b[i]);
    G[a[i]].insert(b[i]);
    G[b[i]].insert(a[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (G[i].size() < k) {
      Q.push(i);
      vis[i] = true;
      sum--;
    }
  }
  solve();
  ans[m] = sum;
  for (int i = m; i > 1; i--) {
    G[a[i]].erase(b[i]);
    G[b[i]].erase(a[i]);
    if (!vis[a[i]] && G[a[i]].size() < k) sum--, Q.push(a[i]), vis[a[i]] = 1;
    if (!vis[b[i]] && G[b[i]].size() < k) sum--, Q.push(b[i]), vis[b[i]] = 1;
    solve();
    ans[i - 1] = sum;
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i] > 0 ? ans[i] : 0);
  return 0;
}
