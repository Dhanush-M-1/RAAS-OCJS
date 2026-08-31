#include <bits/stdc++.h>
using namespace std;
const int ms = 1e6;
vector<int> adj[ms];
int root, n, sz[ms];
int precalc(int i) {
  sz[i] = 1;
  for (auto v : adj[i]) {
    sz[i] += precalc(v);
  }
  return sz[i];
}
void dfs(int i) {
  for (auto v : adj[i])
    if (!(sz[v] & 1)) dfs(v);
  cout << i << " ";
  for (auto v : adj[i])
    if (sz[v] & 1) dfs(v);
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n, x;
  cin >> n;
  if (!(n & 1)) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x)
      adj[x].push_back(i);
    else
      root = i;
  }
  precalc(root);
  dfs(root);
  return 0;
}
