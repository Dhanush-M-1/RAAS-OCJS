#include <bits/stdc++.h>
using namespace std;
const int N = 200000 + 9;
int n, p[N], deg[N];
vector<int> G[N];
unordered_set<int> ust[N][2];
int dfs(int u, int p) {
  int sz = 1;
  for (int v : G[u])
    if (v != p) {
      int tmp = dfs(v, u);
      ust[u][tmp & 1].insert(v);
      sz += tmp;
    }
  if (p) ust[u][(n - sz) & 1].insert(p);
  return sz;
}
bool vis[N];
void solve() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", p + i);
    if (!p[i]) continue;
    G[p[i]].push_back(i);
    G[i].push_back(p[i]);
  }
  dfs(1, 0);
  queue<int> Q;
  vector<int> vc;
  for (int i = 1; i <= n; ++i) {
    if (ust[i][0].empty() && (~ust[i][1].size() & 1u)) {
      Q.push(i);
      vis[i] = true;
    }
  }
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    vc.push_back(u);
    for (int v : G[u])
      if (!vis[v]) {
        ust[v][0].erase(u);
        ust[v][1].erase(u);
        if (ust[v][0].empty() && (~ust[v][1].size() & 1u)) {
          Q.push(v);
          vis[v] = true;
        }
      }
  }
  if ((int)vc.size() == n) {
    printf("YES\n");
    for (int u : vc) printf("%d\n", u);
  } else {
    printf("NO\n");
  }
}
int main() {
  int T = 1;
  while (T--) solve();
  return 0;
}
