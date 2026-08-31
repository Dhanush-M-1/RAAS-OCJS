#include <bits/stdc++.h>
using namespace std;
struct DATA {
  int first, second;
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k;
  cin >> n >> m >> k;
  vector<vector<int>> adj(n + 1);
  vector<int> degree(n + 1, 0);
  set<pair<int, int>> good_set;
  vector<bool> check(n + 1, true);
  vector<int> ans(m + 1, true);
  vector<DATA> edge(m + 1);
  check[0] = false;
  for (int i = 1; i <= m; ++i) {
    cin >> edge[i].first >> edge[i].second;
    adj[edge[i].first].push_back(edge[i].second);
    adj[edge[i].second].push_back(edge[i].first);
    degree[edge[i].first]++;
    degree[edge[i].second]++;
  }
  for (int i = 1; i <= n; ++i) {
    good_set.insert(pair<int, int>(degree[i], i));
  }
  while (!good_set.empty() && good_set.begin()->first < k) {
    int node = good_set.begin()->second;
    for (int i = 0; i < adj[node].size(); ++i) {
      int v = adj[node][i];
      if (check[v]) {
        good_set.erase(pair<int, int>(degree[v], v));
        --degree[v];
        good_set.insert(pair<int, int>(degree[v], v));
      }
    }
    good_set.erase(pair<int, int>(degree[node], node));
    check[node] = false;
  }
  ans[m] = good_set.size();
  for (int i = m; i > 1; --i) {
    int x = edge[i].first;
    int y = edge[i].second;
    if (check[x] && check[y]) {
      good_set.erase(pair<int, int>(degree[x], x));
      degree[x]--;
      good_set.insert(pair<int, int>(degree[x], x));
      good_set.erase(pair<int, int>(degree[y], y));
      degree[y]--;
      good_set.insert(pair<int, int>(degree[y], y));
      adj[x].erase(std::remove(adj[x].begin(), adj[x].end(), y), adj[x].end());
      adj[y].erase(std::remove(adj[y].begin(), adj[y].end(), x), adj[y].end());
      while (!good_set.empty() && good_set.begin()->first < k) {
        int node = good_set.begin()->second;
        for (int j = 0; j < adj[node].size(); ++j) {
          int v = adj[node][j];
          if (check[v]) {
            good_set.erase(pair<int, int>(degree[v], v));
            --degree[v];
            good_set.insert(pair<int, int>(degree[v], v));
          }
        }
        good_set.erase(pair<int, int>(degree[node], node));
        check[node] = false;
      }
    }
    ans[i - 1] = good_set.size();
  }
  for (int i = 1; i <= m; ++i) cout << ans[i] << endl;
  return 0;
}
