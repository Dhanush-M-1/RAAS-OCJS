#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
vector<set<int>> graph;
vector<bool> seen;
vector<bool> removed;
vector<int> removedOrder;
void dfs(int from) {
  seen[from] = true;
  set<int> edges = graph[from];
  for (auto to : edges) {
    if (!seen[to] && !removed[from]) dfs(to);
  }
  const int deg = graph[from].size();
  if (deg % 2 == 0) {
    removed[from] = true;
    removedOrder.push_back(from);
    for (auto to : graph[from]) graph[to].erase(from);
    graph[from].clear();
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  graph.assign(n, set<int>());
  for (int i = 0; i < n; ++i) {
    int p;
    cin >> p;
    if (p) {
      --p;
      graph[i].insert(p);
      graph[p].insert(i);
    }
  }
  removed.assign(n, false);
  for (int i = 0; i < n; ++i) {
    if (!removed[i]) {
      seen.assign(n, false);
      dfs(i);
    }
  }
  if (removedOrder.size() == n) {
    cout << "YES\n";
    for (auto v : removedOrder) cout << v + 1 << '\n';
  } else {
    cout << "NO\n";
  }
  return 0;
}
