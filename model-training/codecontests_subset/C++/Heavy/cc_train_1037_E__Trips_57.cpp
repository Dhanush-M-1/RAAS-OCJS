#include <bits/stdc++.h>
using namespace std;
set<int> adj[200009];
set<int>::iterator it;
int vis[200009];
pair<int, int> edg[200009];
vector<int> bad;
int ses[200009];
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &edg[i].first, &edg[i].second);
    adj[edg[i].first].insert(edg[i].second);
    adj[edg[i].second].insert(edg[i].first);
  }
  int ans = n;
  for (int i = 1; i <= n; i++) {
    if (adj[i].size() < k) {
      vis[i] = 1;
      ans--;
      bad.push_back(i);
    }
  }
  for (int i = m; i >= 1; i--) {
    while (bad.size() > 0) {
      int v = bad.back();
      bad.pop_back();
      for (it = adj[v].begin(); it != adj[v].end(); it++) {
        int u = *it;
        adj[u].erase(v);
        if (vis[u] == 0 && adj[u].size() < k) {
          bad.push_back(u);
          vis[u] = 1;
          ans--;
        }
      }
      adj[v].clear();
    }
    ses[i] = ans;
    int u = edg[i].first;
    int v = edg[i].second;
    if (vis[u] == 1 || vis[v] == 1) continue;
    adj[u].erase(v);
    adj[v].erase(u);
    if (adj[u].size() < k) {
      bad.push_back(u);
      ans--;
      vis[u] = 1;
    }
    if (adj[v].size() < k) {
      bad.push_back(v);
      ans--;
      vis[v] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    printf("%d\n", ses[i]);
  }
  return 0;
}
