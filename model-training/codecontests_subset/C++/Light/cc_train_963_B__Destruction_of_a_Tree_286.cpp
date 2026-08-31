#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, p, root, child[N];
vector<int> adj[N], ans;
void dfs1(int u, int p) {
  child[u] = 1;
  for (int v : adj[u]) {
    dfs1(v, u);
    child[u] += child[v];
  }
}
void dfs2(int u, int p) {
  for (int v : adj[u]) {
    if (child[v] % 2 == 0) {
      dfs2(v, u);
    }
  }
  ans.push_back(u);
  for (int v : adj[u]) {
    if (child[v] % 2 == 1) {
      dfs2(v, u);
    }
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p;
    if (p == 0) {
      root = i;
    } else {
      adj[p].push_back(i);
    }
  }
  if (n % 2 == 0) {
    cout << "NO";
    return 0;
  }
  dfs1(root, root);
  dfs2(root, root);
  cout << "YES\n";
  for (int i : ans) {
    cout << i << "\n";
  }
}
