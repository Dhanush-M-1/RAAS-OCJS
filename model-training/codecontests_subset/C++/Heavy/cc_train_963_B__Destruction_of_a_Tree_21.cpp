#include <bits/stdc++.h>
using namespace std;
stack<int> s;
int deg[200005];
int vis[200005];
int p[200005];
vector<int> ne[200005];
vector<int> ans;
void dfs(int u) {
  s.push(u);
  for (int i = 0; i < ne[u].size(); i++) {
    dfs(ne[u][i]);
  }
}
void dfs2(int u) {
  vis[u] = 1;
  ans.push_back(u);
  for (int i = 0; i < ne[u].size(); i++) {
    int v = ne[u][i];
    deg[v]--;
    if (!vis[v] && deg[v] % 2 == 0) {
      dfs2(v);
    }
  }
  deg[p[u]]--;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    deg[i] = 0;
  }
  for (int i = 1; i <= n; i++) {
    vis[i] = 0;
    cin >> p[i];
    ne[p[i]].push_back(i);
    if (p[i]) {
      deg[i]++;
      deg[p[i]]++;
    }
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  int root = ne[0][0];
  dfs(root);
  while (!s.empty()) {
    int u = s.top();
    s.pop();
    if (!vis[u] && deg[u] % 2 == 0) {
      dfs2(u);
    }
  }
  for (int i = 0; i < n; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
