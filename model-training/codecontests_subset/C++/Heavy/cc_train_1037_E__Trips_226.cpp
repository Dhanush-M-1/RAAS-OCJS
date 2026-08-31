#include <bits/stdc++.h>
using namespace std;
template <typename T, typename Pr = less<T>>
using pq = priority_queue<T, vector<T>, Pr>;
using i64 = long long int;
using ii = pair<int, int>;
using ii64 = pair<i64, i64>;
set<int> adj[200005];
bool removed[200005];
int main() {
  int n, m, k;
  scanf("%d %d %d", &n, &m, &k);
  vector<ii> edges(m);
  for (int i = 0; i < m; i++) {
    scanf("%d %d", &edges[i].first, &edges[i].second);
    adj[edges[i].first].insert(edges[i].second);
    adj[edges[i].second].insert(edges[i].first);
  }
  set<ii> nodes;
  for (int i = 1; i <= n; i++) nodes.emplace(adj[i].size(), i);
  reverse((edges).begin(), (edges).end());
  vector<int> ans(m);
  for (int i = 0; i < m; i++) {
    while (!nodes.empty() && nodes.begin()->first < k) {
      auto x = nodes.begin()->second;
      removed[x] = true;
      nodes.erase(nodes.begin());
      for (auto& e : adj[x]) {
        nodes.erase(ii(adj[e].size(), e));
        adj[e].erase(x);
        nodes.emplace(adj[e].size(), e);
      }
    }
    ans[m - 1 - i] = nodes.size();
    auto& [x, y] = edges[i];
    if (removed[x] || removed[y]) continue;
    nodes.erase(ii(adj[x].size(), x));
    nodes.erase(ii(adj[y].size(), y));
    adj[x].erase(y);
    adj[y].erase(x);
    nodes.emplace(adj[x].size(), x);
    nodes.emplace(adj[y].size(), y);
  }
  for (auto& ai : ans) printf("%d\n", ai);
  return 0;
}
