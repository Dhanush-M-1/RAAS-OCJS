#include <bits/stdc++.h>
using namespace std;
int sz[200001];
bool mark[200001];
set<int> tree[200001];
vector<int> destroy;
void predfs(int u, int p) {
  sz[u] = 1;
  for (int v : tree[u]) {
    if (v != p) {
      predfs(v, u);
      sz[u] += sz[v];
    }
  }
}
void dfs(int u, int p) {
  vector<int> rest;
  for (int v : tree[u]) {
    if (mark[v]) continue;
    if (v != p && sz[v] % 2 == 0) {
      dfs(v, u);
    } else if (v != p) {
      rest.push_back(v);
    }
  }
  mark[u] = true;
  destroy.push_back(u);
  for (int v : rest) {
    dfs(v, -1);
  }
}
int main() {
  int n, p;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> p;
    if (p) {
      tree[i].insert(p);
      tree[p].insert(i);
    }
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  fill(mark, mark + n + 1, false);
  predfs(1, -1);
  dfs(1, -1);
  cout << "YES" << endl;
  for (int u : destroy) {
    cout << u << endl;
  }
  return 0;
}
