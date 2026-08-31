#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, m, t, cnt[N], a, b, vis[N], visId = 1;
vector<int> adj[N];
void DFS1(int node) {
  vis[node] = visId;
  cnt[node]++;
  for (int i = 0; i < adj[node].size(); i++) {
    if (vis[adj[node][i]] == visId || adj[node][i] == a) continue;
    DFS1(adj[node][i]);
  }
}
void DFS2(int node) {
  vis[node] = visId;
  cnt[node]--;
  for (int i = 0; i < adj[node].size(); i++) {
    if (vis[adj[node][i]] == visId || adj[node][i] == b) continue;
    DFS2(adj[node][i]);
  }
}
void clear_all() {
  for (int i = 1; i <= n; i++) adj[i].clear(), cnt[i] = 0;
  ++visId;
}
int main() {
  cin >> t;
  while (t--) {
    scanf("%d%d%d%d", &n, &m, &a, &b);
    int u, v;
    while (m--) {
      scanf("%d%d", &u, &v);
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    DFS1(b);
    ++visId;
    DFS2(a);
    int cnt1 = 0, cnt_1 = 0;
    for (int i = 1; i <= n; i++) {
      cnt1 += (cnt[i] == 1);
      cnt_1 += (cnt[i] == -1);
    }
    printf("%lld\n", 1ll * (cnt1 - 1) * (cnt_1 - 1));
    clear_all();
  }
}
