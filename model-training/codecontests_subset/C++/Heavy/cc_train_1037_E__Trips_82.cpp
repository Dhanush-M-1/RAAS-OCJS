#include <bits/stdc++.h>
using namespace std;
pair<int, int> edge[200000 + 324];
vector<int> adj[200000 + 324];
set<int> degree[200000 + 324];
set<int> friends;
int ans[200000 + 324];
int k;
void rem(int x) {
  set<int> elem_to_remove;
  for (auto bc : degree[x]) {
    elem_to_remove.insert(bc);
    degree[bc].erase(x);
  }
  degree[x].erase(degree[x].begin(), degree[x].end());
  friends.erase(x);
  for (auto bc : elem_to_remove) {
    if (degree[bc].size() < k) {
      rem(bc);
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  int n, m;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> edge[i].first >> edge[i].second;
    degree[edge[i].first].insert(edge[i].second);
    degree[edge[i].second].insert(edge[i].first);
  }
  for (int i = 1; i <= n; i++) {
    if (degree[i].size() >= k) {
      friends.insert(i);
    } else {
      friends.insert(i);
      rem(i);
    }
  }
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = friends.size();
    degree[edge[i].first].erase(edge[i].second);
    degree[edge[i].second].erase(edge[i].first);
    if (degree[edge[i].first].size() < k) {
      rem(edge[i].first);
    }
    if (degree[edge[i].second].size() < k) {
      rem(edge[i].second);
    }
  }
  for (int i = 0; i < m; i++) cout << ans[i] << " ";
  return 0;
}
