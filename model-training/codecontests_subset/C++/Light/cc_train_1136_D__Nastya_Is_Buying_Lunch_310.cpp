#include <bits/stdc++.h>
using namespace std;
const int maxn = 300100;
int n, m;
vector<int> G[maxn];
int vis[maxn];
int pi[maxn];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &pi[i]);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    G[u].push_back(v);
  }
  vis[pi[n]] = 1;
  int ans = 0;
  for (int i = n - 1; i >= 1; i--) {
    int cnt = 0;
    for (int j = 0; j < G[pi[i]].size(); j++) {
      int v = G[pi[i]][j];
      if (vis[v] == 1) cnt++;
    }
    if (cnt + ans + i == n)
      ans++;
    else
      vis[pi[i]] = 1;
  }
  printf("%d\n", ans);
  return 0;
}
