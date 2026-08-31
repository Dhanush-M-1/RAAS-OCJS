#include <bits/stdc++.h>
using namespace std;
vector<int> tree[200100];
bool vis[200100];
int size[200100];
int dfs_size(int u) {
  vis[u] = 1;
  size[u] = 1;
  for (auto i = tree[u].begin(); i != tree[u].end(); i++) {
    int v = *i;
    if (!vis[v]) {
      size[u] += dfs_size(v);
    }
  }
  return size[u];
}
void dfs(int u) {
  vis[u] = 1;
  for (auto i = tree[u].begin(); i != tree[u].end(); i++) {
    int v = *i;
    if (!vis[v] && (size[v] % 2) == 0) {
      dfs(v);
    }
  }
  printf("%d ", u);
  for (auto i = tree[u].begin(); i != tree[u].end(); i++) {
    int v = *i;
    if (!vis[v] && (size[v] % 2) == 1) {
      dfs(v);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, i, j;
  int root;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> j;
    if (j != 0) {
      tree[j].push_back(i);
      tree[i].push_back(j);
    } else
      root = i;
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    dfs_size(root);
    for (i = 0; i <= n + 1; i++) vis[i] = 0;
    dfs(root);
  }
  return 0;
}
