#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int t, n, m, a, b, x, y;
vector<int> adj[200001];
int vis[200001];
void dfs(int src, int d) {
  vis[src] = t + 1;
  for (int ch : adj[src]) {
    if ((d && ch == a) || (!d && ch == b) || vis[ch] == t + 1) {
      continue;
    }
    dfs(ch, d);
  }
}
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d%d", &n, &m, &a, &b);
    while (m--) {
      scanf("%d%d", &x, &y);
      adj[x].emplace_back(y);
      adj[y].emplace_back(x);
    }
    dfs(a, 0);
    int cnt1 = 0, cnt2 = 0;
    for (int i = 1; i <= n; ++i) {
      if (vis[i] != t + 1 && i != a && i != b) {
        cnt1++;
      }
      vis[i] = 0;
    }
    dfs(b, 1);
    for (int i = 1; i <= n; ++i) {
      if (vis[i] != t + 1 && i != a && i != b) {
        cnt2++;
      }
      adj[i].clear();
    }
    printf("%lld\n", 1LL * cnt1 * cnt2);
  }
  return 0;
}
