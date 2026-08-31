#include <bits/stdc++.h>
using namespace std;
int sz[200010];
int vis[200010];
int p[200010];
vector<int> son[200010];
void del(int x) {
  vis[x] = 1;
  cout << x << endl;
  for (int i = 0; i < son[x].size(); i++)
    if (!vis[son[x][i]]) del(son[x][i]);
}
void dfs(int x) {
  sz[x] = 1;
  for (int i = 0; i < son[x].size(); i++)
    dfs(son[x][i]), sz[x] += sz[son[x][i]];
  if (!(sz[x] & 1)) del(x);
}
int main() {
  int n;
  int root;
  cin >> n;
  if (n & 1)
    cout << "YES" << endl;
  else
    return cout << "NO" << endl, 0;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
    if (p[i])
      son[p[i]].push_back(i);
    else
      root = i;
  }
  dfs(root);
  del(root);
  return 0;
}
