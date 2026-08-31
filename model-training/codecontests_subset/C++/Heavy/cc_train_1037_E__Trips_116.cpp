#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, i, k, u;
  scanf("%d", &n);
  scanf("%d", &m);
  scanf("%d", &k);
  vector<pair<int, int> > adj[n + 5];
  pair<int, int> edges[m + 5];
  set<pair<int, int> > degree_set;
  set<pair<int, int> >::iterator it;
  bool isthere[n + 5];
  int deg[n + 5];
  int ans[m + 5];
  memset(ans, 0, sizeof(ans));
  memset(deg, 0, sizeof(deg));
  memset(isthere, true, sizeof(isthere));
  for (i = 0; i < m; i++) {
    scanf("%d", &edges[i].first);
    scanf("%d", &edges[i].second);
    adj[edges[i].first].push_back({edges[i].second, i});
    adj[edges[i].second].push_back({edges[i].first, i});
    ++deg[edges[i].first];
    degree_set.insert({deg[edges[i].first], edges[i].first});
    degree_set.erase({deg[edges[i].first] - 1, edges[i].first});
    ++deg[edges[i].second];
    degree_set.insert({deg[edges[i].second], edges[i].second});
    degree_set.erase({deg[edges[i].second] - 1, edges[i].second});
  }
  for (i = m - 1; i >= 0; i--) {
    while (!degree_set.empty() && (*(degree_set.begin())).first < k) {
      u = (*(degree_set.begin())).second;
      for (auto k1 : adj[u]) {
        if (isthere[k1.first] == true && k1.second <= i) {
          degree_set.erase({deg[k1.first], k1.first});
          deg[k1.first]--;
          degree_set.insert({deg[k1.first], k1.first});
        }
      }
      degree_set.erase({deg[u], u});
      isthere[u] = false;
    }
    ans[i] = degree_set.size();
    if (isthere[edges[i].first] == true && isthere[edges[i].second] == true) {
      degree_set.erase({deg[edges[i].first], edges[i].first});
      deg[edges[i].first]--;
      degree_set.insert({deg[edges[i].first], edges[i].first});
      degree_set.erase({deg[edges[i].second], edges[i].second});
      deg[edges[i].second]--;
      degree_set.insert({deg[edges[i].second], edges[i].second});
    }
  }
  for (i = 0; i < m; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
