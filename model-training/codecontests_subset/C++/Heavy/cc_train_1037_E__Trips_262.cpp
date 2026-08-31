#include <bits/stdc++.h>
using namespace std;
const int maxn = 200010;
pair<int, int> edge[maxn];
int deg[maxn], ans[maxn];
bool del[maxn], vis[maxn];
set<pair<int, int> > dic;
vector<pair<int, int> > g[maxn];
int main() {
  int n, m, k, u, v;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &u, &v);
    g[u].push_back(pair<int, int>(v, i));
    g[v].push_back(pair<int, int>(u, i));
    deg[u]++, deg[v]++;
    edge[i] = pair<int, int>(u, v);
  }
  for (int v = 1; v <= n; v++) dic.insert(pair<int, int>(deg[v], v));
  while (!dic.empty() && dic.begin()->first < k) {
    int v = dic.begin()->second;
    dic.erase(dic.begin());
    del[v] = true;
    for (int i = 0; i < (int)g[v].size(); i++) {
      int adj = g[v][i].first;
      if (del[adj]) continue;
      dic.erase(pair<int, int>(deg[adj], adj));
      dic.insert(pair<int, int>(--deg[adj], adj));
    }
  }
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = dic.size();
    u = edge[i].first, v = edge[i].second;
    if (!del[u] && !del[v] && !vis[i]) {
      dic.erase(pair<int, int>(deg[u], u));
      dic.insert(pair<int, int>(--deg[u], u));
      dic.erase(pair<int, int>(deg[v], v));
      dic.insert(pair<int, int>(--deg[v], v));
      vis[i] = true;
    }
    while (!dic.empty() && dic.begin()->first < k) {
      int v = dic.begin()->second;
      dic.erase(dic.begin());
      del[v] = true;
      for (int i = 0; i < (int)g[v].size(); i++) {
        int adj = g[v][i].first;
        if (del[adj] || vis[g[v][i].second]) continue;
        dic.erase(pair<int, int>(deg[adj], adj));
        dic.insert(pair<int, int>(--deg[adj], adj));
        vis[g[v][i].second] = true;
      }
    }
  }
  for (int i = 0; i < m; i++) printf("%d\n", ans[i]);
  return 0;
}
