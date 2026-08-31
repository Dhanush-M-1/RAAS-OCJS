#include <bits/stdc++.h>
using namespace std;
const int N = 200100;
bool vis1[N], vis2[N], q;
int t, n, m, a, b, cnt1, cnt2, cnt;
vector<int> adj[N];
void _clear() {
  cnt1 = cnt2 = 0;
  for (int i = 1; i <= n; i++) {
    adj[i].clear();
    vis1[i] = vis2[i] = 0;
  }
}
void dfs1(int u) {
  vis1[u] = 1;
  cnt++;
  if (u == b) q = 1;
  for (auto x : adj[u])
    if (!vis1[x] && x != a) dfs1(x);
}
void dfs2(int u) {
  vis2[u] = 1;
  cnt++;
  if (u == a) q = 1;
  for (auto x : adj[u])
    if (!vis2[x] && x != b) dfs2(x);
}
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d%d", &n, &m, &a, &b);
    _clear();
    for (int i = 0; i < m; i++) {
      int x, y;
      scanf("%d%d", &x, &y);
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    for (auto x : adj[a]) {
      q = cnt = 0;
      if (!vis1[x]) {
        dfs1(x);
        if (!q) cnt1 += cnt;
      }
    }
    for (auto x : adj[b]) {
      q = cnt = 0;
      if (!vis2[x]) {
        dfs2(x);
        if (!q) cnt2 += cnt;
      }
    }
    printf("%lld\n", 1LL * cnt1 * cnt2);
  }
}
