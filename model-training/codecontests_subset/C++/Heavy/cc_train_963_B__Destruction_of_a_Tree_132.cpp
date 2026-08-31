#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int N = 212345;
int par[N];
vector<int> g[N];
int num[N], adj[N], ct, vis[N];
void dfs(int u) {
  num[u] = ct++;
  for (auto v : g[u]) dfs(v);
}
int main(void) {
  int n;
  scanf("%d", &n);
  int root = -1;
  for (int i = 1; i <= n; i++) {
    int p;
    scanf("%d", &p);
    g[p].push_back(i);
    par[i] = p;
    if (!p)
      root = i;
    else {
      adj[i]++;
      adj[p]++;
    }
  }
  dfs(root);
  set<pair<int, int> > s;
  for (int i = 1; i <= n; i++) {
    if (par[i]) g[i].push_back(par[i]);
    if (adj[i] % 2 == 0) {
      s.emplace(-num[i], i);
    }
  }
  vector<int> ans;
  while (!s.empty()) {
    int u = s.begin()->second;
    s.erase(s.begin());
    vis[u] = 1;
    for (auto v : g[u]) {
      if (vis[v]) continue;
      if (adj[v] % 2) {
        s.emplace(-num[v], v);
      } else {
        s.erase(make_pair(-num[v], v));
      }
      adj[v]--;
    }
    ans.push_back(u);
  }
  if (ans.size() == n) {
    printf("YES\n");
    for (int i = 0; i < n; i++) printf("%d\n", ans[i]);
  } else
    printf("NO\n");
  return 0;
}
