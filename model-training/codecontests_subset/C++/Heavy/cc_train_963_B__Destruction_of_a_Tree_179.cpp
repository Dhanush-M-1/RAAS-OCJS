#include <bits/stdc++.h>
using namespace std;
int n;
int ans[200000 + 5], root, vis[200000 + 5], del[200000 + 5];
int degree[200000 + 5], parent[200000 + 5];
vector<int> edge[200000 + 5];
int top;
void Del(int node) {
  ans[++top] = node;
  del[node] = 1;
  for (int i = 0; i < edge[node].size(); i++) {
    int v = edge[node][i];
    if (del[v]) continue;
    degree[v] -= 1;
    if (degree[v] % 2 == 0 && parent[node] != v) Del(v);
  }
}
void dfs(int node) {
  vis[node] = 1;
  for (int i = 0; i < edge[node].size(); i++) {
    int v = edge[node][i];
    if (vis[v]) continue;
    parent[v] = node;
    dfs(v);
  }
  if (degree[node] % 2 == 0) Del(node);
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int v;
    cin >> v;
    if (v == 0)
      root = i;
    else {
      edge[i].push_back(v);
      edge[v].push_back(i);
    }
  }
  for (int i = 1; i <= n; i++) degree[i] = edge[i].size();
  dfs(root);
  if (top == n) {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) cout << ans[i] << endl;
  } else
    cout << "NO";
  return 0;
}
