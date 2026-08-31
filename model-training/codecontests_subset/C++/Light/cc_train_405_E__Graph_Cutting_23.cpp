#include <bits/stdc++.h>
using namespace std;
int vis[100100];
vector<int> adj[100100];
vector<pair<int, pair<int, int>>> ans;
int dfs(int v) {
  vis[v] = 2;
  vector<int> res;
  for (auto i : adj[v]) {
    if (vis[i] == 0) {
      int node = dfs(i);
      if (node == 0)
        res.push_back(i);
      else
        ans.push_back(make_pair(v, make_pair(i, node)));
    } else if (vis[i] == 1)
      res.push_back(i);
  }
  vis[v] = 1;
  while (res.size() != 0) {
    int node1 = res[res.size() - 1];
    res.pop_back();
    if (!res.size()) return node1;
    int node2 = res[res.size() - 1];
    res.pop_back();
    ans.push_back(make_pair(node1, make_pair(v, node2)));
  }
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, x, y, i;
  cin >> n >> m;
  if (m % 2 == 1) {
    cout << "No solution" << endl;
    return 0;
  }
  for (i = 0; i < m; i++) {
    cin >> x >> y;
    adj[x].push_back(y);
    adj[y].push_back(x);
  }
  for (i = 1; i <= n; i++)
    if (vis[i] != 1) dfs(i);
  for (i = 0; i < ans.size(); i++)
    cout << ans[i].first << " " << ans[i].second.first << " "
         << ans[i].second.second << endl;
  return 0;
}
