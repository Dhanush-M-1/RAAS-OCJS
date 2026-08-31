#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
vector<int> adj[N];
int ans[N], a[N], idx[N];
int dfs(int u, int p) {
  int cnt = 0;
  for (int v : adj[u])
    if (v != p) {
      cnt += dfs(v, u);
    }
  return ans[u] = (int(adj[u].size()) - cnt) % 2 == 0;
}
void DFS(int u, int p) {
  if (ans[u])
    a[u] = a[p] - 1;
  else
    a[u] = a[p] + 1;
  for (int v : adj[u])
    if (v != p) {
      DFS(v, u);
    }
}
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int j;
    cin >> j;
    if (j) {
      adj[i].push_back(j);
      adj[j].push_back(i);
    }
  }
  int root = -1;
  for (int i = 1; i <= n; i++) {
    if (adj[i].size() != 1) root = i;
  }
  if (root == -1) {
    cout << "NO" << endl;
    return 0;
  }
  if (dfs(root, 0)) {
    cout << "YES" << endl;
    DFS(root, 0);
    vector<pair<int, int> > xx;
    for (int i = 1; i <= n; i++) xx.push_back({a[i], i});
    sort(xx.begin(), xx.end());
    for (int i = 1; i <= n; i++) cout << xx[i - 1].second << endl;
  } else
    cout << "NO" << endl;
}
